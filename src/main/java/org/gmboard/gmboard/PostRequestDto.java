package org.gmboard.gmboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostRequestDto {
    private String content;
    private MultipartFile img;
}
