package onboarding;

import java.util.List;

public class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    private static final int SIZE_OF_PAGE = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        try {
            validation(pobi);
            validation(crong);
            int pobiScore = makeScore(pobi);
            int crongScore = makeScore(crong);
            answer = getWinner(pobiScore, crongScore);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return EXCEPTION;
        }
        return answer;
    }

    public static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    public static int makeScore(List<Integer> pages) {

        int leftPage = Math.max(sumCalculate(pages.get(0)), multiplyCalculate(pages.get(0)));
        int rightPage = Math.max(sumCalculate(pages.get(1)), multiplyCalculate(pages.get(1)));

        return Math.max(leftPage, rightPage);
    }

    public static int sumCalculate(int num) {
        int total = 0;

        while (num != 0) {
            total += (num % 10);
            num /= 10;
        }
        return total;
    }

    public static int multiplyCalculate(int num) {
        int total = 1;

        while (num != 0) {
            total *= (num % 10);
            num /= 10;
        }
        return total;
    }

    public static void validation(List<Integer> pages) {
        validatePages(pages);
        validatePagesSize(pages);
        validateFirstOrLastPage(pages);
        validatePagesDiff(pages);
    }

    public static void validatePages(List<Integer> pages) {
        if (pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1) {
            throw new IllegalArgumentException("페이지를 잘못 펼쳤습니다.");
        }
    }

    public static void validatePagesSize(List<Integer> pages) {
        if (pages.size() != SIZE_OF_PAGE) {
            throw new IllegalArgumentException("왼쪽, 오른쪽 2개의 페이지만을 가질 수 있습니다.");
        }
    }

    public static void validatePagesDiff(List<Integer> pages) {
        int diff = pages.get(1) - pages.get(0);
        if (diff != 1) {
            throw new IllegalArgumentException("페이지를 잘못 펼쳤습니다.");
        }
    }

    public static void validateFirstOrLastPage(List<Integer> pages) {
        if (pages.get(0) == FIRST_PAGE || pages.get(1) == LAST_PAGE) {
            throw new IllegalArgumentException("시작 면이나 마지막 면이 나오도록 책을 펼칠 수 없습니다.");
        }
    }
}