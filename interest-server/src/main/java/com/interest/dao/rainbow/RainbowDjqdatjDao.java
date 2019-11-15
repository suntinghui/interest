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

    List<HashMap> jqsxxx(String ddiNo, String startDate, String endDate);

    List<HashMap> mdsxxx(String ddiNo, String startDate, String endDate, String shopNo);

    List<HashMap> yyzt1(String ddiNo, String startDate, String endDate);

    List<HashMap> yyzt2(String ddiNo, String startDate, String endDate);

    List<HashMap> yyzt3_jqhkzrs(String ddiNo, String startDate, String endDate);

    List<HashMap> yyzt3_jqrjgcrs(String ddiNo, String startDate, String endDate);

    List<HashMap> yyzt3_jqrjxgcrs(String ddiNo, String startDate, String endDate, String shopNo);

    List<HashMap> yyzt3_jqrjfgrs(String ddiNo, String startDate, String endDate);

    List<HashMap> sbwhtj3(String ddiNo, String startDate, String endDate);

    List<HashMap> sbwhtj4(String ddiNo, String startDate, String endDate);

    List<HashMap> sbwhtj5(String ddiNo, String startDate, String endDate);

    List<HashMap> sbjyxx_xs(String ddiNo, String startDate, String endDate);

    List<HashMap> sbjyxx_tk(String ddiNo, String startDate, String endDate);

    List<HashMap> sbjyxx_tkddbl(String ddiNo, String startDate, String endDate);

    List<HashMap> sbjyxx_drxs(String ddiNo, String startDate, String endDate);

    List<HashMap> sbjyxx_drtk(String ddiNo, String startDate, String endDate);

    List<HashMap> sbjyxx_drpzxl(String ddiNo, String startDate, String endDate);

}
