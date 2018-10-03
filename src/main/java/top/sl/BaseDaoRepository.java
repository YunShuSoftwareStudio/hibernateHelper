package top.sl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Base Dao
 * <p>
 * You should extends this class in your dao implements<br/>
 * such as:<br/>
 * <code>
 * public class UserDaoImpl extends top.sl.BaseDaoRepository<User, String> implements UserDao
 * </code>
 *
 * @author 舒露
 * @see org.springframework.orm.hibernate5.support.HibernateDaoSupport
 */
public abstract class BaseDaoRepository<ENTITY, ID extends Serializable> extends HibernateDaoSupport implements BaseDao<ENTITY, ID> {
    private Class clazz;
    private String className;

    public BaseDaoRepository() {
        //获取带有泛型的父类
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        clazz = (Class) pt.getActualTypeArguments()[0];
        className = clazz.getSimpleName();
    }

    @Override
    public void delete(ID id) {
        currentSession()
                .createQuery("delete from " + className + " where id=?")
                .setParameter(0, id)
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ENTITY findById(ID id) {
        return (ENTITY) currentSession().get(clazz, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ENTITY> getAll() {
        return currentSession().createQuery("from " + className).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean exists(ID id) {
        return currentSession().load(clazz, id) != null;
    }

    @Override
    public void save(ENTITY t) {
        currentSession().save(t);
    }

    @Override
    public void update(ENTITY t) {
        currentSession().update(t);
    }
}
