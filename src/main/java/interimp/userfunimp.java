package interimp;

import JDBC.select;
import JavaBean.User;
import inter.userfun;

import java.util.List;

public class userfunimp implements userfun {
    /**
     * 获取所有用户的所有信息
     * @return 返回list集合，所有的用户都在该集合中，如果返回为null，则表示没有用户或查询异常
     */
    @Override
    public List<User> Alluser() {
        select s = new select();
        List<User> u  = s.select("select * from user");
       if(u.size() > 0) {
           return u;
       }
        return  null;
    }
}
