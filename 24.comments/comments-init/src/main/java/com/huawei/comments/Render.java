/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.comments;

public class Render {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String renderBanner(String browser, String platform, int resize) {
        if (canRender(browser, platform, resize)) {
            return doRender(browser, platform, resize);
        }
        return "can not render";
    }

    private boolean canRender(String browser, String platform, int resize) {
        final boolean isIE = browser.toUpperCase().contains("IE");
        final boolean isMacOs = platform.toUpperCase().contains("MAC");
        return isIE // 浏览器中是否为"IE"
            && isMacOs // 操作系统是否是MAC
            && resize > 0;
    }

    private String doRender(String browser, String platform, int resize) {
        return "browser: " + browser + LINE_SEPARATOR
            + "platform: " + platform + LINE_SEPARATOR
            + "resize: " + resize;
    }
}
