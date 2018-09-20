package cn.iceyax.base.condition;

import cn.iceyax.base.BaseVO;

@SuppressWarnings("serial")
public class OrderCondition extends BaseVO{
	/**
     * 排序字段名
     */
    private String orderColumn;

    /**
     * 排序方向
     */
    private String orderDirection = "DESC";

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}
