package com.yiran.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yiran.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * return  store category by shopid
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);
	/**
	 * catch process for category
	 * @param productCategoryList
	 * @return
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	/**
	 * delete specified category
	 * @param productCategoryId
	 * @param shopId
	 * @return effectedNum
	 */
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
