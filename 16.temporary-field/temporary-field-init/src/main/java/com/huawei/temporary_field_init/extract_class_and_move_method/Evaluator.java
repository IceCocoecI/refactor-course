package com.huawei.temporary_field_init.extract_class_and_move_method;

public class Evaluator {
    int maxAsset;
    double usageFrequency;
    int overdueTimes;

    public Evaluator() {
    }

    /**
     * 整体评估
     *
     * @return 评估结果
     */
    public int evaluateAccount() {
        int evaluatePoint = 60;
        int usageTimes = (int) (usageFrequency * 365) + 1;
        double overdueRate = (double) overdueTimes / usageTimes;
        evaluatePoint -= 10 * overdueRate;
        evaluatePoint += (maxAsset / 100);
        return evaluatePoint;
    }

    /**
     * 消费水平评估
     *
     * @return 评估结果
     */
    public int evaluateConsumptionLevel() {
        return (int) (usageFrequency * 365) - overdueTimes * 3;
    }

    public void setMaxAsset(int maxAsset) {
        this.maxAsset = maxAsset;
    }

    public void setUsageFrequency(double usageFrequency) {
        this.usageFrequency = usageFrequency;
    }

    public void setOverdueTimes(int overdueTimes) {
        this.overdueTimes = overdueTimes;
    }
}