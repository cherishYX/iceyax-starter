package cn.iceyax.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.google.common.base.CaseFormat;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.TableInfo;
import cn.iceyax.config.db.DBField;
import cn.iceyax.config.eu.PackageType;
import cn.iceyax.model.DataModel;
import cn.iceyax.model.XmlDataModel;
import cn.iceyax.model.XmlJavaMapper;
import cn.iceyax.utils.DatabaseUtils;
import cn.iceyax.utils.PathUtils;
/**
 * 
 * ClassName: AbstractGeneratedMapperClass 
 * @Description: 創建Mapper对应xml文件
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月20日 下午2:19:13
 */
public class AbstractGeneratedXml extends AbstractGeneratedFile{

	private XmlDataModel model;
	
	public AbstractGeneratedXml(GeneratorParam generatorParam,TableInfo tableInfo) {
		super(generatorParam);
		model = new XmlDataModel();
		PackageInfo p = generatorParam.getPackageInfo();
		// 模板填充数据  ,  设置文件路径;
		String tableName = tableInfo.getName();
		String simpleTableName = getSimpleTableName(tableName,generatorParam.getExclude());		
		// 命名空间
		String path = PathUtils.getBasePackagePath(generatorParam, PackageType.DAO);
		String upperModelName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, simpleTableName);
		String nameSpaces = path + "." + upperModelName + "Mapper";
		model.setNameSpace(nameSpaces);
		String modelName = upperModelName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, p.getEntityPackage());
		String entityBasePath = PathUtils.getBasePackagePath(generatorParam, PackageType.ENTITY);
		String modelClassPath = entityBasePath + "." + modelName;
		model.setModelClass(modelClassPath);
		// 表名
		model.setPreTableName(tableInfo.getPreName());
		model.setTableName(tableName);
		// 映射关系
		try {
			List<DBField> dbFields = DatabaseUtils.getTableColumns(generatorParam.getDatabaseInfo(), tableInfo);
			List<XmlJavaMapper> mappers = new ArrayList<>();
			for(DBField f : dbFields){
				XmlJavaMapper xj = new XmlJavaMapper();
				xj.setColumnName(f.getColumnName());
				xj.setPropertyName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, f.getColumnName()));
				xj.setJdbcType(f.getTypeName());
				mappers.add(xj);
			}
			model.setJxms(mappers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String pp = PathUtils.getTargetFilePath(generatorParam,PackageType.DAO);
		fileName = pp + upperModelName + "Mapper.xml";
	}

	private String fileName;
	
	@Override
	public String getTemplateName() {
		return "mapper-xml.ftl";
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
	 * @Description: 精简表名
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
}
