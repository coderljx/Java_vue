package JDBC;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class insert {
    private static Connection con = Con.GetCon();
    private static QueryRunner qr = new QueryRunner();


    /**
     * 该方法用于注册操作，其他操作暂时没有匹配
     * @param ars 注册用户时需要传入的参数， 根据数据库字段
     *            字段顺序： 用户名，密码， 邮箱，如果没有则用null表示
     * @return 返回-1 表示没有新增数据成功， 其他表示新增成功
     */
    public static int  inse(Object... ars){
        String sql = "insert  into user(username,password,email) values(?,?,?)";
        try {
            return qr.update(con, sql,ars);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return  -1;
    }

    /**
     *
     * @param ars  第一个参数是title，第二个参数是content
     * @return 如果写入成功则返回正数， 否则返回-1
     */
    public static int  insememo(Object... ars){
        String sql = "insert  into memorandum values(null ,?,?)";
        try {
            return qr.update(con, sql,ars);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return  -1;
    }
}
