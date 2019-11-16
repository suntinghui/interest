package com.interest.service;

import com.interest.model.entity.ParamEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;

import java.util.HashMap;
import java.util.List;

public interface RainbowDjqdatjService {

	PageResult jqsxxx_list(PageWrapper pageWrapper, HashMap filterMap);

	HashMap<String, List<HashMap>> jqsxxx_detail(HashMap filterMap);

}
