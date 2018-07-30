package com.hewuqi.miniapp.baidu.dao;

import com.hewuqi.miniapp.baidu.model.OcrToken;
import com.hewuqi.miniapp.baidu.model.OcrTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcrTokenMapper {
    int countByExample(OcrTokenExample example);

    int deleteByExample(OcrTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcrToken record);

    int insertSelective(OcrToken record);

    List<OcrToken> selectByExample(OcrTokenExample example);

    OcrToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcrToken record, @Param("example") OcrTokenExample example);

    int updateByExample(@Param("record") OcrToken record, @Param("example") OcrTokenExample example);

    int updateByPrimaryKeySelective(OcrToken record);

    int updateByPrimaryKey(OcrToken record);
}