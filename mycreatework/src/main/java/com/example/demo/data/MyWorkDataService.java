package com.example.demo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyWorkModel;
import com.example.demo.repositories.WorkRepository;

@Service
public class MyWorkDataService {
	@Autowired
	private WorkRepository repository;

	public List<? extends MyWorkDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}

	public int add(MyWorkDataInterface data) {
		System.out.println("Service.add[" + data + "]");
		if (data instanceof MyWorkModel) {
			MyWorkModel savedData = repository.saveAndFlush((MyWorkModel) data);
			return savedData.getId();
		}
		return 0;
	}

}
