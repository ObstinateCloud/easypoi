package com.lengedyun.easypoi.bo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 *
 * @author zxx
 * @version 1.0.0 2021-11-06
 */
public class OrderlyExectionStatusBo {

    /** 省公司 */
    private String company;

    /** 省公司编码 */
    private String companyCode;

    /** 实际发生最大负荷（万千瓦） */
    private Double actualMaxLoad;

    /** 调度下达缺口指标（万千瓦） */
    private Double gapIndex;

    /** 执行时段 */
    private String execPeriod;

    /** 错避峰户数（户） */
    private Integer avoidPeakHouseholdNum;

    /** 错避峰负荷（万千瓦） */
    private Double avoidPeakLoad;

    /** 需求响应户数（户） */
    private Integer demandResponseHouseholdNum;

    /** 需求响应负荷（万千瓦） */
    private Double demandResponseLoad;

    /** 高耗能行业压限负荷 */
    private Double highEnergyIndustryLimitLoad;

    /** 高耗能行业压限负荷占比（百分比） */
    private String highEnergyIndustryLimitLoadRate;

    /** 影响电量（万千瓦时） */
    private Double affectedChargeQuantity;

    /** 用户执行率（百分比） */
    private String execRate;

    public OrderlyExectionStatusBo() {
    }

    public OrderlyExectionStatusBo(String company, String companyCode, Double actualMaxLoad, Double gapIndex, String execPeriod, Integer avoidPeakHouseholdNum, Double avoidPeakLoad, Integer demandResponseHouseholdNum, Double demandResponseLoad, Double highEnergyIndustryLimitLoad, String highEnergyIndustryLimitLoadRate, Double affectedChargeQuantity, String execRate) {
        this.company = company;
        this.companyCode = companyCode;
        this.actualMaxLoad = actualMaxLoad;
        this.gapIndex = gapIndex;
        this.execPeriod = execPeriod;
        this.avoidPeakHouseholdNum = avoidPeakHouseholdNum;
        this.avoidPeakLoad = avoidPeakLoad;
        this.demandResponseHouseholdNum = demandResponseHouseholdNum;
        this.demandResponseLoad = demandResponseLoad;
        this.highEnergyIndustryLimitLoad = highEnergyIndustryLimitLoad;
        this.highEnergyIndustryLimitLoadRate = highEnergyIndustryLimitLoadRate;
        this.affectedChargeQuantity = affectedChargeQuantity;
        this.execRate = execRate;
    }

    /**
     * 获取省公司
     *
     * @return 省公司
     */

    public String getCompany() {
        return this.company;
    }
    /**
     * 设置省公司
     * 
     * @param company
     *          省公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取省公司编码
     * 
     * @return 省公司编码
     */
    public String getCompanyCode() {
        return this.companyCode;
    }

    /**
     * 设置省公司编码
     * 
     * @param companyCode
     *          省公司编码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取实际发生最大负荷（万千瓦）
     * 
     * @return 实际发生最大负荷（万千瓦）
     */
    public Double getActualMaxLoad() {
        return this.actualMaxLoad;
    }

    /**
     * 设置实际发生最大负荷（万千瓦）
     * 
     * @param actualMaxLoad
     *          实际发生最大负荷（万千瓦）
     */
    public void setActualMaxLoad(Double actualMaxLoad) {
        this.actualMaxLoad = actualMaxLoad;
    }

    /**
     * 获取调度下达缺口指标（万千瓦）
     * 
     * @return 调度下达缺口指标（万千瓦）
     */
    public Double getGapIndex() {
        return this.gapIndex;
    }

    /**
     * 设置调度下达缺口指标（万千瓦）
     * 
     * @param gapIndex
     *          调度下达缺口指标（万千瓦）
     */
    public void setGapIndex(Double gapIndex) {
        this.gapIndex = gapIndex;
    }

    /**
     * 获取执行时段
     * 
     * @return 执行时段
     */
    public String getExecPeriod() {
        return this.execPeriod;
    }

    /**
     * 设置执行时段
     * 
     * @param execPeriod
     *          执行时段
     */
    public void setExecPeriod(String execPeriod) {
        this.execPeriod = execPeriod;
    }

    /**
     * 获取错避峰户数（户）
     * 
     * @return 错避峰户数（户）
     */
    public Integer getAvoidPeakHouseholdNum() {
        return this.avoidPeakHouseholdNum;
    }

    /**
     * 设置错避峰户数（户）
     * 
     * @param avoidPeakHouseholdNum
     *          错避峰户数（户）
     */
    public void setAvoidPeakHouseholdNum(Integer avoidPeakHouseholdNum) {
        this.avoidPeakHouseholdNum = avoidPeakHouseholdNum;
    }

    /**
     * 获取错避峰负荷（万千瓦）
     * 
     * @return 错避峰负荷（万千瓦）
     */
    public Double getAvoidPeakLoad() {
        return this.avoidPeakLoad;
    }

    /**
     * 设置错避峰负荷（万千瓦）
     * 
     * @param avoidPeakLoad
     *          错避峰负荷（万千瓦）
     */
    public void setAvoidPeakLoad(Double avoidPeakLoad) {
        this.avoidPeakLoad = avoidPeakLoad;
    }

    /**
     * 获取需求响应户数（户）
     * 
     * @return 需求响应户数（户）
     */
    public Integer getDemandResponseHouseholdNum() {
        return this.demandResponseHouseholdNum;
    }

    /**
     * 设置需求响应户数（户）
     * 
     * @param demandResponseHouseholdNum
     *          需求响应户数（户）
     */
    public void setDemandResponseHouseholdNum(Integer demandResponseHouseholdNum) {
        this.demandResponseHouseholdNum = demandResponseHouseholdNum;
    }

    /**
     * 获取需求响应负荷（万千瓦）
     * 
     * @return 需求响应负荷（万千瓦）
     */
    public Double getDemandResponseLoad() {
        return this.demandResponseLoad;
    }

    /**
     * 设置需求响应负荷（万千瓦）
     * 
     * @param demandResponseLoad
     *          需求响应负荷（万千瓦）
     */
    public void setDemandResponseLoad(Double demandResponseLoad) {
        this.demandResponseLoad = demandResponseLoad;
    }

    /**
     * 获取影响电量（万千瓦时）
     * 
     * @return 影响电量（万千瓦时）
     */
    public Double getAffectedChargeQuantity() {
        return this.affectedChargeQuantity;
    }

    /**
     * 设置影响电量（万千瓦时）
     * 
     * @param affectedChargeQuantity
     *          影响电量（万千瓦时）
     */
    public void setAffectedChargeQuantity(Double affectedChargeQuantity) {
        this.affectedChargeQuantity = affectedChargeQuantity;
    }

    /**
     * 获取用户执行率（百分比）
     * 
     * @return 用户执行率（百分比）
     */
    public String getExecRate() {
        return this.execRate;
    }

    /**
     * 设置用户执行率（百分比）
     * 
     * @param execRate
     *          用户执行率（百分比）
     */
    public void setExecRate(String execRate) {
        this.execRate = execRate;
    }


    /**
     * 获取高耗能行业压限负荷
     * 
     * @return 高耗能行业压限负荷
     */
    public Double getHighEnergyIndustryLimitLoad() {
        return this.highEnergyIndustryLimitLoad;
    }

    /**
     * 设置高耗能行业压限负荷
     * 
     * @param highEnergyIndustryLimitLoad
     *          高耗能行业压限负荷
     */
    public void setHighEnergyIndustryLimitLoad(Double highEnergyIndustryLimitLoad) {
        this.highEnergyIndustryLimitLoad = highEnergyIndustryLimitLoad;
    }

    /**
     * 获取高耗能行业压限负荷占比（百分比）
     * 
     * @return 高耗能行业压限负荷占比（百分比）
     */
    public String getHighEnergyIndustryLimitLoadRate() {
        return this.highEnergyIndustryLimitLoadRate;
    }

    /**
     * 设置高耗能行业压限负荷占比（百分比）
     * 
     * @param highEnergyIndustryLimitLoadRate
     *          高耗能行业压限负荷占比（百分比）
     */
    public void setHighEnergyIndustryLimitLoadRate(String highEnergyIndustryLimitLoadRate) {
        this.highEnergyIndustryLimitLoadRate = highEnergyIndustryLimitLoadRate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}