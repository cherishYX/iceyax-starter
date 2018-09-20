package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.TableInfo;
import cn.iceyax.core.AbstractGeneratedEntityClass;

public class EntityGenerator implements Generator {

	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		for (TableInfo tableInfo : generatorParam.getTables()) {
			AbstractGeneratedEntityClass gen = new AbstractGeneratedEntityClass(generatorParam,tableInfo);
			gen.generateFile();
		}
		
	}

}
