package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        validateNumberLen(number);
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String num = Integer.toString(i);
            if (isContain369(num)) {
                answer += countClab(num);
            }
        }
        return answer;
    }

    private static boolean isContain369(String num) {
        if (num.contains("3") || num.contains("6") || num.contains("9")) {
            return true;
        }
        return false;
    }

    private static int countClab(String num) {
        String[] arr = num.split("");
        return (int) Arrays.stream(arr).filter(i -> i.equals("3") || i.equals("6") || i.equals("9")).count();
    }

    private static void validateNumberLen(int number) {
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("입력값은 1이상 10,000이하의 자연수를 입력해야합니다.");
        }
    }
}
