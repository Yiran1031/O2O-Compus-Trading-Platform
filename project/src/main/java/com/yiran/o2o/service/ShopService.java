package com.yiran.o2o.service;

import java.io.File;
import java.io.InputStream;

import com.yiran.o2o.dto.ImageHolder;
import com.yiran.o2o.dto.ShopExecution;
import com.yiran.o2o.entity.Shop;
import com.yiran.o2o.exceptions.ShopOperationException;

public interface ShopService {
	/**
	 * return shop information by page and list
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	/**
	 * get shop information by shop id
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	/**
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	
	/**
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */	
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
