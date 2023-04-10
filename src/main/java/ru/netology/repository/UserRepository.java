package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        System.out.println(user + " " + password);
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("5555")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("profi") && password.equals("2222")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("user") && password.equals("1111")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}
