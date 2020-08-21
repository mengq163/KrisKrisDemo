package com.kris.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderPresentInfo {
    private Long id;

    private String activityName;

    private Date beginTime;

    private Date endTime;

    private Integer activityStoresSelectType;

    private String activityStoresIds;

    private Integer memberLevelSelectType;

    private String memberLevelIds;

    private BigDecimal activityOrderConsume;

    private String paymentChannelIds;

    private Integer equityType;

    private Long couponId;

    private Long luckyTurningId;

    private Integer activityStatus;

    private Date createTime;

    private Date updateTime;
}
