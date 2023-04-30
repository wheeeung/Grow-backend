package com.example.raisingjungsu.domain.chat.domain;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chat-app")
public class Chat {
    @Id
    private String id;
    private String msg;
    private String sender;
    private String receiver;
    private LocalDateTime createdAt;
}
