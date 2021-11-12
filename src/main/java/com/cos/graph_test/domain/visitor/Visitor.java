package com.cos.graph_test.domain.visitor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	private String ip; // IP 주소
	private Date time; // 세션이 만들어진 시간
//	private String refer; //접속 전 사이트 정보
//	private String agent; // 브라우저 정보
	
}
