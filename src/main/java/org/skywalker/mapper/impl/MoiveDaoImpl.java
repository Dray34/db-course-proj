package org.skywalker.mapper.impl;

import org.skywalker.entity.Moive;
import org.skywalker.mapper.DaoBase;
import org.skywalker.mapper.MoiveDao;

import java.sql.SQLException;

public class MoiveDaoImpl extends DaoBase implements MoiveDao {

    @Override
    public int deleteByPrimaryKey(Integer movieid) {
        sql = "delete from movie where movie_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, movieid);
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public int insert(Moive moive) {
        sql = "insert into movie (movie_id, name, rate, imdb_id, alias)" +
                " values(?,?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, moive.getMoiveId());
            ps.setString(2, moive.getName());
            ps.setFloat(3, moive.getRate());
            ps.setString(4, moive.getImdbId());
            ps.setString(5, moive.getAlias());
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }
        return ret;
    }

    @Override
    public Moive selectByPrimaryKey(Integer movieid) {
        Moive moive = new Moive();
        sql = "select * from movie where movie_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                moive.setMoiveId(rs.getInt("moive_id"));
                moive.setName(rs.getString("name"));
                moive.setRate(rs.getFloat("rate"));
                moive.setImdbId(rs.getString("imdb_id"));
                moive.setAlias(rs.getString("alias"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecutionRet();
        }
        return moive;
    }

    @Override
    public int updateByPrimaryKey(Moive moive) {
        sql = "update movie set name=?,rate=?,imdb_id=?,alias=? where movie_id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, moive.getName());
            ps.setFloat(2, moive.getRate());
            ps.setString(3, moive.getImdbId());
            ps.setString(4, moive.getAlias());
            ps.setInt(5, moive.getMoiveId());
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endExecution();
        }

        return ret;
    }
}
