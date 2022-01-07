package interimp;

import JDBC.insert;
import inter.regist;

public class registimp implements regist {

    /**
     *
     * @param ars 需要注册的用户的信息， 比如用户名，密码，邮箱等
     * @return   注册成功返回的数字为正数， 否则为负数
     */
    @Override
    public int Regist(Object... ars) {
        return insert.inse(ars);
    }



}
