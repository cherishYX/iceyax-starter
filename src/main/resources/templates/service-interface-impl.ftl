package ${packageName};

import org.springframework.stereotype.Service;

<#list imports as import>
import ${import.name};
</#list>

/**
 * ${classRemark!'实体类'}
 * @author ${author}
 * @date   ${date}
 */
@Service("${serviceParentName?uncap_first}")
public interface ${className} extends ${serviceParentName}{
	
}