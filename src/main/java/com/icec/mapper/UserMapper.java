package com.icec.mapper;

import com.icec.enums.UserStatusEnum;
import com.icec.modal.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jqChu on 2017/6/17.
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
@Repository
public interface UserMapper{

    @Select("select * from user")
    @Results({
            @Result(property = "userName", column = "username"),
            @Result(property = "nickName", column = "nickname"),
            @Result(property = "status", column = "status", javaType = UserStatusEnum.class)
    })
    List<User> getAll();

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(property = "userName", column = "username"),
            @Result(property = "nickName", column = "nickname"),
            @Result(property = "status", column = "status", javaType = UserStatusEnum.class)
    })
    User find(Long id);

    @Insert("insert into user(userName, nickName, password, status) values (#{userName},#{nickName},#{password}, #{status})")
    void insert(User user);

    @Update("update user set userName=#{userName},nickName=#{nickName} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Long id);

}
