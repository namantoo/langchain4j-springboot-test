package com.naman.llc4jtesting;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standup")
public class StandupController {
    private final StandupService standupService;

    public StandupController(StandupService standupService){
        this.standupService = standupService;
    }
    @PostMapping("/submit")
    public StandupEntry submit(@RequestBody StandupEntry entry){
        return standupService.submit(entry);
    }

    @GetMapping("/all")
    public List<StandupEntry> getAll(){
        return standupService.getAll();
    }
    @GetMapping("/summary")
    public String getSummary(){
        return standupService.generateSummary();
    }
    @DeleteMapping("/clear")
    public String clear(){
        standupService.clear();
        return "Standup entries cleared.";
    }

}
