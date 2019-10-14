package com.yiran.o2o.web.shopadmin;

import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yiran.o2o.dto.ShopExecution;
import com.yiran.o2o.entity.Area;
import com.yiran.o2o.entity.PersonInfo;
import com.yiran.o2o.entity.Shop;
import com.yiran.o2o.entity.ShopCategory;
import com.yiran.o2o.enums.ShopStateEnum;
import com.yiran.o2o.exceptions.ShopOperationException;
import com.yiran.o2o.service.AreaService;
import com.yiran.o2o.service.ShopCategoryService;
import com.yiran.o2o.service.ShopService;
import com.yiran.o2o.util.CodeUtil;
import com.yiran.o2o.util.HttpServletRequestUtil;
import com.yiran.o2o.util.ImageUtil;
import com.yiran.o2o.util.PathUtil;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopCategoryService shopCategoryService;
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopInitInfo() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList=  new ArrayList<Area>();
		try {
			//get all list
			shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
			areaList = areaService.getAreaList();
			modelMap.put("shopCategoryList", shopCategoryList);
			modelMap.put("areaList", areaList);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			e.printStackTrace();
		}
		return modelMap;
	}
	
	
	
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if(!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "verify code is not right");
			return modelMap;
		}
		
		//1. get and convert parameter(shop information and image information
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		}catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		//1.1 get image
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
			
		} else {// if upload image is not necessary, just remove this code.
			modelMap.put("success", false);
			modelMap.put("errMsg", "image must be uploaded");
			return modelMap;
		}
		//2. register shop
		
		if (shop != null && shopImg != null) {
			PersonInfo owner = new PersonInfo(); // we can get it from session
			owner.setUserId(1L);// temp code, session todo
			shop.setOwner(owner);
			
//			 commonsMultipartResolver object can not convert to File object directly
//			 we use File because it easy to do unit test in service layer.
//			 I use a trick way to do that, however this makes whole system unstable
//			 newest function has been updated.
			
			
//			File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
//			try {
//				shopImgFile.createNewFile();
//			} catch (IOException e) {
//				modelMap.put("success", false);
//				modelMap.put("errMsg", e.getMessage());
//				return modelMap;
//			}
//			try {
//				inputStreamToFile(shopImg.getInputStream(), shopImgFile);	
//			} catch (IOException e) {
//				modelMap.put("success", false);
//				modelMap.put("errMsg", e.getMessage());
//				return modelMap;
//			}
			ShopExecution se;
			try {
				se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			} catch (ShopOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "please input shop information");
			return modelMap;
		}
		//3. return result
	}
	
//	private static void inputStreamToFile(InputStream ins, File file) {
//		FileOutputStream os = null;
//		try {
//			os = new FileOutputStream(file);
//			int bytesRead = 0;
//			byte[] buffer = new byte[1024];
//			while ((bytesRead = ins.read(buffer)) != -1) {
//				os.write(buffer, 0, bytesRead);
//			}
//		}catch (Exception e) {
//			throw new RuntimeException("call inputStreamToFile error: " + e.getMessage() );
//		}finally {
//			try {
//				if (os != null) {
//					os.close();
//				}
//				if (ins != null) {
//					ins.close();
//				}
//			}catch (IOException e) {
//				throw new RuntimeException("call close inputStreamToFile I/O stream error: " + e.getMessage() );
//			}
//		}
//	}
}
