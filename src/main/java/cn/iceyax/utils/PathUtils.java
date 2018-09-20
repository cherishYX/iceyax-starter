package cn.iceyax.utils;

import java.io.File;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.eu.PackageType;

public class PathUtils {
	private final static String SPILT = File.separator;
	private final static String POINT = ".";
	
	public static String getProjectPath(GeneratorParam generatorParam){
		return generatorParam.getPackageInfo().getProjectPath();
	}
	
	public static String getBasePackage(GeneratorParam generatorParam){
		return generatorParam.getPackageInfo().getBasePackage();
	}
	/**
	 * 
	 * @Description: 获取文件生成基本路径projectPath + javaPath + basePath</br>
	 * projectPath : D:\\yxworkspace\\iceyax-starter</br>
	 * javaPath    : src\\main\\java</br>
	 * basePath    : cn.ice.web</br>
	 * @param @param generatorParam
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月19日 下午3:57:31
	 */
	public static String getFileBasePath(GeneratorParam generatorParam){
		String spilt = File.separator;
		PackageInfo packageInfo = generatorParam.getPackageInfo();
		String projectPath = packageInfo.getProjectPath() + SPILT;
		String javaPath = packageInfo.getJavaPath() + SPILT;
		String basePackage = packageInfo.getBasePackage().replace(".", "\\") + SPILT;
		return projectPath + javaPath + basePackage;
	}
	
	/**
	 * 
	 * @Description: 获取文件保存路径名, 只需要拼接文件名即可 </br>
	 * getFileBasePath() + {type} 文件绝对路径,无文件名称
	 * @param @param generatorParam
	 * @param @param type
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月19日 下午4:36:59
	 */
	public static String getTargetFilePath(GeneratorParam generatorParam,String type){
		String result = getFileBasePath(generatorParam);
		PackageInfo packageInfo = generatorParam.getPackageInfo();
		switch(type){
		case PackageType.DAO:
			result = result + packageInfo.getDaoPackage() + SPILT;
			break;
		case PackageType.ENTITY:
			result = result + packageInfo.getEntityPackage() + SPILT;
			break;
		case PackageType.SERVICE:
			result = result + packageInfo.getServicePackage() + SPILT;
			break;
		case PackageType.CONTROLLER:
			result = result + packageInfo.getControllerPackage() + SPILT;
			break;
		}
		return result;
	}
	/**
	 * 
	 * @Description: 获取项目根路径:返回cn.ice + {type}对应名称
	 * @param @param generatorParam
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author yanx
	 * @email 123190875@qq.com
	 * @date 2018年9月20日 上午10:54:45
	 */
	public static String getBasePackagePath(GeneratorParam generatorParam,String type){
		PackageInfo packageInfo = generatorParam.getPackageInfo();
		String result = packageInfo.getBasePackage().replace("\\", ".");
		switch(type){
		case PackageType.DAO:
			result = result + POINT + packageInfo.getDaoPackage();
			break;
		case PackageType.ENTITY:
			result = result + POINT + packageInfo.getEntityPackage();
			break;
		case PackageType.SERVICE:
			result = result + POINT + packageInfo.getServicePackage();
			break;
		case PackageType.CONTROLLER:
			result = result + POINT + packageInfo.getControllerPackage();
			break;
		}
		return result;
	}
}
