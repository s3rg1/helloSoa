package org.example.soacourse.logic;

import java.util.ArrayList;
import java.util.List;

import org.example.soacourse.model.ProductBean;

public class ProductLogic {
	
	public ArrayList<ProductBean> findProductsByStatus(List<String> status) {
		ArrayList<ProductBean> arr = new ArrayList<ProductBean>();
    	arr.add(new ProductBean("Prod 3", 99.9));
    	arr.add(new ProductBean("Prod 4", 2.34));
		return arr;
	}
	
	public ProductBean getProductDetails(long productId) {
		ProductBean pb = new ProductBean("Prod 1", 12.5);
		pb.setId(productId);
		return pb;
	}

}
