package cn.iceyax.base.condition;

import cn.iceyax.constants.SystemConstant;

@SuppressWarnings("serial")
public class PageCondition extends OrderCondition{
	/**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 分页大小
     */
    private Integer pageSize = SystemConstant.DEFAULT_PAGE_SIZE;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
    
}
