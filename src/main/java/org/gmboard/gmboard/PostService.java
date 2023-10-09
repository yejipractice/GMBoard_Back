package org.gmboard.gmboard;

import java.util.List;

public interface PostService {

    List<Post> getPosts();

    Post savePost(PostRequestDto requestDto);
}
