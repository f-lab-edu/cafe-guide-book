## ☕ Takeout Coffee Ordering Service
![](https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80)

## ☕ 프로젝트 주제

고도의 집중력을 요구하는 개발자에게 커피는 필수라고할 수 있습니다. 저희도 개발자로서 평소에 커피를 즐겨마시고 있습니다. 당시에는 무심결하게 넘어갔지만 벡엔드 공부를 진행하면서 커피시장 1위 프렌차이즈인 [별다방 서버가 다운되었던 사건](http://www.dtoday.co.kr/news/articleView.html?idxno=342387)이 떠올랐습니다.

이에 도대체 어떻게 개발해야 `수많은 트래픽을 견디면서 장애없이 서비스를 지속할 수 있을까?` 라는 호기심을 갖게 되었고, 본 프로젝트에서는 이러한 호기심을 해소하기 위해 시작하였으며 별다방 테이크 아웃 주문 애플리케이션을 모티브로 프로젝트를 진행하였습니다.

## ☕ 서버 구조도
![](https://user-images.githubusercontent.com/44136364/137728757-93fa3559-2446-4dc4-b1e8-e70a828486ef.png)


## ☕ 프로젝트 주요 관심사 (진행중)

### 1. 단순 기능 구현에만 집중하지 않기

* 단순히 기능을 빠르게 구현하는것보다 중요한 것은 `사용 기술을 정확하게 이해`하고 사용하는 것이라고 생각합니다.
* 새로운 기술을 적용할 때 `기술서적과 공식문서를 통해 해당 기술에 대한 깊이 있는 학습`을 진행하여 이를 최대한 코드에 녹이기 위해 노력했습니다.

### 2. 대용량 트래픽 환경에서도 안정적인 서비스 구현하기

* 프로젝트를 시작하게된 동기와 최종목표는 대용량 트래픽에도 견고하고 안정적인 서비스를 개발하는 것입니다.
* 틈틈이 부하테스트와 모니터링을 통해 이를 지키기 위해 노력했습니다.

### 3. 테스트 코드 작성에 충실하기

* 올바른 기능 구현과 `예상한대로 코드가 동작하는지 검증`하기 위해 `새로운 기능을 구현할 때 마다 통합테스트 및 단위테스트를 구현`하도록 하였습니다.
* 새로운 개발자가 합류했을 경우 기능을 추가하거나 수정할 때 테스트 코드를 통해 문제가 없음을 보장하고 자신감을 줌으로써 빠르게 프로젝트에 적응할 수 있습니다.
* 또한 테스트 코드는 작성된 코드에 대한 `문서` 자체의 역할을 하기도 합니다.

### 4. 문서화

* 새로운 개발자가 중간에 프로젝트에 참여하더라도 [Wiki](https://github.com/f-lab-edu/cafe-guide-book/wiki)와 같은 문서를 통해 프로젝트에 대해 쉽게 이해하고 적응할 수 있도록 하였습니다.
* PR, Issues, Commit Template을 통해 협업하는 개발자간의 `커뮤니케이션 미스에 대한 비용을 최소화` 하기 위해 노력하였습니다.

### 5. 사소한 이슈라도 끝까지 파헤쳐서 원인 파악하기

* 발생한 이슈가 사소한것일지라도 추후에 다시 문제가 생기지 않도록 예방해야 합니다.
* 문제의 원인을 파악하기 위한 학습을 진행하였고 이를 [기술블로그](https://github.com/f-lab-edu/cafe-guide-book/wiki/2.-%EC%9D%B4%EC%8A%88-%EB%B0%8F-%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-%EA%B4%80%EB%A0%A8-%EA%B8%B0%EC%88%A0%EB%B8%94%EB%A1%9C%EA%B7%B8-%ED%8F%AC%EC%8A%A4%ED%8C%85)에 정리하였습니다.

## 기술블로그

### [김민성 블로그](https://blog.minseong.kim)

- [nGrinder과 Pinpoint를 통한 부하 테스트 및 힙덤프 분석](https://blog.minseong.kim/ngrinder-test-pinpoint-monitor.html)
- [부하테스트를 통한 HikariCP의 적절한 Connection Pool Size 도출](https://blog.minseong.kim/db-connection-pool-size.html)
- [Redis Pipeline를 통한 네트워크 병목 해결](https://blog.minseong.kim/about-redis-pipelining.html)
- [MySQL Replication을 통한 부하 분산](https://blog.minseong.kim/spring-with-mysql-replication.html)
- [@Async를 통한 비동기 처리](https://blog.minseong.kim/async-principle.html)
- [Junit5와 Mockito Framwork를 통한 단위테스트, 통합테스트 필수 작성 및 지속적인 리팩토링](https://blog.minseong.kim/test-refactoring-with-parameterresolver.html)
- 이슈 트래킹 중 스프링 내부 동작원리에 대한 깊이있는 학습
   - [JdbcTemplate 등에 적용된 템플릿 콜백 패턴 분석](https://blog.minseong.kim/spring-template-callback-pattern.html)
   - [DispatcherServlet에 대한 기본전략 분석](https://blog.minseong.kim/dispatcherservlet-default-strategy.html)
   - [@Autowired의 내부 동작원리 분석](https://blog.minseong.kim/autowired-deep-dive.html)
   - [@EnableWebMvc의 내부 동작원리 분석](https://blog.minseong.kim/enablewebmvc-strategy.html)

### [정선주](https://velog.io/@jsj3282)

- [메모리 누수를 방지하기 위한 자바 힙 메모리 설정](https://velog.io/@jsj3282/Heap-Memory-Leak-OutOfMemoryError)
- [요청 본문에서 JSON 메시지를 읽어들이거나 작성할 때 쓰이는 Spring HTTP 메시지 컨버터](https://velog.io/@jsj3282/%EC%8A%A4%ED%94%84%EB%A7%81-MVC-%EC%84%A4%EC%A0%959-WebMvcConfigure-HTTP-%EB%A9%94%EC%8B%9C%EC%A7%80-%EC%BB%A8%EB%B2%84%ED%84%B0-JSON-XML)
- [REST API란?](https://velog.io/@jsj3282/REST-API)
- [객체 지향 설계 5원칙](https://velog.io/@jsj3282/%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84-5%EC%9B%90%EC%B9%99-SOLID)

## ☕ 사용기술

* Java 11
* Spring Boot
* JUnit5
* Mockito
* MySQL
* MyBatis
* Redis
* Jenkins
* nGrinder
* Pinpoint
* AWS
