//服务层
app.service('specificationOptionService', function ($http) {


    //查找所有
    this.findAll = function () {
        return $http.get("./specificationOption");
    }
    //查询一个
    this.findOne = function (id) {
        return $http.get("./specificationOption/" + id);
    }

    //分页查找
    this.findPage = function (pageNo, pageSize) {
        return $http.get("./specificationOption/" + pageNo + "/" + pageSize);
    }

    //添加品牌数据
    this.save = function (entity) {
        return $http.post("./specificationOption", entity);
    }

    //修改品牌数据
    this.update = function (entity) {
        return $http.put("./specificationOption", entity);
    }

    //删除品牌数据
    this.delete = function (selectIds) {
        return $http.delete("./specificationOption?ids=" + selectIds);
    }

    //模糊查询品牌数据
    this.search = function (pageNo, pageSize, entity) {
        return $http.post("./specificationOption/search/" + pageNo + "/" + pageSize, entity);
    }

});
