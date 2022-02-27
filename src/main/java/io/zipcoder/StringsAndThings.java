package io.zipcoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int count = 0;
        int search;
        int max = input.length()+1;

        int findBlank = input.indexOf(" ");
        while (findBlank != -1) {
            if(((input.toUpperCase().charAt(findBlank-1)) == 'Y') || ((input.toUpperCase().charAt(findBlank-1)) == 'Z'))
            count++;
                findBlank = input.indexOf(" ",(findBlank+1));
        }



       /*search = input.toUpperCase().indexOf("Y ");
      / if (search < max){
           count++;
       }else if((input.toUpperCase().indexOf("Z "))< max){
           count++;
       }

*/
        if (input.toUpperCase().endsWith("Y")){
            count++;
        }
        if (input.toUpperCase().endsWith("Z")){
            count++;
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        int length = base.length();
        int removeLength = remove.length();
        int whereIsString = 0;
        String result ="";
        String traverse = base;
        whereIsString = traverse.indexOf(remove);
        while (whereIsString != -1){
            result = result.concat(traverse.substring(0,(whereIsString)));
            traverse = traverse.substring((whereIsString+removeLength));
            whereIsString = traverse.indexOf(remove);
        }
        if (result.length() <=0)
            return base;
        else result = result.concat(traverse);


        //find the matching string
        // remake the string from the

        return result;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */

    public Boolean containsEqualNumberOfIsAndNot(String input) {
        int var1 =0, var2 =0;
        String check = input;
        String check1 = input;
        int whereIsIs = check.indexOf("is");
        while (whereIsIs != -1) {
            var1++;
            whereIsIs = check.indexOf("is",(whereIsIs+1));
        }
        int whereIsNot = check1.indexOf("not");
        while (whereIsNot != -1) {
            var2++;
            whereIsNot = check1.indexOf("not",(whereIsNot + 1));
        }
        if (var2 == var1){
            return true;
        } else return false;
    }


    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
       // "(gg)" find g see if next char is g then continue
        String check = input;
        int whereIsg = check.indexOf("g");
        while (whereIsg != -1){
            int nextG = whereIsg +1;
              if(check.charAt(nextG) == 'g'){
                  check = check.substring(nextG+1);
                  whereIsg = check.indexOf("g");
            }else
                return false;
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
       // [a-z]{3}
        int count = 0;
        int index = 0;
        int length = input.length();
        while (index <= (length-2)) {
            if ((input.charAt(index) == input.charAt(index + 1)) && (input.charAt(index + 1) == (input.charAt(index + 2)))) {
                count++;
            }
            index++;
        }
        return count;
    }
}
