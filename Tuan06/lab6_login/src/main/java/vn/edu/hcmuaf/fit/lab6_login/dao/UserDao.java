package vn.edu.hcmuaf.fit.lab6_login.dao;

import vn.edu.hcmuaf.fit.lab6_login.dao.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    static Map<String, User> users = new HashMap<String, User>();
    static {
        users.put("ti", new User("ti", "111", "ti"));
        users.put("teo", new User("teo", "112", "teo"));
        users.put("tun", new User("tun", "113", "tun"));
    }
    public User findUserName(String username){
        return users.get(username);

    }
}
