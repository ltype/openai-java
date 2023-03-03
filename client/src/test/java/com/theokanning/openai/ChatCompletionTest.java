package com.theokanning.openai;

import com.theokanning.openai.chat.ChatCompletionChoice;
import com.theokanning.openai.chat.ChatCompletionRequest;
import com.theokanning.openai.chat.ChatMessage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChatCompletionTest {

    String token = System.getenv("OPENAI_TOKEN");
    OpenAiService service = new OpenAiService(token);

    @Test
    void createChatCompletion() {
        ChatMessage message = ChatMessage.builder()
                .role("user")
                .content("Hello!")
                .build();
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(Arrays.asList(message))
                .n(5)
                .maxTokens(50)
                .user("testing")
                .logitBias(new HashMap<>())
                .build();

        List<ChatCompletionChoice> choices = service.createChatCompletion(request).getChoices();
        assertEquals(5, choices.size());
    }
}
