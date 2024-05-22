package com.javaex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolController {

	@GetMapping("/odo/company/join")
	public void test() {
		System.out.println("test");
	}
}
