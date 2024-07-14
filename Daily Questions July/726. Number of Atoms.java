// 726. Number of Atoms

// https://leetcode.com/problems/number-of-atoms/

/*

Given a string formula representing a chemical formula, return the count of each atom.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.

For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
Two formulas are concatenated together to produce another formula.

For example, "H2O2He3Mg4" is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula.

For example, "(H2O2)" and "(H2O2)3" are formulas.
Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

The test cases are generated so that all the values in the output fit in a 32-bit integer.

 

Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.
Example 2:

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 

Constraints:

1 <= formula.length <= 1000
formula consists of English letters, digits, '(', and ')'.
formula is always valid.


 */

class Solution {
    int i = 0;
    public String countOfAtoms(String formula) {
            //formula can have the following types of characters:
            // uppercase letter
            // lowercase letter
            // digits (0-9)
            // left parentheses
            // right parentheses
            
            // can have a lowercase letter followed by a digit
            // can't have digit followed by lowercase letter
            // therefore, only certain types of characters can follow others

            //starting character can only be a ( or an uppercase letter

            // cases:
            // if the element has letters and then has a number after it
            // if the element has no numbers after it (count = 1)
            // if element(s) has/have parentheses around it --
                // parentheses and nothing after it -- count = 1 for the compound
                // parentheses and a number after it -- need to multiply each element number count in the compound by the number outside
                //idea: use a stack for the parentheses
                // hint: When we see a (, we will parse recursively whatever is inside the barackets and it to our count, multiplying by the following multiplicity if there is one.
                // otherwise, we should see an uppercase character -- we will parsethe rest of the letters to get the name, and add tha
            Map<String, Integer> total = helper(formula);

            TreeMap<String, Integer> sortedTotal = new TreeMap<>(total);

            StringBuilder output = new StringBuilder();
            for (String atom : sortedTotal.keySet()) {
                output.append(atom);
                if (sortedTotal.get(atom) > 1) {
                    output.append(sortedTotal.get(atom));
                }
            }
            return output.toString();

            
            
    }

    //parsing recursive function 
    private Map<String, Integer> helper(String formula) {
        HashMap<String, Integer> elemToCount = new HashMap<>();
            String currCount = new String();
            String currAtom = new String();
            while (i < formula.length()) {
                //upper case
                if (isUpperCase(formula.charAt(i))) {
                    if (!currAtom.isEmpty()) {
                        if (currCount.isEmpty()) {
                            elemToCount.put(currAtom, elemToCount.getOrDefault(currAtom, 0) + 1);
                        } else {
                            elemToCount.put(currAtom, elemToCount.getOrDefault(currAtom, 0) + Integer.parseInt(currCount));
                            currAtom = "";
                        }
                    }
                    currCount = "";
                    currAtom = String.valueOf(formula.charAt(i));
                    i++;
                } 
                // lower case
                else if (isLowerCase(formula.charAt(i))) {
                    currAtom += String.valueOf(formula.charAt(i));
                    i++;
                } else if (isDigit(formula.charAt(i))) {
                    currCount += formula.charAt(i);
                    i++;
                } else if (formula.charAt(i) == '(') {
                    i++;
                    Map<String, Integer> nestElemToCount = helper(formula);
                    for (String atom : nestElemToCount.keySet()) {
                        elemToCount.put(atom, elemToCount.getOrDefault(atom, 0) + nestElemToCount.get(atom));
                    }
                } else if (formula.charAt(i) == ')') {
                    if (!currAtom.isEmpty()) {
                        if (currCount.isEmpty()) {
                            elemToCount.put(currAtom, elemToCount.getOrDefault(currAtom, 0) + 1);
                        } else {
                            elemToCount.put(currAtom, elemToCount.getOrDefault(currAtom, 0) + Integer.parseInt(currCount));
                        }
                    }

                    i++;
                    StringBuilder multiplicity = new StringBuilder();
                    while (i < formula.length() && isDigit(formula.charAt(i))) {
                        multiplicity.append(formula.charAt(i));
                        i++;
                    }
                    if (!multiplicity.isEmpty()) {
                        int mul = Integer.parseInt(multiplicity.toString());
                        for (String atom : elemToCount.keySet()) {
                            elemToCount.put(atom, elemToCount.get(atom) * mul);
                        }
                    }

                    return elemToCount;

                }
            }

            if (!currAtom.isEmpty()) {
                if (currCount.isEmpty()) {
                    elemToCount.put(currAtom, elemToCount.getOrDefault(currAtom, 0) + 1);
                } else {
                    elemToCount.put(currAtom, elemToCount.getOrDefault(currAtom, 0) + Integer.parseInt(currCount));
                }
            }
            return elemToCount;
    }

    //check if a letter is upper case:
    boolean isUpperCase(char c) {
        if ((int) c <= 90 && (int) c >= 65) {
            return true;
        }
        return false;
    }

    boolean isDigit(char c) {
        if ((int) c >= 45 && (int) c <= 57) {
            return true;
        }
        return false;
    }

    boolean isLowerCase(char c) {
        if ((int) c >= 97 && (int) c <= 122) {
            return true;
        }
        return false;
    }


}