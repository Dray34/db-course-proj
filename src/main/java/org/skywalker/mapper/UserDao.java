package org.skywalker.mapper;

import org.skywalker.entity.User;

import java.util.ArrayList;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);
    int insert(User user);
    User selectByPrimaryKey(Integer userId);
    int updateByPrimaryKey(User user);
    ArrayList<User> selectAll();
}
