package com.yiran.o2o.dao;

import com.yiran.o2o.entity.Shop;

public interface ShopDao {
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
