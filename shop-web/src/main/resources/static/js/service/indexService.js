app.service("indexService", function ($http) {

    //请求获取用户名
    this.show = function () {
        return $http.get("./name");
    }

})