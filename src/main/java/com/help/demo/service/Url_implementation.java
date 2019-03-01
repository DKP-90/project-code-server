package com.help.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.demo.controller.model.repository.url_repo;
import com.help.demo.model.Url;



@Service
public class Url_implementation implements Url_service {

	@Autowired
	url_repo url_obj;
	
	@Override
	public Url save(Url data) {
		return url_obj.save(data);
	}

	@Override
	public Url fetchlogicById(int id) {
		Optional<Url> url_return= url_obj.findById( id);
	     if(url_return.isPresent()){
	         return url_return.get();
	     }
	     return null;
	}

	@Override
	public Url delete(int id) {
		url_obj.deleteById(id);
		 return null;
	}
	

}
