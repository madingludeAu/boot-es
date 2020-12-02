package com.es.mapper;

import com.es.entity.Shebei;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShebeiMapper {


    List<Shebei> findList(Shebei shebei);

}
