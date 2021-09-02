package btc.dto;

import lombok.Data;

@Data
public class AxiosBoardDto {
	private int seq;
	private String title;
	private String contents;
	private String creatorId;
	private String createdDate;
	private String updatedDate;
	private String updaterId;
	private String hitCnt;
}
