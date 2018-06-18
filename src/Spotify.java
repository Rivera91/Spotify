/**
 * QUESTION 1:
 * Sort the letters in the string s by the order they occur in the string t. You can assume t will not have
 * repetitive characters. For s = "weather" and t = "therapyw", the output should be sortByString(s, t) = "theeraw".
 * For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".
 *
 *
 *
 * QUESTION 2:
 * Given an encoded string, return its corresponding decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated
 * exactly k times. Note: k is guaranteed to be a positive integer.
 * <p>
 * For s = "4[ab]", the output should be decodeString(s) = "abababab"
 * For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
 *
 *
 *
 * QUESTION 3:
 * Your quirky boss collects rare, old coins. They found out you're a programmer and asked you to solve something
 * they've been wondering for a long time.
 *
 * Write a function that, given an amount of money and an array of coin denominations, computes the number of ways
 * to make the amount of money with coins of the available denominations.
 *
 * Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your program would output 4—the number of
 * ways to make 4¢ with those denominations:
 *
 * 1¢, 1¢, 1¢, 1¢
 * 1¢, 1¢, 2¢
 * 1¢, 3¢
 * 2¢, 2¢
 */




public class Spotify {


        public static void main(String[] args) {
            int[] denominations = new int[]{1, 2, 3};


            System.out.println("QUESTION 1 ANSWER ");

            System.out.println("Projected Output: theeraw");
            System.out.println("Actual Output: " + sortByStrings("weather", "therapyw"));


            System.out.println("Projected Output: oodg");
            System.out.println("Actual Output: " + sortByStrings("good", "odg"));

            System.out.println("QUESTION 2 ANSWER");

            System.out.println("Projected Output: abababab");
            System.out.println(decodeString(4, "ab"));

            System.out.println("Projected Output: baaabaaa");
            System.out.println(decodeString(2, "b" + decodeString(3, "a")));

            System.out.println("QUESTION 3 ANSWER");

            System.out.println("Projected Output: 4");
            System.out.println(changeCombos(4, denominations));



        }

        private static String sortByStrings(String s, String t) {
            StringBuilder sb = new StringBuilder();

            int[] charArr = new int[26];

            for (char c : t.toCharArray()) {
                charArr[c - 'a']++;
            }

            for (char c : s.toCharArray()) {
                if (charArr[c - 'a'] > 0) {
                    charArr[c - 'a']++;
                } else {
                    sb.append(c);
                }
            }

            for (char c : t.toCharArray()) {
                while (--charArr[c - 'a'] > 0) {
                    sb.append(c);
                }
            }

            return sb.toString();
        }

    private static String decodeString(int k, String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(s);
        }

        return sb.toString();
    }

    private static int changeCombos(int amount, int[] denominations) {
        int[] dominationArr = new int[amount + 1];

        dominationArr[0] = 1;

        for (int i : denominations) {

            for (int j = i; j <= amount; j++) {

                int remainder = j - i;

                dominationArr[j] += dominationArr[remainder];

            }
        }

        return dominationArr[amount];
    }

    }

