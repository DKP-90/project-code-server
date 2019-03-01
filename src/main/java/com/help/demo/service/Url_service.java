package com.help.demo.service;

import com.help.demo.model.Url;

public interface Url_service {

	Url save(Url data);
	Url fetchlogicById(int id);
	Url delete(int id);
}
