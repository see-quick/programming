package io.programming.junit5.orderExecution;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(ExtensionContextParameterResolver.class)
public class AbstractSuite {

    private static final Logger LOGGER = LogManager.getLogger(AbstractSuite.class);

    @BeforeEach
    void setUpTestCase(ExtensionContext extensionContext) {
        LOGGER.debug(String.join("", Collections.nCopies(76, "=")));
        LOGGER.debug(this.getClass().getName() + "- [BEFORE EACH] has been called.");
        beforeEachMayOverride(extensionContext);
    }

    @BeforeAll
    void setUpTestSuite(ExtensionContext extensionContext) {
        LOGGER.debug(String.join("", Collections.nCopies(76, "=")));
        LOGGER.debug(this.getClass().getName() + "- [BEFORE ALL] has been called.");
        beforeAllMayOverride(extensionContext);
    }

    @AfterEach
    void tearDownTestCase(ExtensionContext extensionContext) throws Exception {
        LOGGER.debug(String.join("", Collections.nCopies(76, "=")));
        LOGGER.debug(this.getClass().getName() + "- [AFTER EACH] has been called.");
        afterEachMayOverride(extensionContext);
    }

    @AfterAll
    void tearDownTestSuite(ExtensionContext extensionContext) throws Exception {
        LOGGER.debug(String.join("", Collections.nCopies(76, "=")));
        LOGGER.debug(this.getClass().getName() + "- [AFTER ALL] has been called.");
        afterAllMayOverride(extensionContext);
    }

    protected void afterEachMayOverride(ExtensionContext extensionContext) throws Exception {
//        if (!Environment.SKIP_TEARDOWN) {
//            ResourceManager.getInstance().deleteResources(extensionContext);
//
//            // if 'parallel namespace test' we are gonna delete namespace
//            if (StUtils.isParallelNamespaceTest(extensionContext)) {
//                // if RBAC is enable we don't run tests in parallel mode and with that said we don't create another namespaces
//                if (!Environment.isNamespaceRbacScope()) {
//                    final String namespaceToDelete = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get(Constants.NAMESPACE_KEY).toString();
//
//                    LOGGER.info("Deleting namespace:{} for test case:{}", namespaceToDelete, extensionContext.getDisplayName());
//                    cluster.deleteNamespace(CollectorElement.createCollectorElement(extensionContext.getRequiredTestClass().getName(), extensionContext.getDisplayName()), namespaceToDelete);
//                }
//            }
//        }
    }

    protected synchronized void afterAllMayOverride(ExtensionContext extensionContext) throws Exception {
//        if (!Environment.SKIP_TEARDOWN) {
//            ResourceManager.getInstance().deleteResources(extensionContext);
//            testSuiteNamespaceManager.deleteAdditionalNamespaces(extensionContext);
//        }
//        if (StUtils.isParallelSuite(extensionContext)) {
//            parallelSuiteController.removeParallelSuite(extensionContext);
//        }
//
//        if (StUtils.isIsolatedSuite(extensionContext)) {
//            parallelSuiteController.unLockIsolatedSuite();
//        }
//
//        // 1st case = contract that we always change configuration of CO when we annotate suite to 'isolated' and therefore
//        // we need to rollback to default configuration, which most of the suites use.
//        // ----
//        // 2nd case = transition from if previous suite is @IsolatedSuite and now @ParallelSuite is running we must do
//        // additional check that configuration is in default
//        LOGGER.error(String.join("", Collections.nCopies(76, "=")));
//        LOGGER.error(!SetupClusterOperator.defaultInstallation().createInstallation().equals(install));
//        if (install != null && !SetupClusterOperator.defaultInstallation().createInstallation().equals(install)) {
//            // install configuration differs from default one we are gonna roll-back
//            LOGGER.info(String.join("", Collections.nCopies(76, "=")));
//            LOGGER.info("Configurations of previous Cluster Operator are not identical. Starting rollback to the default configuration.");
//            LOGGER.info("Current Cluster Operator configuration:\n" + install.toString());
//            LOGGER.info("Default Cluster Operator configuration:\n" + SetupClusterOperator.defaultInstallation().createInstallation().toString());
//            LOGGER.info(String.join("", Collections.nCopies(76, "=")));
//            install = install.rollbackToDefaultConfiguration();
//        }
    }

    /**
     * BeforeEachMayOverride, is a method, which gives you option to override @BeforeAll in sub-classes and
     * ensure that this is also executed if you call it with super.beforeEachMayOverride(). You can also skip it and
     * you your implementation in sub-class as you want.
     * @param extensionContext
     */
    protected void beforeEachMayOverride(ExtensionContext extensionContext) {
//        // this is because we need to have different clusterName and kafkaClientsName in each test case without
//        // synchronization it can produce `data-race`
//        String testName = null;
//
//        synchronized (LOCK) {
//            if (extensionContext.getTestMethod().isPresent()) {
//                testName = extensionContext.getTestMethod().get().getName();
//            }
//
//            LOGGER.info("Not first test we are gonna generate cluster name");
//            String clusterName = CLUSTER_NAME_PREFIX + new Random().nextInt(Integer.MAX_VALUE);
//
//            mapWithClusterNames.put(testName, clusterName);
//            mapWithTestTopics.put(testName, KafkaTopicUtils.generateRandomNameOfTopic());
//            mapWithTestUsers.put(testName, KafkaUserUtils.generateRandomNameOfKafkaUser());
//            mapWithKafkaClientNames.put(testName, clusterName + "-" + Constants.KAFKA_CLIENTS);
//
//            LOGGER.debug("CLUSTER_NAMES_MAP: \n{}", mapWithClusterNames);
//            LOGGER.debug("USERS_NAME_MAP: \n{}", mapWithTestUsers);
//            LOGGER.debug("TOPIC_NAMES_MAP: \n{}", mapWithTestTopics);
//            LOGGER.debug("============THIS IS CLIENTS MAP:\n{}", mapWithKafkaClientNames);
//
//            // if 'parallel namespace test' we are gonna create namespace
//            if (StUtils.isParallelNamespaceTest(extensionContext)) {
//                // if RBAC is enable we don't run tests in parallel mode and with that said we don't create another namespaces
//                if (!Environment.isNamespaceRbacScope()) {
//                    final String namespaceTestCase = "namespace-" + counterOfNamespaces.getAndIncrement();
//
//                    extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put(Constants.NAMESPACE_KEY, namespaceTestCase);
//                    // create namespace by
//                    LOGGER.info("Creating namespace:{} for test case:{}", namespaceTestCase, testName);
//
//                    cluster.createNamespace(CollectorElement.createCollectorElement(extensionContext.getRequiredTestClass().getName(), extensionContext.getDisplayName()), namespaceTestCase);
//                    NetworkPolicyResource.applyDefaultNetworkPolicySettings(extensionContext, Collections.singletonList(namespaceTestCase));
//                    if (Environment.SYSTEM_TEST_STRIMZI_IMAGE_PULL_SECRET != null && !Environment.SYSTEM_TEST_STRIMZI_IMAGE_PULL_SECRET.isEmpty()) {
//                        StUtils.copyImagePullSecret(namespaceTestCase);
//                    }
//                }
//            }
//        }
    }

    /**
     * BeforeAllMayOverride, is a method, which gives you option to override @BeforeAll in sub-classes and
     * ensure that this is also executed if you call it with super.beforeAllMayOverride(). You can also skip it and
     * you your implementation in sub-class as you want.
     * @param extensionContext
     */
    protected void beforeAllMayOverride(ExtensionContext extensionContext) {
        LOGGER.info("Making beforeAll...");
//        cluster = KubeClusterResource.getInstance();
//        install = BeforeAllOnce.getInstall();
//
//        // ensures that only one thread will modify @ParallelSuiteController and race-condition could not happen
//        synchronized (BEFORE_ALL_LOCK) {
//            // (optional) create additional namespace/namespaces for test suites if needed
//            testSuiteNamespaceManager.createAdditionalNamespaces(extensionContext);
//
//            if (StUtils.isParallelSuite(extensionContext)) {
//                parallelSuiteController.addParallelSuite(extensionContext);
//            }
//        }
//        if (StUtils.isIsolatedSuite(extensionContext)) {
//            cluster.setNamespace(Constants.INFRA_NAMESPACE);
//            // wait for parallel suites are done
//            parallelSuiteController.waitUntilZeroParallelSuites();
//            // wait for isolated suites
//            parallelSuiteController.waitUntilEntryIsOpen();
//        }
    }
}
