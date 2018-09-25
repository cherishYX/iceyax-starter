package cn.iceyax;

import org.junit.Test;

import cn.iceyax.api.EntityGenerator;
import cn.iceyax.api.MapperGenerator;
import cn.iceyax.api.XmlGenerator;

public class MapperGenTest extends BaseTest{

	@Test
	public void genMapper(){
		try {
			MapperGenerator genmapper = new MapperGenerator();
			genmapper.generateCode(generatorParam);
			
			EntityGenerator gen = new EntityGenerator();
			gen.generateCode(generatorParam);
			
			XmlGenerator xmlGen = new XmlGenerator();
			xmlGen.generateCode(generatorParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
