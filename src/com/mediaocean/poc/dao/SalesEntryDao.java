package com.mediaocean.poc.dao;

import java.util.List;

import com.mediaocean.poc.entity.ProductReportDTO;
import com.mediaocean.poc.entity.SalesEntry;

public interface SalesEntryDao extends AbstractDao<SalesEntry, String> {
    
    List<ProductReportDTO> getAllProductsSalesAndCount();
}
