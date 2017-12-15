package co.com.sbaqueroa.zkdev.services;

import co.com.sbaqueroa.zkdev.entity.Log;
import java.util.List;

public interface MyService {

	Log addLog(Log log);

	List<Log> getLogs();

	void deleteLog(Log log);
}
