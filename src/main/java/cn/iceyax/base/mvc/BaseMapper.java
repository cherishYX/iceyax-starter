package cn.iceyax.base.mvc;

import java.util.List;

/**
 * 
 * ClassName: BaseMapper 
 * @Description: mapper基础类
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月14日 下午3:39:20
 */
public interface BaseMapper<T extends BaseEntity> {
	
	int add(T t);
	
	int update(T t);
	
	int delete(T t);
	
	T get(T t);
	
	List<T> list();
}
