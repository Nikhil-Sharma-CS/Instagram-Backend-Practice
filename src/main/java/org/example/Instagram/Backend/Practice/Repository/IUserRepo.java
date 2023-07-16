package org.example.Instagram.Backend.Practice.Repository;

import org.example.Instagram.Backend.Practice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByUserEmail(String newEmail);
}
