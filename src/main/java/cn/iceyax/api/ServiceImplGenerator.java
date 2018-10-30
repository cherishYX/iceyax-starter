package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.TableInfo;
import cn.iceyax.core.AbstractGeneratedServiceImplClass;

public class ServiceImplGenerator implements Generator {

	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		for (TableInfo tableInfo : generatorParam.getTables()) {
			AbstractGeneratedServiceImplClass gen = new AbstractGeneratedServiceImplClass(generatorParam,tableInfo);
			gen.generateFile();
		}
		
	}

}
