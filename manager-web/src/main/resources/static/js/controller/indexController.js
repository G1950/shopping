app.controller("indexController", function ($scope, $controller, indexService) {

    //继承baseController
    $controller("baseController", {$scope: $scope});
    //获取登陆用户名
    $scope.showLogin = function () {
        indexService.show().success(function (data) {
            $scope.loginName = data.data
        })
    }

})