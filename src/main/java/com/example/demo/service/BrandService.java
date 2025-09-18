package com.example.demo.service;

import com.example.demo.entity.Brand;
import com.example.demo.mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.SqlSessionFactoryUtil;

import java.util.List;

public class BrandService {
//    TODO 试着直接引入Mapper
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public List<Brand> findAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.findAll();
        sqlSession.close();
        return brandList;
    }
}
