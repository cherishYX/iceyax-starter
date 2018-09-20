package cn.iceyax.base.mvc;

import java.util.List;

import cn.iceyax.base.req.BaseReqPageVO;
/**
 * 
 * ClassName: BaseService 
 * @Description: 基本Service,实现基本的添删改查
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月14日 下午3:41:41
 */
public interface BaseService<T extends BaseEntity,Q extends BaseReqPageVO> {
	int add(T t);
	
	int update(T t);
	
	int delete(Object id);
	
	T get(Object id);
	/**
	 * 
	 * @Description: 单表分页
	 * @param @param q
	 * @param @return   
	 * @return List<T>  
	 * @throws
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月14日 下午3:44:47
	 */
	List<T> list(Q q);
	/**
	 * 
	 * @Description: 按条件查找
	 * @param @param q
	 * @param @return   
	 * @return List<T>  
	 * @throws
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月14日 下午3:44:59
	 */
	List<T> listByCondition(Q q);
}
