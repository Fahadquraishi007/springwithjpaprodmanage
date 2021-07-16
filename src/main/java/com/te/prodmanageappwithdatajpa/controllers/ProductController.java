package com.te.prodmanageappwithdatajpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.prodmanageappwithdatajpa.beans.ProductInfoBean;
import com.te.prodmanageappwithdatajpa.beans.ProductResponse;
import com.te.prodmanageappwithdatajpa.dao.ProductRepository;


@RestController
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@PostMapping("/login")
	public ProductResponse authenticate(int pid , String password) {
		ProductResponse response = new ProductResponse();
	    ProductInfoBean infoBean =	repo.authenticate(pid, password);
	    int count = repo.countOfEmployees();
		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success Number of Employees "+ count);
			response.setDescription("Logged in Successfully");
			response.setProductInfoBean(infoBean);
		} else {
			
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Invalid Crendentials");
		}

		return response;
	}

	@PostMapping("/add")
	public ProductResponse storeData(@RequestBody ProductInfoBean infoBean) {
		ProductResponse response = new ProductResponse();
		Optional<ProductInfoBean> optional = repo.findById(infoBean.getPid());

		if (optional.isPresent()) {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data is already Present for Pid : " + infoBean.getPid());
		} else {
			repo.save(infoBean);// store the record
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data is Stored for Pid : " + infoBean.getPid());
		}

		return response;
	}

	@GetMapping("/get/{id}")
	public ProductResponse getData(@PathVariable int pid) {
		ProductResponse response = new ProductResponse();
		Optional<ProductInfoBean> optional = repo.findById(pid);
		if (optional.isPresent()) {

			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data is Found for Pid : " + pid);
			response.setProductInfoBean(optional.get());

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Data Not Found for Id : " + pid);

		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ProductResponse deleteData(@PathVariable int pid) {
		ProductResponse response = new ProductResponse();
		Optional<ProductInfoBean> optional = repo.findById(pid);

		if (optional.isPresent()) {
			repo.deleteById(pid);
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Deleted for Id : " + pid);

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Data Not Found for Id : " + pid);

		}
		return response;
	}

	@PutMapping("/update")
	public ProductResponse updateData(@RequestBody ProductInfoBean infoBean) {
		ProductResponse response = new ProductResponse();
		Optional<ProductInfoBean> optional = repo.findById(infoBean.getPid());

		if (optional.isPresent()) {
			repo.save(infoBean);
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data updated Successfully");
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Data not found");
		}

		return response;
	}

	@GetMapping("/getall")
	public ProductResponse getAll() {
		ProductResponse response = new ProductResponse();

		List<ProductInfoBean> infoBeans = repo.findAll();
		response.setStatusCode(200);
		response.setMsg("Success");
		response.setDescription("Data Found");
		response.setProductInfoBeans(infoBeans);
		return response;
	}
}
