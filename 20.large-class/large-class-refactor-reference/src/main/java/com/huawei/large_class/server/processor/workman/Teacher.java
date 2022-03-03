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
 * 教师工作信息
 *
 * @since 2021-08-25
 */
public class Teacher extends Workman {
    public Teacher(String name, Gender gender, Contacts contacts, CareerInfo careerInfo) {
        super(name, gender, contacts, careerInfo);
    }

    @Override
    public String generatePersonInfo() {
        return generateBasicInfo()
            + "teachers' hopes: " + showTeachersHope() + LINE_SEPARATOR
            + "school: " + this.careerInfo.getWorkplace() + LINE_SEPARATOR
            + "Salary after 2 years: " + getSalaryAfterYears(0.08, 2);
    }

    private String showTeachersHope() {
        return "Every student can grow sturdily and get good grades";
    }
}
