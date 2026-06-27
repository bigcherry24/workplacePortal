# 🏢 Company Portal System - Spring Boot 학습 프로젝트

이 프로젝트는 Spring Boot의 핵심 개념을 학습하기 위한 toy project입니다. 회사 포탈 시스템의 기본 구조를 구현했습니다.

## 📋 프로젝트 구조

```
company-portal/
├── pom.xml                          # Maven 설정
├── src/main/
│   ├── java/com/company/portal/
│   │   ├── CompanyPortalApplication.java    # Spring Boot 시작점
│   │   ├── config/
│   │   │   ├── SecurityConfig.java         # Spring Security 설정
│   │   │   └── DataInitConfig.java         # 초기 데이터 생성
│   │   ├── controller/
│   │   │   ├── AuthController.java         # 인증 관련 컨트롤러
│   │   │   └── MainController.java         # 메인 화면 컨트롤러
│   │   ├── service/
│   │   │   ├── EmailService.java           # 이메일 비즈니스 로직
│   │   │   ├── NoticeService.java          # 공지사항 비즈니스 로직
│   │   │   └── BannerService.java          # 배너 비즈니스 로직
│   │   ├── model/
│   │   │   ├── User.java                   # 사용자 엔티티
│   │   │   ├── Email.java                  # 이메일 엔티티
│   │   │   ├── Notice.java                 # 공지사항 엔티티
│   │   │   └── Banner.java                 # 배너 모델
│   │   └── repository/
│   │       ├── UserRepository.java         # 사용자 저장소
│   │       ├── EmailRepository.java        # 이메일 저장소
│   │       └── NoticeRepository.java       # 공지사항 저장소
│   └── resources/
│       ├── application.properties           # 애플리케이션 설정
│       └── templates/
│           ├── login.html                   # 로그인 화면
│           └── main.html                    # 메인 화면 (1x3 레이아웃)
```

## 🎯 구현된 주요 기능

### 1. **인증 화면 (Authentication)**
- Spring Security를 이용한 기본 로그인
- 테스트 계정: `user1` / `password123` 또는 `admin` / `admin123`
- 비밀번호 암호화 (BCrypt)

### 2. **메인 화면 (Main Dashboard - 1x3 Layout)**

#### a. **롤링 배너 (Left Panel)**
- 자동으로 5초마다 전환되는 배너
- 이전/다음 버튼으로 수동 조작 가능
- 점(dot) 인디케이터로 현재 위치 표시
- JavaScript를 이용한 클라이언트 사이드 구현

#### b. **메일 받은 편지함 Top 5 (Middle Panel)**
- 사용자별 최신 이메일 5개 표시
- 이메일 발신자, 제목, 수신 시간 표시
- 읽음/안 읽음 상태 표시

#### c. **공지게시판 Top 4 (Right Panel)**
- 최신 공지사항 4개 표시
- 제목, 작성자, 작성 날짜 표시
- 조회수 정보 포함 (데이터베이스에 저장)

## 💡 Spring Boot 핵심 개념

### 1. **Spring Boot 자동 설정**
```
@SpringBootApplication → @EnableAutoConfiguration + @ComponentScan 포함
```

### 2. **의존성 주입 (Dependency Injection)**
```java
@RequiredArgsConstructor  // Lombok이 생성자 자동 생성
private final EmailService emailService;  // 생성자 주입
```

### 3. **계층 구조 (Layered Architecture)**
- **Controller**: HTTP 요청/응답 처리
- **Service**: 비즈니스 로직
- **Repository**: 데이터 접근

### 4. **Spring Security**
- 폼 기반 로그인
- 권한 기반 접근 제어
- CSRF 보호 (학습용으로 비활성화)

### 5. **Spring Data JPA**
- 엔티티 자동 매핑
- 쿼리 메서드 (Query Methods)
- 자동 CRUD 기능

### 6. **Thymeleaf 템플릿 엔진**
- 서버 사이드 렌더링
- SpEL (Spring Expression Language) 통합

## 🚀 프로젝트 실행

### 1. **프로젝트 빌드**
```bash
mvn clean install
```

### 2. **애플리케이션 실행**
```bash
mvn spring-boot:run
```

### 3. **브라우저 접속**
```
http://localhost:8080
```

### 4. **H2 콘솔 접속 (데이터 확인)**
```
http://localhost:8080/h2-console
```

## 📊 데이터베이스

- **DB**: H2 (인메모리)
- **사용자명**: sa
- **비밀번호**: (빈 값)
- **URL**: jdbc:h2:mem:testdb

### 초기 데이터
`DataInitConfig.java`에서 애플리케이션 시작 시 자동으로 생성됩니다:
- **사용자**: user1, admin
- **이메일**: 10개 샘플 데이터
- **공지사항**: 6개 샘플 데이터

## 🔑 테스트 계정

| 아이디 | 비밀번호 | 역할 |
|--------|---------|------|
| user1 | password123 | 일반 사용자 |
| admin | admin123 | 관리자 |

## 📚 Spring Boot 학습 포인트

1. **@Controller vs @RestController**
   - Controller: 뷰 반환 (HTML)
   - RestController: JSON 반환

2. **Model 객체**
   - 컨트롤러에서 뷰로 데이터 전달

3. **Thymeleaf 문법**
   - `th:each`: 반복문
   - `th:text`: 텍스트 출력
   - `th:class`: 조건부 CSS 클래스
   - `sec:authentication`: Spring Security 정보 접근

4. **JPA 어노테이션**
   - `@Entity`: 엔티티 정의
   - `@Column`: 컬럼 속성
   - `@PrePersist`: 저장 전 콜백

5. **Custom Query**
   ```java
   @Query(value = "SELECT * FROM emails WHERE receiver = ?1 ORDER BY received_at DESC LIMIT 5", nativeQuery = true)
   ```

## 🔧 기술 스택

- **Java**: 17
- **Spring Boot**: 3.1.5
- **Spring Security**: Authentication & Authorization
- **Spring Data JPA**: ORM
- **Thymeleaf**: 템플릿 엔진
- **H2 Database**: 인메모리 데이터베이스
- **Lombok**: 보일러플레이트 코드 제거
- **Maven**: 빌드 도구

## 📝 주요 파일 설명

| 파일 | 설명 |
|------|------|
| `CompanyPortalApplication.java` | Spring Boot 애플리케이션 시작점 |
| `SecurityConfig.java` | Spring Security 설정 (로그인, 권한) |
| `DataInitConfig.java` | 초기 데이터 생성 (CommandLineRunner) |
| `MainController.java` | 메인 화면 데이터 조회 및 뷰 반환 |
| `*Service.java` | 비즈니스 로직 계층 |
| `*Repository.java` | 데이터 접근 계층 |

## 🎓 학습 체크리스트

- [ ] Spring Boot 애플리케이션 시작 과정 이해
- [ ] 의존성 주입(DI) 개념 이해
- [ ] 계층화된 아키텍처 이해
- [ ] Spring Security를 이용한 인증 구현
- [ ] Spring Data JPA 사용
- [ ] Thymeleaf 템플릿 엔진 사용
- [ ] MVC 패턴 이해

## 🚀 다음 단계 (심화 학습)

1. **데이터 검증 추가**
   - `@Valid` and `@NotEmpty` 등 validation 어노테이션

2. **REST API 추가**
   - `@RestController` 사용해 JSON 응답

3. **예외 처리**
   - `@ExceptionHandler` 구현

4. **로깅**
   - SLF4J 및 Logback 사용

5. **테스트**
   - JUnit & Mockito

6. **데이터베이스 마이그레이션**
   - Flyway 또는 Liquibase

## 📄 라이센스

이 프로젝트는 학습 목적으로 자유롭게 사용할 수 있습니다.

---

**Happy Learning! 🎉**
