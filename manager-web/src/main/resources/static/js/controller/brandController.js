 //控制层 
app.controller('brandController' ,function($scope,$controller   ,brandService){	
	
	//继承baseController
        $controller("baseController", {$scope: $scope});
    
    
        //加载所有数据
        $scope.findAllBrand = function () {
            brandService.findAll().success(function (data) {
                $scope.list = data
            })
        };
    
        //表格分页
        $scope.findPageBrand = function () {
            brandService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total
            })
        };
    
        //添加表格数据
        $scope.saveBrand = function () {
            brandService.save($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
                $scope.reloadList();//重新加载
            })
        };
    
        //修改表格数据
        $scope.updateBrand = function () {
            brandService.update($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
                $scope.reloadList();//重新加载
            })

        };
    
        //保存
        $scope.save = function () {
            var method = {} //存入要执行的方法对象
            if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
                method = brandService.update;
            else
                method = brandService.save;
            method($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
                $scope.reloadList();//重新加载
            })
        }
    
        //删除表格数据
        $scope.deleteBrand = function () {
            brandService.delete($scope.selectIds).success(function (data) {
                if (data.code === 1) {
                    $scope.reloadList();//重新加载
                } else
                    alert(data.msg)
            })
    
        };
    
        //模糊查询品牌数据
        $scope.search = function () {
            brandService.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.searchEntity).success(function (res) {
                $scope.list = res.data.rows;
                $scope.paginationConf.totalItems = res.data.total
            })
        }

});	
