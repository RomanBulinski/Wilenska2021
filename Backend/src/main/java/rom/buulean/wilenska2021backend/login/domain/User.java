package rom.buulean.wilenska2021backend.login.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private String userName;
    private String password;
    private RealEstateType role;

    private Map<String, List<String>> usersData;

    public User() {
        usersData = new HashMap<>();
        usersData.put("admin1", List.of("admin1","admin1",RealEstateType.ADMIN.name() ));
        usersData.put("user1", List.of("user1","user1",RealEstateType.USER.name() ));
    }

    public boolean checkIfUserExist(String name) {
        return usersData.keySet().contains(name);
    }

    public boolean checkIfUserAndPasswordCorrespond(String name, String password) {
        if(!checkIfUserExist(name)){
            return false;
        }
        return usersData.get(name).get(1).equalsIgnoreCase(password);
    }

    public enum RealEstateType{
        ADMIN, USER
    }
}


