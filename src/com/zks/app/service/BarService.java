package com.zks.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zks.app.domain.Bar;

public interface BarService {
	public boolean create(Bar bar);
	public List<Bar> list();
}
