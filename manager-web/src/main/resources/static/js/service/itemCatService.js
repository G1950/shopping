//服务层
app.service('itemCatService',function($http){
	    	

	    //查找所有
        this.findAll = function () {
            return $http.get("./itemCat");
        }
    
        //分页查找
        this.findPage = function (pageNo, pageSize) {
            return $http.get("./itemCat/" + pageNo + "/" + pageSize);
        }
    
        //添加品牌数据
        this.save = function (entity) {
            return $http.post("./itemCat", entity);
        }
    
        //修改品牌数据
        this.update = function (entity) {
            return $http.put("./itemCat", entity);
        }
    
        //删除品牌数据
        this.delete = function (selectIds) {
            return $http.delete("./itemCat?ids=" + selectIds);
        }
    
        //模糊查询品牌数据
        this.search=function (pageNo, pageSize,entity) {
            return $http.post("./itemCat/search/" + pageNo + "/" + pageSize, entity);
        }
  	
});
