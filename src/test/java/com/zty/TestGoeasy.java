package com.zty;

import io.goeasy.GoEasy;
import org.junit.Test;

public class TestGoeasy {
    @Test
    public void testGo() {
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-a36c38bc99ab4be39f74d7840201943e");
        goEasy.publish("140", "Hello, GoEasy!xxxx");
    }
}
