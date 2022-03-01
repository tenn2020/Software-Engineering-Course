package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {

    // String that stores a sequence of characters
    private String newString;

    public String getString() {
        if(newString.isEmpty()){
            return null;
        } else {
            return newString;
        }
    }

    public void setString(String newString) {
        this.newString = newString;
    }

    public int countNumbers() {
        int totalDigitsInString = 0;
        boolean isPrevIntDigit = false;

        if(newString.isEmpty()){
            return 0;
        }
        else if(newString == null){
            throw new NullPointerException();
        }
        for (int i = 0; i < newString.length(); i++) {

            // checks if the char at index i of newString is a digit value or not 
            if(Character.isDigit(newString.charAt(i))){
                if(isPrevIntDigit == false){
                    totalDigitsInString++;
                    isPrevIntDigit = true;
                }
                else{
                    isPrevIntDigit = true;
                }
            }
            // if the value is not digit, then set the isPrevIntDigit to false
            // so we can count again any other intergers in string. 
            else {
                isPrevIntDigit = false;
            }
        }
        return totalDigitsInString;
    }

    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        
        if(n <= 0) {
            throw new IllegalArgumentException();
        }
        else if(newString == null && n > 0) {
            throw new NullPointerException();
        }
        else if(newString.length() == 0 || n > newString.length()){
            return "";
        }
        else {
            StringBuffer result = new StringBuffer(); 

            if(startFromEnd == true) {
                for(int i = newString.length() - n; i >= 0; i = i-n) {
                    result.insert(0, newString.charAt(i));
                }
                return result.toString();
            }
            else {
                for(int i = n-1; i < newString.length(); i = i+n) {
                    result.append(newString.charAt(i));
                }
                return result.toString();
            }
        }
    }
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if(startPosition > endPosition){
            throw new IllegalArgumentException();
        }
        else if((startPosition <= endPosition) && ((startPosition < 1 || endPosition > newString.length()))){
            throw new MyIndexOutOfBoundsException();
        }
        else if((startPosition <= endPosition) && ((startPosition > 0 && endPosition > 0 && newString == null))){
            throw new NullPointerException();
        }
        else {
            StringBuffer result = new StringBuffer(); 
            for(int i = 0; i < newString.length(); i++){
                if(Character.isDigit(newString.charAt(i)) && i >= startPosition-1 && i <= endPosition -1){
                    switch(newString.charAt(i)){
                        case '0' : 
                            result.append("Zero");
                            break;
                        case '1' : 
                            result.append("One");
                            break;
                        case '2' : 
                            result.append("Two");
                            break;
                        case '3' : 
                            result.append("Three");
                            break;
                        case '4' : 
                            result.append("Four");
                            break;
                        case '5' : 
                            result.append("Five");
                            break;
                        case '6' : 
                            result.append("Six");
                            break;
                        case '7' : 
                            result.append("Seven");
                            break;
                        case '8' : 
                            result.append("Eight");
                            break;
                        case '9' : 
                            result.append("Nine");
                            break;
                    }
                }
                else{
                    result.append(newString.charAt(i));
                }
            }
            newString = result.toString();
        }
    }
}