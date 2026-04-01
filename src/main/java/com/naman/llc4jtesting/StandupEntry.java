package com.naman.llc4jtesting;

import java.time.LocalDateTime;
public class StandupEntry {

    private String memberName;
    private String didYesterday;
    private String doingToday;
    private String blockers;
    private LocalDateTime submittedAt;

    public StandupEntry(){}

    public StandupEntry(String memberName, String didYesterday, String doingToday, String blockers){
        this.memberName = memberName;
        this.didYesterday = didYesterday;
        this.doingToday = doingToday;
        this.blockers = blockers;
        this.submittedAt = LocalDateTime.now();
    }

    public String getMemberName(){
        return memberName;
    }
    public void setMemberName(String memberName){
        this.memberName = memberName;
    }
    public String getDidYesterday(){
        return didYesterday;
    }
    public void setDidYesterday(String memberName){
        this.didYesterday = memberName;
    }
    public String getDoingToday() { return doingToday; }
    public void setDoingToday(String doingToday) { this.doingToday = doingToday; }

    public String getBlockers() { return blockers; }
    public void setBlockers(String blockers) { this.blockers = blockers; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}
