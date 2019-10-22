package com.interest.controller.rainbow;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowDjqdatjService;
import com.interest.utils.RainbowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单机器档案统计
 */

@RestController
public class RainbowDjqdatjController {

	private Logger log = LoggerFactory.getLogger(RainbowDjqdatjController.class);

	@Resource(name = "rainbowDjqdatjServiceImpl")
	private RainbowDjqdatjService rainbowDjqdatjService;

	// 机器属性信息
	@InterestLog
	@GetMapping("/rainbow/jqsxxx")
	public ResponseWrapper<PageResult> jqsxxx(@RequestParam(value = "searchContent", required = false) String searchContent, @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageWrapper pageWrapper = new PageWrapper(pageSize, page);
		PageResult pageResult = rainbowDjqdatjService.getDeviceInfoList(searchContent, pageWrapper);
		return new ResponseWrapper<>(pageResult);
	}

	// 详情信息
	@InterestLog
	@GetMapping("/rainbow/mdsxxx")
	public ResponseWrapper<HashMap> mdsxxx(@RequestParam(value = "shopNo", required = false) String shopNo) {
		HashMap<String, HashMap<String, String>> resultMap = new HashMap<>();

		if (!StringUtils.isEmpty(shopNo)) {
			HashMap<String, String> deviceInfoMap = rainbowDjqdatjService.getDeviceInfo(shopNo);
			resultMap.put("deviceInfo", deviceInfoMap);

			HashMap<String, String> shopInfoMap = rainbowDjqdatjService.getShopInfo(shopNo);
			resultMap.put("shopInfo", shopInfoMap);


		} else {
			resultMap.put("deviceInfo", new HashMap<>());
			resultMap.put("shopInfo", new HashMap<>());
		}

		return new ResponseWrapper<>(resultMap);
	}

}
