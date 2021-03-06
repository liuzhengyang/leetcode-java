package bfs.getwatchedvideosbyfriends;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liuzhengyang
 * Created on 2020-07-14
 */
public class GetWatchedVideosByFriends {
    public static void main(String[] args) {

    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        if (friends == null || friends.length == 0) {
            return Collections.emptyList();
        }
        Set<Integer> friendIdsOfLevel = getFriendsOfLevel(friends, id, level);
        if (friendIdsOfLevel.isEmpty()) {
            return Collections.emptyList();
        }
        Map<String, VideoAndCount> videoAndCountMap = new HashMap<>();
        friendIdsOfLevel.forEach(friend -> {
            List<String> videos = watchedVideos.get(friend);
            for (String video : videos) {
                videoAndCountMap.computeIfAbsent(video, v -> new VideoAndCount(v, 0))
                        .increment();
            }
        });
        List<VideoAndCount> collect = videoAndCountMap.values()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.count == o2.count) {
                        return o1.name.compareTo(o2.name);
                    }
                    return Integer.compare(o1.count, o2.count);
                }).collect(Collectors.toList());
        return collect.stream().map(v -> v.name).collect(Collectors.toList());
    }

    static class VideoAndCount {
        String name;
        int count;

        public VideoAndCount(String name, int count) {
            this.name = name;
            this.count = count;
        }

        void increment() {
            count++;
        }

        @Override
        public String toString() {
            return "VideoAndCount{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    private Set<Integer> getFriendsOfLevel(int[][] friends, int id, int level) {
        boolean[] visited = new boolean[friends.length];
        int levelCount = 0;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        prev.add(id);
        while (!prev.isEmpty()) {
            for (int index : prev) {
                visited[index] = true;
            }
            for (int index : prev) {
                int[] friendsOfIndex = friends[index];
                for (int friendIndex : friendsOfIndex) {
                    if (!visited[friendIndex]) {
                        next.add(friendIndex);
                    }
                }
            }
            if (++levelCount == level) {
                return next;
            } else {
                prev = next;
                next = new HashSet<>();
            }
        }
        return Collections.emptySet();
    }
}
