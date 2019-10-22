package com.yiran.o2o.service;

import java.util.List;

import com.yiran.o2o.dao.ProductCategoryDao;
import com.yiran.o2o.dto.ProductCategoryExecution;
import com.yiran.o2o.entity.ProductCategory;
import com.yiran.o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	public List<ProductCategory> getProductCategoryList(Long shopId);
	
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;

	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;	
}
