package com.bkwblz.aichat.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatMemoryService {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    private final String PERSONA_DEFINITION = """
                        You are a telemarketing specialist. Answer all questions at the best of your capabilities.
                        You should respond in a JSON format like:
                        {
                            "reply": "reply example" 
                        }
                        """;

    public ChatMemoryService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory){
        this.chatClient = chatClientBuilder.build();
        this.chatMemory = chatMemory;
    }

    public String simpleChat(String userMessage){
        return this.chatClient.prompt()
                .system(PERSONA_DEFINITION).advisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).user(userMessage).call().content();
    }

}
