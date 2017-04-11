package com.lanxiang.mybatis.analysis.use.mapper;

import com.lanxiang.mybatis.analysis.use.model.Kindle;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lanxiang on 2017/3/27.
 */
public interface KindleMapper {

    @Select("select * from kindle where version = #{version}")
    @ResultMap("BaseResultMap")
    List<Kindle> queryByVersion(int version);

    int insert(Kindle kindle);

    List<Kindle> selectKindle(int version);

    List<Kindle> joinSelect(int version);
}
