package com.example.javapythonstory.code.util;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传下载工具类
 */
public class FileUtil {

    /**
     *
     * @param imgFile 接收前端上传的图片
     * @param path 服务器储存图片的路径
     * @return 返回路径，用于前端删除图片
     * @throws IOException 抛出io流异常
     */
    public static String addImg(MultipartFile imgFile, String path) throws IOException {
        File imgFolder=new File(path);
        if (!imgFolder.exists()) {
            imgFolder.mkdir();
        }
        InputStream fis = null;
        String filePath = null;
        fis = imgFile.getInputStream();
        String imageName = imgFile.getName() + ".jpg";
        filePath = path + "/" + imageName;
        //服务器上使用
        File img = new File(filePath);
        FileOutputStream fos = new FileOutputStream(img);
        byte[] bytes=new byte[1024*8];
        int len;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
        //本地测试使用
//        return filePath;
        //服务器上使用
        String id = path.replace("/usr/local/src/spring/file/image/","");
        return "/file/image/" + id + "/" + imageName;
    }

    /**
     *
     * @param videoFile 接收前端上传的图片
     * @param path 服务器储存图片的路径
     * @return 返回路径，用于前端删除图片
     * @throws IOException 抛出io流异常
     */
    public static String addVideo(MultipartFile videoFile,String path) throws IOException {
        File videoFolder = new File(path);
        if (!videoFolder.exists()) {
            videoFolder.mkdir();
        }
        InputStream fis= null;
        String filePath = null;
        fis = videoFile.getInputStream();
        String videoName = videoFile.getName() + ".mp4";
        filePath = path + "/" + videoName;
        //服务器上使用
        File img = new File(filePath);
        FileOutputStream fos = new FileOutputStream(img);
        byte[] bytes=new byte[1024*8];
        int len;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
        //本地测试使用
        //return filePath;
        //服务器上使用
        String id = path.replace("/usr/local/src/file/","");
        return "/file/video/" + id + "/" + videoName;
    }

    /**
     * 删除图片
     * @param filename 要删除的图片的路径
     * @return 返回删除后剩余图片的路径
     */
    public static Boolean deleteFile(String filename){
        File file=new File(filename);
        return file.delete();
    }

}
