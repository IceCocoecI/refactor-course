/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.comments;

/**
 * 渲染
 *
 * @since 2021-09-06
 */
public class Render {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 渲染标题
     * 
     * @param browser 浏览器名称
     * @param platform 平台名称
     * @param resize 调整尺寸
     * @return 渲染结果
     */
    public String renderBanner(String browser, String platform, int resize) {
        if (canRender(browser, platform, resize)) {
            return doRender(browser, platform, resize);
        }
        return "can not render";
    }

    private boolean canRender(String browser, String platform, int resize) {
        final boolean isIE = browser.toUpperCase().contains("IE");
        final boolean isMacOs = platform.toUpperCase().contains("MAC");
        return isIE && isMacOs && resize > 0;
    }

    private String doRender(String browser, String platform, int resize) {
        return "browser: " + browser + LINE_SEPARATOR
            + "platform: " + platform + LINE_SEPARATOR
            + "resize: " + resize;
    }
}
