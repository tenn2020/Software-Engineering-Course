package test.edu.qc.seclass;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import src.edu.qc.seclass.BuggyClass;

public class BuggyClassTestSC2 {
    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After  //after each test
    public void tearDown() {
        myBuggyClass = null;
    }

    // This test achieves 100% Statement Coverage of buggyMethod2 and does NOT reveal the fault. 
    @Test
    public void buggyMethod2() {
        assertEquals(-1, myBuggyClass.buggyMethod2(5, 3)); 
    }
}