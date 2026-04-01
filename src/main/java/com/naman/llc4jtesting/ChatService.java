package com.naman.llc4jtesting;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;

import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    interface Assistant{
        @SystemMessage("You are a helpful assistant named Nova. Be concise and friendly")
        String chat(String message);
    }
    private final Assistant assistant;

    public ChatService(@Value("${openrouter.api.key}") String apiKey){
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .apiKey(apiKey).modelName("qwen/qwen3.6-plus-preview:free")
                .build();
        this.assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }

    public String chat(String userMessage){
        return assistant.chat(userMessage);
    }
}