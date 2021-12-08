package com.huawei.shotgun_surgery_init.model;

/**
 * 薪资单
 *
 * @since 2021-11-16
 */
public class PaySlip implements Cloneable {
    private final int employeeId;

    private final double basePay;

    private double actualPay;

    private double tax;

    private double insurance;

    public PaySlip(int employeeId, double basePay) {
        this.employeeId = employeeId;
        this.basePay = basePay;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBasePay() {
        return basePay;
    }

    public double getActualPay() {
        return actualPay;
    }

    public void setActualPay(double actualPay) {
        this.actualPay = actualPay;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    @Override
    public PaySlip clone() {
        try {
            return (PaySlip) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("CloneNotSupportedException for money");
        }
    }
}
