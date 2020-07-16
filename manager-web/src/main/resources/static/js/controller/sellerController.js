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

    //修改表格数据
    $scope.updateSeller = function (status) {
        $scope.entity.status = status;
        sellerService.update($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
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

    //设置当前状态
    $scope.setStatus = function (status) {
        if (status === '1')
            return "审核通过"
        if (status === '2')
            return "审核未通过"
        if (status === '3')
            return "商家被关闭"
        if (status === '0')
            return "未审核"
    }
});	
