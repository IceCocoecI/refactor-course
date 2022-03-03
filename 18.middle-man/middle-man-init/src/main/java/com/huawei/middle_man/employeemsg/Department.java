/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.middle_man.employeemsg;

/**
 * 部门信息
 *
 * @since 2021-06-17
 */
public class Department {
    private String id;

    private String chargeCode;

    private String manager;

    private String type;

    private String totalEmployee;

    private String function;

    private String location;

    /**
     * 获取部门ID
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取部门交易编号
     *
     * @return String
     */
    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    /**
     * 获取部门领导
     *
     * @return String
     */
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 获取部门类型
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取部门人数
     *
     * @return String
     */
    public String getTotalEmployee() {
        return totalEmployee;
    }

    public void setTotalEmployee(String totalEmployee) {
        this.totalEmployee = totalEmployee;
    }

    /**
     * 获取部门职能
     *
     * @return String
     */
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * 获取部门位置
     *
     * @return String
     */
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
