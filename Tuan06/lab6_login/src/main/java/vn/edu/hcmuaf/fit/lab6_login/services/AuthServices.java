package vn.edu.hcmuaf.fit.lab6_login.services;

import vn.edu.hcmuaf.fit.lab6_login.dao.UserDao;
import vn.edu.hcmuaf.fit.lab6_login.dao.model.User;

public class AuthServices {
    public boolean checkLogin(String username, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.findUserName(username);
        if (user == null) {
            return false;
        }
        return password.equals(user.getPassword());
    }
}
