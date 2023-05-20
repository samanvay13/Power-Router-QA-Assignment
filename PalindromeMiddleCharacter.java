import java.util.*;

public class PalindromeMiddleCharacter {

    public static String rearrangeIntoPalindrome(String string) {

        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : string.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        StringBuilder palindrome = new StringBuilder();
        Character oddChar = null;

        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            Character c = entry.getKey();
            int frequency = entry.getValue();
            if (frequency % 2 == 1) {

                if (oddChar != null) {
                    return null;
                }
                oddChar = c;
            }
            for (int i = 0; i < frequency / 2; i++) {
                palindrome.append(c);
                palindrome.insert(0, c);
            }
        }

        if (oddChar != null) {
            palindrome.insert(palindrome.length() / 2, oddChar);
        }
        return palindrome.toString();
    }

    public static String findMiddleCharacter(String string) {
        
        int length = string.length();
        int middleIndex = length / 2;

        if (length % 2 == 0) {
            return string.substring(middleIndex - 1, middleIndex + 1);
        } else {
            return string.substring(middleIndex, middleIndex + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] strings = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        scanner.close();

        for (String string : strings) {
            String palindrome = rearrangeIntoPalindrome(string);
            if (palindrome == null) {
                System.out.println(string + " cannot be rearranged into a palindrome");
            } else {
                System.out.println("Palindrome: " + palindrome);
                System.out.println("Middle character(s): " + findMiddleCharacter(palindrome));
            }
        }
    }
}
