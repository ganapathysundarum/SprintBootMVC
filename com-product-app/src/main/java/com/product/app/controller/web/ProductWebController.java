package com.product.app.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.app.model.Product;
import com.product.app.service.ProductDAOService;

@Controller
public class ProductWebController {
	
	@Autowired
	private ProductDAOService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	private String listProducts(ModelMap model) {
		model.put("products",service.getProducts());
		return "list-products";
	}
	
	@RequestMapping(value="/add-product",method=RequestMethod.GET)
	private String showAddProductPage(ModelMap model) {		
		model.addAttribute("product", new Product((String)model.get("name"),
				(String)model.get("type"),
				(String)model.get("brand"),
				(Double)(model.get("retailPrice")!=null?model.get("retailPrice"):new Double(0)),
				(Double)(model.get("weight")!=null?model.get("weight"):new Double(0)),
				(String)model.get("size"),
				new Date(),
				new Date()));
		
		return "product";
	}
	
	@RequestMapping(value="/add-product",method=RequestMethod.POST)
	public String addProduct(ModelMap model, @Valid Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "product";
		}
				
		service.insert(product);
		
		return "redirect:/products";
	}

	@RequestMapping(value="/delete-product",method=RequestMethod.GET)
	public String deleteBook(@RequestParam long id) {
		service.deleteProduct(id);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/update-product",method=RequestMethod.GET)
	public String showUpdateProduct(@RequestParam long id,ModelMap model) {
		Optional<Product> prod = service.readProduct(id);
		model.put("product",prod);
		return "product";
	}

	
	@RequestMapping(value="/update-product",method=RequestMethod.POST)
	public String updateProduct(@RequestParam long id,ModelMap model, @Valid Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			return "product";
		}
		
		Product prod = (Product)model.get("product");
		product.setName(prod.getName());
		product.setType(prod.getType());
		product.setBrand(prod.getBrand());
		product.setRetailPrice(prod.getRetailPrice());
		product.setWeight(prod.getWeight());
		product.setSize(prod.getSize());
		product.setManufactured(prod.getManufactured());
		product.setExpiry(prod.getExpiry());
		
		service.updateProduct(product);
		
		return "redirect:/products";
	}
	
}
