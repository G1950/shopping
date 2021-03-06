//控制层
app.controller('itemCatController', function ($scope, $controller, itemCatService) {

    //继承baseController
    $controller("baseController", {$scope: $scope});


    //加载所有数据
    $scope.findAllItemCat = function () {
        itemCatService.findAll().success(function (data) {
            $scope.list = data
        })
    };

    //表格分页
    $scope.findPageItemCat = function () {
        itemCatService.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total
        })
    };

    //添加表格数据
    $scope.saveItemCat = function () {
        itemCatService.save($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    };

    //修改表格数据
    $scope.updateItemCat = function () {
        itemCatService.update($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    };

    //保存
    $scope.save = function () {
        var method = {} //存入要执行的方法对象
        if ($scope.entity.id != null && $scope.entity.id !== '')//如果有ID,则为修改
            method = itemCatService.update;
        else
            method = itemCatService.save;
        method($scope.entity).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList();//重新加载
        })
    }

    //删除表格数据
    $scope.deleteItemCat = function () {
        itemCatService.delete($scope.selectIds).success(function (data) {
            if (data.code !== 1)
                alert(data.msg);
            $scope.reloadList();//重新加载
        })
    };

    //模糊查询数据
    $scope.search = function () {
        itemCatService.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.searchEntity).success(function (res) {
            $scope.list = res.data.rows;
            $scope.paginationConf.totalItems = res.data.total
        })
    }

    //删除单行数据
    $scope.deleteOneItemCat = function (id) {
        itemCatService.deleteOne(id).success(function (data) {
            if (data.code !== 1)
                alert(data.msg)
            $scope.reloadList()
        })
    }
    //根据父级id查找
    $scope.findParentId = function (id) {
        $scope.searchEntity.parentId = id
        $scope.search()
    }


    //存储当前列表级别
    $scope.grade = 1;
    //存储父级id
    $scope.parentId = 0;
    //逐级查找
    $scope.next_list = function (grade, entity) {
        //存储父级id
        $scope.parentId = entity.id;
        if (grade === 1) {
            $scope.entity_1 = null;
            $scope.entity_2 = null;
        }
        if (grade === 2) {
            $scope.entity_1 = entity;
        }
        if (grade === 3) {
            $scope.entity_2 = entity;
        }
        $scope.grade = grade;
        console.log($scope.grade)
        $scope.findParentId(entity.id);
    }

});	
