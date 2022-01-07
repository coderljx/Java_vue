package inter;

public  interface regist {
    /**
     * 用于注册用户的接口，
     * @param ars 需要注册的用户的信息， 比如用户名，密码，邮箱等
     * @return 注册不成功则返回-1， 否则为正数
     */
    int Regist(Object... ars);
}
