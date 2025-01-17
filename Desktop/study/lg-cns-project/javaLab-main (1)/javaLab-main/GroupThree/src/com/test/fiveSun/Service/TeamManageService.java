package com.test.fiveSun.Service;

import com.test.fiveSun.domain.Player;

import java.util.*;
import java.util.stream.Collectors;

import static com.test.fiveSun.FiveSun.kiaTigers;

public class TeamManageService {


    //1. 기아 타이거즈 팀 소개
    public void printTeamInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("팀 이름: " + kiaTigers.getName());
        System.out.println("창단일: " + kiaTigers.getFoundationDate());
        System.out.println("연고지: " + kiaTigers.getHomeCity());
        System.out.println("홈구장: " + kiaTigers.getHomeStadium());
        System.out.println("우승 횟수: " + kiaTigers.getChampionshipWins());
        System.out.println("감독: " + kiaTigers.getCoach());
    }
    //2. 선수단 조회
    public void printSubMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("0. 뒤로가기");
        System.out.println("1. 선수단 목록 보기");
        System.out.println("2. 선수 검색");
        System.out.println("3. 라인업 보기");
        System.out.print("메뉴를 선택해주세요: ");
    }

    public void searchPlayers(Scanner sc) {
        System.out.println("--------------------------------------------------");
        System.out.println("**기아 타이거즈 선수단 조회 화면입니다.\n원하는 동작을 골라주세요." );

        exit: //break label 설정
        while(true) {
            printSubMenu();

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        listPlayers();
                        break;
                    case 2:
                        searchPlayer(sc);
                        break;
                    case 3:
                        printLineUp();
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

    //2.1. 선수단 목록 보기
    public void listPlayers() {
        System.out.println("--------------------------------------------------");
        System.out.println("**기아 타이거즈 선수단 목록입니다.");
        kiaTigers.getPlayers().values().forEach(System.out::println);
    }

    //2.2. 선수 검색
    public void searchPlayer(Scanner sc) {
        System.out.println("--------------------------------------------------");
        System.out.print("**검색할 선수 이름을 입력하세요: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        List<Player> matchedPlayers = kiaTigers.getPlayers().values().stream()
                .filter(player -> player.getName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
        if (matchedPlayers.isEmpty()) {
            System.out.printf("\"%s\"를 포함하는 선수가 없습니다.\n", keyword);
        } else {
            for (Player matchedPlayer : matchedPlayers) {
                System.out.println(matchedPlayer.toString());
            }
        }
    }
    //2.3 라인업 보기
    private void printLineUp() {
        System.out.println("--------------------------------------------------");
        System.out.println("**기아 타이거즈 선수단 최신 라인업 목록입니다.");

        List<Player> list = kiaTigers.getPlayers().values().stream()
                .filter(Player::isLineUp)
                .sorted(Comparator.comparingInt(Player::getLineUpNum))
                .collect(Collectors.toList());
        for (Player player : list) {
            System.out.println(player.toString());
        }
    }

    //3. 라인업 수정
    public void updateLineup(Scanner sc) {
        exit:
        while(true) {
            System.out.println("--------------------------------------------------");
            System.out.print(
                    "투수: 1\n포수: 2\n1루수: 3\n2루수: 4\n3루수: 5\n유격수: 6\n좌익수: 7\n중견수: 8\n우익수: 9\n지명타자: 10\n취소: 0\n"
                            + "원하시는 변경 위치를 입력해주세요: ");
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch(choice) {
                    case 1:
                        switchPlayer(1, choice, sc);
                        break;
                    case 2:
                        switchPlayer(2, choice, sc);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        switchPlayer(3, choice, sc);
                        break;
                    case 7:
                    case 8:
                    case 9:
                        switchPlayer(4, choice, sc);
                        break;
                    case 10:
                        switchPlayer(null, choice, sc);
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
    public void switchPlayer(Integer positionNum, int lineUpNum, Scanner sc) {
        Player selection = kiaTigers.getPlayers().values().stream()
                .filter(Player::isLineUp)
                .filter(player -> player.getLineUpNum() == lineUpNum)
                .findFirst()
                .orElse(null);

        List<Player> candidates = kiaTigers.getPlayers().values().stream()
                .filter(player -> !player.isLineUp())
                .filter(player -> positionNum == null || player.getPositionNum() == positionNum)
                .collect(Collectors.toList());

        /*현재에 데이터 셋에서는 null이 발생할 수 없습니다. 추후에 해당 케이스까지 고려하여 추가 수정*/
        System.out.println("현재 지정된 선수는 \"" + selection.getName() + "\" 선수 입니다.");
        if (candidates.isEmpty()) {
            System.out.println("현재 변경 가능한 선수가 없습니다.");
        } else {
            System.out.println("변경 가능한 선수의 목록입니다.");
            for (int i = 0; i < candidates.size(); i++) {
                System.out.println(i +". " + candidates.get(i).getName());
            }
            System.out.println();
            System.out.print("원하시는 선수의 번호를 눌러주세요.\n원하지 않다면 -1을 입력하세요.: ");
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice > -1 && choice < candidates.size()) {
                    Player candidate = candidates.get(choice);
                    //주전 -> 후보
                    selection.setLineUpNum(0);
                    selection.setLineUp(false);
                    //후보 -> 주전
                    candidate.setLineUpNum(lineUpNum);
                    candidate.setLineUp(true);
                    System.out.println(selection.getName() + "<->" + candidate.getName() + " 변경이 완료되었습니다.");

                    System.out.print("변경된 라인업을 확인하시려면 \"y\"를 입력하세요.: ");
                    if (sc.nextLine().equals("y")) {
                        printLineUp();

                    }
                } else if(choice == -1) {
                    System.out.println("해당 포지션 수정을 중단합니다.");
                } else {
                    System.out.println("잘못된 값입니다. 확인 후 다시 시도 바랍니다.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("입력 값은 숫자여야 합니다.");
                sc.nextLine();
            }
        }
    }
}
