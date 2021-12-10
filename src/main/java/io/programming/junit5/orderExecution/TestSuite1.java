package io.programming.junit5.orderExecution;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestSuite1 extends AbstractSuite {

    private static final Logger LOGGER = LogManager.getLogger(TestSuite1.class);

    @Test
    void test1(ExtensionContext extensionContext) {
    }

    @Override
    protected void beforeAllMayOverride(ExtensionContext extensionContext) {
        super.beforeAllMayOverride(extensionContext);
    }
}
