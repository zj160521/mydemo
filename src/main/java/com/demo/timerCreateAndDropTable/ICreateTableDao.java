package com.demo.timerCreateAndDropTable;

import java.util.List;
import java.util.Map;

public interface ICreateTableDao {
	public void createTble(Map<String, String> map);
	
	public List<Integer> getWorkerIds(Map<String, String> map);
}
