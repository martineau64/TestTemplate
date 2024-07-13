package testTools;

import java.io.IOException;

public class TestTemplate {
    
    private String TESTSNAME;
    private int TESTID;
    private int NBTESTS;
    private int PASSED;
    private int FAILED;

    private boolean DEBUG;

    private String SECTIONSEPARATOR = "****************";
    private String TESTSEPARATOR = "--------";

    public TestTemplate(String testsName, int nbTests) {
        this.TESTSNAME = testsName;
        this.TESTID = 0;
        this.NBTESTS = nbTests;
        this.PASSED = this.FAILED = 0;
        this.DEBUG = false;
    }

    /**
     * Sets the exact number of tests to be performed.
     * Should be called before any other method if needed.
     * @param nbTests Number of expected tests.
     */
    public void setNbTests(int nbTests) {
        this.NBTESTS = nbTests;
    }

    /**
     * Displays the start of the test series, with its name and its number of tests.
     */
    public void displayStartTests() {
        String buffer = "\n" + this.SECTIONSEPARATOR + "  STARTING " + this.TESTSNAME + "  " + SECTIONSEPARATOR;
        System.out.println(buffer);
        System.out.println("NUMBER OF TESTS: " + this.NBTESTS + "\n");
    }

    /**
     * Displays the end of the test series, with its name and the number of PASSED and FAILED
     * tests if the number of tests is correct.
     */
    public void displayEndTests() {
        String buffer;
        if (this.TESTID != this.NBTESTS) {
            buffer = "WARNING: Expected " + this.NBTESTS + " tests, found " + this.TESTID + "!";
            System.out.println(buffer);
        } else {
            buffer = this.PASSED + " tests PASSED, " + this.FAILED + " tests FAILED out of " + this.NBTESTS + " tests!";
            System.out.println(buffer);
        }
        buffer = this.SECTIONSEPARATOR + "  ENDING " + this.TESTSNAME + "  " + SECTIONSEPARATOR + "\n";
        System.out.println(buffer);
    }

    /**
     * Displays whether the result is expected or not, and what was expected if DEBUG.
     * Increments TESTID.
     * @param testName Name of the test.
     * @param expected Expected object.
     * @param result Result object after calling the method to be tested.
     */
    public void displayTestResult(String testName, Object expected, Object result) {
        this.TESTID++;
        if (this.TESTID <= this.NBTESTS) {
            boolean passed = false;
            if (this.TESTID > 1) {
                System.out.println(this.TESTSEPARATOR + "\n");
            }
            String buffer = "Starting test " + testName + "... " + this.TESTID + " / " + this.NBTESTS;
            System.out.println(buffer);
            if (expected == null) {
                if (result == null) {
                    passed = true;
                }
            } else {
                if (expected.equals(result)) {
                    passed = true;
                }
            }
            if (passed) {
                System.out.println("Test " + testName + " PASSED!");
                this.PASSED++;
            } else {
                System.out.println("Test " + testName + " FAILED!");
                if (this.DEBUG) {
                    System.out.println("Found " + result + ", expected " + expected);
                }
                
                this.FAILED++;
            }
            System.out.println();
        }
    }

    /**
     * Displays the failed test and the exception message if DEBUG.
     * Increments TESTID.
     * @param testName Name of the test.
     * @param exception Exception thrown after calling the method to be tested.
     */
    public void displayTestResult(String testName, IOException exception) {
        this.TESTID++;
        if (this.TESTID <= this.NBTESTS) {
            boolean passed = false;
            if (this.TESTID > 1) {
                System.out.println(this.TESTSEPARATOR + "\n");
            }
            String buffer = "Starting test " + testName + "... " + this.TESTID + " / " + this.NBTESTS;
            System.out.println(buffer);
            System.out.println("Test " + testName + " FAILED: exception found!");
            if (this.DEBUG) {
                System.out.println(exception.getMessage());
            }
            this.FAILED++;
            System.out.println();
        }
    }
}
