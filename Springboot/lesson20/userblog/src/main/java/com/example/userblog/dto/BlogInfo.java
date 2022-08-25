package com.example.userblog.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogInfo {
    private String id;
    private String title;
    private String slug;
    private String thumbnail;
    private String content;
    private String publishAt;
    private Integer countComment;
    private AuthorInfo authorInfo;

    public BlogInfo(String id, String title, String slug, String thumbnail, String content, String publishAt, Integer countComment, String authorInfo) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.thumbnail = thumbnail;
        this.content = content;
        this.publishAt = publishAt;
        this.countComment = countComment;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.authorInfo = objectMapper.readValue(authorInfo, AuthorInfo.class);
        } catch (Exception e) {
            this.authorInfo = null;
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class AuthorInfo {
    private Integer id;
    private String name;
}
