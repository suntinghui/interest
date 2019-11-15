package com.interest.controller.rainbow;

import com.alibaba.fastjson.JSON;
import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowDjqdatjService;
import com.interest.service.RainbowRbbxhService;
import com.interest.service.RainbowYjzbService;
import com.interest.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

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
	public ResponseWrapper<PageResult> rbxhjkpjytj(@RequestParam(value = "pageSize", required = false) int pageSize,
												   @RequestParam(value = "page", required = false) int page,
												   @RequestParam(value = "filterMap", required = false) String filterMap) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.rbxhjkpjytj(pageWrapper, JSON.parseObject(filterMap, HashMap.class));
		return new ResponseWrapper<>(pageResult);
	}

	// 即开票交易Top50
	@InterestLog
	@GetMapping("/rainbow/rbxhjkpjy50")
	public ResponseWrapper<List<HashMap>> rbxhjkpjy50(@RequestParam(value = "filterMap", required = false) String filterMap) {
		List<HashMap> list = rainbowRbbxhService.rbxhjkpjy50(JSON.parseObject(filterMap, HashMap.class));
		log.info(JSON.toJSONString(list));
		return new ResponseWrapper<>(list);
	}

	// 每日在网设备数量
	@InterestLog
	@GetMapping("/rainbow/mrzwsbsl")
	public ResponseWrapper<PageResult> mrzwsbsl(@RequestParam(value = "pageSize", required = false) int pageSize,
												@RequestParam(value = "page", required = false) int page,
												@RequestParam(value = "filterMap", required = false) String filterMap) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.mrzwsbsl(pageWrapper, JSON.parseObject(filterMap, HashMap.class));
		return new ResponseWrapper<>(pageResult);
	}

	// 每日新入网设备数量
	@InterestLog
	@GetMapping("/rainbow/mrxrwsbsl")
	public ResponseWrapper<PageResult> mrxrwsbsl(@RequestParam(value = "pageSize", required = false) int pageSize,
												 @RequestParam(value = "page", required = false) int page,
												 @RequestParam(value = "filterMap", required = false) String filterMap) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.mrxrwsbsl(pageWrapper, JSON.parseObject(filterMap, HashMap.class));
		return new ResponseWrapper<>(pageResult);
	}

	// 每日未开机设备数量
	@InterestLog
	@GetMapping("/rainbow/mrwkjsl")
	public ResponseWrapper<PageResult> mrwkjsl(@RequestParam(value = "pageSize", required = false) int pageSize,
											   @RequestParam(value = "page", required = false) int page,
											   @RequestParam(value = "filterMap", required = false) String filterMap) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.mrwkjsl(pageWrapper, JSON.parseObject(filterMap, HashMap.class));
		return new ResponseWrapper<>(pageResult);
	}

	// 撤机设备数
	@InterestLog
	@GetMapping("/rainbow/cjsbs")
	public ResponseWrapper<PageResult> cjsbs(@RequestParam(value = "pageSize", required = false) int pageSize,
											 @RequestParam(value = "page", required = false) int page,
											 @RequestParam(value = "filterMap", required = false) String filterMap) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.cjsbs(pageWrapper, JSON.parseObject(filterMap, HashMap.class));
		return new ResponseWrapper<>(pageResult);
	}

}
