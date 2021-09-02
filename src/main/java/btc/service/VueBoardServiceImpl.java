package btc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btc.dto.AxiosBoardDto;
import btc.mapper.VueBoardMapper;

@Service
public class VueBoardServiceImpl implements VueBoardService {

	@Autowired
	private VueBoardMapper vbMapper;
	
	@Override
	public List<AxiosBoardDto> vueSelectBoardList() throws Exception {
		return vbMapper.vueSelectBoardList();
	}
	
	@Override
	public void vueInsertBoard(AxiosBoardDto board) throws Exception {
		vbMapper.vueInsertBoard(board);
	}
	
	@Override
	public AxiosBoardDto vueSelectDetailBoard(int seq) throws Exception {
		vbMapper.vueCountUp(seq);
		return vbMapper.vueSelectDetaildBoard(seq);
	}
	
	@Override
	public void vueUpdateBoard(AxiosBoardDto board) throws Exception {
		vbMapper.vueUpdateBoard(board);
	}
	
	@Override
	   public void vueDeleteBoard(int seq) throws Exception {
	      vbMapper.vueDeleteBoard(seq);
	  }
}
