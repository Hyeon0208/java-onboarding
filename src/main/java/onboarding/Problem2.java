package onboarding;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        try {
            validate(cryptogram);
            answer = removeDuplicate(cryptogram);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return answer;
    }

    private static String removeDuplicate(String cryptogram) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == cryptogram.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.add(cryptogram.charAt(i));
        }
        stack.forEach(n -> result.append(n));

        return result.toString();
    }

    private static void validate(String cryptogram) {
        validateStringLen(cryptogram);
        validateIsLowerCase(cryptogram);
        validateIsString(cryptogram);
    }

    private static void validateStringLen(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("입력값의 길이가 1 이상 1000 이하여야 합니다.");
        }
    }

    private static void validateIsLowerCase(String cryptogram) {
        for(int i = 0; i < cryptogram.length(); i++){
            if(Character.isUpperCase(cryptogram.charAt(i))) {
                throw new IllegalArgumentException("알파벳은 소문자만 입력할 수 있습니다.");
            }
        }
    }

    private static void validateIsString(String cryptogram) {
        Pattern p = Pattern.compile("^[a-z]*$");
        Matcher m = p.matcher(cryptogram);
        if (!m.matches()) {
            throw new IllegalArgumentException("알파벳 소문자만 입력할 수 있습니다.");
        }
    }
}
