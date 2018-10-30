package cn.iceyax;

import org.junit.Test;

import cn.iceyax.api.ServiceGenerator;
import cn.iceyax.api.ServiceImplGenerator;

public class ServiceGenTest extends BaseTest {

	
	@Test
	public void genService(){
		ServiceGenerator txt = new ServiceGenerator();
		ServiceImplGenerator impl = new ServiceImplGenerator();
		try {
			txt.generateCode(generatorParam);
			impl.generateCode(generatorParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
