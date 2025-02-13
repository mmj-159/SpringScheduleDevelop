## 1. 일정 API 설계하기
| 기능          | method | endpoint          | request  | response |
|-------------|--------|-------------------|----------|----------|
| 유저 생성       | `POST`   | `/users/signup`   | 요청 body  | 등록 정보    |
| 유저 로그인      | `POST`   | `/auth/login`     | 요청 body  | 등록 정보    |
| 유저 로그아웃     | `POST`   | `/auth/logout`    | 요청 body  | 등록 정보    |
| 유저 비밀번호 변경  | `PATCH`   | `/users/{id}`       | 요청 body  | 등록 정보    |
| 새로운 일정 생성   | `POST`   | `/schedules`      | 요청 body  | 등록 정보    |
| 일정 단건 조회    | `GET`  | `/schedules/{id}` | 요청 param | 단건 응답 정보 |
| 일정 다건 조회    | `GET`  | `/schedules`      | 요청 param | 다건 응답 정보 |
| 일정 단건 전체 수정 | `PUT`  | `/schedules/{id}` | 요청 body  | 수정 정보    |
| 일정 삭제       | `DELETE` | `/schedules/{id}` | 요청 param | -        |


![schedule.png](schedule.png)