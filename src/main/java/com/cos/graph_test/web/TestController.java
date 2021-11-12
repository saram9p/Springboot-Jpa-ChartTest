package com.cos.graph_test.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.graph_test.domain.visitor.Visitor;
import com.cos.graph_test.domain.visitor.VisitorRepository;
import com.cos.graph_test.util.VisitorReportInterface;
import com.cos.graph_test.web.dto.CMRespDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestController {

	private final VisitorRepository visitorRepository;
	
	@GetMapping("/")
	public String home() {
		
		return "index";
	}

	@PostMapping("/getAreaChartData")
	public @ResponseBody CMRespDto<String> getAreaChartData(Model model){
		
		// 서비스 단으로 이동시키면 좋을 듯
		
		// 최근 한달간 일별 방문자수 DB에서 가져와서 json 으로 만들기
		List<VisitorReportInterface> vTList = visitorRepository.mVisitorOMITodayChk(); // DB에서 데이터 가져와서 리스트에 담음

		Gson tGson = new Gson();
		JsonArray tJArray = new JsonArray();
				
		Iterator<VisitorReportInterface> tIt = vTList.iterator();
		while(tIt.hasNext()) {
			VisitorReportInterface curVO = tIt.next();
			JsonObject tObject = new JsonObject();
			String tTime = (curVO.getTime()).toString();
			int tCount = curVO.getId();
			
			tObject.addProperty("Time", tTime);
			tObject.addProperty("Count", tCount);
			tJArray.add(tObject);
		}
		String tJson = tGson.toJson(tJArray);
		model.addAttribute("tJson", tJson);
		System.out.println(tJson);

		return new CMRespDto<>(1, "성공", tJson);
	}
	
	@PostMapping("/getBarChartData")
	public @ResponseBody CMRespDto<String> getBarChartData(Model model){
		
		// 서비스 단으로 이동시키면 좋을 듯
		
		// 1년간 월별 방문자수 DB에서 가져와서 json 으로 만들기
		List<VisitorReportInterface> vMList = visitorRepository.mVisitorFaYMonthChk(); // DB에서 데이터 가져와서 리스트에 담음

		// Gson : Java에서 Json을 파싱하고, 생성하기 위해 사용되는 구글에서 개발한 오픈소스
		Gson mGson = new Gson();
		JsonArray mJArray = new JsonArray();
				
		Iterator<VisitorReportInterface> mIt = vMList.iterator();
		while(mIt.hasNext()) {
			VisitorReportInterface mCurVO = mIt.next();
			JsonObject mObject = new JsonObject();
			String mTime = (mCurVO.getTime()).toString();
			String mTimeS = mTime.substring(0, 7);
			int mCount = mCurVO.getId();
			
			mObject.addProperty("Time", mTimeS);
			mObject.addProperty("Count", mCount);
			mJArray.add(mObject);
		}
		
		String mJson = mGson.toJson(mJArray);
		model.addAttribute("mJson", mJson);

		System.out.println(mJson);
		
		return new CMRespDto<>(1, "성공", mJson);
	}
	
}
