package com.test.minyeong;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class WordChainService {
    private static final Map<String, List<String>> predefinedWords = new HashMap<>();
    private static final String API_URL = "https://opendict.korean.go.kr/api/search";
    private static final String API_KEY = "8EEF220FACB9F1BC8DE50032A752AE8E";
    private String lastCharacter;

    static {
        predefinedWords.put("과일", Arrays.asList("사과", "바나나", "포도", "딸기", "자두"));
        predefinedWords.put("동물", Arrays.asList("고양이", "강아지", "토끼", "코끼리", "사자"));
        predefinedWords.put("사물", Arrays.asList("책상", "의자", "스피커", "볼펜", "노트"));
        predefinedWords.put("직업", Arrays.asList("의사", "선생님", "프로그래머", "디자이너", "경찰관"));
        predefinedWords.put("자유", Collections.emptyList());
    }

    public boolean isValidCategory(String category) {
        return predefinedWords.containsKey(category);
    }

    public String initializeGame(String category, UsedWordsRepository usedWordsRepository) {
        if (!category.equals("자유")) {
            String word = getRandomWord(predefinedWords.get(category));
            usedWordsRepository.addWord(word);
            lastCharacter = getLastCharacter(word);
            return word;
        }
        return null;
    }

    public boolean isValidWord(String word) {
        return word.length() >= 2 && (lastCharacter == null || word.startsWith(lastCharacter)) && checkWordInDictionary(word);
    }

    public String getComputerResponse(String userWord, UsedWordsRepository usedWordsRepository) {
        lastCharacter = getLastCharacter(userWord);
        List<String> validWords = findWordsFromApi(lastCharacter);

        for (String word : validWords) {
            if (!usedWordsRepository.isUsed(word)) {
                usedWordsRepository.addWord(word);
                return word;
            }
        }
        return null;
    }

    private List<String> findWordsFromApi(String lastChar) {
        List<String> words = new ArrayList<>();
        try {
            for (int start = 1; start <= 1000; start += 100) {
                URL url = new URL(API_URL + "?key=" + API_KEY + "&req_type=json&q=" + lastChar + "&start=" + start + "&sort=dict");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }

                        JSONObject json = new JSONObject(response.toString());
                        if (json.has("channel") && json.getJSONObject("channel").has("item")) {
                            JSONArray items = json.getJSONObject("channel").getJSONArray("item");
                            for (int i = 0; i < items.length(); i++) {
                                String word = items.getJSONObject(i).getString("word").replaceAll("-", "");
                                words.add(word);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[DEBUG] API 호출 중 오류 발생: " + e.getMessage());
        }
        return words;
    }

    private boolean checkWordInDictionary(String word) {
        try {
            URL url = new URL(API_URL + "?key=" + API_KEY + "&req_type=json&q=" + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    JSONObject json = new JSONObject(response.toString());
                    if (json.has("channel") && json.getJSONObject("channel").has("item")) {
                        JSONArray items = json.getJSONObject("channel").getJSONArray("item");
                        for (int i = 0; i < items.length(); i++) {
                            if (items.getJSONObject(i).getString("word").replaceAll("-", "").equals(word)) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[DEBUG] API 호출 중 오류 발생: " + e.getMessage());
        }
        return false;
    }

    private String getRandomWord(List<String> words) {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    private String getLastCharacter(String word) {
        return word.substring(word.length() - 1);
    }
}
