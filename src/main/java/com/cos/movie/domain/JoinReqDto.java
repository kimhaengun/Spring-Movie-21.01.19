package com.cos.movie.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class JoinReqDto {
	@NotNull(message = "타이틀 키 값이 없습니다")
	@NotBlank(message = "타이틀을 입력하세요")
	@Size(max = 20, message = "타이틀 길이를 초과하였습니다.")
	private String title;
	
	@NotNull(message = "타이틀 키 값이 없습니다.")
	private double rating;
}
