package test.edu.qc.seclass;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import src.edu.qc.seclass.BuggyClass;

public class BuggyClassTestBC2 {
    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After  //after each test
    public void tearDown() {
        myBuggyClass = null;
    }

    // This test achieve more than 50% Branch Coverage of buggyMethod2 and reveal the fault
    @Test
    public void buggyMethod2() {
        assertEquals(2, myBuggyClass.buggyMethod2(2, 2)); 
    }
}