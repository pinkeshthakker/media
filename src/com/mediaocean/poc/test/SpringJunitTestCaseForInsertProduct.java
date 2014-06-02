package com.mediaocean.poc.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediaocean.poc.entity.Product;
import com.mediaocean.poc.entity.ProductReportDTO;
import com.mediaocean.poc.entity.SalesEntry;
import com.mediaocean.poc.service.impl.ProductServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration()
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml", "classpath:/spring/hibernateContext.xml"})
public class SpringJunitTestCaseForInsertProduct {
		
	@Autowired
	private ProductServiceImpl productService;

	 @Test
	 public void testInsertProduct() throws Exception {
		 Product product = new Product();
			Set<SalesEntry> salesEntrySet = new HashSet<SalesEntry>();
			product.setProductName("Product"+ new Date().getTime());
			for (int i = 0; i < 2; i++) {
				SalesEntry salesEntry = new SalesEntry();
				salesEntry.setDateOfSale(new Date());
				salesEntry.setProduct(product);
				salesEntry.setSaleAmount(Math.random() + 400);
				salesEntrySet.add(salesEntry);
			}
			product.setSalesEntry(salesEntrySet);
			productService.insertProduct(product);
	}
}
