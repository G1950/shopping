package com.gm.common;

public enum ResultEnum {
    SUCCESS(1, "成功"),
    FAILURE(0,"失败"),
    EXCEPTION(-1,"异常"),
    ILLEGAL_OPTIONS(-1, "非法操作"),
    SERVER_CONNECT_TIME_OUT(408, "服务器连接超时，请稍后重试"),

    USER_LOGIN_SUCCESS(1, "用户登录成功"),
    USER_REGISTER_SUCCESS(1, "用户注册成功"),
    USER_LOGIN_FAIL(0, "用户登录失败"),
    USER_REGISTER_FAIL(0, "用户注册失败"),

    USER_INFO_NOT_FOUND(205, "请输入账号密码"),
    USER_ACCOUNT_FREEZE(204, "账号被冻结，请联系管理员"),

    EXIST_USER(206, "用户已存在"),
    USER_NOT_FOUND(100, "账号错误或密码错误"),
    NOT_EXIST_USER(203, "不存在该用户"),
    OLD_PASSWORD_ERROR(198, "旧密码错误"),
    SEND_MESSAGE_FAIL(201, "发送短信失败"),
    SMS_ERROR_CODE(202, "短信验证码无效"),

    CAPTCHA_ERROR(0,"验证码错误"),
    CAPTCHA_SUCCESS(1,"验证码正确"),

    SAVE_SUCCESS(1, "添加成功"),
    UPDATE_SUCCESS(1, "更新成功"),
    DELETE_SUCCESS(1, "删除成功"),
    QUERY_SUCCESS(1, "查询成功"),

    PRODUCT_NOT_ENOUGH(-1, "库存不足"),

    SAVE_ERROR(0, "添加失败"),
    UPDATE_ERROR(0, "更新失败"),
    DELETE_ERROR(0, "删除失败"),
    QUERY_NOT_FOUND(0, "查无此题"),
    QUERY_ERROR(0, "查询失败"),
    QUERY_TYPE_ERROR(0, "不存在的查询类型"),

    UPLOAD_IMG_SUCCESS(1, "上传图片成功"),
    UPLOAD_IMG_FAIL(0, "上传图片失败"),
    UPLOAD_IMG_WARN(-1, "仅支持png|jpg格式"),

    MESSAGE_NOT_READABLE(400, "参数格式错误(缺少分隔符或结束标签)"),
    TYPE_MIS_MATCH(400, "参数类型不匹配"),
    MISSING_PARAMETER(400, "缺少请求参数"),
    UNAUTHORIZED_ACCESS(401, "未经授权访问"),
    ACCESS_DENIED_FAIL(401, "权限不足，不允许访问"),
    FORBIDDEN_ACCESS(403, "该资源禁止访问"),
    ACCESS_TOKEN_ERROR(403, "access_token无效或已过期"),
    NO_HANDLER_FOUND(404, "请求的资源不存在"),
    METHOD_NOT_SUPPORT(405, "不支持该请求方式"),
    MEDIA_TYPE_NOT_SUPPORT(415, "内容类型不支持"),
    SYS_ERROR(500, "系统内部异常"),

    RESOURCE_EXIST(207, "资源已存在"),

    ORDER_CREATE_FAIL(0, "订单创建失败"),
    ORDER_CREATE_SUCCESS(1, "订单创建成功"),
    ORDER_PRODUCT_NOT_ENOUGH(205, "库存不足"),
    ORDER_ILLEGAL(-1, "非法操作"),
    ORDER_NOT_EXIST(5, "订单不存在"),
    ORDER_UPDATE_FAIL(0, "订单修改失败"),

    PAY_SUCCESS(1, "支付成功"),
    PAY_FAIL(0, "支付失败"),
    PAY_EXCEPTION(-1, "支付异常"),

    SPECIFICATION_NOT_EXIST(0,"规格分类不存在"),
    SPECIFIC_NOT_EXIST(0,"规格不存在");;



    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultEnum(Integer code, String message) {

        this.code = code;
        this.message = message;
    }
}
