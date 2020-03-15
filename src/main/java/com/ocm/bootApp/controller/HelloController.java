package com.ocm.bootApp.controller;

import com.ocm.bootApp.properties.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by oralceOCM
 * 2020-02-27 17:54
 * @Controller + @ResponseBody = @RestController
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private LimitConfig limitConfig;

	@PostMapping("/say")
	public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
//		return "说明：" + limitConfig.getDescription();
		return "id:" + myId;
	}
}
