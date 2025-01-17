package com.test.shy;

package javaPJ;
import java.util.*;

public class Shy {
	 public void printExerciseMenu(Scanner scanner) {
	        ExerciseManager manager = new ExerciseManager();
	        scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n----------------------");
	            System.out.println("유승희 - 운동 기록");
	            System.out.println("----------------------");
	            System.out.println("1. 운동 등록");
	            System.out.println("2. 운동 목록 출력");
	            System.out.println("3. 특정 날짜 운동 요약");
	            System.out.println("4. 운동 수정");
	            System.out.println("5. 운동 삭제");
	            System.out.println("6. 메인으로");
	            System.out.print("메뉴를 선택하세요: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    manager.addExercise(scanner);
	                    break;
	                case 2:
	                    manager.listExercises();
	                    break;
	                case 3:
	                    manager.listExercisesByDate(scanner);
	                    break;
	                case 4:
	                    manager.updateExercise(scanner);
	                    break;
	                case 5:
	                    manager.deleteExercise(scanner);
	                    break;
	                case 6:
	                    System.out.println("메인으로..");
	                    return;
	                default:
	                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
	            }
	        }
	    }

}
