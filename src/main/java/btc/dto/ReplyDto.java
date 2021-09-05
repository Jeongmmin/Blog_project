package btc.dto;

import lombok.Data;

@Data
public class ReplyDto {
	private int seq;
	private int blogSeq;
	private int repleSeq;
	private String creatorId;
	private String createdDate;
	private String contents;
}
