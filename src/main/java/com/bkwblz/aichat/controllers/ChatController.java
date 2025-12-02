package com.bkwblz.aichat.controllers;

import com.bkwblz.aichat.dtos.ChatRequestDTO;
import com.bkwblz.aichat.dtos.ChatResponseDTO;
import com.bkwblz.aichat.services.ChatMemoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/chat")
public class ChatController {

    private final ChatMemoryService chatMemoryService;

    public ChatController(@NotNull ChatMemoryService chatMemoryService){
        this.chatMemoryService = chatMemoryService;
    }


    @PostMapping
    public ChatResponseDTO callModel(@RequestBody ChatRequestDTO chatRequestDTO){
        return new ChatResponseDTO(this.chatMemoryService.simpleChat(chatRequestDTO.message()));
    }
}
