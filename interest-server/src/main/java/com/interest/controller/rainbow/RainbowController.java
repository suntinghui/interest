package com.interest.controller.rainbow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowService;

@RestController
public class RainbowController {
	
	@Autowired
	private RainbowService rainbowService;
	
	@InterestLog
	@GetMapping("/rainbow/fhgjl")
	public ResponseWrapper<String> getResult() {
		String result = rainbowService.getResult();
        return new ResponseWrapper<>(result);
    }

}
