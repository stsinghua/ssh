package cn.stsinghua.action;

import cn.stsinghua.pojo.Customer;
import cn.stsinghua.pojo.PageBean;
import cn.stsinghua.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stsinghua
 * @date 19-3-8下午6:06
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    //采用属性驱动方式
    public Customer getModel() {
        return customer;
    }

    //手动new实体类
    private Customer customer = new Customer();

    //提供service成员属性，并提供set方法
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 根据id查询
     */
    public String findById() {
        customer = customerService.findById(customer.getId());
        return "findById";
    }

    /**
     * 跳转到添加用户的页面
     */
    public String toSavePage() {
        return "toSavePage";
    }

    /**
     * 添加信息
     */
    public String save() {
        HttpServletRequest request = ServletActionContext.getRequest();
        customerService.save(customer);
        request.setAttribute("message","保存信息成功");
        return "save";
    }

    /**
     * 删除方法
     */
    public String delete() {
        HttpServletRequest request = ServletActionContext.getRequest();
        customer = customerService.findById(customer.getId());
        customerService.delete(customer);
        request.setAttribute("message","删除信息成功");
        return "delete";
    }

    /**
     * 修改的方法
     */
    public String update() {
        customerService.update(customer);
        return "update";
    }

    private String result;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }


    /**
     * 为模态框提供的查询功能
     * 处理ajax的请求
     */
    public String search() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            String id = request.getParameter("id");
            System.out.println("你在jsp中点击的编号：" + id);
            customer = customerService.findById(customer.getId());

            //将数据放到Map集合中，再转换成json格式的数据
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", customer.getId());
            map.put("name", customer.getName());
            map.put("telephone", customer.getTelephone());
            map.put("address", customer.getAddress());
            map.put("remark", customer.getRemark());

            //将Map集合数据转换成json格式的数据
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
            System.out.println("这里我要传给前台页面的JSON数据是："+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 分页查询相关
     */
    //声明要返回的JSON字符串
    private String responseStr;

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    //属性驱动方式，当前页，默认页1
    private Integer pageCode = 1;
    public void setPageCode(Integer pageCode) {
        if (pageCode == null) {
            pageCode = 1;
        }
        this.pageCode = pageCode;
    }

    //默认每页显示的数据条数
    private Integer pageSize = 5;

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //分页查询的方法
    public String findByPage() {
        //调用service层
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //拼接查询条件
        String name = customer.getName();
        String telephone = customer.getTelephone();
        if (name != null && name.trim() != null) {
            criteria.add(Restrictions.like("name", "%" + name + "%"));
        }
        if (telephone != null && telephone.trim() != null) {
            criteria.add(Restrictions.like("telephone", "%" + telephone + "%"));
        }

        //查询
        PageBean<Customer> page = customerService.findByPage(pageCode, pageSize, criteria);
        //压栈
        ValueStack vs = ActionContext.getContext().getValueStack();
        //顶栈是map<"page",page对象>
        vs.set("page", page);
        return "page";
    }
}
