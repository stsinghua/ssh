package cn.stsinghua.service;

import cn.stsinghua.pojo.Customer;
import cn.stsinghua.pojo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author stsinghua
 * @date 19-3-8下午6:51
 */
public interface CustomerService {

    void save(Customer customer);

    Customer findById(int cid);

    void delete(Customer customer);

    void update(Customer customer);

    PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
