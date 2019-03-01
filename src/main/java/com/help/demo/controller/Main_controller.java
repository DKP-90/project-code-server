package com.help.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.help.demo.model.Response;
import com.help.demo.service.Crawl_service;
import com.help.demo.service.Url_service;


@RestController
public class Main_controller {
	
	@Autowired
	Url_service url_obj;	
	@Autowired
	Response res;
	@Autowired
	Crawl_service crawl_obj;
	
	
//	 @RequestMapping(value = "/url", method = RequestMethod.POST)
//	    public Url save(@RequestBody Url data) { 
//		
//	        return url_obj.save(data);
//	    }
//	    
//	    @RequestMapping(value = "/url",method = RequestMethod.DELETE)
//	    public ResponseEntity<Url> delete(@RequestParam int id){
//
//	    	url_obj.delete(id);
//	         return null;
//	    }
//
//	    @RequestMapping(value = "/url",method = RequestMethod.GET)
//	  public ResponseEntity<Url> fetchid(@RequestParam int id){
//
//	        Url data= url_obj.fetchlogicById(id);
//	        
//	        if(data==null){
//	          return   ResponseEntity.notFound().build();
//	        }else{
//	            return  ResponseEntity.ok().body(data);
//	        }
//	  }
	   

	    @RequestMapping(value = "/crawl",method = RequestMethod.GET)
	    public ResponseEntity<Response> getPageLinks() {

	    	res=crawl_obj.crawl("https://www.mkyong.com/java/jsoup-basic-web-crawler-example/");	    	
	        return ResponseEntity.ok().body(res);
	    }
	    

}
