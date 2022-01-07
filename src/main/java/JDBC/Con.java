package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Con {

    /**
     *
     * @return  返回一个链接对象，链接的数据库是book
     *  以通过测试， 可以获取该链接对象
     */
    public static Connection  GetCon(){
        try {
//           通过反射加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/book";
            String name = "root";
            String psd = "12341234";
            Connection con = DriverManager.getConnection(url,name,psd);
            return con;
        }catch (Exception e){}
//        如果执行到这里了， 说明链接没有获取成功，那么就直接返回null
        return  null;
    }

    /**
     *  在获取资源后，需要将链接关闭，使用该方法
     * @param con 链接对象
     */
    public static void  close(Connection con){
        if(con != null) {
            try {
                con.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public  boolean ss(String name,String psd) throws Exception{
        PreparedStatement ps = GetCon().prepareStatement("select * from user where `username` = ? and  `password` = ?");
        ps.setString(1, name);
        ps.setString(2,psd);
       return ps.execute();
    }


}
