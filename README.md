일정 관리 앱 개발 프로젝트

해당 프로젝트는 스파르타클럽의 내일배움캠프에서 진행하는 과제용 프로젝트입니다.

버전에 따라 브랜치를 나누었으며 내용은 아래와 같습니다

LV1
: 일정 생성 기능 구현 (일정 생성시 제목, 내용, 작성자명, 비밀번호, 작성/수정일을 포함할 것) (필수 구현 기능) 

LV2
: 일정 조회 기능 구현 (id로 일정 선택 조회, 작성자명으로 관련 목록 전부 조회)(필수 구현 기능)

LV3
: 일정 수정 기능 구현 (일정 제목과 작성자명을 수정할 수 있도록 구현, 비밀번호를 검사하여 수정 여부를 결정할 수 있도록 작업)(필수 구현 기능)

LV4
: 일정 삭제 기능 구현 (비밀번호를 검사하여 수정 여부를 결정할 수 있도록 작업)(필수 구현 기능)

API 명세서
- API 개요
일정 생성 (Create)
메서드 : POST
url : http://localhost:8080/schedules
request :{
    "title": "제목",
    "content":"내용",
    "name": "이름",
    "password": "비밀번호"
}
response :{
  "id": 아이디,
  "title": "제목",
  "content": "내용",
  "name": "이름",
  "createdAt": "생성일",
  "modifiedAt": "수정일"
}

일정 조회 (Read)
단 건 조회
메서드 : Get
url : http://localhost:8080/schedules/{scheduleId}
response :{
  "id": 아이디,
  "title": "제목",
  "content": "내용",
  "name": "이름",
  "createdAt": "생성일",
  "modifiedAt": "수정일"
}
다 건 조회
메서드 : Get
url : http://localhost:8080/schedules?name=이름
response :{
  "id": 아이디,
  "title": "제목",
  "content": "내용",
  "name": "이름",
  "createdAt": "생성일",
  "modifiedAt": "수정일"
}

일정 수정 (Update)
메서드 : Put
url : http://localhost:8080/schedules/{scheduleId}
request :{
    "title": "제목",
    "name": "이름",
    "password": "비밀번호"
}
response :{
  "id": 아이디,
  "title": "변경된 제목",
  "content": "내용",
  "name": "변경된 이름",
  "createdAt": "생성일",
  "modifiedAt": "수정일"
}
에러 발생시 
{
  "error": "비밀번호가 틀렸습니다."
}

일정 삭제 (Delete)
메서드 : Delete
url : http://localhost:8080/schedules
request :{
    "id": 아이디,
    "password": "비밀번호"
}
에러 발생시 
{
  "error": "비밀번호가 틀렸습니다."
}


ERD
<img width="359" height="210" alt="image" src="https://github.com/user-attachments/assets/5fcdfb00-4ff6-427c-a9f0-a63673d2e1bf" />





트러블 슈팅 및 해당 과제를 수행하며 공부한 것들을 작성한 TIL블로그 링크
https://blog.naver.com/shortring/224064760828
https://blog.naver.com/shortring/224066025454
