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
 * ClassName: AbstractGeneratedMapperClass 
 * @Description: 創建Mapper
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月20日 下午2:19:13
 */
public class AbstractGeneratedMapperClass extends AbstractGeneratedFile{

	private JavaClassModel model;
	
	public AbstractGeneratedMapperClass(GeneratorParam generatorParam,TableInfo tableInfo) {
		super(generatorParam);
		model = new JavaClassModel();
		// 模板填充数据  ,  设置文件路径;
		String tableName = tableInfo.getName();
		String simpleTableName = getSimpleTableName(tableName,generatorParam.getExclude());
		// 包名
		PackageInfo p = generatorParam.getPackageInfo();
		String packageName = p.getBasePackage() + "." + p.getDaoPackage(); 
		model.setPackageName(packageName);
		
		// 实体类名   Mapper类名
		String upperModelName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, simpleTableName); 
		model.setClassName(upperModelName + "Mapper");
		// 类注释
		model.setClassRemark(tableName + "表对应mapper操作");
		String modelName = upperModelName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, p.getEntityPackage());
		model.setModelClassName(modelName);
		
		List<JavaImport> imports = new ArrayList<>();
		String entityBasePath = PathUtils.getBasePackagePath(generatorParam, PackageType.ENTITY);
		JavaImport im = new JavaImport();
		im.setName(entityBasePath + "." + modelName);
		imports.add(im);
		model.setImports(imports);
		
		String path = PathUtils.getTargetFilePath(generatorParam, PackageType.DAO);
		fileName = path + upperModelName + "Mapper.java";
	}

	private String fileName;
	
	@Override
	public String getTemplateName() {
		return "mapper-java.ftl";
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
}
