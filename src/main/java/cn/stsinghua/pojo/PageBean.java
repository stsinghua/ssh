package cn.stsinghua.pojo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author stsinghua
 * @date 19-3-10下午12:47
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T>  extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private int pageCode;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 每页显示的记录条数
     */
    private int pageSize;

    /**
     * 总页数=总条数/每页显示的条数
     */
    private int totalPage;

    /**
     * 每页显示的数据
     */
    private List<T> beanList;


    /**
     * 调用getTotalPage() 获取到总页数
     * javaBean属性规定：totalPage是javaBean属性 ${pageBean.totalPage}
     */
    public int getTotalPage() {
        //计算
        int totalPage = totalCount / pageSize;
        //说明整除
        if(totalCount % pageSize == 0){
            return totalPage;
        }else{
            return totalPage + 1;
        }
    }
}
