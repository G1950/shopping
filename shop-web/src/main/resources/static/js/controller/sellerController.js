 //控制层 
app.controller('sellerController', function ($scope, $controller, sellerService) {

    //继承baseController
    $controller("baseController", {$scope: $scope});


    //加载所有数据
    $scope.findAllSeller = function () {
        sellerService.findAll().success(function (data) {
            $scope.list = data
        })
    };

    //表格分页
    $scope.findPageSeller = function () {
        sellerService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total
        })
    };

    //添加表格数据
    $scope.saveSeller = function () {
        sellerService.save($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            else
                location.href = 'shoplogin.html';
            $scope.reloadList();//重新加载
        })
    };

    //修改表格数据
    $scope.updateSeller = function () {
        sellerService.update($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    };

    //保存
    $scope.save = function () {
        var method = {} //存入要执行的方法对象
        if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
            method = sellerService.update;
        else
            method = sellerService.save;
        method($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    }

    //删除表格数据
    $scope.deleteSeller = function () {
        sellerService.delete($scope.selectIds).success(function (data) {
            if (data.code !== 1)
                alert(data.msg);
            $scope.reloadList();//重新加载
        })
    };

    //模糊查询数据
    $scope.search = function () {
        sellerService.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.searchEntity).success(function (res) {
            $scope.list = res.data.rows;
            $scope.paginationConf.totalItems = res.data.total
        })
    }

    //删除单行数据
    $scope.deleteOneSeller = function (id) {
        sellerService.deleteOne(id).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList()
        })
    }

});	
