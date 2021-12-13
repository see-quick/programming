package io.programming.junit5.orderExecution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestSuite1 extends TestSuiteGeneral {

    private static final Logger LOGGER = LogManager.getLogger(TestSuite1.class.getSimpleName());

    @Test
    void test1(ExtensionContext extensionContext) {
        LOGGER.info("eqweqweww");
    }

    @BeforeAll
    void setUp() {
        LOGGER.info("eweq");
        System.out.println("Mama...");
    }

    @AfterAll
    void tearDown(ExtensionContext extensionContext) throws Exception {
        System.out.println("Firsly this...");

        super.afterAllMayOverride(extensionContext);
    }

//    @Override
//    protected void beforeAllMayOverride(ExtensionContext extensionContext) {
//        super.beforeAllMayOverride(extensionContext);
//    }
}
