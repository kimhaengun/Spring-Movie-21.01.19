package com.cos.movie.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	public List<Movie> finAll(){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1,"도둑들",4.5,new Timestamp(0)));
		movies.add(new Movie(2,"신세계",4.0,new Timestamp(0)));
		movies.add(new Movie(3,"인랑",2.5,new Timestamp(0)));
		return movies;
	}
	public Movie findById(int id) {
		return new Movie(8,"베테랑",4.5,new Timestamp(0));
	}
	public void save(JoinReqDto dto) {
		System.out.println("DB 데이터 저장");
	}
	public void delete(int id) {
		System.out.println("DB 데이터 삭제");
	}
	public void update(int id, UpdateReqDto dto) {
		System.out.println("DB 데이터 수정");
		//DAO 연결해서 실행하다 익센션이 터지면
//		throw new IllegalArgumentException("아규먼트를 잘못넣음");
		// 지금쓰면 Put으로 데이터 던지면 무조건 exception으로 들어가기때문에 오류뜸..
	}
	
}
