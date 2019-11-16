package com.interest.controller.rainbow;

import com.alibaba.fastjson.JSON;
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
    @GetMapping("/rainbow/jqsxxx_list")
    public ResponseWrapper<PageResult> jqsxxx(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page,
                                              @RequestParam(value = "filterMap", required = false) String filterMap) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowDjqdatjService.jqsxxx_list(pageWrapper, JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(pageResult);
    }

    // 详情信息
    @InterestLog
    @GetMapping("/rainbow/jqsxxx_detail")
    public ResponseWrapper<HashMap> jqsxxx_detail(@RequestParam(value = "filterMap", required = false) String filterMap) {
        HashMap<String, List<HashMap>> resultMap = rainbowDjqdatjService.jqsxxx_detail(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(resultMap);
    }

}
