package cn.iceyax.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class XmlJavaMapper {
	/**
	 * 表列名
	 */
	private String columnName;
	/**
	 * 实体类属性名称
	 */
	private String propertyName;
	/**
	 * jdbc类型
	 */
	private String jdbcType;
	
	
}
