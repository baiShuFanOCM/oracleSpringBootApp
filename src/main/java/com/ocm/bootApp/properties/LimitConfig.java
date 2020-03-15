package com.ocm.bootApp.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by oracleOCM
 * 2020-03-08 17:13
 */
@Component
@ConfigurationProperties(prefix = "limit")
public class LimitConfig {

	private BigDecimal minMoney;

	private BigDecimal maxMoney;

	private String description;

	private String name ;



	public BigDecimal getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(BigDecimal minMoney) {
		this.minMoney = minMoney;
	}

	public BigDecimal getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(BigDecimal maxMoney) {
		this.maxMoney = maxMoney;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
