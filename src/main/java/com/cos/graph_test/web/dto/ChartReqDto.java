package com.cos.graph_test.web.dto;

import java.util.Date;

import com.cos.graph_test.domain.visitor.Visitor;

public class ChartReqDto {
	private int id;
	private Date time;
	
	public Visitor toEntity() {
		Visitor visitor = Visitor.builder()
				.id(id)
				.time(time)
				.build();
		return visitor;
	}
}
