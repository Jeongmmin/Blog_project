package btc.service;

import java.util.List;

import btc.dto.BlogDto;

public interface BlogService {
	
//	게시판 목록 불러오기
	List<BlogDto> selectBlogBoardList() throws Exception;

//	게시판 상세내용 보기
	BlogDto selectBlogBoardDetail(int seq) throws Exception;
	
//	게시물 입력하기
	void blogBoardInsert(BlogDto board) throws Exception;

//	게시물 수정하기
	void blogBoardUpdate(BlogDto board) throws Exception;

//	게시물 삭제하기
	void blogBoardDelete(int seq) throws Exception;
}
