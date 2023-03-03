package com.theokanning.openai.chat;

import lombok.Data;

/**
 * Creates a completion for the chat message
 *
 * https://beta.openai.com/docs/api-reference/chat/create
 */
@Data
public class ChatCompletionChoice {

    /**
     * This index of this completion in the returned list.
     */
    Integer index;

    ChatMessage message;

    /**
     * The reason why GPT-3 stopped generating, for example "length".
     */
    String finish_reason;
}
