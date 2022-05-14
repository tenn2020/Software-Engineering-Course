package src.edu.qc.seclass;

public class BuggyClass {

    public int buggyMethod1(int a, int b){

        int result = 1;

        if (b % 2 == 0){
            b = 0;
        }

        // bug
        result = a / b;

        if(result % 2 == 0){
            result = a/result;
        }

        else {
            result = -1;
        }

        return result;
    }
    
    public int buggyMethod2(int a, int b){

        int result = 1;

        if (b % 2 == 0) {
            b = 0;
        }

        if (b == 0) {
            // bug
            result = a / b;
            // result = a/result;
        }
        else if (result % 2 == 0) {
            result = a/result;
        }
        else {
            result = -1;
        }

        return result;
    }

    public void buggyMethod3 (int a, int b){
        /* It is not possible to create a method that achieves 100% branch coverage and 
        does not reveal the fault because in order to achieve 100% for branch coverage, 
        one has to explore all the possibile branches including the test suite that 
        contains the fault/bug. 
        */
        /* It is also impossible to create a test suite that achieves 100% statement 
        coverage, does not achieve 100% branch coverage, and reveals the fault. This is because
        statement coverage is a subsumption of Branch Coverage meaning if you cover all the branches, 
        then this also covers all statements. */
    }

    public void buggyMethod4 (int a, int b) {
        /*
        It is possible to create a method that achieves 100% Statement Coverage and 
        reveals the fault but it is not possible to create a test suite that achieves 
        100% branch coverage and does not reveal the fault. This is because in order 
        to achieve 100% for Branch Coverage, one has to explore all the possibile branches 
        including the test suite that contains the fault/bug. 
         */
    }

    public void buggyMethod5 (int a, int b) {
        /*
        It is not possible to create a test suite that achieves 100% Statement Coverage 
        that does not reveal line 4 or any specific lines because to achieve 100% Statement 
        Coverage, the method should be able to parse all the lines in the method. Parsing all 
        the lines in the method will reveal line 4 or any specific lines. 
         */
    }
    
}