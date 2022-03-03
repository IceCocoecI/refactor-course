/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.comments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 渲染测试类
 *
 * @since 2021-09-06
 */
public class RenderTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void should_get_renderResult() {
        Render render = new Render();
        String browser = "IE10";
        String platform = "MAC2";
        int resize = 10;

        String renderResult = render.renderBanner(browser, platform, resize);

        String expected = "browser: IE10" + LINE_SEPARATOR
            + "platform: MAC2" + LINE_SEPARATOR
            + "resize: 10";
        assertEquals(expected, renderResult);
    }

    @Test
    public void should_get_can_not_render_given_browser_notContain_IE() {
        Render render = new Render();
        String browser = "EI10";
        String platform = "MAC";
        int resize = 10;

        String renderResult = render.renderBanner(browser, platform, resize);

        assertEquals("can not render", renderResult);
    }

    @Test
    public void should_get_can_not_render_given_platform_notContain_MAC() {
        Render render = new Render();
        String browser = "EI10";
        String platform = "CAM";
        int resize = 10;

        String renderResult = render.renderBanner(browser, platform, resize);

        assertEquals("can not render", renderResult);
    }

    @Test
    public void should_get_can_not_render_given_resize_lessThan_0() {
        Render render = new Render();
        String browser = "IE10";
        String platform = "MAC";
        int resize = -1;

        String renderResult = render.renderBanner(browser, platform, resize);

        assertEquals("can not render", renderResult);
    }
}