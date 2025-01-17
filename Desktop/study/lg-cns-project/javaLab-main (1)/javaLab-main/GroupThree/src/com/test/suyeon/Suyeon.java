package com.test.suyeon;

import java.util.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class Diary {
    private Long id;
    private String title;
    private int weather;
    private int mood;
    private String contents;

    // Weather와 Mood 이모지 매핑
    private static final Map<Integer, String> WEATHER_EMOJIS = Map.of(
            1, "☀️",
            2, "🌥️",
            3, "️️",
            4, "☔️",
            5, "☃️"
    );

    private static final Map<Integer, String> MOOD_EMOJIS = Map.of(
            1, "😡",
            2, "😭",
            3, "🧐",
            4, "😊",
            5, "😍"
    );

    // 이모지 반환 메서드
    public String getWeatherEmoji() {
        return WEATHER_EMOJIS.getOrDefault(weather, "❓");
    }

    public String getMoodEmoji() {
        return MOOD_EMOJIS.getOrDefault(mood, "❓");
    }

    // 특정 weather와 mood에 대한 이모지 반환
    public static String getWeatherEmojiByValue(int weather) {
        return WEATHER_EMOJIS.getOrDefault(weather, "❓");
    }

    public static String getMoodEmojiByValue(int mood) {
        return MOOD_EMOJIS.getOrDefault(mood, "❓");
    }

    @Override
    public String toString() {
        return String.format(
                "===========================\n" +
                        "📓 %d번째 일기\n" +
                        "📝 제목: %s\n" +
                        "🌤️ 날씨: %s\n" +
                        "😊 기분: %s\n" +
                        "🖋️ 내용: %s\n" +
                        "===========================",
                id, title, getWeatherEmoji(), getMoodEmoji(), contents
        );
    }
}

class DiaryManagement {
    // 일기 정보
    private final List<Diary> diaries = new ArrayList<>();

    // 조회수 => ID, 조회수 정보를 관리
    private final Map<Long, Integer> diaryViews = new HashMap<>();

    private long nextId = 1;

    // 도서 등록
    public void addDiary(Scanner scanner) {
        Long id = nextId++;

        System.out.print("제목을 알려주세요 ✨ ");
        String title = scanner.nextLine();

        int weather = 0;
        while (true) {
            try {
                System.out.print("오늘 날씨는 어땠나요? 1 ~ 5 중에서 입력해주세요! (1: ☀️, 2: 🌥️, 3: ️️, 4: ☔️, 5: ☃️) ");
                weather = Integer.parseInt(scanner.nextLine().trim());
                if (weather < 1 || weather > 5) {
                    throw new IllegalArgumentException("1부터 5 사이의 숫자를 입력해주세요.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int mood = 0;
        while (true) {
            try {
                System.out.print("오늘의 기분을 1 ~ 5 중에서 입력해주세요! (1: 😡, 2: 😭, 3: 🧐, 4: 😊, 5: 😍) ");
                mood = Integer.parseInt(scanner.nextLine().trim());
                if (mood < 1 || mood > 5) {
                    throw new IllegalArgumentException("1부터 5 사이의 숫자를 입력해주세요.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("내용을 채워주세요 🍀 ");
        String contents = scanner.nextLine();

        Diary diary = new Diary(id, title, weather, mood, contents);
        diaries.add(diary);
        diaryViews.put(diary.getId(), 0);
        System.out.println("\n\n\n오늘의 일기 ʕ•ᴥ•ʔ\n" + diary);
    }

    // 전체 일기 목록 조회
    public void listDiaries() {
        if (diaries.isEmpty()) {
            System.out.println("\n등록된 일기가 없습니다.");
            return;
        }

        diaries.forEach(System.out::println);
    }

    // 일기 검색 => 일기 제목과 내용에 keyword가 포함되어 있는지 검색
    public void searchDiaries(Scanner scanner) {
        System.out.print("제목이나 내용을 입력하세요: ");
        String keyword = scanner.nextLine();
        keyword = keyword.trim().toLowerCase();

        boolean found = false;
        for (Diary diary : diaries) {
            if (diary.getTitle().trim().toLowerCase().contains(keyword) ||
                    diary.getContents().trim().toLowerCase().contains(keyword)) {
                System.out.println(diary);
                diaryViews.put(diary.getId(), diaryViews.get(diary.getId()) + 1);
                found = true;
            }
        }

        if (!found) {
            System.out.printf("\n%s을(를) 포함하는 일기가 없습니다.\n", keyword);
        }
    }

    // weather로 일기 검색
    public void searchDiariesByWeather(Scanner scanner) {
        int weather = 0;

        // 잘못된 입력에 대한 반복 처리
        while (true) {
            try {
                System.out.print("검색할 날씨를 1 ~ 5 중에서 입력해주세요! (1: ☀️, 2: 🌥️, 3: ️️, 4: ☔️, 5: ☃️) ");
                weather = Integer.parseInt(scanner.nextLine().trim());
                if (weather < 1 || weather > 5) {
                    throw new IllegalArgumentException("1부터 5 사이의 숫자를 입력해주세요.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // weather 값에 해당하는 이모지 가져오기
        String weatherEmoji = Diary.getWeatherEmojiByValue(weather);

        // weather 값 필터링
        int finalWeather = weather;
        List<Diary> filteredDiaries = diaries.stream()
                .filter(diary -> diary.getWeather() == finalWeather)
                .collect(Collectors.toList());

        if (filteredDiaries.isEmpty()) {
            System.out.printf("\n%s 날씨에 해당하는 일기가 없습니다.\n", weatherEmoji);
            return;
        }

        System.out.printf("\n%s 날씨에 해당하는 일기 목록입니다 ⭐️📎\n", weatherEmoji);
        filteredDiaries.forEach(System.out::println);
    }

    // mood로 일기 검색
    public void searchDiariesByMood(Scanner scanner) {
        int mood = 0;

        // 잘못된 입력에 대한 반복 처리
        while (true) {
            try {
                System.out.print("검색할 기분을 1 ~ 5 중에서 입력해주세요! (1: 😡, 2: 😭, 3: 🧐, 4: 😊, 5: 😍) ");
                mood = Integer.parseInt(scanner.nextLine().trim());
                if (mood < 1 || mood > 5) {
                    throw new IllegalArgumentException("1부터 5 사이의 숫자를 입력해주세요.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // mood 값에 해당하는 이모지 가져오기
        String moodEmoji = Diary.getMoodEmojiByValue(mood);

        // mood 값 필터링
        int finalMood = mood;
        List<Diary> filteredDiaries = diaries.stream()
                        .filter(diary -> diary.getMood() == finalMood)
                        .collect(Collectors.toList());

        if (filteredDiaries.isEmpty()) {
            System.out.printf("\n%s 기분에 해당하는 일기가 없습니다.\n", moodEmoji);
            return;
        }

        System.out.printf("\n%s 기분에 해당하는 일기 목록입니다 ⭐️📎\n", moodEmoji);
        filteredDiaries.forEach(System.out::println);
    }

    // 일기 삭제
    public void deleteDiary(Scanner scanner) {
        System.out.print("\n삭제할 일기의 번호를 입력하세요: ");
        Long id = Long.valueOf(scanner.nextLine());

        Iterator<Diary> iterator = diaries.iterator();
        while (iterator.hasNext()) {
            Diary diary = iterator.next();
            if (diary.getId().equals(id)) {
                iterator.remove();
                diaryViews.remove(id);
                System.out.printf("\n%s번째 일기를 삭제했습니다.\n", id);
                return;
            }
        }

        System.out.printf("\n%s번째 일기를 찾을 수 없습니다.\n", id);
    }

    // 조회수가 높은 일기 조회
    public void mostViewedDiaries() {
        if (diaryViews.isEmpty()) {
            System.out.println("\n등록된 일기가 없습니다.");
            return;
        }

        // 조회수가 가장 높은 값 구하기
        int maxViews = diaryViews.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        if (maxViews == 0) {
            System.out.println("\n조회수가 높은 일기가 없습니다.");
            return;
        }

        // 조회수가 가장 높은 일기를 필터링
        System.out.println("\n조회수가 가장 높은 일기 목록입니다 🩷️📎\n");
        diaries.stream()
                .filter(diary -> diaryViews.get(diary.getId()) == maxViews)
                .forEach(System.out::println);
    }


}


public class Suyeon {

    public void printMenu() {
        System.out.println("\n🩷🔑♥*♡+:｡.｡.｡:+♡*♥ My Diary ♥*♡+:｡.｡.｡:+♡*♥📎📔\n");
        System.out.println("1. 일기를 작성해 보아요 ✏️");
        System.out.println("2. 모든 일기를 보고싶다면 👀");
        System.out.println("3. 제목과 내용으로 검색해 보아요 📝🔎");
        System.out.println("4. 날씨로 검색해 보아요 🌈🔎");
        System.out.println("5. 기분으로 검색해 보아요 😃🔎");
        System.out.println("6. 지우고 싶은 일기가 있어요 🗑️");
        System.out.println("7. 어떤 일기를 가장 많이 봤을까? 🧐❓");
        System.out.println("8. 일기장 오늘은 이만 덮을게요. 다음에 또 봐요 !! 👋🌌");
        System.out.print("\n원하시는 메뉴를 숫자로 입력해 주세요 🪄✨ ");
    }

    public void diaryApp(Scanner scanner) {
        DiaryManagement bookcase = new DiaryManagement();

        while(true) {
            printMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch(choice) {
                case 1:
                    bookcase.addDiary(scanner);
                    break;
                case 2:
                    bookcase.listDiaries();
                    break;
                case 3:
                    bookcase.searchDiaries(scanner);
                    break;
                case 4:
                    bookcase.searchDiariesByWeather(scanner);
                    break;
                case 5:
                    bookcase.searchDiariesByMood(scanner);
                    break;
                case 6:
                    bookcase.deleteDiary(scanner);
                    break;
                case 7:
                    bookcase.mostViewedDiaries();
                    break;
                case 8:
                    System.out.println("\n\n\nGood Bye ｡.. 💌 .°⑅ପ₍ᐢ｡•༝•｡ᐢ₎ଓ⑅°.");
                    return;
                default:
                    System.out.println("\n\n\n1 ~ 8 중에서 입력해주세요! .°⑅ପ₍ᐢ｡•༝•｡ᐢ₎ଓ⑅°.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n\n\n숫자를 입력해주세요! .°⑅ପ₍ᐢ｡•༝•｡ᐢ₎ଓ⑅°.");
            }
        }
    }
}






