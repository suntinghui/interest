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
	public HashMap<String, List<HashMap>> jqsxxx_detail(HashMap filterMap) {
		HashMap<String, List<HashMap>> map = new HashMap<>();

		map.put("jqsxxx", RainbowUtil.decodeList(rainbowDjqdatjDao.jqsxxx(filterMap)));
		map.put("mdsxxx", RainbowUtil.decodeList(rainbowDjqdatjDao.mdsxxx(filterMap)));
		map.put("yyzt1", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt1(filterMap)));
		map.put("yyzt2", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt2(filterMap)));
		map.put("yyzt3_jqhkzrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqhkzrs(filterMap)));
		map.put("yyzt3_jqrjgcrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqrjgcrs(filterMap)));
		map.put("yyzt3_jqrjxgcrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqrjxgcrs(filterMap)));
		map.put("yyzt3_jqrjfgrs", RainbowUtil.decodeList(rainbowDjqdatjDao.yyzt3_jqrjfgrs(filterMap)));
		map.put("sbwhtj3", RainbowUtil.decodeList(rainbowDjqdatjDao.sbwhtj3(filterMap)));
		map.put("sbwhtj4", RainbowUtil.decodeList(rainbowDjqdatjDao.sbwhtj4(filterMap)));
		map.put("sbwhtj5", RainbowUtil.decodeList(rainbowDjqdatjDao.sbwhtj5(filterMap)));
		map.put("sbjyxx_xs", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_xs(filterMap)));
		map.put("sbjyxx_tk", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_tk(filterMap)));
		map.put("sbjyxx_tkddbl", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_tkddbl(filterMap)));
		map.put("sbjyxx_drxs", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_drxs(filterMap)));
		map.put("sbjyxx_drtk", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_drtk(filterMap)));
		map.put("sbjyxx_drpzxl", RainbowUtil.decodeList(rainbowDjqdatjDao.sbjyxx_drpzxl(filterMap)));

		return map;
	}

	@Override
	public HashMap<String, Object> jqsxxx_transfer_list(HashMap filterMap) {
		HashMap<String, Object> map = new HashMap<>();

		List<HashMap> list = RainbowUtil.decodeList(rainbowDjqdatjDao.jqsxxx_transfer_list(filterMap));
		HashMap<String, String> minmaxMap = rainbowDjqdatjDao.jqsxxx_transfer_minmax(filterMap);
		map.put("list", list);

		try {
			map.put("min", minmaxMap.get("min"));
		} catch (Exception e) {
			map.put("min", "0");
		}

		try {
			map.put("max", minmaxMap.get("max"));
		} catch (Exception e) {
			map.put("max", "0");
		}

		return map;
	}


}
