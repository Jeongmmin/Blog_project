# 블로그 Read Me

> Mysql에 작성한 DB를 Spring과 연결시키고, Spring과 Vue.js를 axios통신으로 연결하여 블로그로 만드는 작업을 했습니다.  
전체적으로 게시판의 형태지만, 우리가 아는 블로그와 유사한 UI를 적용하여 프론트 부분을 꾸몄고, DB를 하나 더 추가하여 댓글기능도 적용하여 각 글마다 댓글도 달 수 있도록 구현하였습니다.  

<p align="center">
<img src="https://user-images.githubusercontent.com/82005305/136494803-f0c81ee4-7101-4a12-a518-5e83628d7300.gif">
</p>
</br>

<p align="center">
<img src="https://user-images.githubusercontent.com/82005305/136492194-b49d5936-2d2d-4c9d-9b88-2275cbc035af.gif">
</p>
</br>

# Installation

## **Project setup**

```jsx
npm install
```

# 기능설명

## 네비게이션바

- 내블로그 : 블로그 첫 화면으로 이동
- 글쓰기 : 글쓰기 페이지로 이동

## 메인화면

- 목록열기 : 눌렀을 때 아코디언 형태로 게시물 리스트가 출력 됨
- 리스트의 글 제목 : 눌렀을 때 해당 글로 연결 됨
- 사진+글 : 눌렀을 때 해당 페이지로 연결

## 글 상세 화면

- 수정 : 글 수정 화면으로 연결
- 삭제 :  글이 삭제 됨
- 댓글작성 : 글쓴이와 내용을 입력하고 등록 버튼을 누르면 댓글이 등록 됨
- 목록으로 : 이전 페이지의 목록으로 돌아감
