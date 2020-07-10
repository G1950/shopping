 //控制层 
app.controller('seckillGoodsController' ,function($scope,$controller   ,seckillGoodsService){	
	
	//继承baseController
        $controller("baseController", {$scope: $scope});
    
    
        //加载所有数据
        $scope.findAllSeckillGoods = function () {
            seckillGoodsService.findAll().success(function (data) {
                $scope.list = data
            })
        };
    
        //表格分页
        $scope.findPageSeckillGoods = function () {
            seckillGoodsService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
                $scope.list = data.rows;
                $scope.paginationConf.totalItems = data.total
            })
        };
    
        //添加表格数据
        $scope.saveSeckillGoods = function () {
            seckillGoodsService.save($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
            })
            $scope.reloadList();//重新加载
        };
    
        //修改表格数据
        $scope.updateSeckillGoods = function () {
            seckillGoodsService.update($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
            })
            $scope.reloadList();//重新加载
        };
    
        //保存
        $scope.save = function () {
            var method = {} //存入要执行的方法对象
            if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
                method = seckillGoodsService.update;
            else
                method = seckillGoodsService.save;
            method($scope.entity).success(function (data) {
                if (data.code !== 1)
                    alert(data.msg)
            })
            $scope.reloadList();//重新加载
        }
    
        //删除表格数据
        $scope.deleteSeckillGoods = function () {
            seckillGoodsService.delete($scope.selectIds).success(function (data) {
                if (data.code === 1) {
                    alert("删除成功");
                } else
                    alert(data.msg)
                $scope.reloadList();//重新加载
            })
    
        };
    
        //模糊查询品牌数据
        $scope.search = function () {
            seckillGoodsService.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.searchEntity).success(function (res) {
                $scope.list = res.data.rows;
                $scope.paginationConf.totalItems = res.data.total
            })
        }

});	
