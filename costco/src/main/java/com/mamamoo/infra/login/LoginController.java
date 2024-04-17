package com.mamamoo.infra.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mamamoo.common.constants.Constants;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	// 관리자 로그인
	@RequestMapping(value = "/loginSdm")
	public String loginSdm() throws Exception {
		return Constants.PATH_LOGIN + "loginSdm";
	}	
	
	// 관리자 로그인 화면에서 회원가입 클릭
	@RequestMapping(value = "/loginSdmMemberCreate")
	public String loginSdmMemberCreate() throws Exception {
		return Constants.PATH_LOGIN + "loginSdmMemberCreate";
	}	
	
	// 사용자 로그인
	/*
	 * @RequestMapping(value = "/loginUsr") public String loginUsr() throws
	 * Exception { return Constants.PATH_LOGIN + "loginUsr"; }
	 */
}
