package btc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import btc.dto.AxiosBoardDto;

@Mapper
public interface VueBoardMapper {
	List<AxiosBoardDto> vueSelectBoardList() throws Exception;

	void vueInsertBoard(AxiosBoardDto board) throws Exception;

	AxiosBoardDto vueSelectDetaildBoard(int seq) throws Exception;
	void vueCountUp(int seq) throws Exception;

	void vueUpdateBoard(AxiosBoardDto board) throws Exception;

	void vueDeleteBoard(int seq) throws Exception;

}
