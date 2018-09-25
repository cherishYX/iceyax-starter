package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.TableInfo;
import cn.iceyax.core.AbstractGeneratedXml;

public class XmlGenerator implements Generator {

	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		for (TableInfo table : generatorParam.getTables()) {
			AbstractGeneratedXml xmlGen = new AbstractGeneratedXml(generatorParam , table);
			xmlGen.generateFile();
		}
	}

}
