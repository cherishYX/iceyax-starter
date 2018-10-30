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
 * ClassName: AbstractGeneratedServiceImplClass 
 * @Description: 实体类创建类
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月19日 上午9:59:34
 */
public class AbstractGeneratedServiceImplClass extends AbstractGeneratedFile{

	private JavaClassModel model;
	
	private final String IMPL = "impl";
	
	public AbstractGeneratedServiceImplClass(GeneratorParam generatorParam,TableInfo tableInfo) {
		super(generatorParam);
		
		model = new JavaClassModel();
		PackageInfo packInfo = generatorParam.getPackageInfo();
		String packageName = PathUtils.getBasePackagePath(generatorParam, PackageType.SERVICE) + "." + IMPL;
		model.setPackageName(packageName);
		String simpleTableName = getSimpleTableName(tableInfo.getName(),generatorParam.getExclude());
		// 实体类名(首字母大写)
		String modelClassName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, simpleTableName);
		// 表名+servicePackage
		String serviceName = modelClassName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, packInfo.getServicePackage());
		model.setClassName(serviceName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, IMPL));//service类名
		model.setServiceParentName(serviceName);
		String entityName = modelClassName + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, packInfo.getEntityPackage());
		model.setModelClassName(entityName);//实体类名
		model.setClassRemark(tableInfo.getName() + "表对应"+serviceName+"实现类");
		
		List<JavaImport> imports = new ArrayList<>();
		JavaImport im1 = new JavaImport();
		im1.setName(PathUtils.getBasePackagePath(generatorParam, PackageType.SERVICE) + "." + serviceName);
		imports.add(im1);
		
		JavaImport im2 = new JavaImport();
		String mapperPath = PathUtils.getBasePackagePath(generatorParam, PackageType.DAO);
		im2.setName(mapperPath + "." + modelClassName + "Mapper");
		imports.add(im2);
		
		JavaImport im3 = new JavaImport();
		String entityPath = PathUtils.getBasePackagePath(generatorParam, PackageType.ENTITY);
		im3.setName(entityPath + "." + entityName);
		imports.add(im3);
		model.setImports(imports);
		String servicePath = PathUtils.getTargetFilePath(generatorParam, PackageType.SERVICE);
		fileName = servicePath + PathUtils.SPILT + IMPL + PathUtils.SPILT + model.getClassName() + ".java";
	}

	private String fileName;
	
	@Override
	public String getTemplateName() {
		return "service-interface-impl.ftl";
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
