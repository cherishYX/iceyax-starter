package cn.iceyax;

import org.junit.Test;

import cn.iceyax.api.TxtGenerator;

public class TxtGenetatorTest extends BaseTest{

	@Test
	public void genTxt(){
		TxtGenerator txt = new TxtGenerator();
		try {
			txt.generateCode(generatorParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
