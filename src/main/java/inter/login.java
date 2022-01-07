package inter;

public interface login {
    /**
     * 用户登陆接口
     * @param name 需要登陆的用户id
     * @param psd  用户密码
     * @return true 表示登陆成功，否则为失败，用户名或密码错误
     */
    public  boolean login(String sql,String name,String psd);

}
