package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.TableInfo;
import cn.iceyax.core.AbstractGeneratedServiceClass;

public class ServiceGenerator implements Generator {

	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		for (TableInfo tableInfo : generatorParam.getTables()) {
			AbstractGeneratedServiceClass gen = new AbstractGeneratedServiceClass(generatorParam,tableInfo);
			gen.generateFile();
		}
		
	}

}
