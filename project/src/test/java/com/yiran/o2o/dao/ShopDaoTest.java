package com.yiran.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yiran.o2o.BaseTest;
import com.yiran.o2o.entity.Area;
import com.yiran.o2o.entity.PersonInfo;
import com.yiran.o2o.entity.Shop;
import com.yiran.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		
		parentCategory.setShopCategoryId(1L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
//		PersonInfo owner = new PersonInfo();
//		owner.setUserId(1L);
//		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 10);
		System.out.println("shop size : " + shopList.size());
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("shop count:" + count);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shopCondition.setShopCategory(sc);
//		shopList = shopDao.queryShopList(shopCondition, 0, 5);
//		System.out.println("size by 1:" + shopList.size());
//		count = shopDao.queryShopCount(shopCondition);
//		System.out.println("count by 1:" + count);
		
	}
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId=1;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("shop id:" + shop.getArea().getAreaId());
		System.out.println("shop area name: " + shop.getArea().getAreaName());
	}
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("test shop");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("11111111");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("checking");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("update desc");
		shop.setShopAddr("update test");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}
