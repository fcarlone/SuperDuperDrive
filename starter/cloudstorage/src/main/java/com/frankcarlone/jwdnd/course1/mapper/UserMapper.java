package com.frankcarlone.jwdnd.course1.mapper;

import com.frankcarlone.jwdnd.course1.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // Select
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    // Select - get userId
    @Select("SELECT userid FROM USERS WHERE username = #{username}")
    int getUserId(String username);

    // Insert
    @Insert("INSERT INTO USERS (username, salt, password, firstName, lastName) " +
            "VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    // Delete
    @Delete("DELETE FROM USERS WHERE userId = #{userId}")
    void deleteUser(int userId);

}
