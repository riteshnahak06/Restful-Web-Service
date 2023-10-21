package com.pralashgroup.restfulwebservicespart1.withOutJPA.socialmedia;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();
    private static  Integer userCount =0;
    static {
        users.add(new User(++userCount,"Ritesh", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount,"Rakesh", LocalDate.now().minusYears(29)));
        users.add(new User(++userCount,"Kailash", LocalDate.now().minusYears(57)));
    }
    public List<User> findAll(){
        return users;
    }

    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId()
                .equals(id)).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
