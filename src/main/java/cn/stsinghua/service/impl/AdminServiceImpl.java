package cn.stsinghua.service.impl;

import cn.stsinghua.dao.AdminDao;
import cn.stsinghua.pojo.Admin;
import cn.stsinghua.service.AdminService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author stsinghua
 * @date 19-3-10下午6:02
 */
@Transactional
public class AdminServiceImpl implements AdminService {

    /**
     * 注入
     */
    private AdminDao adminDao;
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    /**
     * 登录的方法
     */
    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}
