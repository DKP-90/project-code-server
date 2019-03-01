package com.help.demo.service;

import com.help.demo.model.Response;

public interface Crawl_service {

	Response crawl (String URL);
	Response crawl_fallback (String URL);
}