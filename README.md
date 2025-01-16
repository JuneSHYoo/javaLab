# LG CNS AM CAMP 1기 - 3조 프로젝트 안내  
**기간**: 2025.01.16 ~ 2025.01.17 1:00PM 제출

### 팀원 목록
- **신예빈** - 2048
- **심수연** - Diary
- **양한진** - Tamagotchi
- **오태양** - 최강기아 타이거즈
- **오형서** - Convenience
- **유승희** - GymLog
- **유영서** - Cosmetic
- **윤다인** - 
- **이다빈** - Baseball
- **이상훈** - Movie
- **현민영** - 

---

## 1. 프로젝트 폴더 연동 (Eclipse)
- **프로젝트 폴더 경로**:  
  [GroupThree Repository](https://github.com/lg-cns-am-1-group3/javaLab/tree/main/GroupThree)
  
- **주의사항**:  
  해당 경로 내에 다른 폴더나 파일을 생성하지 마세요.

---

## 2. Main 메서드 위치
- **Main.java 파일 경로**:  
  [Main.java](https://github.com/lg-cns-am-1-group3/javaLab/blob/main/GroupThree/src/com/test/Main.java)

---

## 3. 코드 수정 안내
- **메서드 수정**:  
  `GroupThree/src/com/test/Main.java` 파일에서 `switch` 문 내 본인 위치에 맞는 메서드명을 수정해 주세요. (예: `hanjin.tamagotchiApp(scanner);`)
  
- **Scanner 객체 사용**:  
  - `scanner` 객체는 시스템 안정성을 위해 한 번만 선언하고, 메서드 파라미터로 전달하는 방식으로 사용해 주세요.  
  - `scanner` 객체는 `Main` 메서드의 `finally` 블록에서 닫히므로, 개인 클래스에서 `close()` 메서드를 호출하지 않도록 주의해 주세요.
  
- **본인 코드 추가**:  
  본인이 작성한 코드는 본인 이름 패키지(`com.test.000`) 내에 추가해 주세요.  
  예시: [hanjin 패키지](https://github.com/lg-cns-am-1-group3/javaLab/tree/main/GroupThree/src/com/test/hanjin)

---

## 4. 프로젝트 수정 시 유의사항
- **커밋 전**:  
  반드시 최신 버전으로 `pull` 받은 후, 커밋하고 푸쉬해 주세요!
  
- **정상 동작하는 코드만 커밋**:  
  메인 메서드에서 합친 후, **정상적으로 동작하는 코드만 커밋**해 주세요. (충돌 방지)
