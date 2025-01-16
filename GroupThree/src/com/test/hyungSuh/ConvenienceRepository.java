package hyungSuh;

import java.util.List;
import java.util.Optional;

public interface ConvenienceRepository {
    // 상품 추가
    void addProduct(Product product);

    // 상품 전체 조회
    List<Product> findAll();

    // code로 상품 한 개 조회
    Optional<Product> findByCode(Long code);

    // name으로 상품 여러 개 조회(동일명 또는 포함)
    List<Product> findByName(String name);

    // 상품 타입별 조회
    List<Product> findByType(Type type);

    // 상품 한 개 삭제
    void deleteByCode(Long code);

    // 상품 전체 삭제
    void deleteAll();

    // 동일 코드 확인
    boolean existsByCode(Long code);
}