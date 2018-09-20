package cn.iceyax.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 类成员变量
 *
 * @author yanxiang
 * @date 2017/09/26
 */
@Getter
@Setter
public class JavaField {

    /**
     * private, protected, public
     */
    private String scope;

    /**
     * String, Integer, Long, Object
     */
    private String type;

    /**
     * 属性名
     */
    private String name;

    /**
     * 默认值
     */
    private String value;

    /**
     * 注释
     */
    private String remark;

    /**
     * 注解
     */
    private List<JavaAnnotation> annotations = new ArrayList<>();
}
