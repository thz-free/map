package com.example.map.dao;

import com.example.map.domain.dginfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IDginfoDao{
    //发布代购事件
      void setDgInfo(dginfo dgInfo)throws Exception;


}
