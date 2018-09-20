package cn.iceyax.base.mvc;

import java.util.Date;

import cn.iceyax.base.BaseVO;
import cn.iceyax.base.annotation.AuditAnnotation.CreateBy;
import cn.iceyax.base.annotation.AuditAnnotation.CreateDt;
import cn.iceyax.base.annotation.AuditAnnotation.UpdateBy;
import cn.iceyax.base.annotation.AuditAnnotation.UpdateDt;

@SuppressWarnings("serial")
public class BaseEntity extends BaseVO{
	
	private String createBy;
	private Date createDt;
	private String updateBy;
	private Date updateDt;
	public String getCreateBy() {
		return createBy;
	}
	@CreateBy
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDt() {
		return createDt;
	}
	@CreateDt
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	@UpdateBy
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	@UpdateDt
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
}
