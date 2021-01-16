package com.uri.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uri.sp.domain.MemberRegRequest;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {

	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		return "member/memberRegForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberReg(
			@ModelAttribute("regData") MemberRegRequest regRequest
			) {
		
		System.out.println(regRequest); //확인용
		
		return "member/memberRegView";
	}
}
