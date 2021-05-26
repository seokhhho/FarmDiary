# 전원일기

---

[TOC]

---



## Intro

> 2021년 SSAFY 2학기 자율프로젝트로 `전원일기`라는 도서농업 포털 서비스를 개발하였다.
>
> 개발기간: 2021년 4월 12일 - 2021년 5월 21일
> 공공데이터 포털에서 제공하는 데이터를 토대로 라벨링하여 식물이미지가 입력되었을때 해당 식물과 질병가능성 추측하는 Image Classifier구현이 목표

### Service

- 병충해 판단을 AI 알고리즘으로 진단한다.
- 사용자간의 **나눔 게시판** 및 **자유게시판** 서비스를 제공한다.

### Compatibility

- 모델링은 `tensorflow 1.14.0`, `keras 2.3.1`, `python 3.7.0`, `numpy 1.15.4`, `libopencv 3.4.2`, `pillow 8.2.0`, `pip 21.0.1`, `pymongo 3.11.4`, `scikit-learn 0.19.1`, `scipy 1.1.0` 버전에서 테스트되었다.
- 데이터 수치화(그래프)는 `matplotlib 3.3.2` 버전에서 테스트 되었습니다.

## AI(병충해 진단)
- 최종 목표
![KakaoTalk_20210526_155345150](https://user-images.githubusercontent.com/77223675/119620182-ae372a00-be3f-11eb-8b23-5c61622c693d.png)


## 서비스 소개

> `전원일기` 플랫폼에서는 크게 **병충해 진단 및 검색, 나눔 게시판 및 자유 게시판**의 2가지 세부서비스를 제공한다.
>
> - In this platform, users can utilize 2 services of `isease and pest diagnosis and search`,`sharing bulletin board and free bulletin board`

**Main Page**

- 메인 페이지로는 **추천태그별 캠핑장 리스트**가 띄워지게 된다.



- 로그인과 회원가입을 을 통해 개인별 추천서비스를 받을 수 있고, 좋아요와 댓글을 남길 수 있다.














- 캠핑장 클릭시 Detail UI








### 1. 키워드 검색

- 태그가 아닌 일반검색으로 검색하면 해당 검색어를 포함된(이름또는 지역) 캠핑장 리스트가 출력된다.





### 2. 태그로 검색

- 태그로 검색하게 되면, 캠핑장의 태그가 해당태그인 리스트를 출력 한다.





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

