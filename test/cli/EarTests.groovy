import grails.test.AbstractCliTestCase

class EarTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testEar() {

        execute(["ear"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
