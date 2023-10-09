package org.gmboard.gmboard;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(MultipartFile file, String content) {
        String imgUrl = saveFile(file);

        Post newPost = Post.builder()
                .content(content)
                .img(imgUrl)
                .build();

        return postRepository.save(newPost);
    }

    private String saveFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();

        try {
            File destinationFile = new File(uploadDir, fileName);
            file.transferTo(destinationFile);
            return fileName;
        }catch (IOException ex) {
            throw new RuntimeException("파일을 저장할 수 없습니다. 다시 시도하세요.", ex);
        }
    }
}
