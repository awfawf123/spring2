package co.company.spring.controller;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MemberVO {
	String id;
	String name;
	String pw;

}
