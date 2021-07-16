package com.te.prodmanageappwithdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.prodmanageappwithdatajpa.beans.ProductInfoBean;

@Repository
public interface ProductRepository  extends JpaRepository<ProductInfoBean, Integer>{

	@Query("from ProductInfoBean where pid=:pid and password=:pwd")
	public ProductInfoBean authenticate(int pid , String pwd) ;
	
	@Query("select count(*) from ProductInfoBean")
	public int countOfEmployees();
	
}
