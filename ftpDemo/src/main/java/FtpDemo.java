import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * @Description:FTP示例代码
 * @Author:Rogear
 * @Time:2019/12/4 13:46
 */
public class FtpDemo {

    /**
     *  上传文件
     * @param host FTP服务器ip
     * @param username 登陆账户
     * @param password 登陆密码
     * @param localPath 待上传文件路径
     * @param uploadPath 上传目标路径
     * @param fileName 上传文件名称
     */
    public static void uploadFile(String host,String username,String password,String localPath,
                           String uploadPath,String fileName){
        try {
            FTPClient ftpClient = new FTPClient();
                        //连接登陆ftp
            ftpClient.connect(host);
            ftpClient.login(username,password);

            File file = new File(localPath+fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            //设置上传路径
            ftpClient.changeWorkingDirectory("/"+uploadPath);
            ftpClient.setBufferSize(1024);
            //设置编码集
            ftpClient.setControlEncoding("UTF-8");
            //设置被动模式
            ftpClient.enterLocalPassiveMode();
            //设置文件类型为二进制
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            ftpClient.storeFile(fileName,fileInputStream);
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传文件成功！");
    }

    /**
     * 下载文件
     * @param host FTP服务器ip
     * @param username 登陆账户
     * @param password 登陆密码
     * @param downloadPath 下载文件路径
     * @param localPath 下载目标路径
     * @param fileName 文件名称
     */
    public static void downloadFile(String host,String username,String password,String downloadPath,
                             String localPath,String fileName){
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(host);
            ftpClient.login(username,password);
            if (200 != ftpClient.getReplyCode()){
                System.out.println("FTP服务器连接失败！");
            } else {
                System.out.println("FTP服务器连接成功！");
            }
            //设置下载文件的路径
            ftpClient.changeWorkingDirectory(downloadPath);
            //设置编码集
            ftpClient.setControlEncoding("UTF-8");
            //设置被动模式
            ftpClient.enterLocalPassiveMode();
            //设置文件类型为二进制
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File file = new File(localPath+File.separator+fileName);
            OutputStream outputStream = new FileOutputStream(file);
            ftpClient.retrieveFile(fileName,outputStream);
            outputStream.close();
            ftpClient.logout();
            System.out.println("下载成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     * @param host FTP服务器ip
     * @param username 登陆账户
     * @param password 登陆密码
     * @param path 文件路径
     * @param fileName 需要删除的文件名称
     */
    public static void deleteFile(String host,String username,String password,String path,String fileName){
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(host);
            ftpClient.login(username,password);
            ftpClient.changeWorkingDirectory(path);
            ftpClient.deleteFile(fileName);
            ftpClient.logout();
            System.out.println("删除文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建文件夹
     * @param host FTP服务器ip
     * @param username 登陆账户
     * @param password 登陆密码
     * @param directory 文件夹名称
     */
    public static void makeDir(String host,String username,String password,String path,String directory){
        try {
            FTPClient ftpClient = new FTPClient();
            //连接FTP服务器
            ftpClient.connect(host);
            //登陆
            ftpClient.login(username,password);
            //切换路径
            ftpClient.changeWorkingDirectory(path);
            //新建文件夹
            boolean result = ftpClient.makeDirectory(directory);
            if (result){
                System.out.println("新建文件夹成功！");
            } else {
                System.out.println("新建文件夹失败！");
            }
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件夹
     * @param host FTP服务器ip
     * @param username 登陆账户
     * @param password 登陆密码
     * @param directory 文件夹名称
     */
    public static void deleteDir(String host,String username,String password,String path,String directory){
        try {
            FTPClient ftpClient = new FTPClient();
            //连接FTP服务器
            ftpClient.connect(host);
            //登陆
            ftpClient.login(username,password);
            //切换路径
            ftpClient.changeWorkingDirectory(path);
            //新建文件夹
            boolean result = ftpClient.removeDirectory(directory);
            if (result){
                System.out.println("新建文件夹成功！");
            } else {
                System.out.println("新建文件夹失败！");
            }
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        downloadFile("192.168.1.80","ftpuser","aaabbb123",
//                "/","E:\\","1.txt");

//        uploadFile("192.168.1.80","ftpuser","aaabbb123",
//                "E:\\","/home/ftpuser","2.txt");

//        deleteFile("192.168.1.80","ftpuser","aaabbb123","/home/ftpuser","1.txt");

//        makeDir("192.168.1.80","ftpuser","aaabbb123","/home/frpuser","abc");

        deleteDir("192.168.1.80","ftpuser","aaabbb123","/home/frpuser","abc");
    }
}
