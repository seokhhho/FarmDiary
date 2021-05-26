# 전원일기

---

[TOC]

---



## Intro

> 2021년 SSAFY 2학기 자율프로젝트로 `전원일기`라는 도서농업 포털 서비스를 개발하였다.
>
> 개발기간: 2021년 4월 12일 - 2021년 5월 21일
>

### Service

- 병충해 판단을 **경섭이형 알고리즘 적어주세요** AI 알고리즘으로 진단한다.
- 사용자간의 **나눔 게시판** 및 **자유게시판** 서비스를 제공한다.

### Compatibility

- Front-end `openjdk 11.0.9.1`, `npm 6.14.10`, `vue/cli 4.5.19` 버전에서 테스트되었다.
- Back-end `python 3.6.8`,`spring boot 2.3.10` 버전에서 테스트 되었다.
- We tested the code using `openjdk 11.0.9.1`, `npm 6.14.10`, `vue/cli 4.5.19`.
- 데이터베이스는 `Mongodb`에서 작성되었다.
- We created database using `MongoDB`
- AWS EC2를 이용하여 프로젝트를  MSA로 서버에 배포하도록 노력히하였다.
- Using AWS EC2, I tried to deploy the project to the server as MSA.

## AI(병충해 진단)
- AI폴더 안 **read me** 파일 확인

## 서비스 소개

> `전원일기` 플랫폼에서는 크게 **병충해 진단 및 검색, 나눔 게시판 및 자유 게시판**의 2가지 세부서비스를 제공한다.
>
> - In this platform, users can utilize 2 services of `isease and pest diagnosis and search`,`sharing bulletin board and free bulletin board`

**Main Page**

- 메인 페이지로는 **병충해 진단** 페이지로 이동하는 버튼이 있다.
- 사용자 위치에 따라 **일주일 날씨 정보**를 제공한다.

![메인 페이지](https://user-images.githubusercontent.com/62299120/119615386-4cc08c80-be3a-11eb-8454-59d41c7ce0e6.PNG)


### 1. 로그인 페이지

- 아이디와 비밀번호로 로그인이 가능하다.
- 정규식에 맞지 않으면 로그인이 되지 않는다.
- 회원가입으로 이동하는 버튼이 있다.

![로그인 페이지](https://user-images.githubusercontent.com/62299120/119615706-a7f27f00-be3a-11eb-980a-d937551731bb.PNG)

### 2. 회원가입 페이지

- 아이디, 비밀번호, 비밀번호 확인, 이름, 이메일로 회원가입이 가능하다.
- 정규식에 맞지 않으면 회원가입이 가능하지 않고 아이디 이메일이 존재할 경우 회원가입이 되지 않는다.

![회원가입 페이지](https://user-images.githubusercontent.com/62299120/119615708-a923ac00-be3a-11eb-9dba-fd37ef4edb18.PNG)


### 3. 


## 설치 안내

> `git clone`을 한 후 아래의 작업을 진행해야 프론트 서버를 실행할 수 있다.

**1단계: npm 설치**

- `frontend` 프로젝트 폴더에서 npm을 설치한다.

```bash
npm install
npm run serve
```

**2단계: 환경변수 설정**

- `frontend` 폴더 내의 최상위 창에서 환경변수 `.env.local`이라는 파일을 생성한다.

- 환경변수로 관리하는 데이터는 다음과 같다.

  ```markdown
  ## .env.local
  
  VUE_APP_SERVER_URL=<서버 URL>
  VUE_APP_MAP_API_KEY=<카카오 지도 API Javascript 키>
  VUE_APP_SERVER_URL_C=<크롤링 서버 URL>
  ```
  
- `backend` 프로젝트 폴더에서 모듈을 설치한다.
```bash
pip install -r requirements.txt
python manage.py runserver
```

> 


## File Manifest

>**Naming Rule**
>
>- 파일 명은 `PascalCase`를 따른다.
>- 변수 및 함수명은 `snake_case`를 따른다.

### Frontend

- 폴더 구조는 `member`, `app`, `campsite`로 구분한다.

  ```markdown
  1. member
  - 회원계정 관련
  2. app
  - 메인페이지
  3. campsite
  - 캠핑장 추천 서비스 관련

### Backend


 -폴더구조는 서버 `Back-end`, 앱 단위 `main`, `camp`로 구분된다.
 
    
    1. DB 연동
    - python manage.py inspectdb (db 감지 및 model.py 코드 작성 용이)
        
    2.DB가 변경 되었을 시
    - python manage.py makemigrations
    - python manage.py migrate



### Database

### ERdiagram
![](Docs/img/erd.png)



## 저작권 및 사용권 정보

- 캠핑장 추천에서 사용되는 캠핑장 정보는 한국관광공사에서 제공하는 [캠핑장 정보 API]( http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList)를 활용하였다.


```markdown
- axios
- lodash
- vue bootstrap-vue bootstrap
- less less-loader
- mint-ui -S
- vue-awesome-swiper
- vuex
```



## 해결한 버그

> 코드를 서버에 올렸을 때 발생하는 주요 버그 및 그에 대한 해결법을 정리하였다.

**:Aws에 띄운 mysql과 Django가 연결되지 않는다.**

**원인**

- 계정에 대한 권한문제

**해결방안**

- 계정을 새로 생성하고, 해당 스키마에 대한 권한을 부여하여 해결했다.



## 알려진 버그

> 아직 없습니다.



## 배포


> https://j4a304.p.ssafy.io







***Copyright* © 2021 SSAFY_SEOUL3_TEAM4_캠퍼스**

