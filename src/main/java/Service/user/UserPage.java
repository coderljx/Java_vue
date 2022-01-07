package Service.user;

import Mybatis.Mybatis;
import com.google.gson.Gson;
import domain.Uuser;
import now.uuserdao;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 对用户信息进行分页
@WebServlet(value = "/page")
public class UserPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/json;charset=utf-8");
        Map<String,String> map = new HashMap();
        Gson g = new Gson();
        List<Uuser> us =  this.Page(req);
        if(us == null ){
            map.put("msg", "无数据");
            resp.getWriter().println( g.toJson(map) );
        } else  {
            resp.getWriter().println(  g.toJson(us)  );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



    private  List<Uuser> Page(HttpServletRequest req){
        int page = Integer.valueOf(req.getParameter("page"));
        System.out.println(req.getParameter("page"));
        SqlSession ss = Mybatis.GetSqlsession();
        uuserdao us = ss.getMapper(uuserdao.class);
        if(page == 1){
            List<Uuser> uss = us.GetPage(0,10);
            return uss;
        }else {
            int to = page * 10;
            int from = to - 11;
             List<Uuser> uss = us.GetPage(from, to);
             return uss;
        }
    }


}
