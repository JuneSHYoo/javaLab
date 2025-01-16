package hyungSuh;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConvenienceService {
    private final ConvenienceRepository convenienceRepository;

    public ConvenienceService(ConvenienceRepository convenienceRepositoryImpl) {
        this.convenienceRepository = convenienceRepositoryImpl;
    }

    /*
     * 상품 추가, 코드가 다르면 상품명 같아도 상관 없음
     */
    public void addProduct(Scanner scanner) {
        System.out.print("등록할 상품의 코드를 입력해주세요: ");
        Long code = scanner.nextLong();
        scanner.nextLine();

        if (checkProductExists(code)) {
            System.out.printf("%d와 동일한 코드를 가진 상품이 있습니다.\n", code);
            return;
        }

        System.out.print("등록할 상품의 이름을 입력해주세요: ");
        String name = scanner.nextLine();

        System.out.print("등록할 상품의 가격을 입력해주세요: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        Type type = inputType(scanner);

        System.out.print("등록할 상품의 재고를 입력해주세요: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        convenienceRepository.addProduct(new Product(code, name, price, type, stock));
        System.out.println("상품이 등록되었습니다.");
    }

    // 상품 재고 수정
    public void updateProduct(Scanner scanner) {
        System.out.print("수정할 상품의 코드를 입력해주세요: ");
        Long code = scanner.nextLong();
        scanner.nextLine();

        Optional<Product> product = convenienceRepository.findByCode(code);

        if (product.isEmpty()) {
            System.out.println("해당 코드를 가진 상품이 존재하지 않습니다.");
            return;
        }

        System.out.print("수정할 개수를 입력해주세요: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        product.get().updateStock(stock);
    }

    // 상품 코드 조회
    public void findOneByCode(Scanner scanner) {
        System.out.print("검색할 상품의 코드를 입력해주세요: ");
        Long code = scanner.nextLong();
        scanner.nextLine();

        Optional<Product> product = convenienceRepository.findByCode(code);

        if (product.isEmpty()) {
            System.out.println("해당 코드를 가진 상품이 존재하지 않습니다.");
        } else {
            System.out.println(product.get());
        }

    }

    // 상품 이름별 조회
    public void findByName(Scanner scanner) {
        System.out.print("검색할 상품의 이름을 입력해주세요: ");
        String name = scanner.nextLine();

        List<Product> products = convenienceRepository.findByName(name);

        if (products.isEmpty()) {
            System.out.println("결과가 없습니다.");
            return;
        }

        System.out.println("검색 상품 목록입니다.");
        System.out.println(products);
    }

    // 상품 전체 조회
    public void findAll() {
        List<Product> products = convenienceRepository.findAll();

        if (products.isEmpty()) {
            System.out.println("등록된 상품이 없습니다.");
            return;
        }
        System.out.println("전체 상품을 조회했습니다.");
        System.out.println(products);
    }

    // 상품 한 개 삭제
    public void deleteOne(Scanner scanner) {
        System.out.print("삭제할 상품의 코드를 입력해주세요: ");
        Long code = scanner.nextLong();
        scanner.nextLine();

        if (!checkProductExists(code)) {
            System.out.printf("%d와 동일한 코드를 가진 상품이 없습니다.\n", code);
            return;
        }

        convenienceRepository.deleteByCode(code);
        System.out.printf("%d 코드를 가진 상품을 삭제했습니다.\n", code);
    }

    // 상품 전체 삭제
    public void deleteAll() {
        convenienceRepository.deleteAll();
        System.out.println("전체 상품을 삭제했습니다.");
    }

    // 상품 타입별 검색
    public void findByType(Scanner scanner) {
        Type type = inputType(scanner);

        List<Product> products = convenienceRepository.findByType(type);
        System.out.printf("%s 타입 상품을 검색했습니다.\n", type.toString());
        System.out.println(products);
    }


    private Type inputType(Scanner scanner) {
        while (true) {
            System.out.print("등록할 상품의 타입을 입력해주세요 (FOOD/DRINK): ");
            String typeInput = scanner.nextLine().toUpperCase();
            try {
                return Type.valueOf(typeInput);
            } catch (Exception e) {
                System.out.println("\"FOOD\" 또는 \"DRINK\"를 입력해주세요.");
            }
        }
    }

    private boolean checkProductExists(Long code) {
        return convenienceRepository.existsByCode(code);
    }
}
