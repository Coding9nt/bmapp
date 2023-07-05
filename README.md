# bmapp
야구 관리 프로그램


김태일 [Github](https://github.com/james-taeil)
박민기 [Github](https://github.com/Coding9nt)


----

## Work

테이블 설계

```
create table stadium (
	id int auto_increment primary key,
  s_name varchar(50) not null,
  created_at timestamp not null
);

create table team (
	id int auto_increment primary key,
  t_name varchar(50) not null,
  created_at timestamp not null,
  stadium_id int,
  foreign key(stadium_id) references stadium(id)
);

create table player (
	id int auto_increment primary key,
  p_name varchar(50) not null,
  position varchar(50) unique,
  created_at timestamp not null,
	team_id int,
  foreign key(team_id) references team(id),
	constraint uc_team_position unique (team_id, position)
);

create table out_player (
	id int auto_increment primary key,
  reason varchar(100) not null,
  created_at timestamp not null,
	player_id int,
  foreign key(player_id) references player_tb(id)
);
```
## 테이블 설계 

1. 테이블 모델 설계
- [ ] 테이블과 모델 설계
- [ ] 야구관리 프로그램을 위한 적절한 테이블의 필드가 구성되어 있다.

2. Service 생성
- [ ]  모든 기능에 대한 요청을 콘솔을 통해 입력받는다.
- [ ]  요청에 맞는 서비스에 메서드가 적절히 실행된다.
- [ ]  Scanner로 요청하는 모든 문자열을 파싱하는 메서드를 만들고 사용한다.

3. DAO 생성 ⇒ **김태일**, **박민기**
- [ ]  데이터베이스에 접근하는 DAO를 싱글톤 패턴으로 구현하였다.
- [ ]  쿼리로 해결할 수 있는 응답정보는 쿼리로 해결하였다. ex) 포지션별 팀 야구 선수 페이지를 Pivot을 사용하였다
- [ ]  DAO에서 디비로 부터 조회된 데이터를 DTO or Model에 옮길 수 있다.

4. 🤣기능 확인
- [ ]  야구장 등록, 야구장 목록보기 ⇒ **김태일**
- [ ]  팀 등록, 팀 목록보기 ⇒ **김태일**
- [ ]  선수 등록, 팀별 선수 목록 ⇒ **박민기**
- [ ]  선수 퇴출 등록, 선수 퇴출 목록 ⇒ **박민기**
- [ ]  포지션별 팀 야구 선수 페이지 ⇒ **박민기**

5. 완성도
- [ ]  DAO에서 예외 처리를 하고 있다.
- [ ]  변수명, 메서드명 작성시 일관성이 있다. (코드 컨벤션이 있다)
- [ ]  선수 퇴출 등록시에 트랜잭션 처리를 하고 있다. (Begin Transaction ~)
- [ ]  선수 퇴출 등록시에 reason 칼럼에 대한 Enum이 구현되어 있다.

----

## Branch Rule

이름 형식

- feat / 기능명

기능을 새로 추가할 때

> 예시1: feat/login
> 예시2: feat/logout

- fix / 기능명

버그 수정 시

> 예시1: fix/login
- modify / 기능명

기능 수정 시

> 예시1: modify/mainpage

----

## Commit type

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- modify: 수정
- correct: 문법 오류, 타입 변경, 오타 수정
- update: 버전 업데이트
- move : 코드나 파일 이동
- refactor: 코드 리팩토링
