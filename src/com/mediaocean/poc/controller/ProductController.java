package com.mediaocean.poc.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mediaocean.poc.entity.Product;
import com.mediaocean.poc.entity.ProductReportDTO;
import com.mediaocean.poc.entity.SalesEntry;
import com.mediaocean.poc.service.impl.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value = "insertProduct.do")
	public String showUserList(Model model) throws Exception {
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
		// model.addAttribute("users", users);
		return "success";
	}
	@RequestMapping(value = "productReport.do")
	public String displayReport(Model model) {
		List<ProductReportDTO> productsReport = productService.generateReport();
		model.addAttribute("products", productsReport);
		return "displayReport";
	}
}
