/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.alternative_classes.case1;

import com.huawei.alternative_classes.case1.helpers.Material;
import com.huawei.alternative_classes.case1.helpers.Product;
import com.huawei.alternative_classes.case1.helpers.Sex;

/**
 * 制造服务
 *
 * @since 2021-11-15
 */
public class ManufactureService {
    private String workerName;
    private String workerId;
    private Sex workerSex;

    public ManufactureService(String workerName, String workerId, Sex workerSex) {
        this.workerName = workerName;
        this.workerId = workerId;
        this.workerSex = workerSex;
    }

    public Product produceUsingWorker(Material material){
        Worker worker = new Worker().setProperties(workerSex,
                workerName, workerId);
        return worker.produce(material);
    }

    public Product produceUsingEmployee(Material material){
        Worker worker = new Worker();
        worker.setProperties(workerSex, workerName, workerId);
        return worker.produce(material);
    }

}
