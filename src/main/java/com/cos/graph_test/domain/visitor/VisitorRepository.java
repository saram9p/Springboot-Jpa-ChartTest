package com.cos.graph_test.domain.visitor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.graph_test.util.VisitorReportInterface;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
	// 방문자 정보 추가 // If(refer != null and refer !='', refer, refer)
	@Query(value = "Insert Into Visitor(ip, TIME, refer, agent) VALUES(:ip, SYSDATE(), (Select IFNULL( :refer, NULL )), :agent);", nativeQuery = true)
	void mInsertVisitor(String ip, String refer, String agent);
	
	// 방문자 정보 추가 테스트
	@Query(value = "Insert Into Visitor(TIME) VALUES(SYSDATE());", nativeQuery = true)
	void mInsertVisitorTest();
	
	// 전체 일별 방문자 수 조회
	@Query(value = "SELECT date_format(TIME, '%Y-%m-%d') AS time, count(id) AS id FROM visitor Group BY Year(TIME),Month(TIME),Day(TIME) ORDER BY time;", nativeQuery = true)
	// 그룹으로 셀렉트 할때는 인터페이스 사용, 아마 DTO도 만들어야 할 수도 있음
	List<VisitorReportInterface> mVisitorTotalTodayChk();
	
//	// 최근 한달간 일별 방문자 수 조회
//	// 컬럼 이름 잘 설정해야 함 (모델과 동일 하게 안 그러면 에러남 ex) 모델의 id 가 있는데 컬럼 이름을 count(id) 그대로 하면 에러, as id 로 이름을 바꾸어야 함)
//	@Query(value = "Select date_format(TIME, '%Y-%m-%d') AS time , count(id) AS id From visitor Group BY Month(TIME),Day(TIME) having time between DATE(DATE_ADD(NOW(), INTERVAL -1 MONTH)) and date(NOW()) +1 ORDER BY time;", nativeQuery = true)
//	// 그룹으로 셀렉트 할때는 인터페이스 사용, 아마 DTO도 만들어야 할 수도 있음
//	List<VisitorReportInterface> mVisitorOMITodayChk();
	
	
	// 최근 한달간 일별 방문자 수 조회
	// 컬럼 이름 잘 설정해야 함 (모델과 동일 하게 안 그러면 에러남 ex) 모델의 id 가 있는데 컬럼 이름을 count(id) 그대로 하면 에러, as id 로 이름을 바꾸어야 함)
	@Query(value = "SELECT date_format(TIME, '%Y-%m-%d') AS time, count(id) AS id FROM visitor Group BY Month(TIME),Day(TIME) HAVING time BETWEEN Date(DATE_ADD(NOW(), INTERVAL -1 Month )) AND Date(NOW()+1) ORDER BY time;", nativeQuery = true)
	// 그룹으로 셀렉트 할때는 인터페이스 사용, 아마 DTO도 만들어야 할 수도 있음
	List<VisitorReportInterface> mVisitorOMITodayChk();
	
	// 월별 방문자 수 조회
	@Query(value = "SELECT date_format(TIME, '%Y-%m') AS time, count(id) AS id FROM visitor Group BY Year(TIME),Month(TIME) ORDER BY time;", nativeQuery = true)
	// 그룹으로 셀렉트 할때는 인터페이스 사용, 아마 DTO도 만들어야 할 수도 있음
	List<VisitorReportInterface> mVisitorMonthChk();
	
//	// 1년간 월별 방문자 수 조회
//	// date_format에 월 뒤에 00을 넣었는데 왜냐하면 숫자나 (날짜)일 을 넣지 않으면 데이터를 불러오지 못해서 어쩔수 없이 집어넣었다.
//	@Query(value = "SELECT date_format(TIME, '%Y-%m-%00') AS TIME, count(id) AS id FROM visitor Group BY Year(TIME),Month(TIME) having time between DATE(DATE_ADD(NOW(), INTERVAL -1 Year)) and date(NOW())+1 ORDER BY TIME;", nativeQuery = true)
//	// 그룹으로 셀렉트 할때는 인터페이스 사용, 아마 DTO도 만들어야 할 수도 있음
//	List<VisitorReportInterface> mVisitorFaYMonthChk();
	
	// 1년간 월별 방문자 수 조회
	// date_format에 월 뒤에 00을 넣었는데 왜냐하면 숫자나 (날짜)일 을 넣지 않으면 데이터를 불러오지 못해서 어쩔수 없이 집어넣었다.
	@Query(value = "SELECT date_format(TIME, '%Y-%m-%00') AS TIME, count(id) AS id FROM visitor Group BY Year(TIME),Month(TIME) having time between DATE(DATE_ADD(NOW(), INTERVAL -1 Year)) and date(NOW()+1) ORDER BY TIME;", nativeQuery = true)
	// 그룹으로 셀렉트 할때는 인터페이스 사용, 아마 DTO도 만들어야 할 수도 있음
	List<VisitorReportInterface> mVisitorFaYMonthChk();
	
	// 세션 카운트 조회
	@Query(value = "SELECT COUNT(time) FROM visitor;", nativeQuery = true)
	Visitor mSelectCount();
	
}
