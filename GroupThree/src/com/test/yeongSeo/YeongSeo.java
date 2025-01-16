package com.test.yeongSeo;

import java.util.*;

public class YeongSeo {
    private List<Cosmetic> cosmetics = new ArrayList<>();
    private Map<String, Integer> productViews = new HashMap<>();

    public YeongSeo() {
        initializeSampleData();
    }

    public static void printMenu() {
        System.out.println("\n======================================");
        System.out.println("         💄 화장품 관리 시스템 💄        ");
        System.out.println("======================================");
        System.out.println("1. 화장품 등록 🌐");
        System.out.println("2. 전체 화장품 조회 📋");
        System.out.println("3. 화장품 검색 🔍");
        System.out.println("4. 화장품 삭제 ❌");
        System.out.println("5. 랜덤 화장품 추천 🎉");
        System.out.println("6. 종료 🚪");
        System.out.println("======================================");
        System.out.print("메뉴를 선택하세요: ");
    }

    // 샘플 화장품
    public void initializeSampleData() {
        cosmetics.add(new Cosmetic("청귤 비타C 잡티케어 세럼", "구달", "스킨케어", 30900));
        cosmetics.add(new Cosmetic("퍼스트 스프레이 세럼", "달바", "스킨케어", 32900));
        cosmetics.add(new Cosmetic("마데카소사이드 흔적 패드", "메디힐", "스킨케어", 28900));

        cosmetics.add(new Cosmetic("얼티밋 화이트 쿠션", "바닐라코", "메이크업 - 베이스", 33000));
        cosmetics.add(new Cosmetic("블랙 쿠션", "헤라", "메이크업 - 베이스", 62900));
        cosmetics.add(new Cosmetic("비벨벳 커버쿠션", "에스쁘아", "메이크업 - 베이스", 30400));

        cosmetics.add(new Cosmetic("쥬시래스팅 틴트", "롬앤", "메이크업 - 립", 13000));
        cosmetics.add(new Cosmetic("잉크 무드 글로이 틴트", "페리페라", "메이크업 - 립", 8800));
        cosmetics.add(new Cosmetic("센슈얼 누드 글로스", "헤라", "메이크업 - 립", 34000));

        cosmetics.add(new Cosmetic("퓨어 클렌징 오일", "마녀공장", "클렌징", 12000));
        cosmetics.add(new Cosmetic("녹두 약산성 클렌징폼", "비플레인", "클렌징", 12000));
        cosmetics.add(new Cosmetic("클린잇제로 오리지널 플렌징밤", "바닐라코", "클렌징", 12000));

        productViews.put("청귤 비타C 잡티케어 세럼", 0);
        productViews.put("퍼스트 스프레이 세럼", 0);
        productViews.put("마데카소사이드 흔적 패드", 0);

        productViews.put("얼티밋 화이트 쿠션", 0);
        productViews.put("블랙 쿠션", 0);
        productViews.put("비벨벳 커버쿠션", 0);

        productViews.put("쥬시래스팅 틴트", 0);
        productViews.put("잉크 무드 글로이 틴트", 0);
        productViews.put("센슈얼 누드 글로스", 0);

        productViews.put("퓨어 클렌징 오일", 0);
        productViews.put("녹두 약산성 클렌징폼", 0);
        productViews.put("클린잇제로 오리지널 플렌징밤", 0);
    }

    public void addCosmetic(Scanner scanner) {
        System.out.println("\n[📌 화장품 등록]");
        System.out.print("제품명: ");
        String name = scanner.nextLine();

        System.out.print("브랜드명: ");
        String brand = scanner.nextLine();

        System.out.print("카테고리 (스킨케어/메이크업 - 베이스/메이크업 - 립/클렌징 등): ");
        String category = scanner.nextLine();

        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Cosmetic cosmetic = new Cosmetic(name, brand, category, price);
        cosmetics.add(cosmetic);
        productViews.put(name, 0);
        System.out.println("✅ 등록 완료: " + cosmetic);
    }

    public void listCosmetics() {
        System.out.println("\n📋 [전체 화장품 목록]");
        if (cosmetics.isEmpty()) {
            System.out.println("❌ 등록된 화장품이 없습니다.");
        } else {
            System.out.printf("%-30s %-15s %-20s %-10s\n", "제품명", "브랜드", "카테고리", "가격");
            System.out.println("----------------------------------------------------------------------------");
            for (Cosmetic cosmetic : cosmetics) {
                System.out.printf("%-30s %-15s %-20s %-10.2f원\n",
                        cosmetic.getName(),
                        cosmetic.getBrand(),
                        cosmetic.getCategory(),
                        cosmetic.getPrice());
            }
        }
    }

    public void searchCosmetics(Scanner scanner) {
        System.out.println("\n🔍 [화장품 검색]");
        System.out.println("1. 제품명/브랜드명으로 검색");
        System.out.println("2. 카테고리별로 검색");
        System.out.print("선택: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                searchByKeyword(scanner);
                break;
            case 2:
                searchByCategory(scanner);
                break;
            default:
                System.out.println("❌ 잘못된 선택입니다.");
        }
    }

    private void searchByKeyword(Scanner scanner) {
        System.out.print("검색어를 입력하세요 (제품명/브랜드명): ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        System.out.println("\n🔎 검색 결과:");
        boolean found = false;
        System.out.printf("%-30s %-15s %-20s %-10s\n", "제품명", "브랜드", "카테고리", "가격");
        System.out.println("----------------------------------------------------------------------------");
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getName().toLowerCase().contains(keyword) ||
                    cosmetic.getBrand().toLowerCase().contains(keyword)) {
                System.out.printf("%-30s %-15s %-20s %-10.2f원\n",
                        cosmetic.getName(),
                        cosmetic.getBrand(),
                        cosmetic.getCategory(),
                        cosmetic.getPrice());
                productViews.put(cosmetic.getName(), productViews.get(cosmetic.getName()) + 1);
                found = true;
            }
        }

        if (!found) {
            System.out.printf("❌ '%s'를 포함하는 화장품이 없습니다.\n", keyword);
        }
    }

    private void searchByCategory(Scanner scanner) {
        System.out.print("검색할 카테고리를 입력하세요 (스킨케어/메이크업 - 베이스/메이크업 - 립/클렌징 등): ");
        String category = scanner.nextLine().trim();

        System.out.println("\n🔎 검색 결과:");
        boolean found = false;
        System.out.printf("%-30s %-15s %-20s %-10s\n", "제품명", "브랜드", "카테고리", "가격");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getCategory().equalsIgnoreCase(category)) {
                System.out.printf("%-30s %-15s %-20s %-10.2f원\n",
                        cosmetic.getName(),
                        cosmetic.getBrand(),
                        cosmetic.getCategory(),
                        cosmetic.getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.printf("❌ '%s' 카테고리에 해당하는 화장품이 없습니다.\n", category);
        }
    }

    public void deleteCosmetic(Scanner scanner) {
        System.out.println("\n[🗑️ 화장품 삭제]");
        System.out.print("삭제할 제품명을 입력하세요: ");
        String name = scanner.nextLine();

        Iterator<Cosmetic> iterator = cosmetics.iterator();
        while (iterator.hasNext()) {
            Cosmetic cosmetic = iterator.next();
            if (cosmetic.getName().equals(name)) {
                iterator.remove();
                productViews.remove(name);
                System.out.printf("✅ '%s' 제품이 삭제되었습니다.\n", name);
                return;
            }
        }

        System.out.printf("❌ '%s'와 일치하는 화장품이 없습니다.\n", name);
    }

    public void randomRecommendation() {
        System.out.println("\n[🎁 랜덤 추천]");
        if (cosmetics.isEmpty()) {
            System.out.println("❌ 등록된 화장품이 없습니다. 추천이 불가능합니다.");
            return;
        }

        Random random = new Random();
        Cosmetic randomCosmetic = cosmetics.get(random.nextInt(cosmetics.size()));
        System.out.println("🎉 오늘의 추천 화장품: " + randomCosmetic);
    }

    public static void main(String[] args) {
        YeongSeo yeongSeo = new YeongSeo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    yeongSeo.addCosmetic(scanner);
                    break;
                case 2:
                    yeongSeo.listCosmetics();
                    break;
                case 3:
                    yeongSeo.searchCosmetics(scanner);
                    break;
                case 4:
                    yeongSeo.deleteCosmetic(scanner);
                    break;
                case 5:
                    yeongSeo.randomRecommendation();
                    break;
                case 6:
                    System.out.println("\n🚪 프로그램을 종료합니다. 이용해주셔서 감사합니다! 👍");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ 잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

    static class Cosmetic {
        private String name;
        private String brand;
        private String category;
        private double price;

        public Cosmetic(String name, String brand, String category, double price) {
            this.name = name;
            this.brand = brand;
            this.category = category;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getBrand() {
            return brand;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("[제품명: %s, 브랜드: %s, 카테고리: %s, 가격: %.2f원]", name, brand, category, price);
        }
    }
}
