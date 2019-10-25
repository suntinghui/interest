package com.interest.controller.rainbow;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowDjqdatjService;
import com.interest.service.RainbowRbbxhService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 日报表细化
 */

@RestController
public class RainbowRbbxhController {

	private Logger log = LoggerFactory.getLogger(RainbowRbbxhController.class);

	@Resource(name = "rainbowRbbxhServiceImpl")
	private RainbowRbbxhService rainbowRbbxhService;

	// 即开票交易统计
	@InterestLog
	@GetMapping("/rainbow/rbxhjkpjytj")
	public ResponseWrapper<List<HashMap>> rbxhjkpjytj(@RequestParam(value = "searchContent", required = false) String searchContent) {
		List<HashMap> list = rainbowRbbxhService.rbxhjkpjytj();
		return new ResponseWrapper<>(list);
	}

	// 即开票交易Top50
	@InterestLog
	@GetMapping("/rainbow/rbxhjkpjy50")
	public ResponseWrapper<List<HashMap>> rbxhjkpjy50(@RequestParam(value = "searchContent", required = false) String searchContent) {
		List<HashMap> list = rainbowRbbxhService.rbxhjkpjy50();
		return new ResponseWrapper<>(list);
	}





}