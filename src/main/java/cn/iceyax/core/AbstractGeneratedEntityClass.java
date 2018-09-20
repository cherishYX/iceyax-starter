package cn.iceyax.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.google.common.base.CaseFormat;

import cn.iceyax.config.DatabaseInfo;
import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.TableInfo;
import cn.iceyax.config.db.DBField;
import cn.iceyax.config.eu.DBType;
import cn.iceyax.config.eu.PackageType;
import cn.iceyax.model.DataModel;
import cn.iceyax.model.JavaClassModel;
import cn.iceyax.model.JavaField;
import cn.iceyax.model.JavaImport;
import cn.iceyax.utils.PathUtils;
/**
 * 
 * ClassName: AbstractGeneratedEntityClass 
 * @Description: 实体类创建类
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月19日 上午9:59:34
 */
public class AbstractGeneratedEntityClass extends AbstractGeneratedFile{
	/**
     * 数据类型转换对应关系
     */
    protected final Map<String, String> DB_TYPE_2_JAVA_TYPE = new HashMap<>();
    /**
     * 用于Boolean值判断
     */
    private final static String YES = "YES";

	private JavaClassModel model;
	
	public AbstractGeneratedEntityClass(GeneratorParam generatorParam,TableInfo tableInfo) {
		super(generatorParam);
		initMapping();// 初始化匹配关系
		
		model = new JavaClassModel();
		PackageInfo packInfo = generatorParam.getPackageInfo();
		model.setPackageName(PathUtils.getBasePackagePath(generatorParam, PackageType.ENTITY));
		String simpleTableName = getSimpleTableName(tableInfo.getName(),generatorParam.getExclude());
		// 实体类名(首字母大写)
		String modelClassName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, simpleTableName);
		// 表名+entityPackage
		String className = modelClassName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, packInfo.getEntityPackage());
		model.setClassName(className);
		model.setClassRemark(tableInfo.getName() + "表对应实体类");
		
		Set<String> setImports = new HashSet<>();
		List<JavaImport> imports = new ArrayList<>();
		try {
			List<DBField> dbFields = getTableColumns(generatorParam.getDatabaseInfo(),tableInfo);
			List<JavaField> fields = new ArrayList<>(dbFields.size());
			for(DBField f : dbFields){
				JavaField jf = new JavaField();
				jf.setName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, f.getColumnName()));
				jf.setScope("private");
				jf.setRemark(f.getRemarks());
				String classFullName = DB_TYPE_2_JAVA_TYPE.get(f.getTypeName().toLowerCase());
				Class clazz = Class.forName(classFullName);
				jf.setType(clazz.getSimpleName());
				fields.add(jf);
				if(!classFullName.startsWith("java.lang") && !setImports.contains(classFullName)){
					setImports.add(classFullName);
					
					JavaImport im = new JavaImport();
					im.setName(classFullName);
					imports.add(im);
				}
			}
			model.setImports(imports);
			model.setFields(fields);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String daoPath = PathUtils.getTargetFilePath(generatorParam, PackageType.ENTITY);
		fileName = daoPath + className + ".java";
	}

	private String fileName;
	
	@Override
	public String getTemplateName() {
		return "entity.ftl";
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
	
	private void initMapping(){
		DB_TYPE_2_JAVA_TYPE.put("varchar", "java.lang.String");
        DB_TYPE_2_JAVA_TYPE.put("char", "java.lang.String");
        DB_TYPE_2_JAVA_TYPE.put("text", "java.lang.String");
        DB_TYPE_2_JAVA_TYPE.put("json", "java.lang.String");
        DB_TYPE_2_JAVA_TYPE.put("boolean", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("tinyint", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("tinyint unsigned", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("smallint", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("smallint unsigned", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("int", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("int unsigned", "java.lang.Integer");
        DB_TYPE_2_JAVA_TYPE.put("bigint", "java.lang.Long");
        DB_TYPE_2_JAVA_TYPE.put("bigint unsigned", "java.lang.Long");
        DB_TYPE_2_JAVA_TYPE.put("id", "java.lang.Long");
        DB_TYPE_2_JAVA_TYPE.put("float", "java.lang.Float");
        DB_TYPE_2_JAVA_TYPE.put("float unsigned", "java.lang.Float");
        DB_TYPE_2_JAVA_TYPE.put("double", "java.lang.Double");
        DB_TYPE_2_JAVA_TYPE.put("double unsigned", "java.lang.Double");
        DB_TYPE_2_JAVA_TYPE.put("decimal", "java.math.BigDecimal");
        DB_TYPE_2_JAVA_TYPE.put("decimal unsigned", "java.math.BigDecimal");
        DB_TYPE_2_JAVA_TYPE.put("date", "java.util.Date");
        DB_TYPE_2_JAVA_TYPE.put("time", "java.util.Date");
        DB_TYPE_2_JAVA_TYPE.put("datetime", "java.util.Date");
        DB_TYPE_2_JAVA_TYPE.put("timestamp", "java.util.Date");
	}
	
	/**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    protected Connection getConnection(DatabaseInfo databaseInfo) throws Exception {
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
    }

    protected String getConnectionURL(DatabaseInfo databaseInfo) throws ClassNotFoundException {
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        String connectionRUL = String.format(dbType.getConnectionUrlPattern(), databaseInfo.getDbIP(),
                databaseInfo.getDbPort(), databaseInfo.getDbName());
        return connectionRUL;
    }

    /**
     * 读取表结构
     *
     * @return
     * @throws Exception
     */
    protected List<DBField> getTableColumns(DatabaseInfo databaseInfo,TableInfo tableInfo) throws Exception {
        Connection connection = getConnection(databaseInfo);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getColumns(null, null, tableInfo.getName(), null);
        List<DBField> fieldList = new ArrayList<>();
        while (resultSet.next()) {
            DBField field = new DBField();
            field.setColumnName(resultSet.getString("COLUMN_NAME"));
            field.setDataType(resultSet.getInt("DATA_TYPE"));
            field.setTypeName(resultSet.getString("TYPE_NAME"));
            field.setColumnSize(resultSet.getInt("COLUMN_SIZE"));
            field.setDecimalDigits(resultSet.getInt("DECIMAL_DIGITS"));
            field.setNullable(YES.equalsIgnoreCase(resultSet.getString("IS_NULLABLE")));
            field.setAutoIncrement(YES.equalsIgnoreCase(resultSet.getString("IS_AUTOINCREMENT")));
            field.setRemarks(resultSet.getString("REMARKS"));
            field.setColumnDef(resultSet.getObject("COLUMN_DEF"));
            field.setCharOctetLength(resultSet.getInt("CHAR_OCTET_LENGTH"));

            fieldList.add(field);
        }

        return fieldList;
    }
}
