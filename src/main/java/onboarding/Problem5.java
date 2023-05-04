package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        validateMoney(money);
        List<Integer> answer = new ArrayList<>();
        final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int m : MONEY_LIST) {
            answer.add(money / m);
            money = money % m;
        }

        return answer;
    }

    private static void validateMoney(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("1 이상 1,000,000 이하인 자연수를 입력해야 합니다.");
        }

    }
}
