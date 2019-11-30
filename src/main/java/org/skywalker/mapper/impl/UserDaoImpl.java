package org.skywalker.mapper.impl;

import org.skywalker.entity.User;
import org.skywalker.mapper.DaoBase;
import org.skywalker.mapper.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl extends DaoBase implements UserDao {

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        sql = "delete from usert where user_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public int insert(User user) {
        sql = "insert into usert (user_id, label, name, password, phone, email)" +
                " values(?,?,?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getLabel());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        User user = new User();
        sql = "select * from usert where user_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setLabel(rs.getString("label"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }

        return user;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        sql = "update usert set label=?,name=?,password=?,phone=?,email=? where user_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getLabel());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getUserId());

            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> userList = new ArrayList<>();
        User user;
        sql = "select * from usert";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int column = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setLabel(rs.getString("label"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }

        return userList;
    }
}
