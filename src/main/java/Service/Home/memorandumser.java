package Service.Home;

import Dao.Memo.Memo;
import JavaBean.memorandum;
import Mybatis.Mybatis;
import com.google.gson.Gson;
import interimp.memorandumsimp;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "memorandum", value = "/memo")
public class memorandumser extends HttpServlet {
    private  Gson g = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        memorandumsimp imp = new memorandumsimp();
        List<memorandum> list = imp.selectall();

//        Map<String,List<memorandum>> map = new HashMap<>();
//        memorandum mm =(memorandum) map.put("msg", list);
//        告诉浏览器下载该文件，同时设置文件名称
//        response.setHeader("content-disposition","attachment;filename=api");
        response.addHeader("Content-Type","text/json;charset=UTF-8");
        response.getWriter().println(this.json());
    }

    private  String json(){
        SqlSession ss = Mybatis.GetSqlsession();
        Memo me = ss.getMapper(Memo.class);
        List<memorandum> clas = me.selectAll();
        String res = g.toJson(clas);
         return  res;
    }
}
