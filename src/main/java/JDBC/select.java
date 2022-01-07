package JDBC;

import JavaBean.User;
import JavaBean.memorandum;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;
public class select {
    private Connection con = Con.GetCon();
    private QueryRunner qr = new QueryRunner();

    /**
     *  查询语句，返回一个user对象的方法
     * @param ars  需要传入用户的name和psd，用于查询条件
     * @return 如果查询到数据返回一个user对象，否则返回空对象，可以根据这个对象的返回值来判断是否查询到数据
     */
    public   List<User> select(String sql , String... ars){
        try {
          return  qr.query(con,sql,new BeanListHandler<User>(User.class),ars);
        } catch (Exception throwables) {
            return  null;
        }finally {
            Con.close(con);
        }
    }

    public List<memorandum> selectmemo(String sql,Object... ars){
        try {
         return  qr.query(con,sql,new BeanListHandler<memorandum>(memorandum.class),ars);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  null;
    }



}
