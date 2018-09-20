package cn.iceyax.config.db;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DBField {
	/**
     * 列名
     */
    private String columnName;

    /**
     * 类型
     */
    private String typeName;

    /**
     * 类型（INT值）
     */
    private int dataType;

    /**
     * 长度
     */
    private int columnSize;

    /**
     * 小数点
     */
    private int decimalDigits;

    /**
     * 是否可空
     */
    private boolean isNullable = true;

    /**
     * 是否主键
     */
    private boolean isPrimaryKey = false;

    /**
     * 注释
     */
    private String remarks;

    /**
     * 默认值
     */
    private Object columnDef;


    /**
     * 是否自增
     */
    private boolean isAutoIncrement = false;

    /**
     * 字符最大字节数
     */
    private int charOctetLength;
}
