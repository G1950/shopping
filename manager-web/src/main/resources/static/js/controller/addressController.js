 //控制层 
app.controller('addressController' ,function($scope,$controller   ,addressService){	
	
	//继承baseController
        $controller("baseController", {$scope: $scope});
    
    
        //加载所有数据
        $scope.findAllAddress = function () {
            addressService.findAll().success(function (data) {
                $scope.list = data
            })
        };
    
        //表格分页
        $scope.findPageAddress = function () {
            addressService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total
            })
        };
    
        //添加表格数据
        $scope.saveAddress = function () {
            addressService.save($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
            })
            $scope.reloadList();//重新加载
        };
    
        //修改表格数据
        $scope.updateAddress = function () {
            addressService.update($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
            })
            $scope.reloadList();//重新加载
        };
    
        //保存
        $scope.save = function () {
            var method = {} //存入要执行的方法对象
            if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
                method = addressService.update;
            else
                method = addressService.save;
            method($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
            })
            $scope.reloadList();//重新加载
        }
    
        //删除表格数据
        $scope.deleteAddress = function () {
            addressService.delete($scope.selectIds).success(function (data) {
                if (data.code === 1) {
                    alert("删除成功");
                } else
                    alert(data.msg)
                $scope.reloadList();//重新加载
            })
    
        };
    
        //模糊查询品牌数据
        $scope.search = function () {
            addressService.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.searchEntity).success(function (res) {
                $scope.list = res.data.rows;
                $scope.paginationConf.totalItems = res.data.total
            })
        }

});	
