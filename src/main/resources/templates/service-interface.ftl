package ${packageName};

import cn.iceyax.base.mvc.BaseService;
<#list imports as import>
import ${import.name};
</#list>

/**
 * ${classRemark!'实体类'}
 * @author ${author}
 * @date   ${date}
 */
public interface ${className} extends BaseService<${modelClassName}>{
	
}