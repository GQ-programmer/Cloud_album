package pub.zgq.CloudAlbum.pojo;

import org.springframework.stereotype.Component;

/**
 * 结果集对象
 */
@Component("info")
public class ResultInfo {
    private boolean flag;
    private String errorMsg;
    private User user;

    public ResultInfo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", errorMsg='" + errorMsg + '\'' +
                ", user=" + user +
                '}';
    }

    public ResultInfo(boolean flag, String errorMsg, User user) {
        this.flag = flag;
        this.errorMsg = errorMsg;
        this.user = user;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
