package com.test.hanjin;

//Tamagotchi.java
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tamagotchi {
 private String name;
 private int hunger;
 private int fatigue;
 private int happiness;

 // 생성자
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
     
	 if (hunger > 0) {
         hunger--;
         
         System.out.println(name + "에게 먹이를 주었습니다.");
     
	 } else {
         
		 System.out.println(name + "는 배가 부릅니다.");
     }
 }

 // 다마고치와 놀기
 public void play() {
    
	 if (happiness < 10) {
         happiness++;
         fatigue++;
         
         System.out.println(name + "와 놀았습니다.");
     } else {
         System.out.println(name + "는 이미 너무 행복합니다!");
     }
 }

 // 다마고치 잠 재우기
 public void sleep() {
    
	 if (fatigue > 0) {
         fatigue--;
         
         System.out.println(name + "이(가) 잠을 잤습니다.");
     } else {
        
    	 System.out.println(name + "는 충분히 쉬었습니다.");
     }
 }
 
//시간 경과
 public void timePasses() {
     
	 hunger++;
     fatigue++;
     
     if (happiness > 0) happiness--;
 }

 // 이름 변경
 public void changeName(String newName) {
     
	 this.name = newName;
     System.out.println("다마고치 이름이 " + newName + "로 변경되었습니다.");
 }

}