package com.help.demo.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.help.demo.model.Content;
import com.help.demo.model.Link;
import com.help.demo.model.Media;
import com.help.demo.model.Response;
import com.help.demo.model.Url;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class Crawl_implementation implements Crawl_service {

	@Autowired
	Response res;
	@Autowired
	Url_service url_obj;
	 @Autowired
	 private RestTemplate restTemplate;
	 @Autowired
	 private LoadBalancerClient client;
	Url url_data=new Url();
	Content content_data=new Content();
	ArrayList<Link> link_array=new ArrayList<Link>();
	ArrayList<Media> media_array=new ArrayList<Media>();
	
	@HystrixCommand(fallbackMethod="crawl_fallback",commandKey="crawl_1",groupKey="crawl_2")
	public Response crawl (String URL)
	{    	        
            try {	 
            	
            	url_data.setId(MD5(URL));
            	url_data.setUrl(URL);
            	            	
                Document document = Jsoup.connect(URL).get();	               
                Elements linksOnPage = document.select("a[href]");                
                content_data.setId(MD5(URL));
                content_data.setHttp_response("200");
                content_data.setTitle(document.title().toString());
                content_data.setContent(document.select("meta[content]").text().toString());               
                for (Element page : linksOnPage) 
                {                
                	Link link_data=new Link();                	
                	link_data.setId(MD5(URL));
                	link_data.setLink(page.attr("abs:href").toString());
                	link_data.setTxt(page.text().toString());
                	link_array.add(link_data);
                	
                	Media media_data=new Media();  
                	Elements img = document.getElementsByTag("img");
                	for (Element el : img) 
                	{                	
                	media_data.setId_m(MD5(URL));
                	media_data.setMurl(el.absUrl("src"));
                	
                	}                	
                	media_array.add(media_data);
                }
                                
                	    
            }
            catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
                content_data.setHttp_response("408");
                res.setSuccess(false);
                res.setMessage("Failed");
            }
            url_data.setLink_type(link_array);
            url_data.setContent_type(content_data);
            url_data.setMedia_type(media_array);
        	url_obj.save(url_data);
        	for(int i=49;i<65;i++)
            {
        	//LOAD BALANCING
            //	String url = client.choose("project-client").getUri() +"/download?id="+ String.valueOf(i);
            	String url = "http://project-client/download?id="+ String.valueOf(i);
            	System.out.println(url);
            	try
            	{
            	 res.setMessage(restTemplate.getForObject(url, String.class));
            	}catch (Exception e) {
            		
				}
            }
            res.setSuccess(true);
            res.setMessage("Successful");
            
		return res;		
	}
	
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
	public Response crawl_fallback (String URL)
	{ 		
		return res;	
	}
}