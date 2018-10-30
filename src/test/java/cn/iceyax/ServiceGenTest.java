package cn.iceyax;

import org.junit.Test;

import cn.iceyax.api.ServiceGenerator;
import cn.iceyax.api.ServiceImplGenerator;

public class ServiceGenTest extends BaseTest {

	
	@Test
	public void genService() throws Exception{
		ServiceGenerator txt = new ServiceGenerator();
		txt.generateCode(generatorParam);
		ServiceImplGenerator impl = new ServiceImplGenerator();
		impl.generateCode(generatorParam);
	}
}
