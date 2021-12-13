/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class_init.server.processor;

import com.huawei.large_class_init.server.processor.enums.Gender;
import com.huawei.large_class_init.server.processor.model.CareerInfo;
import com.huawei.large_class_init.server.processor.model.Contacts;
import com.huawei.large_class_init.server.processor.workman.Doctor;
import com.huawei.large_class_init.server.processor.workman.InvalidWorkman;
import com.huawei.large_class_init.server.processor.workman.Teacher;

/**
 * 功能描述
 *
 * @since 2021-12-13
 */
public class WorkmanFactory {
    public Workman createWorkman(String name, Gender gender, CareerInfo careerInfo, Contacts contacts) {
        switch (careerInfo.getCareer()) {
            case TEACHER:
                return new Teacher(name, gender, careerInfo, contacts);
            case DOCTOR:
                return new Doctor(name, gender, careerInfo, contacts);
            default:
                return new InvalidWorkman(name, gender, careerInfo, contacts);
        }
    }
}
