package com.mediaocean.poc.dao.impl;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.mediaocean.poc.dao.SalesEntryDao;
import com.mediaocean.poc.entity.ProductReportDTO;
import com.mediaocean.poc.entity.SalesEntry;

@Repository("salesEntryDao")
public class SalesEntryDaoImpl extends AbstractDaoImpl<SalesEntry, String> implements SalesEntryDao {

    protected SalesEntryDaoImpl() {
        super(SalesEntry.class);
    }
	
	@Override
	public List<ProductReportDTO> getAllProductsSalesAndCount(){
		List result = getCurrentSession().createCriteria(entityClass)       
        .setProjection(Projections.projectionList()
                .add(Projections.groupProperty("product"))
                .add(Projections.sum("saleAmount"))
                .add(Projections.count("product"))           
        ).list();
		return result;
	}
}
