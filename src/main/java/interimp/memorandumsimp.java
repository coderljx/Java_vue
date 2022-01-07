package interimp;

import JDBC.select;
import JavaBean.memorandum;
import inter.memorandums;

import java.util.List;

public class memorandumsimp implements memorandums {
    /**
     *
     * @param ars  这个参数可以传入也可以不传入,传入可以根据请求id去查询， 不传入是查询所有的数据
     * @return 返回一个list集合， 包含了查询到的所有信息
     */
    @Override
    public List<memorandum> selectall(Object... ars) {
        select s = new select();
//        如果ars数组第一个有值，可变参数其实就是数组
        if(ars != null){
            String sql = "select * from memorandum";
            List<memorandum> list =  s.selectmemo(sql);
            if(list != null) {
                return  list;
            }
        }else {
            String sql = "select * from memorandum where id = ?";
            List<memorandum> list =  s.selectmemo(sql);
            if(list != null) {
                return  list;
            }
        }
        return  null;
    }


}
