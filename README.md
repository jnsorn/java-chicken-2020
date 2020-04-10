# java-chicken-2019

## 구현 기능 목록
1. 사용자가 원하는 기능 입력받기 (주문등록 / 결제하기 / 프로그램 종료)
※ 예외처리
    - null 혹은 빈 문자열일 경우 
    - 숫자가 아닌 경우
    - 1,2,3이 아닌 경우

2. 원하는 기능에 따라 실행

2-1. 주문등록
- 테이블 목록 출력
- 테이블 번호 입력받기
    ※ 예외처리
        - null 혹은 빈 문자열일 경우 
        - 숫자가 아닌 경우
        - 테이블 번호가 아닌 경우
- 메뉴판 출력
- 등록할 메뉴를 입력받기
    ※ 예외처리
        - null 혹은 빈 문자열일 경우 
        - 숫자가 아닌 경우
        - 메뉴 번호가 아닌 경우
- 수량을 입력받는다. (한 메뉴의 최대 수량 99개)
    ※ 예외처리
        - null 혹은 빈 문자열일 경우 
        - 숫자가 아닌 경우
        - 0이하, 99 이상인 경우
- 주문이 완료되면 해당 테이블에 \ 표시를 한다. 

2-2. 결제하기
- 테이블 목록을 보여준다.
- 테이블 번호를 입력받는다.
    ※ 예외처리
        - null 혹은 빈 문자열일 경우 
        - 숫자가 아닌 경우
        - 테이블 번호가 아닌 경우
- 주문 내역을 보여준다
- 결제방법을 입력받는다
    ※ 예외처리
        - null 혹은 빈 문자열일 경우 
        - 1 혹은 2가 아닌 경우
- 계산한다.
    - 결제 유형에 따라 할인률이 달라진다.
    - 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.
        - 10~19개: 1만원, 20~29개: 2만원...
    - 현금 결제는 5%가 할인되며, 할인된 금액에서 한 번 더 할인이 가능하다.
    ※ 예외처리
        - 주문이 없는 테이블을 계산할 경우
- 결제할 금액을 출력한다.

2-3. 프로그램 종료
- 정상 종료

* 예외처리 시
주문 혹은 결제가 불가능한 경우 그 이유를 보여주고, 다시 주문 혹은 결제가 가능하도록 해야한다. 