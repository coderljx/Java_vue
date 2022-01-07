package Mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Mybatis {
    private static SqlSession ss = null;

    public static SqlSession GetSqlsession(){
        try {
            InputStream in = Resources.getResourceAsStream("Dao/db/blog/mybatis.xml");
            SqlSessionFactory fa = new SqlSessionFactoryBuilder().build(in);
            return  ss = fa.openSession();
        }catch (Exception e) {
            e.printStackTrace();
        }
     return null;
    }
}
