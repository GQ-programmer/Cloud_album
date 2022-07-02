package pub.zgq.CloudAlbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pub.zgq.CloudAlbum.pojo.Image;
import pub.zgq.CloudAlbum.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class FileController {
    @Autowired
    private Image img;
    @Autowired
    private UserService userService;
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session, String fileName, HttpServletResponse response) throws
            IOException {
        System.out.println(fileName);
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/images/"+fileName);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);

        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        //headers.add("content-type", "text/html");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        System.out.println(responseEntity);
        //关闭输入流
        is.close();
        //response.setContentType("text/html");
        return responseEntity;
    }

    @RequestMapping(value = "/testUp",method = RequestMethod.POST)
    //@ResponseBody
    public String testUp(MultipartFile images,String imgName,String album,HttpSession
                          session) throws IOException {
        /*System.out.println("imgName----->"+imgName+"album-------->"+album);
        System.out.println(images);
        */
        //获取文件名称
        String fileName = images.getOriginalFilename();

        //获取上传的文件后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //将UUID作为文件名
        String uuid = UUID.randomUUID().toString();
        //文件名
        fileName = uuid + suffixName;

        ServletContext servletContext = session.getServletContext();
        //获得images文件夹的真实路径
        String imagesPath = servletContext.getRealPath("images");
        File file = new File(imagesPath);
        //判断是否存在
        if (!file.exists()){
            //若不存在，则创建目录
            file.mkdir();
        }
        //最终文件路径
        String finalPath = imagesPath + File.separator + fileName;
        images.transferTo(new File(finalPath));

        //保存图片信息
        img.setImgName(imgName);
        img.setAlbumName(album);
        img.setFileName(fileName);
        DateFormat dateInstance = DateFormat.getDateInstance();
        //System.out.println(dateInstance.format(new Date()));
        img.setTime(dateInstance.format(new Date()));
        img.setSize(String.valueOf(images.getSize()));
        //调用service保存信息
        userService.saveImg(img);

        System.out.println(img);
        //Image{imgId='0', imgName='老君山',
        // fileName='85c3c490-a5f5-42fd-a468-f5cece381b84.jpg',
        // date=Thu Jan 20 18:04:31 CST 2022, albumName='老君山',
        // size='287673'}
        return "upload";
    }
}
