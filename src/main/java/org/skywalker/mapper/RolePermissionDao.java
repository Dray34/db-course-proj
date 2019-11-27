package org.skywalker.mapper;

import org.skywalker.entity.Permission;
import org.skywalker.entity.Role;

public interface RolePermissionDao {
    int deleteByPrimaryKeys(Integer permissionId, Integer roleId);
    int insert(Permission permission, Role role);
}
