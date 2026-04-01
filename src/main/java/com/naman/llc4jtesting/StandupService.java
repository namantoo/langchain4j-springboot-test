package com.naman.llc4jtesting;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StandupService {
    private final List<StandupEntry> entries = new ArrayList<>();
    private final OpenAiChatModel model;

    public StandupService(@Value("${openrouter.api.key}") String apiKey) {
        this.model = OpenAiChatModel.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .apiKey(apiKey)
                .modelName("qwen/qwen3.6-plus-preview:free")
                .build();
    }
    public StandupEntry submit(StandupEntry entry){
        entries.add(entry);
        return entry;
    }
    public List<StandupEntry> getAll(){
        return entries;
    }
    public void clear(){
        entries.clear();
    }

    public String generateSummary(){
        if(entries.isEmpty()){
            return "No standup entries submitted yet";
        }
        StringBuilder prompt = new StringBuilder();
        prompt.append("You are and engineering manager, below are today's standup updates from the team.").append("\n");
        prompt.append("Generate a clean, concise summary grouped by: Completed Work, In Progress, and Blockers. \n\n");

        for(StandupEntry entry: entries){
            prompt.append("Team member: ").append(entry.getMemberName()).append("\n");
            prompt.append("Did Yesterday: ").append(entry.getDidYesterday()).append("\n");
            prompt.append("Doing Today: ").append(entry.getDoingToday()).append("\n");
            prompt.append("Blockers: ").append(entry.getBlockers()).append("\n\n");
        }

        return model.generate(prompt.toString());
    }

}
