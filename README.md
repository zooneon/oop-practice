# oop-practice

### 실행
```shell
# running the app
$ ./gradlew jar
$ java -jar build/libs/oop-practice-1.0.0.jar

# test
$ ./gradlew test 
```
- 순서대로 입력하는 것은 `줄 바꿈(next line)`으로 입력하시면 됩니다.
- 테스트 데이터는 [DataInit 클래스](/src/main/java/ooppractice/global/util/DataInit.java)를 확인해주세요.
- 관련 기능은 [요구사항](#요구사항)을 참고해주세요.

### 목표
- `객체지향의 사실과 오해` 를 읽고 학습한 내용을 직접 적용해본다.
- 객체지향적 설계 및 코드에 익숙해진다.
    - 객체의 책임, 역할, 협력에 집중한다.
    - 적절한 추상화를 이용한다.
- 연습한 내용을 바탕으로 앞으로 진행할 프로젝트에 적용한다.

### 진행 방식
- 어플리케이션은 gradle 프로젝트로 웹 계층을 포함하지 않는다.
- 입출력은 콘솔을 통해 진행된다.
- 단위 테스트를 작성한다.
- 고민들과 해결 과정을 기록한다.

### 주제
- 상품 주문 서비스

### 요구사항
- [입출력 요구사항](https://www.notion.so/zzooneon/242a78c16dc7434884ba48cc27806e0b)
- [기능 요구사항](https://www.notion.so/zzooneon/fd97de5b194f462d9530e65f6fc7bb06)

## 기록
- [설계에 필요한 요소](https://www.notion.so/zzooneon/78509f1adafc430ebfc138acec946a96)
- [도메인 모델](https://www.notion.so/zzooneon/acb6b99dc0064ecf81d7f9a398ca225e)
- [유즈케이스](https://www.notion.so/zzooneon/2e6cfc840c2640c3b2641b0b99a0bbfd)
- [책임 할당하기](https://www.notion.so/zzooneon/4007cd2307fe4f2eb9c56d0c7ded8958)
- [전체 협력 구조](https://www.notion.so/zzooneon/f94c16effc5f4f99b5741ce72a976e16)
- [객체별 책임 정리](https://www.notion.so/zzooneon/4d542a649a0c4a7b9754b028338ecc30)
- [클래스 다이어그램](https://www.notion.so/zzooneon/2699340667104bb998ff240192bdf354)
- [패키지 구조](https://www.notion.so/zzooneon/112d882fb89b41b8a7f856c2abf62c09)
- [repository 생성](https://www.notion.so/zzooneon/repository-701ff8b149b24e81a0c845dc097876dc)
- [junit-jupiter-engine](https://www.notion.so/zzooneon/junit-jupiter-engine-6e7e8fc596e8475b96c3e13cbafa7446)
- [execption 처리하기](https://www.notion.so/zzooneon/exception-dac40bf2c3784f1284d9236306da26b7)
- [GetLocalDateTime](https://www.notion.so/zzooneon/GetLocalDateTime-b4ce07633a5444f7ab9ae7133018ae62)
- [enum 활용하기](https://www.notion.so/zzooneon/enum-80dc5a207ff94dfe9dba4773ac4abfcc)
- [IoC, DI를 위한 AppConfig 작성](https://www.notion.so/zzooneon/IoC-DI-AppConfig-f395d746f087470993b1dbd3bbc6bde6)
- [결제 로직 작성하기](https://www.notion.so/zzooneon/7f0456e5bf54474795ea705a3a1b8894)
- [AbstractView 작성](https://www.notion.so/zzooneon/AbstractView-12bff77f03634ce1ac03bfe3d61488fc)
