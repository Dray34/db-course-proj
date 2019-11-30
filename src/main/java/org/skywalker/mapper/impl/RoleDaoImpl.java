package org.skywalker.mapper.impl;

import org.skywalker.entity.Role;
import org.skywalker.mapper.DaoBase;
import org.skywalker.mapper.RoleDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDaoImpl extends DaoBase implements RoleDao {

    @Override
    public int updateByPrimaryKey(Role role) {
        sql = "update role set name=?,description=? where role_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, role.getName());
            ps.setString(2, role.getDescription());
            ps.setInt(3, role.getRoleId());

            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        Role role = new Role();
        sql = "select * from role where role_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            int column = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                role.setRoleId(rs.getInt("role_id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }

        return role;
    }

    @Override
    public ArrayList<Role> selectAll() {
        ArrayList<Role> roles = new ArrayList<>();
        Role role;
        sql = "select * from role";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int column = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }

        return roles;
    }
}
