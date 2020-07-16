//服务层
app.service('typeTemplateService', function ($http) {


    //查找所有
    this.findAll = function () {
        return $http.get("./typeTemplate");
    }

    //分页查找
    this.findPage = function (pageNo, pageSize) {
        return $http.get("./typeTemplate/" + pageNo + "/" + pageSize);
    }

    //添加数据
    this.save = function (entity) {
        return $http.post("./typeTemplate", entity);
    }

    //修改数据
    this.update = function (entity) {
        return $http.put("./typeTemplate", entity);
    }

    //删除数据
    this.delete = function (selectIds) {
        return $http.delete("./typeTemplate?ids=" + selectIds);
    }

    //模糊查询数据
    this.search = function (pageNo, pageSize, entity) {
        return $http.post("./typeTemplate/search/" + pageNo + "/" + pageSize, entity);
    }

    //删除单行数据
    this.deleteOne = function (id) {
        return $http.delete("./typeTemplate/" + id);

    }

    //删除单行数据
    this.findOne = function (id) {
        return $http.get("./typeTemplate/" + id);

    }

});
