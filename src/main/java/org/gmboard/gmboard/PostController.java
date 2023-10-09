package org.gmboard.gmboard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getPosts();
    }

    @PostMapping("/")
    public Post savePost(PostRequestDto requestDto) {
        return postService.savePost(requestDto);
    }
}
