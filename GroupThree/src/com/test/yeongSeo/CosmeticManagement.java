package com.test.yeongSeo;


import java.util.*;

public class CosmeticManagement {
    private List<Cosmetic> cosmetics = new ArrayList<>();
    private Map<String, Integer> productViews = new HashMap<>();

    // 화장품 등록
    public void addCosmetic(Scanner scanner) {
        System.out.print("제품명: ");
        String name = scanner.nextLine();

        System.out.print("브랜드명: ");
        String brand = scanner.nextLine();

        System.out.print("카테고리 (스킨케어/메이크업 등): ");
        String category = scanner.nextLine();

        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // 버퍼 비우기

        Cosmetic cosmetic = new Cosmetic(name, brand, category, price);
        cosmetics.add(cosmetic);
        productViews.put(name, 0); // 조회수 초기화
        System.out.println("정상적으로 등록되었습니다: " + cosmetic);
    }

    // 전체 화장품 조회
    public void listCosmetics() {
        if (cosmetics.isEmpty()) {
            System.out.println("등록된 화장품이 없습니다.");
            return;
        }
        cosmetics.forEach(System.out::println);
    }

    // 화장품 검색
    public void searchCosmetics(Scanner scanner) {
        System.out.print("검색어를 입력하세요 (제품명/브랜드명): ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getName().toLowerCase().contains(keyword) ||
                    cosmetic.getBrand().toLowerCase().contains(keyword)) {
                System.out.println(cosmetic);
                productViews.put(cosmetic.getName(), productViews.get(cosmetic.getName()) + 1); // 조회수 증가
                found = true;
            }
        }

        if (!found) {
            System.out.printf("'%s'를 포함하는 화장품을 찾을 수 없습니다.\n", keyword);
        }
    }

    // 화장품 삭제
    public void deleteCosmetic(Scanner scanner) {
        System.out.print("삭제할 제품명을 입력하세요: ");
        String name = scanner.nextLine();

        Iterator<Cosmetic> iterator = cosmetics.iterator();
        while (iterator.hasNext()) {
            Cosmetic cosmetic = iterator.next();
            if (cosmetic.getName().equals(name)) {
                iterator.remove();
                productViews.remove(name);
                System.out.printf("'%s' 제품을 삭제했습니다.\n", name);
                return;
            }
        }

        System.out.printf("'%s'와 일치하는 화장품을 찾을 수 없습니다.\n", name);
    }

    // 화장품 수정 (Update)
    public void updateCosmetic(Scanner scanner) {
        System.out.print("수정할 제품명을 입력하세요: ");
        String name = scanner.nextLine();

        // 수정할 화장품 찾기
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getName().equals(name)) {
                System.out.println("수정할 항목을 선택하세요: ");
                System.out.println("1. 브랜드명");
                System.out.println("2. 카테고리");
                System.out.println("3. 가격");
                System.out.print("선택: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기

                switch (choice) {
                    case 1:
                        System.out.print("새로운 브랜드명을 입력하세요: ");
                        String newBrand = scanner.nextLine();
                        cosmetics.set(cosmetics.indexOf(cosmetic), new Cosmetic(name, newBrand, cosmetic.getCategory(), cosmetic.getPrice()));
                        break;
                    case 2:
                        System.out.print("새로운 카테고리를 입력하세요: ");
                        String newCategory = scanner.nextLine();
                        cosmetics.set(cosmetics.indexOf(cosmetic), new Cosmetic(name, cosmetic.getBrand(), newCategory, cosmetic.getPrice()));
                        break;
                    case 3:
                        System.out.print("새로운 가격을 입력하세요: ");
                        double newPrice = scanner.nextDouble();
                        cosmetics.set(cosmetics.indexOf(cosmetic), new Cosmetic(name, cosmetic.getBrand(), cosmetic.getCategory(), newPrice));
                        scanner.nextLine(); // 버퍼 비우기
                        break;
                    default:
                        System.out.println("잘못된 선택입니다.");
                }
                System.out.println("수정이 완료되었습니다: " + cosmetics.get(cosmetics.indexOf(cosmetic)));
                return;
            }
        }
        System.out.printf("'%s'와 일치하는 화장품을 찾을 수 없습니다.\n", name);
    }


    // 인기 화장품 조회
    public void mostViewedCosmetics() {
        if (productViews.isEmpty()) {
            System.out.println("등록된 화장품이 없습니다.");
            return;
        }

        int maxViews = Collections.max(productViews.values());
        if (maxViews == 0) {
            System.out.println("조회된 화장품이 없습니다.");
            return;
        }

        for (Map.Entry<String, Integer> entry : productViews.entrySet()) {
            if (entry.getValue() == maxViews) {
                cosmetics.stream()
                        .filter(cosmetic -> cosmetic.getName().equals(entry.getKey()))
                        .forEach(System.out::println);
            }
        }
    }
}

