package pub.zgq.CloudAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.service.UserService;

import java.util.List;

@Controller
public class ImgListController {

    @Autowired
    private UserService userService;

    /**
     * 根据相册类别查询图片集合
     * @param albumName
     * @return
     */
    @RequestMapping("/imgList")
    @ResponseBody
    public List<Image> imgList(String albumName){
        System.out.println(albumName);
        List<Image> images = userService.findImages(albumName);
        return images;
    }

    @RequestMapping("/imgOne")
    @ResponseBody
    public Image img(int imgId){
        System.out.println("int:"+imgId);
        //System.out.println("int:"+imgId);
        Image img = userService.findImageOne(imgId);
        System.out.println(img);
        return img;
    }

    @RequestMapping(value = "/imgLike")
    @ResponseBody
    public List<Image> imgLike(String imgName){
        List<Image> img = userService.findImgByImgName(imgName);
        return img;
    }

    @RequestMapping("/search_img")
    public String search_img(){
        return "search_img";
    }
}
