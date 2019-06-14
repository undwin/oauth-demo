package win.und.demo.oauth.support.properities;

/**
 * @author yuit
 * @date 2018/10/19 17:34
 *
 */

public class BootSmsCodeProperties {

    private Integer expirationTime = 240;
    private Integer length = 4;
    private String mobileParameter = "mobile";

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getMobileParameter() {
        return mobileParameter;
    }

    public void setMobileParameter(String mobileParameter) {
        this.mobileParameter = mobileParameter;
    }
}
