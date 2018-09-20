package cn.iceyax.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AuditAnnotation {
	// 表明注解会被写入字节码文件，并且能够被JVM 在运行时获取到，可以通过反射的方式解析到
	@Retention(RetentionPolicy.RUNTIME)
	// 标识注解的使用范围
	@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
	public @interface CreateBy{}
	
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
	public @interface CreateDt{}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
	public @interface UpdateBy{}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
	public @interface UpdateDt{}
}
