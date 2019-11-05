package com.interest.controller.rainbow;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowRbbxhService;
import com.interest.service.RainbowRxstjService;
import com.interest.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日销售统计
 */

@RestController
public class RainbowRxstjController {

    private Logger log = LoggerFactory.getLogger(RainbowRxstjController.class);

    @Resource(name = "rainbowRxstjServiceImpl")
    private RainbowRxstjService rainbowRxstjService;

    // 销售统计
    @InterestLog
    @GetMapping("/rainbow/xstj")
    public ResponseWrapper<PageResult> xstj(@RequestParam(value = "pageSize", required = false) int pageSize,
                                            @RequestParam(value = "page", required = false) int page,
                                            @RequestParam(value = "startDate", required = false) String startDate,
                                            @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowRxstjService.xstj(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }


}
