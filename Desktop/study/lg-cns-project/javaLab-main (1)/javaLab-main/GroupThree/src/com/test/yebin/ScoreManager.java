package com.test.yebin;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreManager {
    private List<Score> scores = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addScore(Score score) {
        scores.add(score);
    }

    public void getUserScores(String username) {
        List<Score> filteredScores = scores.stream()
                .filter(score -> score.getName().equals(username))
                .sorted(Comparator.comparingInt(Score::getScore).reversed())
                .collect(Collectors.toList());

        if (filteredScores.isEmpty()) {
            System.out.println(username + "의 기록을 찾을 수 없습니다.");
        }
        else {
            System.out.println(username + "의 기록");
            for (int i = 0; i < filteredScores.size(); i++) {
                System.out.println((i + 1) + ". " + filteredScores.get(i).getScore());
            }
        }
    }

    public int getUserHighScore(String username) {
        Optional<Score> topScore = scores.stream()
                .filter(score -> score.getName().equals(username))
                .max(Comparator.comparingInt(Score::getScore));
        return topScore.map(Score::getScore).orElse(-1);
    }

    public void getRank() {
        List<Score> filteredScores = scores.stream()
                .sorted(Comparator.comparingInt(Score::getScore).reversed())
                .collect(Collectors.toList());

        if (filteredScores.isEmpty()) {
            System.out.println("기록을 찾을 수 없습니다.");
        }
        else {
            System.out.println("Ranking");
            for (int i = 0; i < Math.min(filteredScores.size(), 10); i++) {
                System.out.println((i + 1) + ". " + filteredScores.get(i).getName() + " " + filteredScores.get(i).getScore());
            }
        }
    }

    public void deleteScore(String username) {
        List<Score> filteredScores = scores.stream()
                .filter(score -> score.getName().equals(username))
                .sorted(Comparator.comparingInt(Score::getScore).reversed())
                .collect(Collectors.toList());

        if (filteredScores.isEmpty()) {
            System.out.println(username + "의 기록을 찾을 수 없습니다.");
        }
        else {
            System.out.println(username + "의 기록");
            for (int i = 0; i < filteredScores.size(); i++) {
                System.out.println((i + 1) + ". " + filteredScores.get(i).getScore());
            }
            System.out.println("삭제할 기록의 번호를 입력하세요: ");
            int index = scanner.nextInt();
            int deleteScore = filteredScores.get(index-1).getScore();

            Iterator<Score> iterator = scores.iterator();
            while (iterator.hasNext()) {
                Score score = iterator.next();
                if (score.getName().equals(username) && score.getScore() == deleteScore) {
                    iterator.remove();
                    System.out.println("삭제했습니다.");
                    return;
                }
            }
            System.out.println("잘못 입력했습니다.");
        }
    }

    public void deleteUser(String username) {
        boolean isDeleted = false;

        Iterator<Score> iterator = scores.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            if (score.getName().equals(username)) {
                iterator.remove();
                isDeleted = true;
            }
        }
        if (isDeleted) {
            System.out.println(username + " 기록을 삭제했습니다.");
        }
        else {
            System.out.println(username + " 기록이 없습니다.");
        }
    }
}
