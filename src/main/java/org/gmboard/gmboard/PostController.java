package org.gmboard.gmboard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Post savePost(@RequestPart(value = "file", required = false) MultipartFile file, @RequestPart(value = "content") String content) {
        return postService.savePost(file, content);
    }
}
