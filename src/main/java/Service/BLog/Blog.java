package Service.BLog;

import Dao.db.blog.blog;
import JavaBean.blogs;
import Mybatis.Mybatis;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "Blog", value = "/Blog")
public class Blog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession ss =Mybatis.GetSqlsession();
        blog b = ss.getMapper(blog.class);
        List<blogs> s = b.Select();
        Gson g= new Gson();
        String res = g.toJson(s);
        response.setHeader("content-type","text/json;charset=utf-8");
        response.getWriter().println(res);
    }
}
