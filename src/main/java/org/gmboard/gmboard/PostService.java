package org.gmboard.gmboard;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Post savePost(MultipartFile file, String content);
}
