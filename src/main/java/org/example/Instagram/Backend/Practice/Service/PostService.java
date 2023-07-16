package org.example.Instagram.Backend.Practice.Service;

import org.example.Instagram.Backend.Practice.Model.Post;
import org.example.Instagram.Backend.Practice.Model.User;
import org.example.Instagram.Backend.Practice.Repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    @Autowired
    UserService userService;

    public String instaPost(Post post, String email) {

        User postOwner = userService.findUserByEmail(email);

        post.setUser(postOwner);
        postRepo.save(post);

        return "Post Saved";
    }

    public Post getPost(Integer postId, String email) {
        User postOwner = userService.findUserByEmail(email);

        return postRepo.findBypostIdAndUser(postId, postOwner);
    }
}
