package com.test.yeongSeo;


import java.util.Scanner;

public class YeongSeo {
    public static void printMenu() {
        System.out.println("\n화장품 관리 시스템");
        System.out.println("1. 화장품 등록");
        System.out.println("2. 전체 화장품 조회");
        System.out.println("3. 화장품 검색");
        System.out.println("4. 화장품 삭제");
        System.out.println("5. 인기 화장품 조회");
        System.out.println("6. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    public static void main(String[] args) {
        CosmeticManagement management = new CosmeticManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    management.addCosmetic(scanner);
                    break;
                case 2:
                    management.listCosmetics();
                    break;
                case 3:
                    management.searchCosmetics(scanner);
                    break;
                case 4:
                    management.deleteCosmetic(scanner);
                    break;
                case 5:
                    management.mostViewedCosmetics();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }
}
