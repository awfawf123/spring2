package co.company.spring;

import co.company.spring.controller.MemberVO;

public class LombokTest {
	public static void main(String[] args) {
		 MemberVO member = MemberVO.builder().id("id").name("name").build();
		
	}

}
