//品牌控制层
app.controller('baseController', function ($scope) {

    //表格数据重载
    $scope.reloadList = function () {
        $scope.search();
        $scope.searchEntity = {};

    }

    //分页参数
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    //表格数据查找
    $scope.findOne = function (id) {
        $scope.entity = $scope.list[id]
    };

    //复选框记录
    $scope.selectIds = []
    $scope.deleteSelect = function ($event, id) {
        if ($event.target.checked) //选中则加入数组
            $scope.selectIds.push(id) //将品牌id加入数组
        else {
            let idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1)
        }
    }

    //模糊查询,记录查询的对象
    $scope.searchEntity = {}


});	