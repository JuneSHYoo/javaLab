# 영화 관리 애플리케이션

이 영화 관리 애플리케이션은 Java 기반의 콘솔 프로그램으로, 영화 컬렉션을 관리할 수 있는 기능을 제공합니다. CRUD (생성, 조회, 수정, 삭제) 작업과 함께 검색, 정렬 및 필터링 기능을 포함하고 있습니다. 애플리케이션은 모듈화된 구조와 객체 지향 원칙을 따라 유지보수가 용이하도록 설계되었습니다.

## 주요 기능

### 1. 영화 추가
- 새로운 영화를 컬렉션에 추가합니다.
- 제목은 필수 입력값이며, 감독, 개봉 연도, 장르, 관객 수는 선택적으로 입력 가능합니다.
- 제목은 대소문자를 구분하지 않도록 소문자로 저장됩니다.

### 2. 영화 검색
- 제목, 감독, 개봉 연도, 장르로 영화를 검색할 수 있습니다.
- 제목과 감독은 일부 문구만 입력해도 검색 가능합니다.
- 장르는 영화의 장르 목록 중 하나라도 일치하면 검색됩니다.

### 3. 영화 수정
- 기존 영화의 정보를 수정할 수 있습니다.
- 제목은 수정할 수 없으며, 감독, 개봉 연도, 장르, 관객 수는 수정 가능합니다.

### 4. 영화 삭제
- 제목을 기준으로 영화를 컬렉션에서 삭제합니다.

### 5. 상위 영화 목록 조회
- 관객 수를 기준으로 상위 10개의 영화를 조회합니다.
- 특정 장르로 필터링하여 조회할 수도 있습니다.

### 6. 종료
- 프로그램을 종료합니다.

## 파일 구조

### 1. `Movie.java`
`Movie` 클래스는 다음과 같은 속성을 포함합니다:
- `title` (문자열, 필수)
- `director` (문자열, 선택)
- `releaseYear` (정수, 선택)
- `genres` (문자열 리스트, 선택, 여러 장르 지원)
- `audience` (정수, 선택, 관객 수를 나타냄)

### 2. `MovieManager.java`
영화를 관리하는 주요 비즈니스 로직을 포함합니다:
- 영화 추가, 검색, 수정, 삭제 기능.
- 영화 목록을 정렬 및 필터링하여 조회.
- Java의 `ArrayList`와 `Stream API`를 사용하여 효율적인 작업을 수행합니다.

### 3. `SangHoon.java`
사용자와 상호작용하며 `MovieManager`를 호출하는 메뉴 기반 인터페이스를 제공합니다:
- 메뉴를 통해 기능을 선택하고 실행.
- 사용자 입력 검증을 통해 잘못된 입력을 방지.

## 사용 예시

### 영화 추가
```
Enter title: Inception
Enter director (or leave blank): Christopher Nolan
Enter release year (or leave blank): 2010
Enter genres (comma-separated, or leave blank): sci-fi,thriller
Enter audience (or leave blank): 1000000
Movie added successfully.
```

### 영화 검색
```
Enter title to search (or leave blank): inception
Enter director to search (or leave blank):
Enter release year to search (or leave blank):
Enter genres to search (comma-separated, or leave blank): sci-fi
Title: inception
Director: christopher nolan
Release Year: 2010
Genres: sci-fi, thriller
Audience: 1000000
```

### 상위 영화 목록 조회
```
Enter genre to filter (or leave blank):
Title: the dark knight
Director: christopher nolan
Release Year: 2008
Genres: action, drama
Audience: 1500000
-------------------------
Title: interstellar
Director: christopher nolan
Release Year: 2014
Genres: sci-fi, drama
Audience: 1200000
```

## 사용된 도구 및 라이브러리
- Java 컬렉션 프레임워크 (`ArrayList`, `List`)
- `Stream API`를 활용한 필터링 및 정렬.
- Lombok을 사용하여 보일러플레이트 코드(예: getter, setter, 생성자) 감소.