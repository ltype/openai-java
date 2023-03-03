package com.theokanning.openai.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Creates a completion for the chat message
 *
 * https://platform.openai.com/docs/api-reference/chat/create#chat/create-messages
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatMessage {
    String role;

    String content;
}
