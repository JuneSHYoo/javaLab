package com.test.hanjin;

//InputValidator.java
import java.util.Scanner;

public class InputValidator {

 // 유효한 메뉴 선택 번호를 받는 메서드
 public static int getValidMenuChoice(Scanner scanner) {
     int choice = -1;
     
     while (choice < 1 || choice > 9) {
         System.out.print("메뉴를 선택하세요 (1-9): ");
         String input = scanner.nextLine().trim(); // 입력값을 받아오고 공백 제거
         
         if (input.isEmpty()) {
             System.out.println("입력값이 비어있습니다. 숫자를 입력해주세요.");
             continue;
         }

         try {
             choice = Integer.parseInt(input);
             
             if (choice < 1 || choice > 9) {
                 System.out.println("1부터 9까지의 숫자만 입력할 수 있습니다.");
             }
         
         } catch (NumberFormatException e) {
             System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
         }
     }
     return choice;
 }

 // 유효한 이름 입력을 받는 메서드
 public static String getValidName(Scanner scanner) {
     String name = "";
     
     while (name.trim().isEmpty()) {
         System.out.print("새로운 다마고치의 이름을 입력하세요: ");
         name = scanner.nextLine();
         
         if (name.trim().isEmpty()) {
             System.out.println("이름은 비워둘 수 없습니다. 다시 입력해주세요.");
         }
     }
     return name;
 }

 // 유효한 다마고치 번호 선택을 위한 메서드
 public static int getValidTamagotchiIndex(Scanner scanner, int size) {
     int index = -1;
    
     while (index < 0 || index >= size) {
         
    	 try {
             System.out.print("선택할 다마고치의 번호를 입력하세요: ");
             String input = scanner.nextLine().trim();
             
             if (input.isEmpty()) {
                 System.out.println("번호를 입력해주세요.");
                 continue;
             }
             
             index = Integer.parseInt(input) - 1; // 1부터 시작하는 번호를 0 기반으로 변경
             
             if (index < 0 || index >= size) {
                 System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
             }
         
    	 } catch (NumberFormatException e) {
             System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
         }
     }
     return index;
 }
}