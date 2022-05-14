package test.edu.qc.seclass;

import org.junit.*;
import src.edu.qc.seclass.BuggyClass;

import static org.junit.Assert.*;

public class BuggyClassTestSC1a {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After  //after each test
    public void tearDown() {
        myBuggyClass = null;
    }

    // This test achieves 100% statement coverage and does not reveal the fault. 
    @Test
    public void buggyMethod1() {
        // assertEquals(1, myBuggyClass.buggyMethod1(2, 1)); // achieves 50% statement coverage
        assertEquals(-1, myBuggyClass.buggyMethod1(5, 3)); //achieves 100% statement coverage
    }
}