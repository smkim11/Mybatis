package com.example.hashtag.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hashtag.dto.Hashtag;
import com.example.hashtag.mapper.MyMapper;

@Service
@Transactional
public class MyService {
	private MyMapper myMapper;
	
	public MyService(MyMapper myMapper) {
		this.myMapper= myMapper;
	}
	
	// 태그를 포함한 리스트 출력
	public List<Map<String,Object>> selectBoardListAndTags(){
		return myMapper.selectBoardListAndTags();
	}
	
	// 번호에 맞는 태그들 출력
	public String getTagsByBoard(int boardNo){
		List<String> list = myMapper.selectTagsByBoard(boardNo);
		
		// Stream을 사용한 함수형 프로그래밍을 권고
		// 리스트를 문자열로 변환
		String result = String.join(",", list);
		return result;
	}

	// 태그 입력
	public void addTags(String tags, int boardNo) {
		// tags => 배열 => newList
		// Arrays.asList(tags.split(","))는 List형태, 정적이기 때문에 동적인 ArrayList로 변경
		List<String> newList = new ArrayList<String>(Arrays.asList(tags.split(","))); 
		
		List<String> oldList = myMapper.selectTagsByBoard(boardNo);
		// newList 과 oldList의 차집합결과 Set으로 변경 후 insert
		newList.removeAll(oldList); // newList-oldList == 차집합
		Set<String> set = new HashSet<String>(newList);
		for(String tag: set) { // set은 index(순서)가 없는 데이터와 반복이 안된다. 이터레이터로 반복해야한다, foreach문법으로는 반복가능
			System.out.println(tag);
			Hashtag hashtag = new Hashtag();
			hashtag.setBoardNo(boardNo);
			hashtag.setTag(tag);
			
			myMapper.insertHashtag(hashtag);
		}
	}
}
