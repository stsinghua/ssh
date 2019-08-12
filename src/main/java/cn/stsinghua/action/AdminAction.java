package cn.stsinghua.action;

import cn.stsinghua.pojo.Admin;
import cn.stsinghua.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.extern.slf4j.Slf4j;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author stsinghua
 * @date 19-3-10下午5:56
 */
@Slf4j
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

    private static final Logger logger = LoggerFactory.getLogger(AdminAction.class);

    //手动new实体类
    private Admin admin = new Admin();

    /**
     * 采用模型驱动方式
     * @return
     */
    @Override
    public Admin getModel() {
        return admin;
    }

    /**
     * 注入service
     */
    private AdminService adminService;
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 登录功能
     */
    public String adminLogin(){
        try{
            Admin existAdmin = adminService.login(admin);
            String name = existAdmin.getName();
            if(existAdmin != null){
                // 登录成功,将其放到域对象中
                ServletActionContext.getRequest().setAttribute("name",name);
                return "adminLogin";
            }else{
                ServletActionContext.getRequest().setAttribute("message","没有查询到当前用户登录信息");
                return "error";
            }
        }catch(Exception e){
            logger.error("你输入的用户名或则密码错误",e);
            ServletActionContext.getRequest().setAttribute("message","你输入的用户名或则密码错误");
            return "error";
        }
    }

    /**
     * 提供跳转到首页的方法
     */
    public String toIndexPage(){
        return "toIndexPage";
    }

}
