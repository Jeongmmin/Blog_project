package btc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btc.dto.BlogDto;
import btc.dto.ReplyDto;
import btc.mapper.BlogMapper;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper bMapper;
	
//	게시판 목록 불러오기
	@Override
	public List<BlogDto> selectBlogBoardList() throws Exception {
		return bMapper.selectBlogBoardList();
	}
	
//	게시판 상세내용 보기
	@Override
	public BlogDto selectBlogBoardDetail(int seq) throws Exception {
		bMapper.vueCountUp(seq);
		return bMapper.selectBlogBoardDetail(seq);
	}
	
//	게시물 입력하기
	@Override
	public void blogBoardInsert(BlogDto board) throws Exception {
		bMapper.blogBoardInsert(board);
	}
	
//	게시물 수정하기
	@Override
	public void blogBoardUpdate(BlogDto board) throws Exception {
		bMapper.blogBoardUpdate(board);
	}
	
//	게시물 삭제하기
	@Override
	   public void blogBoardDelete(int seq) throws Exception {
		bMapper.blogBoardDelete(seq);
	  }
	
//	댓글 목록 불러오기
	@Override
	public List<ReplyDto> replyList(int blogSeq) throws Exception {
		List<ReplyDto> list = bMapper.replyList(blogSeq);
		return list;
	}
	
//	댓글 등록하기
	@Override
	public void replyInsert(ReplyDto board) throws Exception {
		bMapper.replyInsert(board);
	}
	
//	댓글 삭제하기
	@Override
	public void replyDelete(int seq) throws Exception {
		bMapper.replyDelete(seq);
	}
}
