package Service.Home;

import com.google.gson.Gson;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet (name = "pay", value = "/pay")
public class pay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      String path2= "image/1.png";
//      List<String> url = this.imageurl();
//      String ppath = this.getServletContext().getRealPath(path2);
//        //输出测试一下路径
//        System.out.println(ppath);
//        //使用路径创建输入流
//        FileInputStream in = new FileInputStream(ppath);
//        //创建一个输出流到浏览器
//        ServletOutputStream out = response.getOutputStream();
//        int length = 0;
//        byte[] buffer = new byte[in.available()];
//        while ((length = in.read(buffer)) != -1){
//            out.write(buffer);
//        }
//        in.close();
        response.setHeader("Content-Type","text/plain;charset=utf-8");

        response.getWriter().println(this.text());

    }

    /**
     * 拿到image文件夹下的所有资源名称
     * @return list集合，包含image目录下的所有资源名，浏览器通过该名称可以直接访问服务器上的图片资源
   */
    private List<String> imageurl(){
//        映射路径，通过浏览器可以访问
//      /Users/brother/Java_vue/target/Java_vue-1.0-SNAPSHOT/image
//        httP://127.0.0.1:9001/image
//        存储文件地址
        String urlpath ="/Users/brother/Java_vue/src/main/webapp/image";
        String broew = "httP://127.0.0.1:9001/image";
        File f = new File(urlpath);
        Boolean dir = f.isDirectory();
        File[] fs=  f.listFiles();
        List<String> list = new ArrayList<>();
        if(dir){
            for(File fi : fs){
                list.add(broew+"/"+fi.getName());
            }
        }
   return list;
    }

    private  String text(){
        String urlpath ="/Users/brother/Java_vue/src/main/webapp/image";
        String broew = "http://127.0.0.1:9001/image";
        File f = new File(urlpath);
        Boolean dir = f.isDirectory();
        File[] fs=  f.listFiles();
        List<String> list = new ArrayList<>();
        if(dir){
            for(File fi : fs){
                list.add(broew+"/"+fi.getName());
            }
        }
        String[] str = new String[list.size()];
        List< Map<String,String>> ll = new ArrayList<>();
        Gson gson = new Gson();
        for(int i =0;i<list.size();i++){
            Map<String,String> ss = new HashMap<>();
            ss.put("url", list.get(i));
            ss.put("content","来自深海的水母");
            ll.add(ss);
        }
        return  gson.toJson(ll);
    }

    public static String GetImageStrFromUrl(String imgURL) {
        try {
            File f = new File(imgURL);
            if(f.exists()){
                FileInputStream file = new FileInputStream(f);
                byte[] bytes = new byte[file.available()];
                file.read(bytes);
                BASE64Encoder base64Encoder = new BASE64Encoder();
                return    base64Encoder.encode(bytes);
            }else {
                throw  new Exception("文件地址不存在");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}


