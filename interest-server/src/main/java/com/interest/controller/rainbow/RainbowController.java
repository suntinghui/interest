package com.interest.controller.rainbow;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interest.annotation.InterestLog;
import com.interest.controller.sys.UserController;
import com.interest.model.entity.RainbowDeviceDocEntity;
import com.interest.model.entity.UserEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowService;

@RestController
public class RainbowController {

	private Logger log = LoggerFactory.getLogger(RainbowController.class);

	@Resource(name = "rainbowServiceImpl")
	private RainbowService rainbowService;

	@InterestLog
	@GetMapping("/rainbow/fhgjl")
	public ResponseWrapper<String> fhgjl() {
		String result = rainbowService.fhgjl();
		log.info(result);
		return new ResponseWrapper<>(result);
	}

	@InterestLog
	@GetMapping("/rainbow/zhkjsc")
	public ResponseWrapper<String> zhkjsc() {
		String result = rainbowService.zhkjsc();
		log.info(result);
		return new ResponseWrapper<>(result);
	}

	// 设备档案
	@InterestLog
	@GetMapping("/rainbow/sbda")
	public ResponseWrapper<PageResult> sbda(@RequestParam(value = "searchContent", required = false) String searchContent, @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowService.getDeviceDocList(searchContent, pageWrapper);
		return new ResponseWrapper<>(pageResult);
	}

}
