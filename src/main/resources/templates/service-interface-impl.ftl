package ${packageName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<#list imports as import>
import ${import.name};
</#list>

/**
 * ${classRemark!'实体类'}
 * @author ${author}
 * @date   ${date}
 */
@Service("${serviceParentName?uncap_first}")
public class ${className} implements ${serviceParentName}{
	
	<#--mapper名称-->
	<#assign mapperName>${modelClassName?uncap_first?replace("Entity","Mapper")}</#assign>
	
	@Autowired
	private  ${modelClassName?replace("Entity","Mapper")} ${mapperName};

	@Override
	public int add(${modelClassName} entity) {
		return ${mapperName}.add(entity);
	}

	@Override
	public int update(${modelClassName} entity) {
		return ${mapperName}.update(entity);
	}

	@Override
	public int delete(${modelClassName} entity) {
		return ${mapperName}.delete(entity);
	}

	@Override
	public ${modelClassName} get(${modelClassName} entity) {
		return ${mapperName}.get(entity);
	}
	
	@Override
	public List<${modelClassName}> list() {
		return ${mapperName}.list();
	}
}