package com.test.fiveSun;

import com.test.fiveSun.Service.TeamManageService;
import com.test.fiveSun.domain.Player;
import com.test.fiveSun.domain.Team;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FiveSun {
    //0. 데이터 세팅
    public static final Team kiaTigers;
    private static long sequence = 0L;

    private static final TeamManageService teamManageService = new TeamManageService();

    static {
        //초기값 세팅
        kiaTigers = new Team(
                "KIA 타이거즈",
                LocalDate.of(1982, 1, 30),
                "광주 광역시",
                "광주-기아 챔피언스 필드",
                11,
                "이범호"
        );
        // 선수 정보 추가 (2024 한국시리즈 5차전 라인업 + 기아 레전드)
        kiaTigers.getPlayers().put(sequence++, new Player("곽도규", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("윤영철", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("이준영", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("최지민", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("네일", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("황동하", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("장현식", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("전상현", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("김기훈", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("양현종", "투수", 1, 1, true));
        kiaTigers.getPlayers().put(sequence++, new Player("김도현", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("정해영", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("라우어", "투수", 1, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("김대유", "투수", 1, 0, false));

        kiaTigers.getPlayers().put(sequence++, new Player("한승택", "포수", 2, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("김태군", "포수", 2, 2, true));
        kiaTigers.getPlayers().put(sequence++, new Player("한준수", "포수", 2, 0, false));

        kiaTigers.getPlayers().put(sequence++, new Player("박찬호", "내야수", 3, 6, true));
        kiaTigers.getPlayers().put(sequence++, new Player("김선빈", "내야수", 3, 4, true));
        kiaTigers.getPlayers().put(sequence++, new Player("김도영", "내야수", 3, 5, true));
        kiaTigers.getPlayers().put(sequence++, new Player("김규성", "내야수", 3, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("이우성", "내야수", 3, 3, true));
        kiaTigers.getPlayers().put(sequence++, new Player("변우혁", "내야수", 3, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("서건창", "내야수", 3, 0, false));

        kiaTigers.getPlayers().put(sequence++, new Player("이창진", "외야수", 4, 7, true));
        kiaTigers.getPlayers().put(sequence++, new Player("박정우", "외야수", 4, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("최원준", "외야수", 4, 0, false));
        kiaTigers.getPlayers().put(sequence++, new Player("소크라테스", "외야수", 4, 8, true));
        kiaTigers.getPlayers().put(sequence++, new Player("최형우", "외야수", 4, 10, true));
        kiaTigers.getPlayers().put(sequence++, new Player("나성범(C)", "외야수", 4, 9, true));
    }

    public void printMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("**기아 타이거즈 화면 - 오태양");
        System.out.println("0. 뒤로가기");
        System.out.println("1. 기아 타이거즈 소개");
        System.out.println("2. 선수단 조회");
        System.out.println("3. 라인업 수정");
        System.out.print("메뉴를 선택해주세요: ");
    }

    public void start(Scanner sc) {
        TeamManageService service = new TeamManageService();

        exit: //break label 설정
        while(true) {
            printMenu();

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        teamManageService.printTeamInfo();
                        break;
                    case 2:
                        teamManageService.searchPlayers(sc);
                        break;
                    case 3:
                        teamManageService.updateLineup(sc);
                        break;
                    case 0:
                        break exit;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("입력 값은 숫자여야 합니다.");
                sc.nextLine();
            }
        }

    }


}
