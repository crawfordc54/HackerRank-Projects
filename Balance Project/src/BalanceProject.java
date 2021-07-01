import java.io.*;
import java.util.*;
/*
 A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. 
 if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, this program determines if it is balanced or not.
 */
public class BalanceProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while(sc.hasNext()){
            input = sc.next();
            System.out.println(check(input));
        }
    }
    
    // Function to determine if a given string is balanced based on inputs of "{", "}", "(", ")", "[", "]"
    public static boolean check(String input){
        int c = 0 , s = 0, p = 0;
        for(int i = 0; i<input.length(); i++){ // Cycle through the passed in string...
            switch(input.charAt(i)){ 		   // For each character in the string check it
                case '(':					   // if it is equal to an opening ( then increment the placeholder count
                    p++;
                    break;
                case ')':					   // if it is equal to a closing ) and we have an opening paren, decrement the count
                    if(p == 0)                 // if we have a closing ) before we have seen an opening paren, return invalid
                        return false;
                    else
                        p--;
                    break;
                    
                case '{':					   // if it is equal to an opening { then increment the placeholder count
                    c++;
                    break;
                case '}':
                    if(c == 0)				   // if it is equal to a closing } and we have an opening {, decrement the count
                        return false;
                    else
                        c--;
                    break;
                    
                case '[':					  // if it is equal to an opening [ then increment the placeholder count
                    s++;
                    break;
                case ']':					 // if it is equal to a closing ] and we have an opening [, decrement the count
                    if(s == 0)
                        return false;
                    else
                        s--;
                    break;
                default :
            }   
        }
        if(p == 0 && s ==0 && c==0){		// Determine if it's balanced then return true
                return true;
            }
            return false;
    }
}
