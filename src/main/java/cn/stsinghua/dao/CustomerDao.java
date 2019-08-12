package cn.stsinghua.dao;

import cn.stsinghua.pojo.Customer;
import cn.stsinghua.pojo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author stsinghua
 * @date 19-3-8下午6:50
 */
public interface CustomerDao {

    Customer findById(int cid);

    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
