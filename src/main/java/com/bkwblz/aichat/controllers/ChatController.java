package com.bkwblz.aichat.controllers;

import com.bkwblz.aichat.dtos.ChatMessageDTO;
import com.bkwblz.aichat.services.ChatMemoryService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/chat")
public class ChatController {

    private final ChatMemoryService chatMemoryService;

    public ChatController(@NotNull ChatMemoryService chatMemoryService){
        this.chatMemoryService = chatMemoryService;
    }


    @PostMapping
    public String callModel(@RequestBody ChatMessageDTO chatMessageDTO){
        return this.chatMemoryService.simpleChat(chatMessageDTO.message());
    }
}
