//服务层
app.service('sellerService',function($http){


    //查找所有
    this.findAll = function () {
        return $http.get("./seller");
    }

    //分页查找
    this.findPage = function (pageNo, pageSize) {
        return $http.get("./seller/" + pageNo + "/" + pageSize);
    }

    //添加数据
    this.save = function (entity) {
        return $http.post("./seller", entity);
    }

    //修改数据
    this.update = function (entity) {
        return $http.put("./seller", entity);
    }

    //删除数据
    this.delete = function (selectIds) {
        return $http.delete("./seller?ids=" + selectIds);
    }

    //模糊查询数据
    this.search = function (pageNo, pageSize, entity) {
        return $http.post("./seller/search/" + pageNo + "/" + pageSize, entity);
    }
    //删除单行数据
    this.deleteOne = function (id) {
        return $http.delete("./seller/" + id);
    }

});
