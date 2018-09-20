package cn.iceyax.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.PackageInfo;
import cn.iceyax.config.TableInfo;
import cn.iceyax.model.DataModel;
import cn.iceyax.model.HelloWorldModel;
/**
 * 
 * ClassName: AbstractGeneratedHelloWorldFile 
 * @Description: 生成txt文件,可以用来设置spring-boot的启动banner
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月18日 上午9:52:09
 */
public class AbstractGeneratedHelloWorldFile extends AbstractGeneratedFile{

	private String fileName;
	
	public AbstractGeneratedHelloWorldFile(GeneratorParam generatorParam,TableInfo tableInfo){
		super(generatorParam);
		dataModel = new HelloWorldModel();
		
		
		Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(now);
		dataModel.setDate(date);
		
		String author = generatorParam.getPackageInfo().getAuthor();
		dataModel.setAuthor(author);
		
		dataModel.setMsg("hello world...");
		
		PackageInfo info = generatorParam.getPackageInfo();
		String rootDir = info.getProjectPath();
        String javaPath = info.getJavaPath();
        
        fileName = rootDir + "/" + javaPath + "/" + "banner.txt";
        System.out.println(fileName);
	}
	
	private HelloWorldModel dataModel;
	
	@Override
	public String getTemplateName(){
		return "banner.ftl";
	}

	@Override
	public DataModel getDataModel() {
		return dataModel;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

}
