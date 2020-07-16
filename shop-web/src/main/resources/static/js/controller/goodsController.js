//控制层
app.controller('goodsController', function ($scope, $controller, goodsService, fileService, itemCatService, typeTemplateService, specificationOptionService) {

    //继承baseController
    $controller("baseController", {$scope: $scope});


    //加载所有数据
    $scope.findAllGoods = function () {
        goodsService.findAll().success(function (data) {
            $scope.list = data
        })
    };

    //表格分页
    $scope.findPageGoods = function () {
        goodsService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total
        })
    };

    //添加表格数据
    $scope.saveGoods = function () {
        console.log(angular.toJson($scope.typeTemplate.customAttributeItems))
        $scope.entity.goodsDesc.customAttributeItems = angular.toJson($scope.typeTemplate.customAttributeItems)
        $scope.entity.goodsDesc.itemImages = angular.toJson($scope.itemImages)
        $scope.entity.goodsDesc.introduction = editor.html();
        console.log(editor.html())
        goodsService.save($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
        })
    };

    //修改表格数据
    $scope.updateGoods = function () {
        goodsService.update($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    };

    //保存
    $scope.save = function () {
        var method = {} //存入要执行的方法对象
        if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
            method = goodsService.update;
        else
            method = goodsService.save;
        method($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    }

    //删除表格数据
    $scope.deleteGoods = function () {
        goodsService.delete($scope.selectIds).success(function (data) {
            if (data.code !== 1)
                alert(data.msg);
            $scope.reloadList();//重新加载
        })
    };

    //模糊查询数据
    $scope.search = function () {
        goodsService.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.searchEntity).success(function (res) {
            $scope.list = res.data.rows;
            $scope.paginationConf.totalItems = res.data.total
        })
    }

    //删除单行数据
    $scope.deleteOneGoods = function (id) {
        goodsService.deleteOne(id).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList()
        })
    }
    //图片信息
    $scope.pic_entity = {}

    //图片列表
    $scope.itemImages = []

    //物品实体
    $scope.entity = {goods: {}, goodsDesc: {itemImages: []}};

    //图片上传
    $scope.uploadPic = function () {
        if (file.files[0] == null) {
            alert("请选择图片")
            return false
        }
        fileService.uploadPic().success(function (data) {
            if (data.code === 1) {
                $scope.pic_entity.url = data.data
            } else {
                alert(data.msg)
            }
            console.log(data)
        })
    }

    //保存图片到列表
    $scope.savePic = function () {
        var index = $scope.itemImages.indexOf($scope.pic_entity)
        if (index >= 0) {
            $scope.itemImages[index].color = $scope.pic_entity.color
            $scope.itemImages[index].url = $scope.pic_entity.url
        } else {
            $scope.itemImages.push($scope.pic_entity)
        }
    }

    //从列表中删除一张图片
    $scope.deletePic = function (index) {
        $scope.itemImages.splice(index, 1)
    }
    //修改图片信息
    $scope.findOnePic = function (index) {
        $("#file").val("");
        $scope.pic_entity = $scope.itemImages[index];
        $("#upload_pic").attr("src", $scope.pic_entity.url)
    }

    //clear图片信息录入
    $scope.clear = function () {
        $scope.pic_entity = {}
        $("#file").val("");
        $("#upload_pic").attr("src", "../img/account.png")
    }

    //分类查找
    $scope.selectItemList = function (grade, id) {
        if (id === "" || id == null)
            return false
        itemCatService.findByParentId(id).success(function (data) {
            if (data.code === 1) {
                if (grade === 1) {
                    $scope.itemCat1List = data.data
                }
                if (grade === 2) {
                    $scope.itemCat2List = data.data
                }
                if (grade === 3) {
                    $scope.itemCat3List = data.data
                }
            } else {
                alert(data.msg)
            }

        })
    }

    //监测分类改变
    //一级改变获取二级
    $scope.$watch('entity.goods.category1Id', function (newValue) {
        $scope.itemCat3List = []
        $scope.entity.goods.typeTemplateId = ''
        $scope.selectItemList(2, newValue);
    })
    //二级改变获取三级
    $scope.$watch('entity.goods.category2Id', function (newValue) {
        $scope.selectItemList(3, newValue);
    })
    //三级分类选择后  读取模板ID
    $scope.$watch('entity.goods.category3Id', function (newValue) {
        if (newValue === "" || newValue == null)
            return false
        itemCatService.findById(newValue).success(function (data) {
            if (data.code === 1)
                $scope.entity.goods.typeTemplateId = data.data.typeId; //更新模板ID
        })
    });

    //获取列表
    $scope.$watch('entity.goods.typeTemplateId', function (newValue) {
        if (newValue === "" || newValue == null)
            return false
        //获取品牌列表
        typeTemplateService.findOne(newValue).success(
            function (data) {
                if (data.code === 1) {
                    $scope.typeTemplate = data.data;//获取类型模板
                    $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);//品牌列表
                    $scope.typeTemplate.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);//扩展属性列表
                    $scope.typeTemplate.specIds = JSON.parse($scope.typeTemplate.specIds);//规格列表
                    $scope.OptionList($scope.typeTemplate.specIds); //处理规格详细
                }
            }
        );
    });


    //获取规格列表
    $scope.OptionList = function (specIds) {
        var length = specIds.length;
        for (let i = 0; i < length; i++) {
            var id = $scope.typeTemplate.specIds[i].id; //规格id
            specificationOptionService.findOne(id).success(function (data) {
                if (data.code === 1)
                    $scope.typeTemplate.specIds[i].options = data.data  //获取信息规格
            })
        }
    }

    //规格
    $scope.baseSpecList = {num: 9999, spec: []}

    //选择参数,传入参数: $event事件，specText规格名称，optName规格参数
    $scope.selectOptionSpec = function ($event, specText, optName) {
        if ($event.target.checked) {
            const length = $scope.baseSpecList.spec.length;
            for (let i = 0; i < length; i++) {
                if ($scope.baseSpecList.spec[i].attributeName === specText) { //判断规格参数是否已存入
                    $scope.baseSpecList.spec[i].attributeValue = optName;
                    return false;
                }

            }
            $scope.baseSpecList.spec.push({attributeName: specText, attributeValue: optName}) //参数首次添加
        }
    }

    //商品规格列表
    $scope.specList = []
    //添加到规格列表
    $scope.addSpecList = function () {
        var length = $scope.typeTemplate.specIds.length;
        var base_length = Object.keys($scope.baseSpecList).length
        console.log(base_length)
        if (base_length < 5 || $scope.baseSpecList.spec.length < length) {
            alert("请填写完整规格")
            return false;
        }
        $scope.specList.push($scope.baseSpecList)

        //置空输入的规格
        $scope.baseSpecList = {num: 9999, spec: []}
        //置空单选框
        $scope.typeTemplate.specIds.forEach(function (value) {
            $("input[name=" + value.id + "]").attr("checked", false)
        })
    }
});
