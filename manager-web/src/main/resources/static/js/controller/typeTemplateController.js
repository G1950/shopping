//控制层
app.controller('typeTemplateController', function ($scope, $controller, typeTemplateService, brandService, specificationService) {

    //继承baseController
    $controller("baseController", {$scope: $scope});


    //加载所有数据
    $scope.findAllTypeTemplate = function () {
        typeTemplateService.findAll().success(function (data) {
            $scope.list = data
        })
    };

    //表格分页
    $scope.findPageTypeTemplate = function () {
        typeTemplateService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total
        })
    };

    //添加表格数据
    $scope.saveTypeTemplate = function () {
        typeTemplateService.save($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
        })
        $scope.reloadList();//重新加载
    };

    //修改表格数据
    $scope.updateTypeTemplate = function () {
        typeTemplateService.update($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
        })
        $scope.reloadList();//重新加载
    };

    //保存
    $scope.save = function () {
        //对象转成String
        $scope.entity.brandIds = JSON.stringify($scope.brandIds)
        $scope.entity.specIds = JSON.stringify($scope.specIds)
        $scope.entity.customAttributeItems = angular.toJson($scope.customAttributeItems)
        var method //存入要执行的方法对象
        if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
            method = typeTemplateService.update;
        else
            method = typeTemplateService.save;
        method($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
        })
        $scope.reloadList();//重新加载
    }

    //删除表格数据
    $scope.deleteTypeTemplate = function () {
        typeTemplateService.delete($scope.selectIds).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })

    };
    //模糊查询品牌数据
    $scope.search = function () {
        typeTemplateService.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.searchEntity).success(function (res) {
            $scope.list = res.data.rows;
            $scope.paginationConf.totalItems = res.data.total
        })
    }

    //json转String
    $scope.jsonToString = function (jsonString, key) {
        if (jsonString == null || jsonString === '')
            return null;
        var json = JSON.parse(jsonString);
        var str = '';
        json.forEach(function (value) {
            str += value[key] + ' , '
        })
        return str.substring(0, str.length - 3)

    }

    //修改一个模板
    $scope.findOneTemplate = function (index) {
        $scope.findOne(index)
        $scope.brandIds = JSON.parse($scope.entity.brandIds)
        $scope.specIds = JSON.parse($scope.entity.specIds)
        if ($scope.entity.customAttributeItems != null || $scope.entity.customAttributeItems !== '')
            $scope.customAttributeItems = JSON.parse($scope.entity.customAttributeItems)
    }
    $scope.brandList = {data: []};//品牌列表
    $scope.specList = {data: []};//规格列表
    //获取关联列表
    $scope.relateList = function () {
        brandService.findAll().success(function (data) {
            if (data.code === 1) {
                data.data.forEach(function (res) {
                    $scope.brandList.data.push({id: res.id, text: res.name})
                })
            }
        })
        specificationService.findAll().success(function (data) {
            if (data.code === 1) {
                data.data.forEach(function (res) {
                    $scope.specList.data.push({id: res.id, text: res.specName})
                })
            }
        })
    }
    //清空
    $scope.clear = function () {
        $scope.entity = {}
        $scope.brandIds = []
        $scope.specIds = []
        $scope.customAttributeItems = []
    }

    //添加扩展属性行
    $scope.addCustomAttributeItemsList = function () {
        if ($scope.customAttributeItems == null)
            $scope.customAttributeItems = []
        $scope.customAttributeItems.push({});
    }

    //删除扩展属性行
    $scope.deleteCustomAttributeItemsList = function (index) {
        $scope.customAttributeItems.splice(index, 1);
    }

    //删除单行
    $scope.deleteOneTemplate = function (id) {
        typeTemplateService.deleteOne(id).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList()
        })
    }
});	
