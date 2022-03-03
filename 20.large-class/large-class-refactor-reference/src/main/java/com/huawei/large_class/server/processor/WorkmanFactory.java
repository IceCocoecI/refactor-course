/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.large_class.server.processor;

import com.huawei.large_class.server.processor.enums.Gender;
import com.huawei.large_class.server.processor.model.CareerInfo;
import com.huawei.large_class.server.processor.model.Contacts;
import com.huawei.large_class.server.processor.workman.InvalidWorkman;
import com.huawei.large_class.server.processor.workman.Doctor;
import com.huawei.large_class.server.processor.workman.Teacher;

/**
 * 工作人员信息工厂
 *
 * @since 2021-08-25
 */
public class WorkmanFactory {
    /**
     * 创建工作人员
     * 
     * @param name 姓名
     * @param gender 性别
     * @param contacts 联系方式
     * @param careerInfo 职业信息
     * @return 工作人员
     */
    public Workman createWorkman(String name, Gender gender, Contacts contacts, CareerInfo careerInfo) {
        switch (careerInfo.getCareer()) {
            case TEACHER:
                return new Teacher(name, gender, contacts, careerInfo);
            case DOCTOR:
                return new Doctor(name, gender, contacts, careerInfo);
            default:
                return new InvalidWorkman(name, gender, contacts, careerInfo);
        }
    }
}
