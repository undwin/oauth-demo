package win.und.demo.oauth.support.code;


/**
 * @author yuit
 * @date 2018/10/19 10:42
 *
 */
public  class VerificationCode {

    private String code;
    private Integer expirationTime;

    public VerificationCode() {
    }


    public VerificationCode(String code, Integer expirationTime) {
        this.code = code;
        this.expirationTime = expirationTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }
}
