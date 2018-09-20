package cn.iceyax;

import org.junit.Test;

import cn.iceyax.api.EntityGenerator;
import cn.iceyax.api.MapperGenerator;

public class MapperGenTest extends BaseTest{

	@Test
	public void genMapper(){
		try {
			MapperGenerator genmapper = new MapperGenerator();
			genmapper.generateCode(generatorParam);
			EntityGenerator gen = new EntityGenerator();
			gen.generateCode(generatorParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
