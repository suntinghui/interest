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
import java.util.HashMap;

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

    // 按设备类型统计
    @InterestLog
    @GetMapping("/rainbow/sblxtj")
    public ResponseWrapper<PageResult> sblxtj(@RequestParam(value = "pageSize", required = false) int pageSize,
                                            @RequestParam(value = "page", required = false) int page,
                                            @RequestParam(value = "startDate", required = false) String startDate,
                                            @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowRxstjService.sblxtj(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }

    // 按彩种统计
    @InterestLog
    @GetMapping("/rainbow/acztj")
    public ResponseWrapper<PageResult> acztj(@RequestParam(value = "pageSize", required = false) int pageSize,
                                              @RequestParam(value = "page", required = false) int page,
                                              @RequestParam(value = "startDate", required = false) String startDate,
                                              @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowRxstjService.acztj(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }

    //  单台平均销售统计
    @InterestLog
    @GetMapping("/rainbow/dtpjxstj")
    public ResponseWrapper<PageResult> dtpjxstj(@RequestParam(value = "pageSize", required = false) int pageSize,
                                             @RequestParam(value = "page", required = false) int page,
                                             @RequestParam(value = "startDate", required = false) String startDate,
                                             @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowRxstjService.dtpjxstj(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }


    //  单台销量排名
    @InterestLog
    @GetMapping("/rainbow/dtxlpm")
    public ResponseWrapper<PageResult> dtxlpm(@RequestParam(value = "pageSize", required = false) int pageSize,
                                                @RequestParam(value = "page", required = false) int page,
                                                @RequestParam(value = "startDate", required = false) String startDate,
                                                @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowRxstjService.dtxlpm(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }

    //  零销量设备占比统计
    @InterestLog
    @GetMapping("/rainbow/lxlsbzbtj")
    public ResponseWrapper<HashMap> lxlsbzbtj(@RequestParam(value = "queryDate", required = false) String queryDate) {
        HashMap map = rainbowRxstjService.lxlsbzbtj(queryDate);
        return new ResponseWrapper<>(map);
    }


}
