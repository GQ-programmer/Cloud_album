package pub.zgq.CloudAlbum.dao;

import org.springframework.stereotype.Repository;
import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.pojo.User;

import java.util.List;

@Repository
public interface UserDao {
    public User findUser(User user);

    User findUserByUsername(String username);

    void save(User user);

    void saveImg(Image img);

    List<Image> findImages(String albumName);

    Image findImageOne(int imgId);

    List<Image> findImgByImgName(String imgName);
}
