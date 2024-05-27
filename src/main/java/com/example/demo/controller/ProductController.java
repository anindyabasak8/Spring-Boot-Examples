package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProdService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public ProdService serv;
	
	@GetMapping("/get")
	public List<Product> getAll(){
		return serv.getAll();
	}
	
	@GetMapping("/get/{pid}")
	public Product getProduct(@PathVariable int pid) {
		return serv.getAProduct(pid);
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product pr) {
		return serv.saveProd(pr);
	}
	
	
	@PutMapping("/update/{pid}")
	public String updateProduct(@PathVariable int pid,@RequestBody Product pr) {
		return serv.updateProd(pid,pr);
	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		return serv.deleteProd(pid);
	}

}
