package pub.zgq.CloudAlbum.service;

import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.pojo.ResultInfo;
import pub.zgq.CloudAlbum.pojo.User;

import java.util.List;

public interface UserService {
    /*
        登录方法
     */
    User findUser(User user);

    ResultInfo regist(User user);

    void saveImg(Image img);

    List<Image> findImages(String albumName);

    Image findImageOne(int imgId);

    List<Image> findImgByImgName(String imgName);
}
