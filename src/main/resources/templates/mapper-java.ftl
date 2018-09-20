package ${packageName};

import cn.iceyax.base.mvc.BaseMapper;
<#list imports as import>
import ${import.name};
</#list>

/**
 * ${classRemark}
 * @author ${author}
 * @date   ${date}
 */
public interface ${className} extends BaseMapper<${modelClassName}>{
	
}