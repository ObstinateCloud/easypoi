package com.lengedyun.easypoi.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ExectionStatusBO {
    private Date fillingDate;
    @Excel(name = "单位")
    private String company;
    private String companyCode;

    @Excel(name = "实际发生最大负荷")
    private BigDecimal actualMaxLoad;
    @Excel(name="调度下达缺口指标")
    private BigDecimal gapIndex;
    @Excel(name="执行时段")
    private String execPeriod;
    private Integer avoidPeakHouseholdNum;
    private BigDecimal avoidPeakLoad;
    private Integer demandResponseHouseholdNum;
    private BigDecimal demandResponseLoad;
    private BigDecimal affectedChargeQuantity;
    private BigDecimal execRate;
    private BigDecimal execPeriodLimitLoad;
    private String execRateExplain;
    private BigDecimal annualOrderlyPowerMaxLoad;
    private BigDecimal rateInAnnualOrderlyPower;
    private BigDecimal rateInMaxLoad;
    private BigDecimal rateInIndustrialLoad;
    private BigDecimal chemicalIndustryLimitLoad;
    private BigDecimal nonmetalIndustryLimitLoad;
    private BigDecimal ferrousMetalIndustryLimitLoad;
    private BigDecimal nonferrousMetalIndustryLimitLoad;
    private BigDecimal otherIndustriesLimitLoad;
    private BigDecimal highEnergyIndustryLimitLoad;
    private BigDecimal highEnergyIndustryLimitLoadRate;
}
