package com.airchina.xn.dao;

import com.airchina.xn.model.Photos;
import java.util.List;

public interface PhotosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Photos record);

    Photos selectByPrimaryKey(Integer id);

    List<Photos> selectAll();

    int updateByPrimaryKey(Photos record);
}