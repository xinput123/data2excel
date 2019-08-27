package com.export.entity;

import java.util.Date;

public class LisDetail {
    private String id;
    private String reportCode;
    private String userCode;
    private String inspName;
    private String inspValue;
    private String inspUnit;
    private Integer inspState;
    private String inspRenge;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getInspName() {
        return inspName;
    }

    public void setInspName(String inspName) {
        this.inspName = inspName;
    }

    public String getInspValue() {
        return inspValue;
    }

    public void setInspValue(String inspValue) {
        this.inspValue = inspValue;
    }

    public String getInspUnit() {
        return inspUnit;
    }

    public void setInspUnit(String inspUnit) {
        this.inspUnit = inspUnit;
    }

    public Integer getInspState() {
        return inspState;
    }

    public void setInspState(Integer inspState) {
        this.inspState = inspState;
    }

    public String getInspRenge() {
        return inspRenge;
    }

    public void setInspRenge(String inspRenge) {
        this.inspRenge = inspRenge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
