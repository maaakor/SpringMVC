package Service;

import model.LogEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huangfei on 2015/8/31.
 */
public interface LogService {

    public List getAllLog();

    public LogEntity getLog(LogEntity log );

    public List getLogByTime(String start, String end);

    public void saveOrUpdate(LogEntity log);

    public void batchSaveOrUpdate(List<LogEntity>logEntities);



}
