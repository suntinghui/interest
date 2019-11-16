package com.interest.dao.rainbow;

import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RainbowDjqdatjDao {

    // 机器属性信息
    List<HashMap> jqsxxx_list(@Param("pageWrapper") PageWrapper pageWrapper, @Param("filterMap") HashMap filterMap);

    int jqsxxx_list_count(@Param("filterMap") HashMap filterMap);

    List<HashMap> jqsxxx(@Param("filterMap") HashMap filterMap);

    List<HashMap> mdsxxx(@Param("filterMap") HashMap filterMap);

    List<HashMap> yyzt1(@Param("filterMap") HashMap filterMap);

    List<HashMap> yyzt2(@Param("filterMap") HashMap filterMap);

    List<HashMap> yyzt3_jqhkzrs(@Param("filterMap") HashMap filterMap);

    List<HashMap> yyzt3_jqrjgcrs(@Param("filterMap") HashMap filterMap);

    List<HashMap> yyzt3_jqrjxgcrs(@Param("filterMap") HashMap filterMap);

    List<HashMap> yyzt3_jqrjfgrs(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbwhtj3(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbwhtj4(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbwhtj5(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbjyxx_xs(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbjyxx_tk(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbjyxx_tkddbl(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbjyxx_drxs(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbjyxx_drtk(@Param("filterMap") HashMap filterMap);

    List<HashMap> sbjyxx_drpzxl(@Param("filterMap") HashMap filterMap);

}
