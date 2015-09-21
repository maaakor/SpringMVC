package Service;

import model.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by huangfei on 2015/6/21.
 */
public interface UserService {
    public void add(UserEntity userEntity);

    public List getAllUser();

    public List getUserByParam(Map<String, Object> data);

    public void addUser(List<Object[]> list);
}
