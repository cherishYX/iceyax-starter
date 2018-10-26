package cn.iceyax;


import java.util.ArrayList;
import java.util.List;

import cn.iceyax.config.DatabaseInfo;
import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.TableInfo;

public class BaseTest {
	
	protected static GeneratorParam generatorParam = new GeneratorParam();
	static{
		generatorParam.setDatabaseInfo(getDbInfo());
		generatorParam.setPackageInfo(getPckInfo());
		generatorParam.setTables(getTables());
		
		List<String> exclude = new ArrayList<>();
		exclude.add("t_");
		generatorParam.setExclude(exclude);
	}
	
	private static PackageInfo getPckInfo(){
		PackageInfo packageInfo = new PackageInfo();
		packageInfo.setAuthor("yanx");
		packageInfo.setDaoPackage("dao");
		packageInfo.setProjectPath("D:\\yxworkspace\\iceyax-starter");
		packageInfo.setJavaPath("src\\main\\java");
		packageInfo.setBasePackage("cn.ice.web");
		packageInfo.setEntityPackage("entity");
		packageInfo.setResourcePath("src\\main\\java");
		packageInfo.setExtendsPath("area");
		
		
		return packageInfo;
	}
	private static DatabaseInfo getDbInfo(){
		DatabaseInfo databaseInfo = new DatabaseInfo();
		databaseInfo.setDbType("MySQL");
		databaseInfo.setDbIP("127.0.0.1");
		databaseInfo.setDbName("yapi");
		databaseInfo.setDbPassword("root");
		databaseInfo.setDbPort(3306);
		databaseInfo.setDbUsername("root");
		return databaseInfo;
	}
	
	private static List<TableInfo> getTables(){
		List<TableInfo> tables = new ArrayList<>();
		TableInfo t = new TableInfo();
		t.setName("t_area");
		//t.setKey("area_code");//主键字段名称
		//t.setKeyType("Single");
		List<String> query = new ArrayList<>();
		/*query.add("area_code");
		query.add("tree_name");
		query.add("area_name");*/
		t.setQuery(query);
		t.setRemark("地区信息表");
		tables.add(t);
		return tables;
	}
}
