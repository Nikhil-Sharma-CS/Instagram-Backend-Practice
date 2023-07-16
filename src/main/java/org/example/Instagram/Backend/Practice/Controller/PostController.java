package org.example.Instagram.Backend.Practice.Controller;

import jakarta.persistence.GeneratedValue;
import org.example.Instagram.Backend.Practice.Model.Post;
import org.example.Instagram.Backend.Practice.Service.AuthenticationService;
import org.example.Instagram.Backend.Practice.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    AuthenticationService authenticationService;


    //Let's post something from user
    @PostMapping("posts/post")
    String instaPost(@RequestBody Post post, @RequestParam String email,@RequestParam String token)
    {
        if(authenticationService.authenticate(email, token))
        {
            return postService.instaPost(post, email);
        }
        return "Authentication Failed";
    }


    //Now we get post
    @GetMapping("posts/get")
    Post getPost(@RequestParam Integer postId,@RequestParam String email,@RequestParam String token)
    {
        if(authenticationService.authenticate(email, token))
        {
            return postService.getPost(postId, email);
        }
        return null;
    }

}
