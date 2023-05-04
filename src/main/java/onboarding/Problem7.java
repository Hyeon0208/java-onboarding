package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendScore = getFriendLists(friends, visitors);
        Set<String> userFriend = getUserFriends(user, friends);
        List<String> togetherFriend = getTogetherFriend(user, friends, userFriend);

        countVisiter(friendScore, visitors);
        countFriendsTogether(friendScore, togetherFriend);
        deleteFriendScore(friendScore, userFriend, user);

        List<String> answer = new ArrayList<>(friendScore.keySet());
        Collections.sort(answer);
        Collections.sort(answer, (v1, v2) -> (friendScore.get(v2).compareTo(friendScore.get(v1))));

        return answer;
    }

    private static void deleteFriendScore(Map<String, Integer> friendScore, Set<String> userFriend, String user) {
        for (String uf : userFriend) {
            friendScore.remove(uf);
        }
        friendScore.remove(user);
    }

    private static List<String> getTogetherFriend(String user, List<List<String>> friends, Set<String> userFriend) {
        List<String> togetherFriend = new ArrayList<>();
        for (List<String> friend : friends) {
            for (String together : userFriend) {
                if (!friend.contains(user) && isFriend(friend, together)) {
                    togetherFriend.add(friend.get(1));
                }
            }
        }
        return togetherFriend;
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriend = new HashSet<>();
        for (List<String> friend : friends) {
            if (isFriend(friend, user)) {
                userFriend.add(friend.get(0));
            }
        }
        return userFriend;
    }

    private static void countFriendsTogether(Map<String, Integer> friendScore, List<String> togetherFriend) {
        for (String together : togetherFriend) {
            friendScore.put(together, friendScore.getOrDefault(together, 0) + 10);
        }
    }

    private static boolean isFriend(List<String> friend, String user) {
        if (friend.contains(user)) {
            return true;
        }
        return false;
    }

    private static void countVisiter(Map<String, Integer> map, List<String> visitors) {
        for (String visitor : visitors) {
            map.put(visitor, map.getOrDefault(visitor, 0) + 1);
        }
    }

    private static Map<String, Integer> getFriendLists(List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();

        for (List<String> friend : friends) {
            map.put(friend.get(0), 0);
            map.put(friend.get(1), 0);
        }

        for (String visitor : visitors) {
            map.put(visitor, 0);
        }
        return map;
    }
}
