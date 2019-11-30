package org.skywalker.mapper.impl;

import org.skywalker.entity.Permission;
import org.skywalker.mapper.DaoBase;
import org.skywalker.mapper.PermissionDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class PermissionDaoImpl extends DaoBase implements PermissionDao {
    @Override
    public int deleteByPrimaryKey(Integer permission) {
        sql = "delete from permission where permission_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, permission);
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public int insert(Permission permission) {
        sql = "insert into permission (permission_id, url, description) values(?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, permission.getPermissionId());
            ps.setString(2, permission.getUrl());
            ps.setString(3, permission.getDescription());
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Permission selectByPrimaryKey(Integer permissionId) {
        Permission permission = new Permission();
        sql = "select * from permission where permission_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, permissionId);
            rs = ps.executeQuery();
            if (rs.next()) {
                permission.setPermissionId(rs.getInt("permission_id"));
                permission.setUrl(rs.getString("url"));
                permission.setDescription(rs.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }
        return permission;
    }

    @Override
    public int updateByPrimaryKey(Permission permission) {
        sql = "update permission set url=?,description=? where permission_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, permission.getUrl());
            ps.setString(2, permission.getDescription());
            ps.setInt(3, permission.getPermissionId());

            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public ArrayList<Permission> selectAll() {
        Permission permission;
        ArrayList<Permission> permissions = new ArrayList<>();
        sql = "select * from permission";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                permission = new Permission();
                permission.setPermissionId(rs.getInt("permission_id"));
                permission.setUrl(rs.getString("url"));
                permission.setDescription(rs.getString("description"));
                permissions.add(permission);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }
        return permissions;
    }

    @Override
    public ArrayList<Permission> selectPermissionsByRoleId(Integer roleId) {
        Permission permission;
        ArrayList<Permission> permissions = new ArrayList<>();
        sql = "select * from permission inner join " +
                "role_permission on " +
                "permission.permission_id=role_permission.permission_id where " +
                "role_permission.role_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            while (rs.next()) {
                permission = new Permission();
                permission.setPermissionId(rs.getInt("permission_id"));
                permission.setUrl(rs.getString("url"));
                permission.setDescription(rs.getString("description"));
                permissions.add(permission);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }
        return permissions;
    }
}
