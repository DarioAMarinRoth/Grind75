package firstweek;
public class Palindrome {
    public boolean isPalindrome(String s) {

        String regex = "[^a-z0-9]";
        s = s.toLowerCase().replaceAll(regex, "");
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;

    }
}
