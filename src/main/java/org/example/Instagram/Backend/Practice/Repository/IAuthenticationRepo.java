package org.example.Instagram.Backend.Practice.Repository;

import org.example.Instagram.Backend.Practice.Model.Authentication;
import org.example.Instagram.Backend.Practice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<Authentication, Long> {
    Authentication findFirstByToken(String token);

    Authentication findFirstByUser(User user);
}
