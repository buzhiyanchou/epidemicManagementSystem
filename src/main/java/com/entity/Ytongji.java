package com.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Ytongji<T> implements Serializable {

    // 社区总人数
    private Integer allNum;
    // 无症状感染者人数 用户中无症状感染的总人数
    private Integer wzzNum;
    // 现已隔离
    private Integer allGlNum;
    // 已治愈
    private Integer zyNum;
    // 累计确诊
    private Integer allQzNum;
    // 今日新增感染
    private Integer todayAddNum;
    // 今日新增无症状
    private Integer todayWzzNum;
    // 今日新增隔离
    private Integer todayGlNum;

}
