package com.test.hanjin;

import java.util.List;
import java.util.Scanner;

public class MenuManager {

    // 메뉴를 출력하는 메서드
    public static void displayMainMenu() {
        System.out.println("\n==== 메뉴 ====");
        System.out.println("1. 새로운 다마고치 키우기");
        System.out.println("2. 상태 보기");
        System.out.println("3. 이름 변경");
        System.out.println("4. 먹이 주기");
        System.out.println("5. 놀아주기");
        System.out.println("6. 잠 재우기");
        System.out.println("7. 시간 경과"); 
        System.out.println("8. 다마고치 삭제");
        System.out.println("9. 종료");
    }

    // 다마고치 목록을 출력하는 메서드
    private static void displayTamagotchiList(List<Tamagotchi> tamagotchis) {
    	
        if (tamagotchis == null || tamagotchis.isEmpty()) {
            System.out.println("키운 다마고치가 없습니다.");
            return;
        
        } else {
        	
        	System.out.println("다마고치 목록:");
            tamagotchis.stream()
                    .map(t -> tamagotchis.indexOf(t) + 1 + ". " + t.getName()) // 각 다마고치의 번호와 이름을 포맷팅
                    .forEach(System.out::println); // 각 항목을 출력
        }
        
    }

    /********************************************************************************************/
    // 새로운 다마고치 키우기
    public static void createTamagotchi(Scanner scanner, List<Tamagotchi> tamagotchis) {
       
    	String name = InputValidator.getValidName(scanner);
        tamagotchis.add(new Tamagotchi(name));
        System.out.println(name + "을(를) 새로 키우기 시작했습니다.");
    }

    // 다마고치 상태 보기
    public static void showTamagotchiStatus(Scanner scanner, List<Tamagotchi> tamagotchis) {
       
    	displayTamagotchiList(tamagotchis); // 다마고치 목록 출력
        
    	if (!tamagotchis.isEmpty()) {
            
    		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
            tamagotchis.get(index).showStatus();
        }
    }

    // 다마고치 이름 변경
    public static void changeTamagotchiName(Scanner scanner, List<Tamagotchi> tamagotchis) {
        
    	displayTamagotchiList(tamagotchis); // 다마고치 목록 출력
        
    	if (!tamagotchis.isEmpty()) {
            
    		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
            String newName = InputValidator.getValidName(scanner);
            tamagotchis.get(index).changeName(newName);
        }
    }

    // 다마고치 삭제
    public static void deleteTamagotchi(Scanner scanner, List<Tamagotchi> tamagotchis) {
        
    	displayTamagotchiList(tamagotchis); // 다마고치 목록 출력
        
    	if (!tamagotchis.isEmpty()) {
            
    		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
            tamagotchis.remove(index);
            System.out.println("다마고치가 삭제되었습니다.");
        }
    }

    // 다마고치 먹이 주기
    public static void feedTamagotchi(Scanner scanner, List<Tamagotchi> tamagotchis) {
        
    	displayTamagotchiList(tamagotchis); // 다마고치 목록 출력
        
    	if (!tamagotchis.isEmpty()) {
            
    		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
            tamagotchis.get(index).feed(); // 먹이를 주는 기능 실행
        }
    }

    // 다마고치 놀아 주기
    public static void playTamagotchi(Scanner scanner, List<Tamagotchi> tamagotchis) {
        
    	displayTamagotchiList(tamagotchis); // 다마고치 목록 출력
        
    	if (!tamagotchis.isEmpty()) {
           
    		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
            tamagotchis.get(index).play(); // 놀아 주는 기능 실행
        }
    }

    // 다마고치 잠 재우기
    public static void sleepTamagotchi(Scanner scanner, List<Tamagotchi> tamagotchis) {
        
    	displayTamagotchiList(tamagotchis); // 다마고치 목록 출력
        
    	if (!tamagotchis.isEmpty()) {
            
    		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
            tamagotchis.get(index).sleep(); // 잠 재우는 기능 실행
        }
    }

    // 다마고치 시간 경과
    public static void timePassesTamagotchi(List<Tamagotchi> tamagotchis) {
        
    	if (tamagotchis == null || tamagotchis.isEmpty()) {
           
    		System.out.println("키운 다마고치가 없습니다.");
            return;
        }

        // 시간 경과
        tamagotchis.forEach(Tamagotchi::timePasses);
        System.out.println("시간이 경과했습니다.");
    }
}