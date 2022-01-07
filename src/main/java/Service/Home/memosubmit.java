package Service.Home;

import JDBC.insert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "memosubmit", value = "/memosubmit")
public class memosubmit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title =  request.getParameter("title");
        String content = request.getParameter("content");
        int i = insert.insememo(title,content);
        if (i >0){
            response.getWriter().println("ok");
            response.setStatus(200);
        }else {
            response.setHeader("content-type", "text/plain");
            response.getWriter().println("失败");
            response.setStatus(400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
