package com.mediaocean.poc.dao.impl;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.mediaocean.poc.dao.ProductDao;
import com.mediaocean.poc.entity.Product;
import com.mediaocean.poc.entity.SalesEntry;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDaoImpl<Product, String> implements ProductDao {

    protected ProductDaoImpl() {
        super(Product.class);
    }
	@Override
	public List<Product> getAllProducts() {
		 return getCurrentSession().createCriteria(entityClass).setMaxResults(500).list();
	}
	@Override
	public List getAllProductsSalesAndCount(){
		List result = getCurrentSession().createCriteria(SalesEntry.class)       
        .setProjection(Projections.projectionList()
                .add(Projections.groupProperty("product"))
                .add(Projections.sum("saleAmount"))
                .add(Projections.count("product"))           
        ).list();
		return result;
	}
}
