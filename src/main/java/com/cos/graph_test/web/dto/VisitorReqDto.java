package com.cos.graph_test.web.dto;

import com.cos.graph_test.domain.visitor.Visitor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class VisitorReqDto {
	private String ip;
	private String refer;
	private String agent;
	
//	public Visitor toEntity() {
//		Visitor visitor = Visitor.builder()
//				.ip(ip)
//				.refer(refer)
//				.agent(agent)
//				.build();
//		return visitor;
//	}
}
