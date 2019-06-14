package win.und.demo.oauth.support.properities;

import java.io.Serializable;

/**
 * @author yuit
 * @date 2018/10/19 16:30
 *
 */

public class BootLogLevelProperties implements Serializable {

    private String level = "INFO";

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
