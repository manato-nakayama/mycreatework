package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCreate implements InitializingBean {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		// データベースの初期化処理をここに記述する
		initializeDatabase();
	}

	private void initializeDatabase() {
		// logテーブルが存在するか確認して、存在する場合は削除する
		if (checkTableExists("log")) {
			dropTable();
			createTable();
		} else {
			createTable();
		}
	}

	//テーブルが存在するかチェックする
	private boolean checkTableExists(String tableName) {
		String query = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?";
		int count = jdbcTemplate.queryForObject(query, Integer.class, tableName);
		return count > 0;
	}

	private void dropTable() {
		jdbcTemplate.execute("DROP TABLE log");
	}

	private void createTable() {
		jdbcTemplate.execute("CREATE TABLE log (id INT AUTO_INCREMENT PRIMARY KEY, formula VARCHAR(255))");
	}
}
