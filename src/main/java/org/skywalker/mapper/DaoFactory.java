package org.skywalker.mapper;

import org.skywalker.entity.Actor;
import org.skywalker.entity.Permission;
import org.skywalker.mapper.impl.*;

public class DaoFactory
{
    private volatile static DaoFactory instance = null;
    private DaoFactory() {}
    public static DaoFactory getInstance() {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                instance = new DaoFactory();
            }
        }
        return instance;
    }

    public ActorDao getActorDao() { return new ActorDaoImpl(); }

    public MoiveDao getMoiveDao() { return new MoiveDaoImpl(); }

    public UserDao getUserDao() { return new UserDaoImpl(); }

    public PermissionDao getPermissionDao() { return new PermissionDaoImpl(); }

    public RoleDao getRoleDao() { return new RoleDaoImpl(); }

    public RolePermissionDao getRolePermissionDao() { return new RolePermissionDaoImpl(); }
}
