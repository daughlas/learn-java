package tech.lvjiawen.jdbc.service;

import tech.lvjiawen.jdbc.bean.User;
import tech.lvjiawen.jdbc.dao.UserDAO;

/**
 * 用户服务
 */
public class UserService {

    private static UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    /**
     * 根据 id 查询用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
