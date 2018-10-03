import java.io.Serializable;
import java.util.List;


/**
 * @author 舒露
 */
public interface BaseDao<ENTITY, ID extends Serializable> {
    /**
     * 保存
     *
     * @param entity 实体
     */
    void save(ENTITY entity);

    /**
     * 更新
     *
     * @param entity 实体
     */
    void update(ENTITY entity);

    /**
     * 删除
     *
     * @param id ID
     */
    void delete(ID id);

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return 实体
     */
    ENTITY findById(ID id);

    /**
     * 获取所有
     *
     * @return 所有集合
     */
    List<ENTITY> getAll();

    /**
     * 是否存在
     *
     * @param id ID
     * @return 存在返回<code>true</code>,否则返回<code>false</code>
     */
    boolean exists(ID id);
}

