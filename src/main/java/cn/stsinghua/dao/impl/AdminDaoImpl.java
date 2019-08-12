package cn.stsinghua.dao.impl;

import cn.stsinghua.dao.AdminDao;
import cn.stsinghua.pojo.Admin;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author stsinghua
 * @date 19-3-10下午6:03
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

    /**
     * 登录
     */
    public Admin login(Admin admin) {
        //使用QBC的查询
        DetachedCriteria criteria = DetachedCriteria.forClass(Admin.class);
        criteria.add(Restrictions.eq("name", admin.getName()));
        criteria.add(Restrictions.eq("password", admin.getPassword()));
        //查询
        List<Admin> list = (List<Admin>) this.getHibernateTemplate().findByCriteria(criteria);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
