app.service("fileService", function ($http) {

    //上传图片
    this.uploadPic = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);
        return $http({
            method: 'POST',
            url: "./upload/pic",
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        });
    }

})