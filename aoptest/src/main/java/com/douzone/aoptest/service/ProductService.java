package com.douzone.aoptest.service;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVo;

@Service
public class ProductService {

	public ProductVo find(String name) {
		System.out.println("[ProductService] Finding...");
		ProductVo vo = new ProductVo(name);
//		if (1-1 == 0) {
//			throw new RuntimeException("MyFindException");
//		}
		return vo;
	}

}
