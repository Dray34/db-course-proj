package org.skywalker.mapper;

import org.skywalker.entity.Role;

import java.util.ArrayList;

public interface RoleDao {
    int updateByPrimaryKey(Role role);
    Role selectByPrimaryKey(Integer roleId);
    ArrayList<Role> selectAll();
}
