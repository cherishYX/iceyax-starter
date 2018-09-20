package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.core.AbstractGeneratedHelloWorldFile;

public class TxtGenerator implements Generator{

	
	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		AbstractGeneratedHelloWorldFile gen = new AbstractGeneratedHelloWorldFile(generatorParam,null);
		gen.generateFile();
	}

}
