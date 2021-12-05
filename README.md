# Description
- auth : 77kkyu
- development environment : spring-boot
- technology : API Gateway, Service-Discovery (Eureka), Configuration Server

> **_Spring Cloud로 MSA를 구축하면서 느낀 점_**
> 
> 각 서비스들의 독립성 때문에 처음부터 프로젝트 세팅을 MSA로 가면 좋겠다는 생각을 했지만
> 
> 사실 초기에는 대용량 트래픽 방어를 안 해도 된다 그리고 개발 비용이 엄청 들어가는 거 같다
> 
> 우리가 즐겨보는 넷플릭스도 완전한 MSA로 가는데 7년(?)이 걸렸다고 했고 생존을 위해 도입했다고 알고 있다
> 
> 서비스가 커지는 데이터를 보고 차후 MSA로 가는 방향으로 생각하는 것도 나쁘지 않을 거 같다
> 
> 또한 트랜잭션에 관한 문제는 어떻게 풀 것인가... SAGA패턴을 공부해봐야겠습니다!

---

# Spring Cloud

``` text
스프링 클라우드란 마이크로서비스의 개발, 빌드, 배포 운영에 필요한
아키텍처를 쉽게 구성할 수 있도록 도와주는 Spring Boot의 기반 프레임워크입니다
```

> 제가 실제로 구축하면서 각 서비스들이 연동이 되지 않아 찾아봤는데
> Spring boot에서 Spring Cloud를 사용할 때에는 반듯이 호환되는 버전을 사용해야 합니다

### 스프링 클라우드 버전 정보입니다

|Release Train|Boot Version|
|------|---|
|2020.0.x aka Ilford|2.4.x, 2.5.x (Starting with 2020.0.3)|
|Hoxton|2.2.x, 2.3.x (Starting with SR5)|
|Greenwich|2.1.x|
|Finchley|2.0.x|
|Edgware|1.5.x|
|Dalston|1.5.x|

---

## Service-Discovery (Eureka)
Service Registry, Discovery
- 서비스 동적 등록 및 정보 공유
- 서비스 동적 발견
- 상태 모리터링

``` text
Eureka Server는 Eureka Client에 해당하는 마이크로서비스들의 상태 정보가 등록되어있는 레지스트리를 가지고 있습니다
그리고 실시간 모니터링을 하기 위해 등록된 후에 30초마다 통신을 합니다
그렇기 때문에 유레카 서버에서는 등록된 각각의 마이크로서비스의 상태들을 확인할 수 있고
유레카 서버를 구축하면 각각 마이크로서비스의 상태 관리 비용을 줄일 수 있습니다
```

[Service-Discovery](https://github.com/77kkyu/spring-cloud-msa/tree/main/service-discovery)

---

## Configuration Server

``` text
마이크로서비스들의 시스템 환경 설정을 Configuration Server에서 실시간으로
전파 및 변경을 할 수 있습니다
(Git Repository에 시스템 환경을 저장해 두고 불러와서 전파할 수 있습니다)
```

[Configuration Server](https://github.com/77kkyu/spring-cloud-msa/tree/main/server-configs)


---

## API Gateway

``` text
gateway는 마이크로서비스들의 엔드포인트를 하나로 통일하고
트래픽에 따라 알맞은 서비스로 라우팅 할 수 있는 기능을 제공합니다
유입되는 모든 요청/응답을 관리할 수 있게 되므로 gateway Server에 인증 및 보안을 적용하기가 좋습니다

- 라우트(Route) : 목적지 URI, 조건자 목록과 필터 목록을 식별하기 위한 고유 ID로 구성이 되고
    모든 조건자가 충족됐을 때만 매칭 됩니다


- 조건자(Predicates) : 각 요청을 처리하기 전에 실행되는 로직으로 헤더와 입력된 값 등 다양한 HTTP 요청이 정의된 기준에 맞는지를 찾습니다


- 필터(Filters) : HTTP 요청 또는 응답을 수정할 수 있게 하고, 다운스트림 요청을 보내기 전이나 후에 수정할 수 있습니다
    라우터 필터는 특정 라우트에 한정됩니다
```

[API Gateway](https://github.com/77kkyu/spring-cloud-msa/tree/main/gateway)