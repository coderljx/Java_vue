package now;

import domain.Uuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface uuserdao {

    /**
     * 根据 id 查找用户
     * @param id  用户id
     * @return  返回一查询到的用户，如果返回null，则表示没有这个id的用户
     */
    domain.Uuser selectuser(@Param("id") Integer id);

    /**
     *  查询所有用户的信息
     * @return  返回一个list集合
     */
    List<Uuser> selectAll();

    /**
     *  根据用户名id 删除用户
     * @param name  用户名
     * @param id  用户ID
     * @return  删除成功返回1
     */
    int DeleteUser(@Param("name") String name, @Param("id") Integer id);

    /**
     *  页面的分页功能， 返回指定的页面信息
     * @param page 输入想要获得的起始数据数
     * @return 返回list集合， 包含了该页的所有信息
     */
    List<Uuser> GetPage(@Param("page") int page,@Param("page2") int page2);

}
