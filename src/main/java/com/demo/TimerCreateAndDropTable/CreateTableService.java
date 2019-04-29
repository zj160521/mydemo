package com.demo.TimerCreateAndDropTable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CreateTableService implements ICreateTableDao {
	
	@Autowired
	private ICreateTableDao dao;

	public void createTble(Map<String, String> tableName) {
		dao.createTble(tableName);
	}

	@Override
	public List<Integer> getWorkerIds(Map<String, String> map) {
		return dao.getWorkerIds(map);
	}
}
