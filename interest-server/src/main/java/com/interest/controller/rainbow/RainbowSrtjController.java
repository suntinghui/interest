package com.interest.controller.rainbow;

import com.interest.annotation.InterestLog;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseWrapper;
import com.interest.service.RainbowKcqktjService;
import com.interest.service.RainbowSrtjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 收入情况统计
 */

@RestController
public class RainbowSrtjController {

    private Logger log = LoggerFactory.getLogger(RainbowSrtjController.class);

    @Resource(name = "rainbowSrtjServiceImpl")
    private RainbowSrtjService rainbowSrtjService;

    // 销售额情况统计（按月）
    @InterestLog
    @GetMapping("/rainbow/xsetjy")
    public ResponseWrapper<List<HashMap>> xsetjy(@RequestParam(value = "startMonth", required = false) String startMonth,
                                                 @RequestParam(value = "endMonth", required = false) String endMonth) {
        List<HashMap> list = rainbowSrtjService.xsetjy(startMonth, endMonth);
        return new ResponseWrapper<>(list);
    }

    // 收入情况统计（按日）
    @InterestLog
    @GetMapping("/rainbow/srtjr")
    public ResponseWrapper<PageResult> srtjr(@RequestParam(value = "pageSize", required = false) int pageSize,
                                             @RequestParam(value = "page", required = false) int page,
                                             @RequestParam(value = "queryMonth", required = false) String queryMonth) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowSrtjService.srtjr(pageWrapper, queryMonth);
        return new ResponseWrapper<>(pageResult);
    }

    // 分渠道设备数量
    @InterestLog
    @GetMapping("/rainbow/fqdsbsl")
    public ResponseWrapper<List<HashMap>> fqdsbsl(@RequestParam(value = "startDate", required = false) String startDate,
                                                  @RequestParam(value = "endDate", required = false) String endDate) {
        List<HashMap> list = rainbowSrtjService.fqdsbsl(startDate, endDate);
        return new ResponseWrapper<>(list);
    }

    // 门店分成金额
    @InterestLog
    @GetMapping("/rainbow/mdfcjer")
    public ResponseWrapper<PageResult> mdfcjer(@RequestParam(value = "pageSize", required = false) int pageSize,
                                               @RequestParam(value = "page", required = false) int page,
                                               @RequestParam(value = "queryMonth", required = false) String queryMonth) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowSrtjService.mdfcjer(pageWrapper, queryMonth);
        return new ResponseWrapper<>(pageResult);
    }

    // 门店分成金额
    @InterestLog
    @GetMapping("/rainbow/qdfcjer")
    public ResponseWrapper<PageResult> qdfcjer(@RequestParam(value = "pageSize", required = false) int pageSize,
                                               @RequestParam(value = "page", required = false) int page,
                                               @RequestParam(value = "queryMonth", required = false) String queryMonth) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowSrtjService.qdfcjer(pageWrapper, queryMonth);
        return new ResponseWrapper<>(pageResult);
    }

    // 渠道分成比例
    @InterestLog
    @GetMapping("/rainbow/qdfcbl")
    public ResponseWrapper<PageResult> qdfcbl(@RequestParam(value = "pageSize", required = false) int pageSize,
                                              @RequestParam(value = "page", required = false) int page,
                                              @RequestParam(value = "queryMonth", required = false) String queryMonth) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowSrtjService.qdfcbl(pageWrapper, queryMonth);
        return new ResponseWrapper<>(pageResult);
    }

    // 退款情况统计（合计）
    @InterestLog
    @GetMapping("/rainbow/tkqktjhj")
    public ResponseWrapper<List<HashMap>> tkqktjhj(@RequestParam(value = "startMonth", required = false) String startMonth,
                                                  @RequestParam(value = "endMonth", required = false) String endMonth) {
        List<HashMap> list = rainbowSrtjService.tkqktjhj(startMonth, endMonth);
        return new ResponseWrapper<>(list);
    }

    // 退款情况统计（按月）
    @InterestLog
    @GetMapping("/rainbow/tkqktjy")
    public ResponseWrapper<PageResult> tkqktjy(@RequestParam(value = "pageSize", required = false) int pageSize,
                                                  @RequestParam(value = "page", required = false) int page,
                                                  @RequestParam(value = "startMonth", required = false) String startMonth,
                                                  @RequestParam(value = "endMonth", required = false) String endMonth) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowSrtjService.tkqktjy(pageWrapper, startMonth, endMonth);
        return new ResponseWrapper<>(pageResult);
    }

    // 退款情况统计（按日）
    @InterestLog
    @GetMapping("/rainbow/tkqktjr")
    public ResponseWrapper<PageResult> tkqktjr(@RequestParam(value = "pageSize", required = false) int pageSize,
                                               @RequestParam(value = "page", required = false) int page,
                                               @RequestParam(value = "queryMonth", required = false) String queryMonth) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = rainbowSrtjService.tkqktjr(pageWrapper, queryMonth);
        return new ResponseWrapper<>(pageResult);
    }

}
