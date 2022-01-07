package Test1;

import Dao.db.blog.blog;
import JDBC.insert;
import JDBC.select;
import JavaBean.User;
import JavaBean.blogs;
import JavaBean.memorandum;
import Mybatis.Mybatis;
import com.google.gson.Gson;
import domain.Uuser;
import interimp.memorandumsimp;
import now.uuserdao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.iiImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

     @Test
    public  void  cc(){
         memorandumsimp imp = new memorandumsimp();
         List<memorandum> list = imp.selectall();
         Gson g = new Gson();
         Map<String,List<memorandum>> map = new HashMap<>();
         memorandum mm =(memorandum) map.put("msg", list);
         System.out.println(map);

    }


    @Test
    public  void inssert(){
        insert i = new insert();
        int c = insert.insememo("api","使用接口新增");
        System.out.println(c);
    }



    @Test
    public  void login() throws Exception{
        select s = new select();
        List<User> u  = s.select("select * from user");
        u.size();

    }


    @Test
    public  void file(){
        String urlpath ="/Users/brother/Java_vue/src/main/webapp/image";
        String broew = "http://127.0.0.1:9001/image";
        File f = new File(urlpath);
        Boolean dir = f.isDirectory();
        File[] fs=  f.listFiles();
        List<String> list = new ArrayList<>();
        if(dir){
            for(File fi : fs){
                list.add(broew + "/" + fi.getName());
            }
        }
        Gson gson = new Gson();
        List<Map<String,String>> ll = new ArrayList<>();
        Map<String,String> ss = new HashMap<>();
        for(int i =0;i<list.size();i++){
            ss.put("title","水母");
            ss.put("url", list.get(i));
            ss.put("content","来自深海的水母");
            ll.add(ss);
            ss.clear();
        }
        String aa = gson.toJson(ll);
    }


    @Test
    public  void mybatis(){
        SqlSession ss =  Mybatis.GetSqlsession();
        uuserdao us = ss.getMapper(uuserdao.class);
        int i = us.DeleteUser("Michael Jordan", 18);
        ss.commit();
        System.out.println(i);
    }


    @Test
    public  void spring(){
         String res = "Dao/db/blog/beans.xml";
         ApplicationContext app = new ClassPathXmlApplicationContext(res);
         iiImpl  i =  (iiImpl) app.getBean("ii");
         i.seat();
         System.out.println(i.getName());

    }

    @Test
    public  void invocat(){
        select s = new  select();
        List<User> li = s.select("select * from user where `username` = ? and  `password` = ?", "Brother","321");
        User ss = li.get(0);
        System.out.println(ss.toString());
    }


    @Test
    public  void page(){
       int page = 2;
        SqlSession ss = Mybatis.GetSqlsession();
        uuserdao us = ss.getMapper(uuserdao.class);
        if(page == 1){
            List<Uuser> uss = us.GetPage(0,10);
            uss.forEach( item -> {
                System.out.println(item);
            });

        }else {
            int to = page * 10;
            int from = to - 11;
            List<Uuser> uss = us.GetPage(from, to);
            uss.forEach( item -> {
                System.out.println(item);
            });
        }
    }

   @Test
    public  void blog(){
         SqlSession ss = Mybatis.GetSqlsession();
         blog b = ss.getMapper(blog.class);
        List<blogs>  bs = b.Select();
         bs.forEach(s -> {
             System.out.println(s);
         });
   }


}
