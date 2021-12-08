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

    public double getTax() {
        return tax;
    }

    public double getInsurance() {
        return insurance;
    }

    @Override
    public PaySlip clone() {
        try {
            return (PaySlip) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("CloneNotSupportedException for money");
        }
    }

    public PaySlip enrichPaySlip() {
        final PaySlip clonePaySlip = clone();
        final double base = clonePaySlip.getBasePay();
        final double tax = Math.max(0, (base - 5000) * 0.2);
        final double insurance = base * 0.08;
        double actualPay = base - tax - insurance;
        clonePaySlip.tax = tax;
        clonePaySlip.insurance = insurance;
        clonePaySlip.actualPay = actualPay;
        return clonePaySlip;
    }
}
