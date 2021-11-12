package com.cos.graph_test.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
@WebListener
public class VisitorCounter implements ServletContextListener { 

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		System.out.println("contextdestroyed");
	} // 웹어플리이션이 실행될때 작동 ( 가장 먼저 실행)

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
	} // 웹어플리이션이 종료될때 작동 (가장 늦게 실행)
}
