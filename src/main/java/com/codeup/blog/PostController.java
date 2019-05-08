package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostController(PostRepository posts, UserRepository userRepo) {
        this.postRepo = posts;
        this.userRepo = userRepo;
    }



    @GetMapping("/posts")
    public String showPosts(Model model){
//        init();

        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
//        Post post = new Post();
//        post.setId(id);
//        post.setTitle("Here is post #" + post.getId());
//        post.setBody("This is not going to be a very long blog post");
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title, @RequestParam String body){

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        User user=userRepo.findOne(1l);
        postRepo.save(new Post(title,body,user));
        return "new post created";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    @ResponseBody
    public String editPost(@RequestParam String title, @RequestParam String body, @RequestParam String id) {
        Post post = postRepo.findOne(Long.valueOf(id));
        post.setTitle(title);
        post.setBody(body);
        postRepo.save(post);
        return "successfully modified post";
    }
    @GetMapping("/posts/{id}/delete")
    public String deleteform(@PathVariable Long id,Model vmodel){

        Post post = postRepo.findOne(id);
        vmodel.addAttribute("post",post);
        return ("posts/delete");
    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable Long id){
        postRepo.delete(id);

        return "deleted";
    }


    private void init() {
//        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Here is our first new post");
        post.setBody("This is not going to be a very long blog post");
        post.setId(4L);
        postRepo.save(post);
        Post post2 = new Post();
        post2.setTitle("Here is our second new post");
        post2.setBody("This is not going to be a very long blog post");
        post2.setId(44L);
        postRepo.save(post2);

    }




}