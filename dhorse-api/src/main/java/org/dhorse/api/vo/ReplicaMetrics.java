package org.dhorse.api.vo;

/**
 * 副本指标
 * 
 * @author Dahai 2023-02-28
 */
public class ReplicaMetrics extends BaseDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 副本名称
	 */
	private String replicaName;

	/**
	 * 指标类型，1：cpu，2：内存
	 */
	private int metricsType;

	/**
	 * 最小值
	 */
	private Long minValue;

	/**
	 * 最大值
	 */
	private Long maxValue;

	/**
	 * 当前值
	 */
	private Long currentValue;

	public String getReplicaName() {
		return replicaName;
	}

	public void setReplicaName(String replicaName) {
		this.replicaName = replicaName;
	}

	public int getMetricsType() {
		return metricsType;
	}

	public void setMetricsType(int metricsType) {
		this.metricsType = metricsType;
	}

	public Long getMinValue() {
		return minValue;
	}

	public void setMinValue(Long minValue) {
		this.minValue = minValue;
	}

	public Long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}

	public Long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}
}