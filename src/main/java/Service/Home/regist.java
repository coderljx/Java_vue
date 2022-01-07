package Service.Home;

import interimp.registimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//在映射后的根目录后输入： /regist 可以让服务器访问到这个servlet程序
@WebServlet (name = "regist", value = "/regist")
public class regist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int c =  new cc().regi(request,response);
         if(c > 0){
             response.getWriter().println("用户注册成功！");
         }else {
             response.getWriter().println("用户注册失败！");
         }
    }



    //内部类
    class  cc{
        public  int regi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            String name = request.getParameter("name");
            String psd = request.getParameter("psd");
            String email = request.getParameter("email");
            int sum = -1;
            if(name != "" && psd != "" && email != ""){
                registimp in = new registimp();
                sum = in.Regist(name,psd,email);
            }
            return  sum;
        }
    }


}

