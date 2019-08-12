package cn.stsinghua.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author stsinghua
 * @date 19-4-7下午7:27
 */
@Slf4j
@Setter
@Getter
public class Customer extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 客户的id
     */
    private int id;
    /**
     * 客户的姓名
     */
    private String name;
    /**
     * 客户的电话
     */
    private String telephone;
    /**
     * 客户的住址
     */
    private String address;
    /**
     * 客户备注
     */
    private String remark;


}
