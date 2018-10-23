package cn.iceyax.core;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.google.common.base.CaseFormat;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.TableInfo;
import cn.iceyax.config.eu.PackageType;
import cn.iceyax.model.DataModel;
import cn.iceyax.model.JavaClassModel;
import cn.iceyax.utils.PathUtils;

public class AbstractGeneratedRequestVO extends AbstractGeneratedFile{
	
	private JavaClassModel model;

	public AbstractGeneratedRequestVO(GeneratorParam generatorParam) {
		super(generatorParam);		
		for(TableInfo tableInfo : generatorParam.getTables()){
			model = new JavaClassModel();
			doGenerated(generatorParam,tableInfo);
		}
	}

	private void doGenerated(GeneratorParam generatorParam,TableInfo tableInfo){
		List<String> querys = tableInfo.getQuery();
		String packageName = PathUtils.getBasePackagePath(generatorParam, PackageType.VO_REQ);
		model.setPackageName(packageName);
		
		PackageInfo packInfo = generatorParam.getPackageInfo();
		String tableName = tableInfo.getName();
		String simpleTableName = getSimpleTableName(tableName,generatorParam.getExclude());
		// 实体类名(首字母大写)
		String modelClassName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, simpleTableName);
		// 表名+entityPackage
		String className = modelClassName + "Req" + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, packInfo.getVoPackage());
		model.setClassName(className);
		
		// TODO 未完成
		
	}
	
	@Override
	public String getTemplateName() {
		return "request-vo.ftl";
	}

	@Override
	public DataModel getDataModel() {
		return model;
	}

	private String fileName;
	@Override
	public String getFileName() {
		return fileName;
	}


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
