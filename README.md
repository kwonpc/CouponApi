# CouponApi
==============

## API 명세
1. 쿠폰 목록 조회 API 
상품 금액을 입력받아 사용 가능한 쿠폰 목록을 조회합니다. 
쿠폰 만료일시가 가까운 순으로 조회되어야 합니다. 
쿠폰 만료일시가 같은 경우 할인 금액이 큰 순으로 조회되어야 합니다. 
2. 쿠폰 사용 처리 API 
쿠폰 id와 상품 금액을 입력받고 쿠폰을 사용처리 합니다. (status를 USED로 업데이트) 
해당 쿠폰이 사용 가능한 쿠폰이 아닌 경우 오류를 응답합니다. 
사용 처리의 응답은 상품 금액, 결제 금액(상품 금액에서 할인 금액을 차감하고 남은 금액), 실제 할인
금액(쿠폰의 할인금액 중 사용된 금액)을 포함해야 합니다. 
예시) 
1. 3000원 상품에 5000원 쿠폰을 사용하는 경우
-> 상품금액 : 3000, 결제금액 : 0, 실제 할인 금액 : 3000 
2. 5000원 상품에 3000원 쿠폰을 사용하는 경우
-> 상품금액 : 5000, 결제금액 : 2000, 실제 할인 금액 : 3000 
3. 3000원 상품에 최소 사용 가능 상품 금액이 5000원인 5000원 쿠폰을 사용하는 경우
-> 사용불가
* 사용가능한 쿠폰이란? 
현재 시각이 쿠폰 사용 가능일시와 쿠폰 사용 만료일시 사이에 포함된다. 
최소 사용 가능 상품 금액이 상품금액보다 작거나 같다. 
쿠폰 상태가 사용가능한 상태이다.

## 요구사항
* spring boot로 구현해주세요.  
* README.md 파일에 프로젝트 소개 및 문제해결 전략, 프로젝트 빌드와 실행 방법을 명시해주세요. 
* Database를 사용하고 Schema를 산출물에 포함해주세요. 
* Unit Test 코드를 작성해주세요. 
* 요구사항에 명시되지 않은 부분은 자유롭게 구현해도 좋습니다.

## API스펙
### 쿠폰 목록 조회 API 
### /coupon/availableCouponList/{amount}
|구분|파라미터|설명|
|---|---|---|
|요청|amount|상품금액|
|---|---|---|
|HTTP응답코드|200|정상|
|HTTP응답코드|400|비정상|
|---|---|---|
|응답(json)|resultMsg|응답메시지|
|응답(json)|couponList|쿠폰리스트|
|응답(json)|- id|쿠폰id|
|응답(json)|- useMinAmount|최소 사용 가능 상품 금액|
|응답(json)|- discountAmount|할인 금액|
|응답(json)|- usableFrom|쿠폰 사용 가능일시|
|응답(json)|- usableUntil|쿠폰 사용 만료일시|
|응답(json)|- status|쿠폰 상태(NORMAL:사용가능, USED:사용됨|

### 쿠폰 사용 처리 API 
### /coupon/couponPayment/{id}/{amount}
|구분|파라미터|설명|
|---|---|---|
|요청|id|쿠폰id|
|요청|amount|상품금액|
|---|---|---|
|HTTP응답코드|200|정상|
|HTTP응답코드|400|비정상|
|---|---|---|
|응답(json)|resultMsg|응답메시지|
|응답(json)|productAmount|상품금액|
|응답(json)|discountAmount|실제 할인금액|
|응답(json)|paymentAmount|결제 금액|

## Database Table Schema
### COUPON : 쿠폰 목록
|필드명|데이터타입|key|설명|
|---|---|---|---|
|id|int|PK|쿠폰ID|
|use_min_amount|int|  |최소 사용 가능 상품 금액|
|discountAmount|int|  |할인 금액|
|usableFrom|date|  |쿠폰 사용 가능일시|
|usableUntil|date|  |쿠폰 사용 만료일시|
|status|varchar(10)|  |쿠폰 상태(NORMAL:사용가능, USED:사용됨|



## 문제해결
쿠폰의 동시 사용 제한을 위해 JPA의 PESSIMISTIC_WRITE 모드를 사용
- 동일 쿠폰 ID의 사용을 동시에 진행할 경우 모든 요청에 대하여 할인이 적용되는 것을 막기 위해 DB에서 해당 쿠폰 ROW에 LOCK을 걸고
  읽기와 쓰기를 제한하여 다른 요청에서 할인이 되는 것을 방지한다. 


## 프로젝트 빌드 및 실행 방법
### 개발 환경 
- JAVA 1.8
- Eclipse Java EE IDE for Web Developers Photon ( STS Plugin 설치 )
- Dependencies : spring-boot, JPA, H2, lombok ..

### 빌드 및 실행 방법
- Git Repositoires 에 https://github.com/kwonpc/CouponApi.git 등록 후 Import Projects 로 내려받기
- 내려받은 프로젝트를 Maven 빌드
- Run AS > Junit Test 진행하여 테스트 결과 확인
