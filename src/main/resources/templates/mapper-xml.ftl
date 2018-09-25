<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${nameSpace}">
  <resultMap id="BaseResultMap" type="${modelClass}">
  <#list jxms as jx>
    <result column="${jx.columnName!''}" jdbcType="${jx.jdbcType!''}" property="${jx.propertyName!''}" />
  </#list>
  </resultMap>
  
  <!--base column-->
  <#assign sqltmp><#list jxms as jx>t.${jx.columnName},</#list></#assign>
  <sql id="baseColumnList">
  ${sqltmp?substring(0,sqltmp?length-1)}
  </sql>
  <!--java列-->
  <#assign sqlJavaColumn><#list jxms as jx>t.${jx.propertyName},</#list></#assign>
  <sql id="baseJavaColumnList">
  ${sqltmp?substring(0,sqlJavaColumn?length-1)}
  </sql>
  
  <!--table name-->
  <sql id="tableName"><#if preTableName??>${preTableName}.</#if>${tableName} t</sql>
  <!--查询-->
  <select id="get" resultMap="BaseResultMap">
  	select <include refid="baseColumnList"/>
  		from <include refid="tableName"/>
  </select>
  <!--添加-->
  <insert id="add">
  	insert into <include refid="tableName"/>(<include refid="baseColumnList"/>) 
  		values(
  		<include refid="baseJavaColumnList"/>
  		)
  </insert>
</mapper>