package com.mediaocean.poc.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;

import com.mediaocean.poc.entity.SalesEntry;

public class TestReport {
	
	public static void main(String[] args) {
		Session session = null;
		try{
			 SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			 session = sessionFactory.openSession();
			 List result = session.createCriteria(SalesEntry.class)       
		        .setProjection(Projections.projectionList()
		                .add(Projections.groupProperty("product"))
		                .add(Projections.sum("saleAmount"))
		                .add(Projections.count("product"))           
		        ).list();
			 displayObjectsList(result);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			System.out.println("test");
			 session.flush();
			 session.close();
			}
	}
	static private void displayObjectsList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No objects to display.");
			return;
		}
		while (iter.hasNext()) {
			System.out.println("New object");
			Object[] obj = (Object[]) iter.next();
			for (int i = 0; i < obj.length; i++) {
				System.out.println(obj[i]);
			}
		}
	}

}
