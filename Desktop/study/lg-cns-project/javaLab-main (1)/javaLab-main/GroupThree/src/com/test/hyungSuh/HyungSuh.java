package com.test.hyungSuh;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class HyungSuh {

    private final ConvenienceService convenienceService;

    public HyungSuh() {
        ConvenienceRepository convenienceRepository = ConvenienceRepositoryImpl.getInstance();
        this.convenienceService = new ConvenienceService(convenienceRepository);
    }

    // 결국 컨트롤러 역할
    public void start(Scanner scanner) {
        while (true) {
            try {
                printMenu();

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // 상품 추가
                        convenienceService.addProduct(scanner);
                        break;
                    case 2:
                        // 상품 수정
                        convenienceService.updateProduct(scanner);
                        break;
                    case 3:
                        // 상품 한 개 코드 조회
                        convenienceService.findOneByCode(scanner);
                        break;
                    case 4:
                        // 상품 이름 조회
                        convenienceService.findByName(scanner);
                        break;
                    case 5:
                        // 상품 전체 조회
                        convenienceService.findAll();
                        break;
                    case 6:
                        // 상품 한 개 삭제
                        convenienceService.deleteOne(scanner);
                        break;
                    case 7:
                        // 상품 전체 삭제
                        convenienceService.deleteAll();
                        break;
                    case 8:
                        // 상품 타입별 조회
                        convenienceService.findByType(scanner);
                        break;
                    case 9:
                        // 종료
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("해당 숫자는 기능이 없습니다.");
                }
            } catch (Exception e) {
                System.out.println("입력이 올바르지 않습니다. 숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=================");
        System.out.println("\n편의점 재고 관리: ");
        System.out.println("1. 상품 추가");
        System.out.println("2. 상품 수정");
        System.out.println("3. 상품 한 개 코드 조회");
        System.out.println("4. 상품 이름 조회");
        System.out.println("5. 상품 전체 조회");
        System.out.println("6. 상품 한 개 삭제");
        System.out.println("7. 상품 전체 삭제");
        System.out.println("8. 상품 타입별 조회");
        System.out.println("9. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
}
