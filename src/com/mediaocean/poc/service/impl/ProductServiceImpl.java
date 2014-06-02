package com.mediaocean.poc.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mediaocean.poc.dao.ProductDao;
import com.mediaocean.poc.dao.SalesEntryDao;
import com.mediaocean.poc.entity.Product;
import com.mediaocean.poc.entity.ProductReportDTO;

@Service("productService")
public class ProductServiceImpl {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private SalesEntryDao salesEntryDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
	public void insertProduct(Product product) throws Exception {
		productDao.saveOrUpdate(product);
		//throw new Exception("test");
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
	public List<ProductReportDTO> generateReport() {
		List productList = salesEntryDao.getAllProductsSalesAndCount();
		List<ProductReportDTO> productDTOList = this.displayObjectsList(productList);
		return productDTOList;
	}

	private List<ProductReportDTO> displayObjectsList(List list) {
		List<ProductReportDTO> productDTOList = new ArrayList<ProductReportDTO>();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				ProductReportDTO productReportDTO = new ProductReportDTO();
				Product product = (Product)obj[0];
				productReportDTO.setProduct(product);
				productReportDTO.setSumOfProduct(Double.valueOf(obj[1].toString()));
				productReportDTO.setProductCount(Long.valueOf(obj[2].toString()));
				productDTOList.add(productReportDTO);
				System.out.println("Product Name : "+ product.getProductName() + "::Product ID is :"+ product.getProductId());
		}
		return productDTOList;
	}
}
