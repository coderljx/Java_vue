package interimp;

import JDBC.select;
import JavaBean.User;
import inter.login;

import java.util.List;

public class loginimp implements login {

    @Override
    public  boolean login(String sql,String name, String psd) {
        select s= new select();
        List<User> us= s.select(sql,name,psd);
        if(!us.isEmpty()){
           return true;
        }
     return  false;
    }


}
