package com.test.minyeong;

import java.util.Scanner;

public class WordChainGame {
    private final Scanner scanner;
    private final WordChainService service;
    private final UsedWordsRepository usedWordsRepository;

    public WordChainGame(Scanner scanner) {
        this.scanner = scanner;
        this.service = new WordChainService();
        this.usedWordsRepository = new UsedWordsRepository();
    }

    public void start() {
        System.out.println("============= 끝말잇기 게임 =============");
        System.out.println("주제를 선택하면 컴퓨터가 먼저 단어를 제시합니다.");
        System.out.println("주제: [사물, 동물, 과일, 직업, 자유]");
        System.out.print("주제를 입력하세요: ");
        String category = scanner.nextLine().trim();

        if (!service.isValidCategory(category)) {
            System.out.println("올바르지 않은 주제입니다. 게임을 종료합니다.");
            return;
        }

        String computerWord = service.initializeGame(category, usedWordsRepository);
        if (computerWord != null) {
            System.out.println("컴퓨터: " + computerWord);
        } else {
            System.out.println("자유 주제입니다. 사용자가 먼저 단어를 입력하세요.");
        }

        while (true) {
            System.out.print("사용자 차례! 단어를 입력하세요: ");
            String userWord = scanner.nextLine().trim();

            if (usedWordsRepository.isUsed(userWord)) {
                System.out.println("이미 사용된 단어입니다. 컴퓨터 승리!");
                break;
            }

            if (!service.isValidWord(userWord)) {
                System.out.println("유효하지 않은 단어입니다. 컴퓨터 승리!");
                break;
            }

            usedWordsRepository.addWord(userWord);
            String computerResponse = service.getComputerResponse(userWord, usedWordsRepository);

            if (computerResponse == null) {
                System.out.println("컴퓨터가 단어를 찾지 못했습니다. 사용자 승리!");
                break;
            }

            System.out.println("컴퓨터: " + computerResponse);
        }
    }

    public void resetGame() {
        usedWordsRepository.clear();
    }
}
