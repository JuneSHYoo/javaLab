package com.test.hanjin;

import java.util.Scanner;

public class InputValidator {

    // 유효한 입력값을 받는 일반적인 메서드
    private static int getValidInput(Scanner scanner, String prompt, int minValue, int maxValue) {
        int value = -1;
        
        while (value < minValue || value > maxValue) {
            
        	System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("입력값이 비어있습니다. 다시 입력해주세요.");
                continue;
            }
            
            try {
                value = Integer.parseInt(input);
                
                if (value < minValue || value > maxValue) {
                    System.out.println(minValue + "부터 " + maxValue + "까지의 숫자만 입력할 수 있습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return value;
    }

    // 유효한 메뉴 선택 번호를 받는 메서드
    public static int getValidMenuChoice(Scanner scanner) {
        return getValidInput(scanner, "메뉴를 선택하세요 (1-9): ", 1, 9);
    }

    // 유효한 이름 입력을 받는 메서드
    public static String getValidName(Scanner scanner) {
        
    	String name = "";
       
    	while (name.trim().isEmpty()) {
           
    		System.out.print("새로운 다마고치의 이름을 입력하세요: ");
            name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("이름은 비워둘 수 없습니다. 다시 입력해주세요.");
            }
        }
        return name;
    }

    // 유효한 다마고치 번호 선택을 위한 메서드
    public static int getValidTamagotchiIndex(Scanner scanner, int size) {
        return getValidInput(scanner, "선택할 다마고치의 번호를 입력하세요: ", 1, size) - 1;
    }
}