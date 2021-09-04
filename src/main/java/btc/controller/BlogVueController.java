package btc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import btc.dto.BlogDto;
import btc.service.BlogService;

@RestController
public class BlogVueController {
	@Autowired
	private BlogService bService;
	
//	전체 게시판 불러오기
	@RequestMapping(value="/blogList", method=RequestMethod.GET)
	public Object SelectBlogBoardList() throws Exception {
		List<BlogDto> dataList = bService.selectBlogBoardList();
		
		return dataList;
	}
	
//	지정한 게시판 글 확인하기
	@RequestMapping(value="/blogDetail", method=RequestMethod.GET)
	public Object SelectBlogBoardDetail(@RequestParam("seq") int seq) throws Exception {
		BlogDto board = bService.selectBlogBoardDetail(seq);
		return board;
	}
	
//	detailNew 로 받는 컨트롤러 메서드 필요
	
//	새로운 게시글 등록하기
	@RequestMapping(value="/blogBoardInsert", method=RequestMethod.POST)
	public void BlogBoardInsert(@RequestBody BlogDto board) throws Exception {
		bService.blogBoardInsert(board);
	}
	
//	게시글 수정하기
	@RequestMapping(value="/updateBlogBoard", method=RequestMethod.PUT)
	public void BlogBoardUpdate(@RequestBody BlogDto board) throws Exception {
		bService.blogBoardUpdate(board);
	}
	
//	게시글 삭제하기
	@RequestMapping(value="/deleteBlogBoard", method=RequestMethod.DELETE)
	public void BlogBoardDelete(@RequestParam("seq") int seq) throws Exception {
		bService.blogBoardDelete(seq);
	}
}
