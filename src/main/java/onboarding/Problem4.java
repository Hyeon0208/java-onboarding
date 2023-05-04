package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            answer.append(convertReverse(ch));
        }
        return answer.toString();
    }

    private static char convertReverse(char ch) {
        if (ch == ' ') {
            return ch;
        }
        if (Character.isLowerCase(ch)) {
            return (char)('z' - (ch - 'a'));
        }
        if (Character.isUpperCase(ch)) {
            return (char)('Z' - (ch - 'A'));
        }
        return ch;
    }
}
