package com.interest.service.impl;

import com.interest.dao.rainbow.RainbowDjqdatjDao;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.RainbowDjqdatjService;
import com.interest.utils.RainbowUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RainbowDjqdatjServiceImpl implements RainbowDjqdatjService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public RainbowDjqdatjDao rainbowDjqdatjDao;
	
	@Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public PageResult jqsxxx_list(PageWrapper pageWrapper ,HashMap filterMap) {
		List<HashMap> list = RainbowUtil.decodeList(rainbowDjqdatjDao.jqsxxx_list(pageWrapper,filterMap));
		int size = rainbowDjqdatjDao.jqsxxx_list_count(filterMap);
		return new PageResult<>(list, size);
	}

	@Override
	public HashMap<String, List<HashMap>> jqsxxx_detail(String startDate, String endDate, String ddiNo, String shopNo) {
		HashMap<String, List<HashMap>> map = new HashMap<>();

		map.put("jqsxxx", RainbowUtil.decodeList(rainbowDjqdatjDao.jqsxxx(ddiNo, startDate, endDate)));
		map.put("mdsxxx", RainbowUtil.decodeList(rainbowDjqdatjDao.mdsxxx(ddiNo, startDate, endDate, shopNo)));
		map.put("yyzt1", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt1(ddiNo, startDate, endDate)));
		map.put("yyzt2", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt2(ddiNo, startDate, endDate)));
		map.put("yyzt3_jqhkzrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqhkzrs(ddiNo, startDate, endDate)));
		map.put("yyzt3_jqrjgcrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqrjgcrs(ddiNo, startDate, endDate)));
		map.put("yyzt3_jqrjxgcrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqrjxgcrs(ddiNo, startDate, endDate, shopNo)));
		map.put("yyzt3_jqrjfgrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqrjfgrs(ddiNo, startDate, endDate)));
		map.put("sbwhtj3", RainbowUtil.decodeList(rainbowDjqdatjDao.sbwhtj3(ddiNo, startDate, endDate)));
		map.put("sbwhtj4", RainbowUtil.decodeList(rainbowDjqdatjDao.sbwhtj4(ddiNo, startDate, endDate)));
		map.put("sbwhtj5", RainbowUtil.decodeList(rainbowDjqdatjDao.sbwhtj5(ddiNo, startDate, endDate)));
		map.put("sbjyxx_xs", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_xs(ddiNo, startDate, endDate)));
		map.put("sbjyxx_tk", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_tk(ddiNo, startDate, endDate)));
		map.put("sbjyxx_tkddbl", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_tkddbl(ddiNo, startDate, endDate)));
		map.put("sbjyxx_drxs", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_drxs(ddiNo, startDate, endDate)));
		map.put("sbjyxx_drtk", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_drtk(ddiNo, startDate, endDate)));
		map.put("sbjyxx_drpzxl", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_drpzxl(ddiNo, startDate, endDate)));

		return map;
	}


}
