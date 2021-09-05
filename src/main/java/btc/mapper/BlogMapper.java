package btc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import btc.dto.BlogDto;
import btc.dto.ReplyDto;

@Mapper
public interface BlogMapper {

//	게시판 목록 불러오기
	List<BlogDto> selectBlogBoardList() throws Exception;

//	게시판 상세내용 보기
	BlogDto selectBlogBoardDetail(int seq) throws Exception;
	
//	게시물 내용 입력하기
	void blogBoardInsert(BlogDto board) throws Exception;

//	조회수 카운트 
	void vueCountUp(int seq) throws Exception;

//	게시물 수정하기
	void blogBoardUpdate(BlogDto board) throws Exception;

//	게시물 삭제하기
	void blogBoardDelete(int seq) throws Exception;
	
//	댓글 목록 불러오기
	List<ReplyDto> replyList(int blogSeq) throws Exception;
	
//	댓글 등록하기
	void replyInsert(ReplyDto board) throws Exception;
	
//	댓글 삭제하기
	void replyDelete(int seq) throws Exception;

}
