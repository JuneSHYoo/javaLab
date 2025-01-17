package com.test.hanjin;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tamagotchi {
    private String name;
    private int hunger;
    private int fatigue;
    private int happiness;

    private static final int MAX_LEVEL = 10;
    private static final int MIN_LEVEL = 0;

    // 기본 생성자
    public Tamagotchi(String name) {
        this.name = name;
        this.hunger = 5;
        this.fatigue = 5;
        this.happiness = 5;
    }

    // 다마고치 상태 출력
    public void showStatus() {
        System.out.println("==== " + name + "'s 상태 ====");
        System.out.println("배고픔: " + hunger);
        System.out.println("피로도: " + fatigue);
        System.out.println("행복도: " + happiness);

        printFace();
    }

    // 아스키 아트로 상태 표현
    private void printFace() {
        if (hunger > 7) {
            System.out.println("  (XoX)  <- 배고파요!");
        } else if (happiness < 3) {
            System.out.println("  (-_-)  <- 슬퍼요...");
        } else if (fatigue > 7) {
            System.out.println("  (o_o)  <- 피곤해요...");
        } else {
            System.out.println("  (^_^)  <- 행복해요!");
        }
    }

    // 다마고치 먹이 주기
    public void feed() {
        if (hunger > MIN_LEVEL) {
            hunger--;
            printActionMessage("먹이를 주었습니다.");
        } else {
            printActionMessage("배가 부릅니다.");
        }
    }

    // 다마고치와 놀기
    public void play() {
        if (happiness < MAX_LEVEL) {
            happiness++;
            fatigue++;
            printActionMessage("와 놀았습니다.");
        } else {
            printActionMessage("이미 너무 행복합니다!");
        }
    }

    // 다마고치 잠 재우기
    public void sleep() {
        if (fatigue > MIN_LEVEL) {
            fatigue--;
            printActionMessage("이(가) 잠을 잤습니다.");
        } else {
            printActionMessage("는 충분히 쉬었습니다.");
        }
    }

    // 시간 경과
    public void timePasses() {
        hunger = Math.min(hunger + 1, MAX_LEVEL);
        fatigue = Math.min(fatigue + 1, MAX_LEVEL);
        happiness = Math.max(happiness - 1, MIN_LEVEL);
    }

    // 이름 변경
    public void changeName(String newName) {
        this.name = newName;
        System.out.println("다마고치 이름이 " + newName + "로 변경되었습니다.");
    }

    // 공통 메시지 출력 메서드
    private void printActionMessage(String action) {
        System.out.println(name + action);
    }
}