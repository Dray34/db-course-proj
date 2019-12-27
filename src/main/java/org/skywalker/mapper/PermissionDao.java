package org.skywalker.mapper;

import org.skywalker.entity.Permission;

import java.util.ArrayList;

public interface PermissionDao {
    int deleteByPrimaryKey(Integer permission);
    int insert(Permission permission);
    Permission selectByPrimaryKey(Integer permission);
    int updateByPrimaryKey(Permission permission);
    ArrayList<Permission> selectAll();

    ArrayList<Permission> selectPermissionsByRoleId(Integer roleId);
}
