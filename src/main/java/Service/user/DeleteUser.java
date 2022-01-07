package Service.user;

import Mybatis.Mybatis;
import now.uuserdao;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "DeleteUser", value = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             try {
                 String name =  request.getParameter("username");
                 int id = Integer.parseInt(request.getParameter("id"));
                 SqlSession ss = Mybatis.GetSqlsession();
                 uuserdao us = ss.getMapper(uuserdao.class);
                 int i = us.DeleteUser(name,id);
                 ss.commit();
                 if(i > 0) {
                     response.setHeader("Content-type", "text/plain;charset=utf-8");
                     response.getWriter().println("用户删除成功");
                 }else {
                     response.setHeader("Content-type", "text/plain;charset=utf-8");
                     response.getWriter().println(" 该用户不能被删除～～～");
                 }
             }catch (Exception e) {
                 response.setHeader("Content-type", "text/plain;charset=utf-8");
                 response.getWriter().println("该用户不能被删除～～～");
             }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
