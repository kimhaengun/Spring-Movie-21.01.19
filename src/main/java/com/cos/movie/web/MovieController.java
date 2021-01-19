package com.cos.movie.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.JoinReqDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.UpdateReqDto;

@RestController
public class MovieController {
	private MovieRepository movieRepository;
	

	public MovieController(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}


	@GetMapping("/movie")
	public List<Movie> findAll() {
		System.out.println("findAll()");
		return movieRepository.finAll();
	}
	

	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id) {
		System.out.println("findByid()");
		return movieRepository.findById(id);
	}
	
	@PostMapping("/movie")
	public CommonDto<?> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {
		
		System.out.println("save()");
		System.out.println("movie save() : "+dto);
		movieRepository.save(dto);
		//
//		System.out.println("저장된 title : "+title);
//		System.out.println("저장된 rating : "+rating);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
		
	}
	

	@DeleteMapping("/movie/{id}")
	public CommonDto<?> delete(@PathVariable int id) {
		System.out.println("delete()");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(), "ok"); 
	}
	
	@PutMapping("/movie/{id}")
	public CommonDto<?> update(@PathVariable int id,@Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		
		System.out.println("update()");
		movieRepository.update(id, dto);
		System.out.println("movie update() : "+dto);
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	}
}

