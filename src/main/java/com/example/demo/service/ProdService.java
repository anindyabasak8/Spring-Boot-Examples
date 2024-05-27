package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
public class ProdService {
	
	
	@Autowired
	private JdbcClient jdbcClient;
	
	public List<Product> getAll(){
		String query = "Select * from product";
		return jdbcClient.sql(query).query(Product.class).list();
	}
	
	
	public Product getAProduct(int pid) {
		String query = "Select * from product where pid = :pid";
		return jdbcClient.sql(query).param("pid",pid).query(Product.class).single();
	}
	
	public Product saveProd(Product pr) {	
		String query = "Insert into Product(pid,name,quantity,price) values(?,?,?,?)";
		int p = jdbcClient.sql(query).params(List.of(pr.getPid(),pr.getName(),pr.getQuantity(),
				pr.getPrice())).update();
		
		if(p>0) {
			return pr;
		}
		return null;
	}
	
	public String updateProd(int pid,Product pr) {	
		String query = "update  Product set name = ?, quantity = ?, price = ? where pid = ?";
		jdbcClient.sql(query).params(List.of(pr.getName()+"_Updated",pr.getQuantity(),
				pr.getPrice(),pid)).update();
		
		return "Data Updated!";
	}
	
	public String deleteProd(int pid) {	
		String query = "delete from product where pid = :pid";
		jdbcClient.sql(query).param("pid",pid).update();
		
		return "Data Deleted!";
	}
	

}
