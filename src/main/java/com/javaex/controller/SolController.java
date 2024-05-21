package com.javaex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolController {

	@GetMapping("/odo/list")
	public void test() {
		System.out.println("test");
	}
}
