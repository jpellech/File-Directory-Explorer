import java.util.ArrayList;

/**
 * Implements different recursive functions as practice.
 * 
 * @author Your Name Goes Here
 */
public class Recursion {
    /**
     * Recursively reverses a String (e.g. "Hello" -> "olleH")
     * 
     * @param s The String to be reversed
     * 
     * @return The reversed String
     */
    public static String rev(String s) {
        String returnString;
        int index = 0;
        if (s.length() == 0){
            return("");
        }
        else{
            char p = s.charAt(0);
            String x = s.substring(1);
            return(rev(x)+p);
        }
        

    }

    /**
     * Recursively removes all the items from an ArrayList of Integers 
     * and returns their sum.
     * 
     * @param numbers An ArrayList of Integers to sum
     * 
     * @return The sum of all the Integers stored in {@code numbers}
     */
     public static int sum(ArrayList<Integer> numbers){
        if (numbers.isEmpty()){
            return 0;
        }
        else{
            int x = numbers.remove(0);
            return(x + sum(numbers));
        }
     }

    /**
     * Recursively removes all the items from an ArrayList of Integers 
     * and prints them out in order on different lines, concatenating 
     * another indent on every even number
     * 
     * @param numbers An ArrayList of Integers to print 
     */
    public static void indentedPrint(ArrayList<Integer> numbers) {
        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.addAll(numbers);
        indentedPrintHelper("", numbers2);
        
    }

    private static int indentedPrintHelper(String prefix, ArrayList<Integer> numbers){
        if (numbers.isEmpty()){
            return 0;
        }
        else{
            int x = numbers.remove(0);
            System.out.println(prefix + x);
           if (x % 2 == 0){
                return indentedPrintHelper(prefix + "\t", numbers);
            }
            else{
                return indentedPrintHelper(prefix, numbers);
            }
            
            
        }
    }

    /**
     * The main method of our program.  It tests all of our functions above.
     * 
     * @param args The command line arguments (unused)
     */
    public static void main(String args[]) {
        /* Testing the rev function */

        String behold = "Behold the power of recursion!";
        System.out.println("The reverse of " + behold + " is " + rev(behold));

        /* Testing the linked list sum function */

         LinkedNode node = new LinkedNode(4);
         node = new LinkedNode(3, node);
         node = new LinkedNode(2, node);
         node = new LinkedNode(1, node);

         System.out.println("The sum of 1 through 4 is " + node.sum());

        /* Testing the array list sum function */

         ArrayList<Integer> numbers = new ArrayList<Integer>();

         numbers.add(1);
         numbers.add(2);
         numbers.add(3);
         numbers.add(4);

         System.out.println("The sum of 1 through 4 is " + sum(numbers));

        /* Testing the indented printing (reuses the now empty numbers list) */

         numbers.add(1);
         numbers.add(1);
         numbers.add(2);
         numbers.add(3);
         numbers.add(5);
         numbers.add(8);
         numbers.add(13);

         indentedPrint(numbers);
    }
}
