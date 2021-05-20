# **프로젝트 세팅 및 실행**

**Backend**

빌드 및 실행

```
$ cd backend/FarmDiary_Board_Service/
$ ./gradlew build -x test
$ java -jar ./build/libs/*.jar
```



**Frontend**

.env.local 설정

```
VUE_APP_SERVER_URL=http://localhost:8877
VUE_APP_SERVER_URL2=http://localhost:8088
```

빌드 및 실행

```
$ cd frontend
$ npm i
$ npm run serve
```

