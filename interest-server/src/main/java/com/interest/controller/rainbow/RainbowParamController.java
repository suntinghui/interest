package com.interest.controller.rainbow;

import com.interest.annotation.InterestLog;
import com.interest.model.entity.ParamEntity;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RainbowParamController {

	private Logger log = LoggerFactory.getLogger(RainbowParamController.class);

	@Resource(name = "rainbowParamServiceImpl")
	private RainbowParamService rainbowParamService;

	@InterestLog
	@GetMapping("/rainbow/areaList")
	public ResponseWrapper<List<ParamEntity>> areaList() {
		List<ParamEntity> result = rainbowParamService.areaList();
		return new ResponseWrapper<>(result);
	}

	@InterestLog
	@GetMapping("/rainbow/shopTypeList")
	public ResponseWrapper<List<ParamEntity>> shopTypeList() {
		List<ParamEntity> result = rainbowParamService.shopTypeList();
		return new ResponseWrapper<>(result);
	}

	@InterestLog
	@GetMapping("/rainbow/shopList")
	public ResponseWrapper<List<ParamEntity>> shopList() {
		List<ParamEntity> result = rainbowParamService.shopList();
		return new ResponseWrapper<>(result);
	}


	@InterestLog
	@GetMapping("/rainbow/deviceTypeList")
	public ResponseWrapper<List<ParamEntity>> deviceTypeList() {
		List<ParamEntity> result = rainbowParamService.deviceTypeList();
		return new ResponseWrapper<>(result);
	}

	@InterestLog
	@GetMapping("/rainbow/channelList")
	public ResponseWrapper<List<ParamEntity>> channelList() {
		List<ParamEntity> result = rainbowParamService.channelList();
		return new ResponseWrapper<>(result);
	}

}
