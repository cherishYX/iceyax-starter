package cn.iceyax.base.mvc;

import java.util.List;

/**
 * 
 * ClassName: BaseService 
 * @Description: 基本Service,实现基本的添删改查
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月14日 下午3:41:41
 */
public interface BaseService<T extends BaseEntity> {
	int add(T t);
	
	int update(T t);
	
	int delete(T t);
	
	T get(T t);
	
	List<T> list();
}
