package com.yiran.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiran.o2o.dao.AreaDao;
import com.yiran.o2o.entity.Area;
import com.yiran.o2o.service.AreaService;

// The notation means this class belongs to services leyer and control by spring.
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}
	
}
