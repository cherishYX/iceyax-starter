package cn.iceyax.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.google.common.base.CaseFormat;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.TableInfo;
import cn.iceyax.config.eu.PackageType;
import cn.iceyax.model.DataModel;
import cn.iceyax.model.JavaClassModel;
import cn.iceyax.model.JavaImport;
import cn.iceyax.utils.PathUtils;
/**
 * 
 * ClassName: AbstractGeneratedServiceClass 
 * @Description: 实体类创建类
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月19日 上午9:59:34
 */
public class AbstractGeneratedServiceClass extends AbstractGeneratedFile{

	private JavaClassModel model;
	/**模板名称*/
	private String templateName;
	
	public AbstractGeneratedServiceClass(GeneratorParam generatorParam,TableInfo tableInfo) {
		super(generatorParam);
		
		model = new JavaClassModel();
		PackageInfo packInfo = generatorParam.getPackageInfo();
		model.setPackageName(PathUtils.getBasePackagePath(generatorParam, PackageType.SERVICE));
		String simpleTableName = getSimpleTableName(tableInfo.getName(),generatorParam.getExclude());
		// 实体类名(首字母大写)
		String modelClassName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, simpleTableName);
		// 表名+servicePackage
		String className = modelClassName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, packInfo.getServicePackage());
		model.setClassName(className);//service类名
		String entityName = modelClassName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, packInfo.getEntityPackage());
		model.setModelClassName(entityName);//实体类名
		model.setClassRemark(tableInfo.getName() + "表对应SERVICE类");
		
		List<JavaImport> imports = new ArrayList<>();
		JavaImport im = new JavaImport();
		im.setName(PathUtils.getBasePackagePath(generatorParam, PackageType.ENTITY) + "." + model.getModelClassName());
		imports.add(im);
		model.setImports(imports);
		String servicePath = PathUtils.getTargetFilePath(generatorParam, PackageType.SERVICE);
		fileName = servicePath + className + ".java";
		this.templateName = "service-interface.ftl";
	}

	private String fileName;
	
	@Override
	public String getTemplateName() {
		return this.templateName;
	}

	@Override
	public DataModel getDataModel() {
		return model;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	/**
	 * @Description: 精簡表明
	 * @param @param tableName
	 * @param @param exclude
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月18日 下午1:22:10
	 */
	private String getSimpleTableName(String tableName,List<String> exclude){
		String simpleTableName = tableName;
		if(!CollectionUtils.isEmpty(exclude)){
			for (String string : exclude) {
				if(simpleTableName.startsWith(string)){
					simpleTableName = simpleTableName.replace(string, "");
					break;
				}
			}
		}
		return simpleTableName;
	}
	
	/**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    /*protected Connection getConnection(DatabaseInfo databaseInfo) throws Exception {
        DriverManager.setLoginTimeout(3);
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        Class.forName(dbType.getDriverClass());
        String url = getConnectionURL(databaseInfo);
        Properties props = new Properties();
        props.setProperty("user", databaseInfo.getDbUsername());
        props.setProperty("password", databaseInfo.getDbPassword());
        //设置可以获取remarks信息
        props.setProperty("remarks", "true");
        //设置可以获取tables remarks信息
        props.setProperty("useInformationSchema", "true");
        Connection connection = DriverManager.getConnection(url, props);
        return connection;
    }*/

    /*protected String getConnectionURL(DatabaseInfo databaseInfo) throws ClassNotFoundException {
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        String connectionRUL = String.format(dbType.getConnectionUrlPattern(), databaseInfo.getDbIP(),
                databaseInfo.getDbPort(), databaseInfo.getDbName());
        return connectionRUL;
    }*/

    
}
