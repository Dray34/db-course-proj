package org.skywalker.mapper.impl;

import org.skywalker.entity.Permission;
import org.skywalker.entity.Role;
import org.skywalker.entity.RolePermission;
import org.skywalker.mapper.DaoBase;
import org.skywalker.mapper.RolePermissionDao;

import java.sql.SQLException;

public class RolePermissionDaoImpl extends DaoBase implements RolePermissionDao {

    @Override
    public int deleteByPrimaryKeys(Integer permissionId, Integer roleId) {
        sql = "delete from role_permission where permission_id=? and role_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, permissionId);
            ps.setInt(2, roleId);
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public int insert(Permission permission, Role role) {
        sql = "insert into role_permission values(?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, permission.getPermissionId());
            ps.setInt(2, role.getRoleId());
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }
}
