package com.naman.llc4jtesting;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping
    public String chat(@RequestParam String message){
        return chatService.chat(message);
    }
}
