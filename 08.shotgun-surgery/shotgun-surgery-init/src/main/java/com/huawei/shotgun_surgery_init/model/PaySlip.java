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

    /**
     * 计算纳税额
     */
    public void calculateTaxForPaySlip() {
        final double base = this.getBasePay();
        final double tax = Math.max(0, (base - 5000) * 0.2);
        setTax(tax);
    }

    /**
     * 计算五险一金
     */
    public void calculateInsuranceForPaySlip() {
        final double base = this.getBasePay();
        final double insurance = base * 0.08;
        setInsurance(insurance);
    }

    /**
     * 计算实发工资
     */
    public void calculateActualPayForPaySlip() {
        final double base = this.getBasePay();
        final double tax = Math.max(0, (base - 5000) * 0.2);
        final double insurance = base * 0.08;
        double actualPay = base - tax - insurance;
        setActualPay(actualPay);
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
