package com.cos.graph_test.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cos.graph_test.domain.visitor.Visitor;
import com.cos.graph_test.domain.visitor.VisitorRepository;

 
//@RequiredArgsConstructor 사용하면 에러
@WebListener
public class VisitorCounter implements HttpSessionListener {
	
//	private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();
//	
//	//중복로그인 지우기
//	public synchronized static String getSessionidCheck(String type, String compareId){
//		String result = "";
//		for( String key : sessions.keySet() ){
//			HttpSession hs = sessions.get(key);
//			if(hs != null &&  hs.getAttribute(type) != null && hs.getAttribute(type).toString().equals(compareId) ){
//				result =  key.toString();
//			}
//		}
//		removeSessionForDoubleLogin(result);
//		return result;
//	}
//	
//	private static void removeSessionForDoubleLogin(String userId){    	
//		System.out.println("remove userId : " + userId);
//		if(userId != null && userId.length() > 0){
//			sessions.get(userId).invalidate();
//			sessions.remove(userId);    		
//		}
//	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession(); // 세션을 만든다.
//		++VisitorCount;
//        System.out.printf("생성된 SESSIONID %s \n",  se.getSession().getId());
//        System.out.printf("방문자 수 : %d \n", VisitorCount);
		Visitor visitor = new Visitor(); // Visitor 객체를 만든다

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext()); //등록되어있는 빈을 사용할수 있도록 설정해준다
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest(); //request를 파라미터에 넣지 않고도 사용할수 있도록 설정
		
		VisitorRepository visitorRepository = (VisitorRepository) wac.getBean("visitorRepository"); // 등록되어 있는 visitorRepository를 사용가능하게 설정
		
//		visitor.setIp(request.getRemoteAddr()); // IP 주소 확인
//		visitor.setAgent(request.getHeader("User-Agent")); // 브라우저 정보
//		visitor.setRefer(request.getHeader("Referer")); // 접속 전 사이트 정보, 직접 치고 들어온 경우 NULL
//		visitorRepository.mInsertVisitor(visitor.getIp(), visitor.getRefer(), visitor.getAgent()); // DB에 데이터 저장
		visitorRepository.mInsertVisitorTest();
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
//		if( VisitorCount < 0 ) VisitorCount = 0;
//		
//		HttpSession session = se.getSession();
//		
//        System.out.printf("제거된 SESSIONID %s \n",  se.getSession().getId());
//        System.out.printf("방문자 수 : %d \n", session);
        
	}

}
