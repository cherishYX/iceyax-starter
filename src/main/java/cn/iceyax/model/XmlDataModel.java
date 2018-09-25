package cn.iceyax.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * ClassName: XmlDataModel 
 * @Description: xml数据模型
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月20日 下午2:21:00
 */
@Setter
@Getter
public class XmlDataModel extends DataModel {
	/**
	 * 命名空间
	 */
	private String nameSpace;
	/**
	 * 实体类名
	 */
	private String modelClass;
	/**
	 * 表名前綴
	 */
	private String preTableName;
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 表与model对应关系
	 */
	private List<XmlJavaMapper> jxms;
}
