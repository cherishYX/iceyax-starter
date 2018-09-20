package cn.iceyax.api;

import java.util.List;

import cn.iceyax.config.GeneratorParam;
import cn.iceyax.config.TableInfo;
import cn.iceyax.core.AbstractGeneratedMapperClass;
/**
 * 
 * ClassName: MapperGenerator 
 * @Description: mapper类生成
 * @author yanx
 * @email 123190875@qq.com
 * @date 2018年9月18日 上午10:48:16
 */
public class MapperGenerator implements Generator{

	@Override
	public void generateCode(GeneratorParam generatorParam) throws Exception {
		List<TableInfo> tables = generatorParam.getTables();
		for (TableInfo table : tables) {
			AbstractGeneratedMapperClass gen = new AbstractGeneratedMapperClass(generatorParam,table);
			gen.generateFile();
		}
	}

}
