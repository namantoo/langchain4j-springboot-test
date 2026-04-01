# LangChain4j Spring Boot AI Chat Demo

A Spring Boot REST API that integrates LLMs using LangChain4j, featuring persistent chat memory and a clean service architecture.

## Tech stack
- Java 17
- Spring Boot 3.5
- LangChain4j 0.36.2
- LLM provider

## Run locally

1. Clone the repo
2. Copy `application.properties.example` to `application.properties`
3. Add your OpenRouter API key
4. Run `Lc4jDemoApplication.java`

## API

GET `/chat?message=your message here`

The model remembers context within a session — try introducing yourself and asking it to recall your name.

## Current status
This is just a playaround template