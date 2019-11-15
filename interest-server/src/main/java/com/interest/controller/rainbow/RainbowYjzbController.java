package com.interest.controller.rainbow;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowYjzbService;

import java.util.HashMap;

/**
 * 业绩指标
 */
@RestController
public class RainbowYjzbController {

	private Logger log = LoggerFactory.getLogger(RainbowYjzbController.class);

	@Resource(name = "rainbowYjzbServiceImpl")
	private RainbowYjzbService rainbowYjzbService;

	// 复合关机率
	@InterestLog
	@GetMapping("/rainbow/fhgjl")
	public ResponseWrapper<String> fhgjl( @RequestParam(value = "filterMap", required = false) String filterMap) {
		String result = rainbowYjzbService.fhgjl(JSON.parseObject(filterMap, HashMap.class));
		log.info(result);
		return new ResponseWrapper<>(result);
	}

	// 剔除关机0销量比率
	@InterestLog
	@GetMapping("/rainbow/tcgjxlbl")
	public ResponseWrapper<String> tcgjxlbl(@RequestParam(value = "filterMap", required = false) String filterMap) {
		String result = rainbowYjzbService.tcgjxlbl(JSON.parseObject(filterMap, HashMap.class));
		log.info(result);
		return new ResponseWrapper<>(result);
	}

	// 空仓时长比率
	@InterestLog
	@GetMapping("/rainbow/kcscbl")
	public ResponseWrapper<String> kcscbl(@RequestParam(value = "filterMap", required = false) String filterMap) {
		try{
			String result = rainbowYjzbService.kcscbl(JSON.parseObject(filterMap, HashMap.class));
			return new ResponseWrapper<>(result);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseWrapper<>("");
		}
	}

	// 单机日销平均
	@InterestLog
	@GetMapping("/rainbow/djrxpj")
	public ResponseWrapper<HashMap> djrxpj(@RequestParam(value = "filterMap", required = false) String filterMap) {
		try{
			HashMap result = rainbowYjzbService.djrxpj(JSON.parseObject(filterMap, HashMap.class));
			return new ResponseWrapper<>(result);
		} catch (Exception e) {
			return new ResponseWrapper<>(new HashMap());
		}
	}

	// 综合开机时长
	@InterestLog
	@GetMapping("/rainbow/zhkjsc")
	public ResponseWrapper<String> zhkjsc(@RequestParam(value = "startDate", required = false) String startDate,  @RequestParam(value = "endDate", required = false) String endDate) {
		String result = rainbowYjzbService.zhkjsc(startDate, endDate);
		log.info(result);
		return new ResponseWrapper<>(result);
	}

	// 设备档案
	@InterestLog
	@GetMapping("/rainbow/sbda")
	public ResponseWrapper<PageResult> sbda(@RequestParam(value = "searchContent", required = false) String searchContent, @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowYjzbService.getDeviceDocList(searchContent, pageWrapper);
		return new ResponseWrapper<>(pageResult);
	}
}
