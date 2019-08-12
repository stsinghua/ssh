package cn.stsinghua.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author stsinghua
 * @date 19-3-8下午4:01
 */
@Slf4j
@Getter
@Setter
public class BaseModel implements Serializable {

    /**
     * 主键ID
     */
    private int id;
    /**
     * 创建时间
     */
    private Timestamp createDate;
    /**
     * 创建时间字符串
     */
    private String createDateStr;
    /**
     * 创建用户
     */
    private String createPid;
    /**
     * 修改时间
     */
    private Timestamp modifyDate;
    /**
     * 修改时间字符串
     */
    private String modifyDateStr;
    /**
     * 修改人用户
     */
    private String modifyPid;
    /**
     * 更新用户
     */
    private String updatePid;
    /**
     * 更新时间
     */
    private Timestamp updateDatetime;
    /**
     * 删除标识
     */
    private String delFalg;

}
