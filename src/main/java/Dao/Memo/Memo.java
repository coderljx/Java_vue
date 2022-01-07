package Dao.Memo;

import JavaBean.memorandum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Memo {
    /**
     * 查询数据库中所有的数据
     * @return 返回全部信息的list集合
     */
    List<memorandum> selectAll();

    /**
     * 根据用户id，查询对应的数据
     * @param id 用户ID
     * @return 返回查询到的信息
     */
    List<memorandum> selectByid(@Param("id") Integer id);
}
