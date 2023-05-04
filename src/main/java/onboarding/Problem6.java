package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        validate(forms);
        Set<String> answer = new HashSet<>();
        Map<String, Integer> map = getDuplicateName(forms);

        System.out.println(map);
        for (String subName : map.keySet()) {
            if (map.get(subName) > 1) {
                findUserEmail(forms, answer, subName);
            }
        }

        return answer.stream().sorted().collect(Collectors.toList());
    }

    private static void findUserEmail(List<List<String>> forms, Set<String> answer, String subName) {
        for (List<String> form : forms) {
            String name = form.get(1);
            String email = form.get(0);
            if (name.contains(subName)) {
                answer.add(email);
            }
        }
    }

    private static Map<String, Integer> getDuplicateName(List<List<String>> forms) {
        Map<String, Integer> map = new HashMap<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String subName = name.substring(i, i + 2);
                map.put(subName, map.getOrDefault(subName, 0) + 1);
            }
        }
        return map;
    }

    private static void validate(List<List<String>> forms) {
        validateFormsSize(forms);
        validateEmail(forms);
        validateDomainOfEmail(forms);
    }

    private static void validateFormsSize(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하여야 합니다.");
        }
    }

    private static void validateEmail(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            if (email.length() < 11 || email.length() > 19) {
                throw new IllegalArgumentException("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
            }
        }
    }

    private static void validateDomainOfEmail(List<List<String>> forms) {
        for (List<String> form : forms) {
            String[] email = form.get(0).split("@");
            if (!email[1].equals("email.com")) {
                throw new IllegalArgumentException("이메일의 도메인은 email.com 만 가능합니다.");
            }
        }
    }
}

