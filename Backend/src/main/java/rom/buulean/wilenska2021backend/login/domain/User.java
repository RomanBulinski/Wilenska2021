package rom.buulean.wilenska2021backend.login.domain;

import java.util.HashMap;
import java.util.Map;

public class User {

    Map<String, String> usersData;

    public User() {
        usersData = new HashMap<>();
        usersData.put("admin1", "admin1");
        usersData.put("user1", "user1");
    }

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkIfUserExist(String name) {
        return usersData.keySet().contains(name);
    }

    public boolean checkIfUserAndPasswordCorrespond(String name, String password) {
        if(!checkIfUserExist(name)){
            return false;
        }
        return usersData.get(name).equalsIgnoreCase(password);
    }
}

