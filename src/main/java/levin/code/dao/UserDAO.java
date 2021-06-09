package levin.code.dao;

import levin.code.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USERCOUNT;
    private List<User> users;


    {
        users = new ArrayList<>();
        users.add(new User(++USERCOUNT,"Ivan"));
        users.add(new User(++USERCOUNT,"Gocha"));
        users.add(new User(++USERCOUNT,"Martin"));
        users.add(new User(++USERCOUNT,"Igor"));
        users.add(new User(++USERCOUNT,"Vova"));
    }

    public List<User> index(){
        return users;
    }

    public User show(int id){
        for(User us : users){
            if(us.getId() == id){
                return us;
            }
        }
        return null;
    }

    public void save(User user){
        user.setId(++USERCOUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
    }
}
