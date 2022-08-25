package com.example.myvocab.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private LocalDateTime createdAt;
    private String message;
    private Long idParent;
    private String userId;
    private String userName;
    private String userAvatar;

}
