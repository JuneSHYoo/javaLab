package com.test.dabin;

public class Dabin {
    public static void printMenu() {
        System.out.println("\n ⚾️🏟️선수 관리 프로그램 🏟️⚾️ ");
        System.out.println("\n현재 선수 목록에는 LG트윈스 일부 선수만 저장되어 있습니다. ");
        System.out.println("1. 선수 등록");
        System.out.println("2. 전체 선수 출력");
        System.out.println("3. 선수 검색");
        System.out.println("4. 선수 삭제");
        System.out.println("5. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    public void run() {
        PlayerManagement pm = new PlayerManagement();
        pm.initializePlayers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    pm.addPlayer(scanner);
                    break;
                case 2:
                    pm.listPlayers();
                    break;
                case 3:
                    pm.searchPlayers(scanner);
                    break;
                case 4:
                    pm.deletePlayer(scanner);
                    break;
                case 5:
                    System.out.println("선수 관리 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

