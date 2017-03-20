package com.fei.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fei
 * @Time：2017年3月17日 下午3:16:57
 * @version 1.0
 */
@RestController
public class HelloController {
	
	@RequestMapping("/info")
	public String info(){
		
		return "fei boot";
	}

}
