package com.interest.controller.rainbow;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowKcqktjService;
import com.interest.service.RainbowRxstjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 库存情况统计
 */

@RestController
public class RainbowKcqktjController {

    private Logger log = LoggerFactory.getLogger(RainbowKcqktjController.class);

    @Resource(name = "rainbowKcqktjServiceImpl")
    private RainbowKcqktjService rainbowKcqktjService;

    @InterestLog
    @GetMapping("/rainbow/jkppsgk")
    public ResponseWrapper<PageResult> jkppsgk(@RequestParam(value = "pageSize", required = false) int pageSize,
                                            @RequestParam(value = "page", required = false) int page,
                                            @RequestParam(value = "startDate", required = false) String startDate,
                                            @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowKcqktjService.jkppsgk(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }


    @InterestLog
    @GetMapping("/rainbow/jkppsmx")
    public ResponseWrapper<PageResult> jkppsmx(@RequestParam(value = "pageSize", required = false) int pageSize,
                                            @RequestParam(value = "page", required = false) int page,
                                            @RequestParam(value = "startDate", required = false) String startDate,
                                            @RequestParam(value = "endDate", required = false) String endDate) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowKcqktjService.jkppsmx(pageWrapper, startDate, endDate);
        return new ResponseWrapper<>(pageResult);
    }

    //  出库包裹数
    @InterestLog
    @GetMapping("/rainbow/ckbgs")
    public ResponseWrapper<List<HashMap>> ckbgs(@RequestParam(value = "startDate", required = false) String startDate,
                                          @RequestParam(value = "endDate", required = false) String endDate) {
        List<HashMap> list = rainbowKcqktjService.ckbgs(startDate, endDate);
        return new ResponseWrapper<>(list);
    }

    //  在途包裹数
    @InterestLog
    @GetMapping("/rainbow/ztbgs")
    public ResponseWrapper<List<HashMap>> ztbgs(@RequestParam(value = "queryDate", required = false) String queryDate) {
        List<HashMap> list = rainbowKcqktjService.ztbgs(queryDate);
        return new ResponseWrapper<>(list);
    }

}
