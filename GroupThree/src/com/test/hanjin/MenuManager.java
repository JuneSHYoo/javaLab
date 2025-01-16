package com.test.hanjin;

//MenuManager.java
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {

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

	 /********************************************************************************************/
	 // 새로운 다마고치 키우기
	 public static void createTamagotchi(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
	     String name = InputValidator.getValidName(scanner);
	     
	     tamagotchis.add(new Tamagotchi(name));
	     System.out.println(name + "을(를) 새로 키우기 시작했습니다.");
	 }

	 // 다마고치 상태 보기
	 public static void showTamagotchiStatus(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
	     
		 if (tamagotchis.isEmpty()) {
	         System.out.println("키운 다마고치가 없습니다.");
	         return;
	     }
	
	     System.out.println("다마고치 목록:");
	     for (int i = 0; i < tamagotchis.size(); i++) {
	         System.out.println((i + 1) + ". " + tamagotchis.get(i).getName());
	     }
	
	     int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
	     tamagotchis.get(index).showStatus();
	 }

	 // 다마고치 이름 변경
	 public static void changeTamagotchiName(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
	     
		 if (tamagotchis.isEmpty()) {
	         System.out.println("키운 다마고치가 없습니다.");
	         return;
	     }
	
	     System.out.println("다마고치 목록:");
	     for (int i = 0; i < tamagotchis.size(); i++) {
	         System.out.println((i + 1) + ". " + tamagotchis.get(i).getName());
	     }
	
	     int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
	     String newName = InputValidator.getValidName(scanner);
	     tamagotchis.get(index).changeName(newName);
	 }

	 // 다마고치 삭제
	 public static void deleteTamagotchi(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
	     
		 if (tamagotchis.isEmpty()) {
	         System.out.println("키운 다마고치가 없습니다.");
	         return;
	     }
	
	     System.out.println("다마고치 목록:");
	     for (int i = 0; i < tamagotchis.size(); i++) {
	         System.out.println((i + 1) + ". " + tamagotchis.get(i).getName());
	     }
	
	     int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
	     tamagotchis.remove(index);
	     System.out.println("다마고치가 삭제되었습니다.");
	 }

 	//다마고치 먹이 주기
	public static void feedTamagotchi(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
		 
		if (tamagotchis.isEmpty()) {
	       System.out.println("키운 다마고치가 없습니다.");
	       return;
	    }

	    System.out.println("다마고치 목록:");
	    for (int i = 0; i < tamagotchis.size(); i++) {
	        System.out.println((i + 1) + ". " + tamagotchis.get(i).getName());
	    }

	    int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
	    tamagotchis.get(index).feed(); // 먹이를 주는 기능 실행
	}
	
	//다마고치 놀아 주기
	public static void playTamagotchi(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
		
		if (tamagotchis.isEmpty()) {
		    System.out.println("키운 다마고치가 없습니다.");
		    return;
		}

		System.out.println("다마고치 목록:");
		for (int i = 0; i < tamagotchis.size(); i++) {
		   System.out.println((i + 1) + ". " + tamagotchis.get(i).getName());
		}

		int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
		tamagotchis.get(index).play(); // 놀아 주는 기능 실행
	}
		
	//다마고치 잠 재우기
	public static void sleepTamagotchi(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
		if (tamagotchis.isEmpty()) {
		   System.out.println("키운 다마고치가 없습니다.");
		   return;
		 }

		 System.out.println("다마고치 목록:");
		 for (int i = 0; i < tamagotchis.size(); i++) {
		     System.out.println((i + 1) + ". " + tamagotchis.get(i).getName());
		 }

		 int index = InputValidator.getValidTamagotchiIndex(scanner, tamagotchis.size());
		 tamagotchis.get(index).sleep(); // 잠 재우는 기능 실행
	}
	
	//다마고치 시간 경과
	public static void timePassesTamagotchi(Scanner scanner, ArrayList<Tamagotchi> tamagotchis) {
		
		if (tamagotchis.isEmpty()) {
			 System.out.println("키운 다마고치가 없습니다.");
			  return;
		}

		for (int i = 0; i < tamagotchis.size(); i++) {
			tamagotchis.get(i).timePasses(); // 시간 경과 기능 실행
		}
		System.out.println("시간이 경과했습니다.");
	}
}