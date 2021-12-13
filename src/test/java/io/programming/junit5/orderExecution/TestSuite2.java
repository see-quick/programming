package io.programming.junit5.orderExecution;

import org.junit.jupiter.api.Test;

public class TestSuite2 extends AbstractSuite {

    @Test
    void test1() {
        throw new RuntimeException();

//        System.out.println("hello from test1");
    }
}
