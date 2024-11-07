package vn.edu.hcmuaf.fit.lab6.dao;

import vn.edu.hcmuaf.fit.lab6.dao.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    static Map<String, User> data = new HashMap<String, User>();
    static {
        data.put("Kane", new User("Kane", "111", "Harry Kane"));
        data.put("Musiala", new User("Musiala", "112", "Jamal Musiala"));
        data.put("Justin", new User("Justin", "113", "Justin Bieber"));
    }

    public User findUserName(String username){
        return data.get(username);
    }
}
