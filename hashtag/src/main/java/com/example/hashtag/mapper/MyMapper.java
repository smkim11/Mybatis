package com.example.hashtag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.hashtag.dto.Hashtag;

@Mapper
public interface MyMapper { // BoardMapper+HashtagMapper
	
	void insertHashtag(Hashtag hashtag);
	
	List<String> selectTagsByBoard(int boardNo);
	List<Map<String,Object>> selectBoardListAndTags(); // 조인
}
