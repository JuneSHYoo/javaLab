package com.test.hanjin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hanjin {
		
    public void tamagotchiApp(Scanner scanner) {
    	List<Tamagotchi> tamagotchis = new ArrayList<>();
        
        try {
        	while (true) {
                MenuManager.displayMainMenu();
                int choice = InputValidator.getValidMenuChoice(scanner);

                switch (choice) {
                    case 1:
                        MenuManager.createTamagotchi(scanner, tamagotchis);
                        break;
                    case 2:
                        MenuManager.showTamagotchiStatus(scanner, tamagotchis);
                        break;
                    case 3:
                        MenuManager.changeTamagotchiName(scanner, tamagotchis);
                        break;
                    case 4:
                        MenuManager.feedTamagotchi(scanner, tamagotchis);
                        break;
                    case 5:
                        MenuManager.playTamagotchi(scanner, tamagotchis);
                        break;
                    case 6:
                        MenuManager.sleepTamagotchi(scanner, tamagotchis);
                        break;
                    case 7:
                        MenuManager.timePassesTamagotchi(tamagotchis);
                        break;
                    case 8:
                        MenuManager.deleteTamagotchi(scanner, tamagotchis);
                        break;
                    case 9:
                        System.out.println("게임을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 선택입니다.");
                }
            }
        	
        } catch (Exception e) {
           
        	System.out.println("오류가 발생했습니다. 다시 시도해주세요.");
            e.printStackTrace();
        } 
        
    
    }
}