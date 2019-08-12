package cn.stsinghua.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author stsinghua
 * @date 19-3-8下午4:01
 */
@Slf4j
@Getter
@Setter
public class Admin extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

}
