package Service.Home;


import JDBC.select;
import JavaBean.User;
import com.google.gson.Gson;
import interimp.loginimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 必须要加/ ， 因为映射的地址是webapp， 不加/ 没办法找到这个servlet程序
@WebServlet(value = "/login")
public class login extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        String name = req.getParameter("name");
        String psd = req.getParameter("psd");
        resp.getWriter().println("ok");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader ins = req.getReader();
//         json转换成user对象
        User us = gson.fromJson(ins, User.class);
        select s = new select();
        Map<String, Object> map = new HashMap<>();
        try {
            List<User> coc = s.select("select * from user where `username` = ? and  `password` = ?",
                    us.getUsername(),
                    us.getPassword());
            int i = coc.get(0).getId();
                resp.setHeader("content-type", "text/plain; charset=utf-8");
                map.put("id", i);
                map.put("msg", "用户登陆成功");
                resp.getWriter().println(gson.toJson(map));
            }catch (Exception e)
        {
            resp.setHeader("content-type", "text/plain;charset=utf-8");
            map.put("msg", "用户名或密码错误");
            String ss = gson.toJson(map);
            resp.getWriter().println(ss);
        }
    }



//  登陆方法， 用于用户名密码登陆
    private Boolean login(String name,String psd)  {
        loginimp loginimp = new loginimp();
        return loginimp.login("select * from user where `username` = ? and  `password` = ?",name,psd);
    }


}
