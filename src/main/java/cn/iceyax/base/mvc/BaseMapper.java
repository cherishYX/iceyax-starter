package cn.iceyax.base.mvc;

import java.util.List;

import cn.iceyax.base.req.BaseReqPageVO;
/**
 * 
 * ClassName: BaseMapper 
 * @Description: mapper基础类
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月14日 下午3:39:20
 */
public interface BaseMapper<T extends BaseEntity/*,Q extends BaseReqPageVO*/> {
	
	int add(T t);
	
	int update(T t);
	
	int delete(Object id);
	
	T get(Object id);
	
	/*List<T> list(Q q);
	
	List<T> listByCondition(Q q);*/
}
