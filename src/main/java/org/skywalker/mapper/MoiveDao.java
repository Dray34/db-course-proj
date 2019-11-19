package org.skywalker.mapper;

import org.skywalker.entity.Moive;

public interface MoiveDao {
    int deleteByPrimaryKey(Integer movieid);
    int insert(Moive moive);
    Moive selectByPrimaryKey(Integer movieid);
    int updateByPrimaryKey(Moive moive);
}
