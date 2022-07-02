package pub.zgq.CloudAlbum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.zgq.CloudAlbum.dao.UserDao;
import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.pojo.ResultInfo;
import pub.zgq.CloudAlbum.pojo.User;
import pub.zgq.CloudAlbum.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ResultInfo info;

    @Override
    public User findUser(User user) {
        //return userDao.findUser(user.getUsername(),user.getPassword());
        return userDao.findUser(user);
    }

    @Override
    public ResultInfo regist(User user) {
        User u = userDao.findUserByUsername(user.getUsername());
        if (u != null){
            //用户名已存在
            //返回提示结果
            info.setFlag(false);
            info.setErrorMsg("用户名已存在!");
        }else{
            //用户名不存在
            //设置用户状态信息
            user.setStatus("N");
            userDao.save(user);
            info.setFlag(true);
            info.setErrorMsg("注册成功!");
        }
        return info;
    }

    @Override
    public void saveImg(Image img) {
        userDao.saveImg(img);
    }

    @Override
    public List<Image> findImages(String albumName) {

        return userDao.findImages(albumName);
    }

    @Override
    public Image findImageOne(int imgId) {
        return userDao.findImageOne(imgId);
    }

    @Override
    public List<Image> findImgByImgName(String imgName) {
        return userDao.findImgByImgName(imgName);
    }
}
