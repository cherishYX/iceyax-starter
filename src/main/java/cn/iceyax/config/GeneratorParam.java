package cn.iceyax.config;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 生成参数
 *
 * @author yanxiang
 * @date 2017/11/09
 */
@Getter
@Setter
public class GeneratorParam {

    /**
     * 数据库相关信息
     */
    private DatabaseInfo databaseInfo;

    /**
     * 程序包相关信息
     */
    private PackageInfo packageInfo;
    /**
     * 基础父类名称
     */
    private ParentBaseClassInfo parentBaseClassInfo;

    /**
     * 数据库表信息
     */
    private List<TableInfo> tables;
    /**
     * 项目结构信息
     */
    private ProjectInfo projectInfo;
    /**
     * entity排除前綴列表，比如去掉 t_
     */
    private List<String> exclude;
    
    
}
