package test.edu.qc.seclass;

import org.junit.*;
import src.edu.qc.seclass.BuggyClass;

import static org.junit.Assert.*;

public class BuggyClassTestSC1b {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After            //after each test
    public void tearDown() {
        myBuggyClass = null;
    }

    // This test achieves less than 50% branch coverage and reveals the fault.
    @Test
    public void buggyMethod1() {
        assertEquals(2, myBuggyClass.buggyMethod1(2, 2));
    }
}