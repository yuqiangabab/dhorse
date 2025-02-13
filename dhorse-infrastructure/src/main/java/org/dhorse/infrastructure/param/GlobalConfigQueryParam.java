package org.dhorse.infrastructure.param;

import java.io.Serializable;

/**
 * 全局配置查询参数
 * 
 * @author Dahai 2021-09-08
 */
public class GlobalConfigQueryParam implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 全局配置编号
	 */
	private String globalConfigId;

	/**
	 * 配置项类型，1：ldap，2：代码仓库，3：镜像仓库，4：maven，5：链路追踪模板，6：环境模板
	 */
	private Integer itemType;

	public String getGlobalConfigId() {
		return globalConfigId;
	}

	public void setGlobalConfigId(String globalConfigId) {
		this.globalConfigId = globalConfigId;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

}
