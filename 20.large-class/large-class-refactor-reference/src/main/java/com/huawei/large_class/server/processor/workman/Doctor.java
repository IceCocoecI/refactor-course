/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.processor.workman;

import static com.huawei.large_class.server.processor.constant.Constant.LINE_SEPARATOR;

import com.huawei.large_class.server.processor.Workman;
import com.huawei.large_class.server.processor.enums.Gender;
import com.huawei.large_class.server.processor.model.CareerInfo;
import com.huawei.large_class.server.processor.model.Contacts;

/**
 * 医生工作信息
 *
 * @since 2021-08-25
 */
public class Doctor extends Workman {
    public Doctor(String name, Gender gender, Contacts contacts, CareerInfo careerInfo) {
        super(name, gender, contacts, careerInfo);
    }

    @Override
    public String generatePersonInfo() {
        return generateBasicInfo()
            + "hospital: " + this.careerInfo.getWorkplace() + LINE_SEPARATOR
            + "doctors' duties: " + showDoctorsDuty() + LINE_SEPARATOR
            + "Salary after 3 years: " + getSalaryAfterYears(0.1, 3);
    }

    private String showDoctorsDuty() {
        return "A doctor's work is to heal and save lives";
    }
}
