package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.core.AbstractGeneratedBannerFile;

public class TxtGenerator implements Generator{

	
	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		AbstractGeneratedBannerFile gen = new AbstractGeneratedBannerFile(generatorParam,null);
		gen.generateFile();
	}

}
