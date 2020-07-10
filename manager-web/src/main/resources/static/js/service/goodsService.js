//服务层
app.service('goodsService',function($http){
	    	

	    //查找所有
        this.findAll = function () {
            return $http.get("./goods");
        }
    
        //分页查找
        this.findPage = function (pageNo, pageSize) {
            return $http.get("./goods/" + pageNo + "/" + pageSize);
        }
    
        //添加品牌数据
        this.save = function (entity) {
            return $http.post("./goods", entity);
        }
    
        //修改品牌数据
        this.update = function (entity) {
            return $http.put("./goods", entity);
        }
    
        //删除品牌数据
        this.delete = function (selectIds) {
            return $http.delete("./goods?ids=" + selectIds);
        }
    
        //模糊查询品牌数据
        this.search=function (pageNo, pageSize,entity) {
            return $http.post("./goods/search/" + pageNo + "/" + pageSize, entity);
        }
  	
});
