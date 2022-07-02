package pub.zgq.CloudAlbum.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Image {
    private int imgId;
    private String imgName;
    private String fileName;
    private String time;//上传时间
    private String albumName;//相册名称
    private String size;//文件大小

    public Image() {
    }

    public Image(int imgId, String imgName, String fileName, String time, String albumName, String size) {
        this.imgId = imgId;
        this.imgName = imgName;
        this.fileName = fileName;
        this.time = time;
        this.albumName = albumName;
        this.size = size;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imgId=" + imgId +
                ", imgName='" + imgName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", time='" + time + '\'' +
                ", albumName='" + albumName + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
