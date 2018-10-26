package cn.iceyax.config;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据库表信息
 *
 * @author yanxiang
 * @date 2017/11/09
 */
@Setter
@Getter
public class TableInfo {
	/**
	 * 表名前綴，如：root.test
	 */
	private String preName;
    /**
     * 名称
     */
    private String name;

    /**
     * 注释
     */
    private String remark;

    /**
     * 表类型
     *
     * Single：独立表
     * SubTable：子表
     */
    private String type;

    /**
     * 主键字段名称
     */
    private String key;

    /**
     * 主键类型
     *
     * ID：主键是自增ID（Long）
     * UUID：主键是UUID（String）
     *
     */
    private String keyType;

    /**
     * 连接表
     */
    private String main;

    /**
     * 连接字段
     */
    private String join;

    /**
     * 查询字段
     */
    private List<String> query;
}
