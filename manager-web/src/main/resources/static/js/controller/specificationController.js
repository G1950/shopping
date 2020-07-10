//控制层
app.controller('specificationController', function ($scope, $controller, specificationService, specificationOptionService) {

    //继承baseController
    $controller("baseController", {$scope: $scope});


    //加载所有数据
    $scope.findAllSpecification = function () {
        specificationService.findAll().success(function (data) {
            $scope.list = data
        })
    };

    //表格分页
    $scope.findPageSpecification = function () {
        specificationService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total
        })
    };

    //添加表格数据
    $scope.saveSpecification = function () {
        specificationOptionService.save($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    };

    //添加规格数据
    $scope.saveSpecificationOption = function () {
        specificationOptionService.save($scope.entity.specificationOptionList).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
        })
    };

    $scope.entity = {specificationOptionList: []};
    //修改规格数据
    $scope.updateSpecification = function (index) {
        $scope.findOne(index);
        specificationOptionService.findOne($scope.entity.id).success(function (data) {
            $scope.entity.specificationOptionList = data.data
        })
    };

    //保存
    $scope.save = function () {
        var method = {} //存入要执行的方法对象
        if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
            method = specificationService.update;
        else
            method = specificationService.save;
        method($scope.entity).success(function (data) {
            if (data.code === 1)
            {
                $scope.saveSpecificationOption();
                $scope.reloadList();//重新加载
            }else {
                alert(data.msg)
            }
        })
    }

    //删除表格数据
    $scope.deleteSpecification = function () {
        specificationService.delete($scope.selectIds).success(function (data) {
            if (data.code === 1) {
                alert("删除成功");
            } else
                alert(data.msg)
            $scope.reloadList();//重新加载
        })

    };

    //模糊查询品牌数据
    $scope.search = function () {
        specificationService.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.searchEntity).success(function (res) {
            $scope.list = res.data.rows;
            $scope.paginationConf.totalItems = res.data.total;
        })
    }

    //添加规格行
    $scope.addOptionList = function (id) {
        $scope.entity.specificationOptionList.push({specId:id});
    }

    //删除规格行
    $scope.deleteOptionList = function (index) {
        $scope.entity.specificationOptionList.splice(index, 1);
    }

});	
