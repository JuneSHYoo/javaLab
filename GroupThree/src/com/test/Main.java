package com.test;
import java.util.Scanner;

import com.test.dabin.Dabin;
import com.test.dain.Dain;
import com.test.fiveSun.FiveSun;
import com.test.hanjin.Hanjin;
import com.test.hyungSuh.HyungSuh;
import com.test.minyeong.Minyeong;
import com.test.sangHoon.SangHoon;
import com.test.shy.Shy;
import com.test.suyeon.Suyeon;
import com.test.yebin.Yebin;
import com.test.yeongSeo.YeongSeo;

public class Main {
	
	public static void printMenu() {
		System.out.println("\n(3조) 구성원 선택: ");
		System.out.println("1. 신예빈 - 2048");
		System.out.println("2. 심수연 - Diary");
		System.out.println("3. 양한진 - Tamagotchi");
		System.out.println("4. 오태양 - 최강기아 타이거즈");
		System.out.println("5. 오형서 - Convenience");
		System.out.println("6. 유승희 - GymLog");
		System.out.println("7. 유영서 - Cosmetic");
		System.out.println("8. 윤다인 - ");
		System.out.println("9. 이다빈 - Baseball");
		System.out.println("10. 이상훈 - Movie");
		System.out.println("11. 현민영 - ");
		System.out.println("12. 종료");
		System.out.println("=======================> 숫자를 입력해주세요 : ");
	}

	public static void main(String[] args) {

		Yebin yebin = new Yebin	(); //2048
		Suyeon suyeon = new Suyeon(); //Diary
		Hanjin hanjin = new Hanjin(); //다마고치
		FiveSun fiveSun = new FiveSun(); //축구팀
		HyungSuh hyungSuh = new HyungSuh(); //Convenience
		Shy shy = new Shy(); //GymLog
		YeongSeo  yeongSeo = new YeongSeo(); //Cosmetic 
		Dain dain = new Dain();
		Dabin dabin = new Dabin(); //Baseball
		SangHoon sangHoon = new SangHoon(); //Movie
		Minyeong minyeong = new Minyeong();
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		try {
			while(true) {
				printMenu();
				choice = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice) {
				case 1:
					//yebin.mostViewedBooks(scanner);
					break;
				case 2:
					suyeon.diaryApp(scanner);				
					break;
				case 3:
					hanjin.tamagotchiApp(scanner);
					break;
				case 4:
					//fiveSun.mostViewedBooks(scanner);
					break;
				case 5:
					hyungSuh.start(scanner);
					break;
				case 6:
					//shy.mostViewedBooks(scanner);
					break;
				case 7:
					//yeongSeo.mostViewedBooks(scanner);
					break;
				case 8:
					//dain.mostViewedBooks(scanner);
					break;
				case 9:
					//dabin.mostViewedBooks(scanner);
					break;
				case 10:
					//sangHoon.mostViewedBooks(scanner);
					break;
				case 11:
					//minyeong.mostViewedBooks(scanner);
					break;
				case 12:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					
				}
				
				
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			scanner.close();
		}
		
	}

}
