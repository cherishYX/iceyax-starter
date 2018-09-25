package cn.iceyax.constants;

import java.util.HashMap;
import java.util.Map;

public class DatabaseMapperContants {
	/**
	 * 
	 * @Description: mysql数据类型与java类对应关系
	 * @param @param dbType
	 * @param @return   
	 * @return String
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月20日 下午3:53:17
	 */
	public static String getMapperJavaClassName(String dbType){
		return MYSQL_DB_TYPE_2_JAVA_TYPE.get(dbType.toLowerCase());
	}
	
	public static Map<String, String> MYSQL_DB_TYPE_2_JAVA_TYPE = new HashMap<>();
	static{
		MYSQL_DB_TYPE_2_JAVA_TYPE.put("varchar", "java.lang.String");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("char", "java.lang.String");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("text", "java.lang.String");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("json", "java.lang.String");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("boolean", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("tinyint", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("tinyint unsigned", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("smallint", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("smallint unsigned", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("int", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("int unsigned", "java.lang.Integer");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("bigint", "java.lang.Long");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("bigint unsigned", "java.lang.Long");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("id", "java.lang.Long");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("float", "java.lang.Float");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("float unsigned", "java.lang.Float");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("double", "java.lang.Double");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("double unsigned", "java.lang.Double");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("decimal", "java.math.BigDecimal");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("decimal unsigned", "java.math.BigDecimal");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("date", "java.util.Date");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("time", "java.util.Date");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("datetime", "java.util.Date");
        MYSQL_DB_TYPE_2_JAVA_TYPE.put("timestamp", "java.util.Date");
	}
}
