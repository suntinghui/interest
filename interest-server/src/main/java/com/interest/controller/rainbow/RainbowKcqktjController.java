package com.interest.controller.rainbow;

import com.alibaba.fastjson.JSON;
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

    // 即开票月度采购总价值
    @InterestLog
    @GetMapping("/rainbow/jkpydcgzjz")
    public ResponseWrapper<List<HashMap>> jkpydcgzjz(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.jkpydcgzjz(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    // 即开票月度采购票种明细
    @InterestLog
    @GetMapping("/rainbow/jkpydcgpzmx")
    public ResponseWrapper<List<HashMap>> jkpydcgpzmx(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.jkpydcgpzmx(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    // 即开票库存数(截止24时)
    @InterestLog
    @GetMapping("/rainbow/jkpkcs")
    public ResponseWrapper<List<HashMap>> jkpkcs(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.jkpkcs(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    // 即开票库存数明细(截止24时)
    @InterestLog
    @GetMapping("/rainbow/jkpkcsmx")
    public ResponseWrapper<List<HashMap>> jkpkcsmx(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.jkpkcsmx(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    @InterestLog
    @GetMapping("/rainbow/jkppsgk")
    public ResponseWrapper<List<HashMap>> jkppsgk(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.jkppsgk(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }


    @InterestLog
    @GetMapping("/rainbow/jkppsmx")
    public ResponseWrapper<List<HashMap>> jkppsmx(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.jkppsmx(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    @InterestLog
    @GetMapping("/rainbow/pcssyl")
    public ResponseWrapper<List<HashMap>> pcssyl(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.pcssyl(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    @InterestLog
    @GetMapping("/rainbow/pcssylxq")
    public ResponseWrapper<List<HashMap>> pcssylxq(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.pcssylxq(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    //  出库包裹数
    @InterestLog
    @GetMapping("/rainbow/ckbgs")
    public ResponseWrapper<List<HashMap>> ckbgs(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.ckbgs(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }

    //  在途包裹数
    @InterestLog
    @GetMapping("/rainbow/ztbgs")
    public ResponseWrapper<List<HashMap>> ztbgs(@RequestParam(value = "filterMap", required = false) String filterMap) {
        List<HashMap> list = rainbowKcqktjService.ztbgs(JSON.parseObject(filterMap, HashMap.class));
        return new ResponseWrapper<>(list);
    }



}
