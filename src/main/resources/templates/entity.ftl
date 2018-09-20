package ${packageName};

import lombok.Getter;
import lombok.Setter;
import cn.iceyax.base.mvc.BaseEntity;
<#list imports as import>
import ${import.name};
</#list>

/**
 * ${classRemark!'实体类'}
 * @author ${author}
 * @date   ${date}
 */
@Getter
@Setter
@SuppressWarnings("serial")
public class ${className} extends BaseEntity{
	<#list fields as f>
	/**
	 * ${f.remark!''}
	 */
	${f.scope!'private'} ${f.type!''} ${f.name!''};
	</#list>
}