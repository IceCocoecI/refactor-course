/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor.workman;

import com.huawei.large_class_init.server.processor.Workman;
import com.huawei.large_class_init.server.processor.enums.Gender;
import com.huawei.large_class_init.server.processor.model.CareerInfo;
import com.huawei.large_class_init.server.processor.model.Contacts;

import static com.huawei.large_class_init.server.processor.constant.Constant.LINE_SEPARATOR;

/**
 * 功能描述
 *
 * @since 2021-12-13
 */
public class Doctor extends Workman {
    public Doctor(String name, Gender gender, CareerInfo careerInfo, Contacts contacts) {
        super(name, gender, careerInfo, contacts);
    }

    @Override
    public String generatePersonInfo() {
        return generateBasicInfo()
            + "hospital: " + this.careerInfo.getWorkplace() + LINE_SEPARATOR
            + "doctors' duties: " + showDoctorsDuty() + LINE_SEPARATOR
            + "Salary after 3 years: " + super.getSalaryAfterYears(0.1, 3);
    }

    private String showDoctorsDuty() {
        return "A doctor's work is to heal and save lives";
    }

}
