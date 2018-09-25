package cn.iceyax.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 程序包信息
 *
 * @author lutiehua
 * @date 2017/09/25
 */
@Getter
@Setter
public class PackageInfo {

    /**
     * 项目路径
     */
    private String projectPath;

    /**
     * 基础包名
     */
    private String basePackage;

    /**
     * config包名
     */
    private String configPackage;
    /**
     * 扩展路径
     */
    private String extendsPath;
    /**
     * controller包名
     */
    private String controllerPackage;

    /**
     * facade包名
     */
    private String facadePackage = "api";

    /**
     * service包名
     */
    private String servicePackage;

    /**
     * dao包名
     */
    private String daoPackage;

    /**
     * entity包名
     */
    private String entityPackage;

    /**
     * dto包名
     */
    private String dtoPackage;

    /**
     * vo包名
     */
    private String voPackage;

    /**
     * 作者
     */
    private String author;

    /**
     * JAVA源文件路径
     */
    private String javaPath;

    /**
     * 资源文件路径
     */
    private String resourcePath;

    /**
     * 测试类路径
     */
    private String testPath;

}
