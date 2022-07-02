package pub.zgq.CloudAlbum.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String username;
    private String nickname;
    private String password;
    private String status;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public User() {
    }

    public User(String username, String nickname, String password, String status) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.status = status;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

}
