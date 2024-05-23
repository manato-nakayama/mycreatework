package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.MyWorkDataInterface;
import com.example.demo.data.MyWorkDataService;
import com.example.demo.model.MyWorkModel;

@RestController
public class MyCreateWorkController {
	@Autowired
	MyWorkDataService service;

	//gameにアクセスしたらjsonデータを表示する
	@GetMapping("/game")
	@CrossOrigin
	public List<? extends MyWorkDataInterface> mywork() {
		System.out.println("mywork/game");
		return service.getAll();
	}

	//追加依頼をされたら
	@PostMapping("/game/add")
	@CrossOrigin
	public int add(@RequestBody MyWorkModel formula) {
		System.out.println("game/add(POST)");
		return service.add(formula);
	}

	//DatabaseCreate.javaのメソッドをControllerで扱えるように
	@Autowired
	DatabaseCreate databaseCreate;

	//データ更新依頼をされたら
	@PostMapping("/game/initialize-database")
	@CrossOrigin
	public String initializeDatabase() {
		try {
			System.out.println("game/initialize-database(POST)");
			// データベースを初期化
			databaseCreate.afterPropertiesSet();
			return "Database initialized successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to initialize database";
		}
	}

}
