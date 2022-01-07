package Service.user;

import Mybatis.Mybatis;
import com.google.gson.Gson;
import domain.Uuser;
import email.SendEamil;
import now.uuserdao;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet (name = "UserFun", value = "/user")
public class UserFun extends HttpServlet {
  private  Gson g = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String send =  request.getParameter("send");
        response.setHeader("Content-type", "text/json;charset=utf-8");
        if(send.equals("true")){
            SendEamil s = new SendEamil();
            s.SendEmailY();
            List<Map<String,String>> list = new ArrayList();
            Map<String,String> map = new HashMap<>();
            map.put("msg", "发送成功");
            list.add(map);
            response.getWriter().println(g.toJson(list));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    InputStream in = request.getInputStream();
     if(in.read() < 1) {
         String json = this.json();
         response.setHeader("Content-Type","text/json;charset=utf-8");
         response.getWriter().println(json);
     }
    }

    private  String json(){
        Mybatis ba = new Mybatis();
        SqlSession ss = ba.GetSqlsession();
        uuserdao us = ss.getMapper(uuserdao.class);
        List<Uuser> uusers = us.selectAll();
        return g.toJson(uusers);
    }

}
