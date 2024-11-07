package vn.edu.hcmuaf.fit.lab6.service;

import vn.edu.hcmuaf.fit.lab6.dao.UserDao;
import vn.edu.hcmuaf.fit.lab6.dao.model.User;

public class AuthService {
    public boolean checkLogin(String username, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.findUserName(username);
        if (user == null) {
            return false;
        }
        return password.equals(user.getPassword());
    }
}
