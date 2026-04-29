package com.example;

import org.junit.Test;

public class AppTest {

    @Test
    public void testMain() {
        App.main(new String[]{});   // 🔥 THIS is what gives coverage
    }
}
