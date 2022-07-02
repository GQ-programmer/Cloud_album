/*
package pub.zgq.CloudAlbum.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pub.zgq.CloudAlbum.dao.UserDao;
import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.pojo.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate template;

    */
/**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     *//*

    public User findUser(String username,String password) {
        User user = null;
        try {
            String sql = "select * from tab_user where username = ? and password = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    */
/**
     * 根据用户名查询用户
     * @param username
     * @return
     *//*

    public User findUserByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from tab_user where username = ? ";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    */
/**
     * 保存存用户信息
     * @param user
     *//*

    public void save(User user) {
        //1.定义sql
        String sql = "insert into tab_user(username,nickname,password,status) values(?,?,?,?)";
        //2.执行sql
        template.update(sql,user.getUsername(),
                user.getNickname(),
                user.getPassword(),
                user.getStatus()
        );
    }

    */
/**
     * 保存图片信息
     * @param img
     *//*

    @Override
    public void saveImg(Image img) {
        String sql = "insert into tab_img(imgName,fileName,time,albumName,size) values(?,?,?,?,?)";
        template.update(sql,img.getImgName(),img.getFileName(),img.getTime(),img.getAlbumName(),img.getSize());

    }

    */
/**
     * 查找图片信息集合
     *//*

    @Override
    public List<Image> findImages(String albumName) {
        String sql = "select * from tab_img where albumName = ?";
        List<Image> list = template.query(sql, new BeanPropertyRowMapper<Image>(Image.class), albumName);
        return list;
    }

    */
/**
     * 根据图片id查找图片
     * @param imgId
     * @return
     *//*

    @Override
    public Image findImageOne(int imgId) {
        String sql = "select * from tab_img where imgId = ?";
        Image image = template.queryForObject(sql, new BeanPropertyRowMapper<Image>(Image.class), imgId);
        return image;
    }

    @Override
    public List<Image> findImgByImgName(String imgName) {
       String sql = "select * from tab_img where imgName like ?";
        List<Image> list = template.query(sql, new BeanPropertyRowMapper<Image>(Image.class),"%"+imgName+"%");
        return list;
    }

}
*/
