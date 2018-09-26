<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${nameSpace}">
  <!--自定义宏-->
  <#macro alertChar>#</#macro>

  <resultMap id="BaseResultMap" type="${modelClass}">
  <#list jxms as jx>
    <result column="${jx.columnName!''}" property="${jx.propertyName!''}" />
  </#list>
  </resultMap>
  
  <!--基础列-->
  <#assign sqltmp><#list jxms as jx>${jx.columnName},</#list></#assign>
  <sql id="baseColumnList">
  ${sqltmp?substring(0,sqltmp?length-1)}
  </sql>
  <!--java列-->
  <#assign sqlJavaColumn><#list jxms as jx><@alertChar/>{${jx.propertyName}},</#list></#assign>
  <sql id="baseJavaColumnList">
  ${sqlJavaColumn?substring(0,sqlJavaColumn?length-1)}
  </sql>
  
  
  
  <!--table name-->
  <sql id="tableName"><#if preTableName??>${preTableName}.</#if>${tableName}</sql>
  <!--查询-->
  <select id="get" resultMap="BaseResultMap" parameterType="${modelClass}">
  	select <include refid="baseColumnList"/>
  		from <include refid="tableName"/>
  	<where>
  		<#list jxms as jx>
		<#if jx.jdbcType == 'VARCHAR' || jx.jdbcType == 'CHAR'>
		<if test="${jx.propertyName!''} != null and ${jx.propertyName!''} != ''">
			and ${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}}
		</if>
		<#else>
		<if test="${jx.propertyName!''} != null">
			and ${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}}
		</if>
		</#if>
  		</#list>
  	</where>
  </select>
  <!--添加-->
  <insert id="add">
  	insert into <include refid="tableName"/>(<include refid="baseColumnList"/>) 
  		values(
  		<include refid="baseJavaColumnList"/>
  		)
  </insert>
  <!--更新-->
  <update id="update">
  	update <include refid="tableName"/>
  	<set>
  	<#list jxms as jx>
  		${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}},
  	</#list>
	</set>
	<where>
		<#list jxms as jx>
		<#if jx.jdbcType == 'VARCHAR' || jx.jdbcType == 'CHAR'>
		<if test="${jx.propertyName!''} != null and ${jx.propertyName!''} != ''">
			and ${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}}
		</if>
		<#else>
		<if test="${jx.propertyName!''} != null">
			and ${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}}
		</if>
		</#if>
  		</#list>
	</where>
  </update>
  <!--删除-->
  <delete id="delete">
  	delete <include refid="tableName"/>
  	<where>
  		<#list jxms as jx>
		<#if jx.jdbcType == 'VARCHAR' || jx.jdbcType == 'CHAR'>
		<if test="${jx.propertyName!''} != null and ${jx.propertyName!''} != ''">
			and ${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}}
		</if>
		<#else>
		<if test="${jx.propertyName!''} != null">
			and ${jx.columnName!''} = <@alertChar/>{${jx.propertyName!''}}
		</if>
		</#if>
  		</#list>
  	</where>
  </delete>
</mapper>