package com.athome.feel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.athome.feel.model.DiaryDto;
import com.athome.feel.model.SentimentDto;
import com.athome.feel.model.service.DiaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/diary")
@Api("Diary Controller API V1")
public class DiaryController {

	private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	DiaryService diaryService;

//	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
//	@GetMapping("/{articleno}")
//	public ResponseEntity<BoardDto> getArticle(@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno) throws Exception {
//		logger.info("getArticle - 호출 : " + articleno);
//		boardService.updateHit(articleno);
//		return new ResponseEntity<BoardDto>(boardService.getArticle(articleno), HttpStatus.OK);
//	}
	
	
//	@ApiOperation(value = "isbn에 해당하는 도서평 목록을 반환한다.", response = List.class)
//	@GetMapping("{articleno}")
//	public ResponseEntity<List<CommentDto>> listComment(@PathVariable("articleno") String articleno) {
//		logger.debug("listComment - 호출");
//		return new ResponseEntity<List<CommentDto>>(commentService.list(articleno), HttpStatus.OK);
//	}
//
	@ApiOperation(value = "member_id에 해당하는 sentimentName과 count를 반환한다.", response = List.class)
	@GetMapping("/sent/{member_id}")
	public ResponseEntity<List<SentimentDto>> listSentiment(@PathVariable("member_id") String member_id) {
		logger.debug("listSentiment - 호출 / "+ member_id);
		return new ResponseEntity<List<SentimentDto>>(diaryService.listSentiment(member_id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "member_id에 해당하는 다이어리 목록을 반환한다.", response = List.class)
	@GetMapping("{member_id}")
	public ResponseEntity<List<DiaryDto>> list(@PathVariable("member_id") String member_id) {
		logger.debug("listComment - 호출");
		return new ResponseEntity<List<DiaryDto>>(diaryService.list(member_id), HttpStatus.OK);
	}
	@ApiOperation(value = "새로운 글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createDiary(@RequestBody DiaryDto diaryDto) {
		logger.debug("createDiary - 호출");
		if(diaryService.create(diaryDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
//
//	@ApiOperation(value = "글번호가 comment_no에 해당하는 도서평을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
//	@PutMapping
//	public ResponseEntity<String> modifyComment(@RequestBody CommentDto commentDto) {
//		logger.debug("modifyComment - 호출");
//		logger.debug("" + commentDto);
//		System.out.println("댓글 수정하자!!!"  + commentDto);
//		if(commentService.modify(commentDto)) {
//			System.out.println("댓글 수정 성공!!!");
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//	}
//
//	@ApiOperation(value = "글번호가 comment_no에 해당하는 도서평을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
//	@DeleteMapping("{commentNO}")
//	public ResponseEntity<String> deleteBook(@PathVariable("commentNO") int commentNO) {
//		logger.debug("deleteBook - 호출");
//		if(commentService.delete(commentNO)) {
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//	}
	
}
