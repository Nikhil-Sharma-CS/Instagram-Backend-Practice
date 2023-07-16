package org.example.Instagram.Backend.Practice.Repository;

import org.example.Instagram.Backend.Practice.Model.Post;
import org.example.Instagram.Backend.Practice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post, Integer> {
    Post findBypostIdAndUser(Integer postId, User postOwner);
}
