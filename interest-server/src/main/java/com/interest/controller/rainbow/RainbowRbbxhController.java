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
												   @RequestParam(value = "startDate", required = false) String startDate,
												   @RequestParam(value = "endDate", required = false) String endDate,
												   @RequestParam(value = "deviceModel", required = false) String deviceModel) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.rbxhjkpjytj(pageWrapper, startDate, endDate, StringUtil.str2List(deviceModel));
		return new ResponseWrapper<>(pageResult);
	}

	// 即开票交易Top50
	@InterestLog
	@GetMapping("/rainbow/rbxhjkpjy50")
	public ResponseWrapper<List<HashMap<String, String>>> rbxhjkpjy50(@RequestParam(value = "startDate", required = false) String startDate,
											   @RequestParam(value = "endDate", required = false) String endDate,
											   @RequestParam(value = "deviceModel", required = false) String deviceModel) {
		List<HashMap<String, String>> list = rainbowRbbxhService.rbxhjkpjy50(startDate, endDate, StringUtil.str2List(deviceModel));
		log.info(JSON.toJSONString(list));
		return new ResponseWrapper<>(list);
	}

	// 每日在网设备数量
	@InterestLog
	@GetMapping("/rainbow/mrzwsbsl")
	public ResponseWrapper<PageResult> mrzwsbsl(@RequestParam(value = "pageSize", required = false) int pageSize,
												   @RequestParam(value = "page", required = false) int page,
												   @RequestParam(value = "startDate", required = false) String startDate,
												   @RequestParam(value = "endDate", required = false) String endDate,
												   @RequestParam(value = "deviceModel", required = false) String deviceModel) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.mrzwsbsl(pageWrapper, startDate, endDate, StringUtil.str2List(deviceModel));
		return new ResponseWrapper<>(pageResult);
	}

	// 每日新入网设备数量
	@InterestLog
	@GetMapping("/rainbow/mrxrwsbsl")
	public ResponseWrapper<PageResult> mrxrwsbsl(@RequestParam(value = "pageSize", required = false) int pageSize,
												@RequestParam(value = "page", required = false) int page,
												@RequestParam(value = "startDate", required = false) String startDate,
												@RequestParam(value = "endDate", required = false) String endDate,
												@RequestParam(value = "deviceModel", required = false) String deviceModel) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.mrxrwsbsl(pageWrapper, startDate, endDate, StringUtil.str2List(deviceModel));
		return new ResponseWrapper<>(pageResult);
	}

	// 每日未开机设备数量
	@InterestLog
	@GetMapping("/rainbow/mrwkjsl")
	public ResponseWrapper<PageResult> mrwkjsl(@RequestParam(value = "pageSize", required = false) int pageSize,
												 @RequestParam(value = "page", required = false) int page,
												 @RequestParam(value = "startDate", required = false) String startDate,
												 @RequestParam(value = "endDate", required = false) String endDate,
												 @RequestParam(value = "deviceModel", required = false) String deviceModel) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.mrwkjsl(pageWrapper, startDate, endDate, StringUtil.str2List(deviceModel));
		return new ResponseWrapper<>(pageResult);
	}

	// 撤机设备数
	@InterestLog
	@GetMapping("/rainbow/cjsbs")
	public ResponseWrapper<PageResult> cjsbs(@RequestParam(value = "pageSize", required = false) int pageSize,
											   @RequestParam(value = "page", required = false) int page,
											   @RequestParam(value = "startDate", required = false) String startDate,
											   @RequestParam(value = "endDate", required = false) String endDate,
											   @RequestParam(value = "deviceModel", required = false) String deviceModel) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowRbbxhService.cjsbs(pageWrapper, startDate, endDate, StringUtil.str2List(deviceModel));
		return new ResponseWrapper<>(pageResult);
	}

}
