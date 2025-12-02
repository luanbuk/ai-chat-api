package com.bkwblz.aichat.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatMemoryService {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    public ChatMemoryService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory){
        this.chatClient = chatClientBuilder.build();
        this.chatMemory = chatMemory;
    }

    public String simpleChat(String userMessage){
        return this.chatClient.prompt().advisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).user(userMessage).call().content();
    }

}
