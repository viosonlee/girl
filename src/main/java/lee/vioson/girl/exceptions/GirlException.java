package lee.vioson.girl.exceptions;

import lee.vioson.girl.enums.ResultStatus;

public class GirlException extends RuntimeException {

    private Integer code;
    private String msg;

    public GirlException(ResultStatus resultStatus) {
        this.code = resultStatus.getCode();
        this.msg = resultStatus.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
