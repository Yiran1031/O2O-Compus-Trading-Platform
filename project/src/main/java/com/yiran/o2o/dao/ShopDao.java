package com.yiran.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yiran.o2o.entity.Shop;

public interface ShopDao {
	
	/**
	 * search store by name, status, category, area
	 * @param shopCondition
	 * @param rotIndex : pick at this row
	 * @param pageSize : return size
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	/**
	 * return the size of queryShopList
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
	/**
	 * search shop by id
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);
	/**
	 * create shop
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	/**
	 * update shop
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
