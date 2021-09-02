package btc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import btc.dto.AxiosBoardDto;
import btc.service.VueBoardService;

@RestController
public class RestApiVueController {
	@Autowired
	private VueBoardService vbService;
	
	@RequestMapping(value="/vue/axiosBoardList", method=RequestMethod.GET)
	public Object vueSelectBoardList() throws Exception {
		List<AxiosBoardDto> dataList = vbService.vueSelectBoardList();
		
		return dataList;
	}
//	지정한 게시판 글 확인하기
	@RequestMapping(value="/vue/axiosBoardDetail", method=RequestMethod.GET)
	public Object vueSelectBoardDetail(@RequestParam("seq") int seq) throws Exception {
		AxiosBoardDto board = vbService.vueSelectDetailBoard(seq);
		return board;
	}
	
//	detailNew 로 받는 컨트롤러 메서드 필요
	
//	새로운 게시글 등록하기
	@RequestMapping(value="/vue/axiosBoardInsert", method=RequestMethod.POST)
	public void vueBoardInsert(@RequestBody AxiosBoardDto board) throws Exception {
		vbService.vueInsertBoard(board);
	}
	
//	게시글 수정하기
	@RequestMapping(value="/vue/axiosBoardUpdate", method=RequestMethod.PUT)
	public void vueBoardUpdate(@RequestBody AxiosBoardDto board) throws Exception {
		vbService.vueUpdateBoard(board);
	}
	
//	게시글 삭제하기
	@RequestMapping(value="/vue/axiosBoardDelete", method=RequestMethod.DELETE)
	public void vueBoardDelete(@RequestParam("seq") int seq) throws Exception {
		vbService.vueDeleteBoard(seq);
	}
}
