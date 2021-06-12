package levin.code.dao;

import levin.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
//    private final JdbcTemplate jdbcTemplate;
//    @Autowired
//    public UserDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    private static int USERCOUNT;
    private List<User> users;


    {
        users = new ArrayList<>();
        users.add(new User(++USERCOUNT,"Ivan", "Levin"));
        users.add(new User(++USERCOUNT,"Gocha", "Pupkin"));
        users.add(new User(++USERCOUNT,"Martin","gog"));
        users.add(new User(++USERCOUNT,"Igor", "kook"));
        users.add(new User(++USERCOUNT,"Vova", "loose"));
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
        userToBeUpdated.setSurname(updatedUser.getSurname());
    }

    public void delete(int id){
        users.removeIf(p -> p.getId() == id);
    }
}
