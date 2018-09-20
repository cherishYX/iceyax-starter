package cn.iceyax.api;

import cn.iceyax.config.GeneratorParam;

public interface Generator {
	/**
     * 自动生成代码
     *
     * @param generatorParam
     * @throws Exception
     */
    void generateCode(GeneratorParam generatorParam) throws Exception;
}
