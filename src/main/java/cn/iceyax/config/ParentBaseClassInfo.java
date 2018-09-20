package cn.iceyax.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * ClassName: ParentBaseClassInfo 
 * @Description: 父类基本信息
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月18日 上午10:44:34
 */
@Getter
@Setter
@ToString
public class ParentBaseClassInfo {
	/**
	 * 基础service名称
	 */
	private String baseServiceName;
	/**
	 * 基础Dao名称
	 */
	private String baseMapperName;
}
