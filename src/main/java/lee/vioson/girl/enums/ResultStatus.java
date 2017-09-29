package lee.vioson.girl.enums;

public enum ResultStatus {
    SUCCESSFUL(200, "成功"),
    ERROR_PARAMS(100, "参数错误");

    private Integer code;
    private String msg;

    ResultStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
