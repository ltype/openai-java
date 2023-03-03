package com.theokanning.openai.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Creates a completion for the chat message
 * All fields are nullable.
 *
 * https://beta.openai.com/docs/api-reference/chat/create
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatCompletionRequest {

    /**
     * ID of the model to use.
     * Currently, only gpt-3.5-turbo and gpt-3.5-turbo-0301 are supported.
     */
    String model;

    /**
     * The messages to generate chat completions for, in the chat format.
     */
    List<ChatMessage> messages;

    /**
     *
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random,
     * while lower values like 0.2 will make it more focused and deterministic.
     *
     * We generally recommend using this or {@link ChatCompletionRequest#topP} but not both.
     */
    Double temperature;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of
     * the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are
     * considered.
     *
     * We generally recommend using this or {@link ChatCompletionRequest#temperature} but not both.
     */
    Double topP;

    /**
     * How many completions to generate for each prompt.
     *
     * Because this parameter generates many completions, it can quickly consume your token quota.
     * Use carefully and ensure that you have reasonable settings
     * for {@link ChatCompletionRequest#maxTokens} and {@link ChatCompletionRequest#stop}.
     */
    Integer n;

    /**
     * Whether to stream back partial progress.
     * If set, tokens will be sent as data-only server-sent events as they become available,
     * with the stream terminated by a data: DONE message.
     */
    Boolean stream;

    /**
     * Up to 4 sequences where the API will stop generating further tokens.
     * The returned text will not contain the stop sequence.
     */
    List<String> stop;

    /**
     * The maximum number of tokens allowed for the generated answer.
     * By default, the number of tokens the model can return will be (4096 - prompt tokens).
     */
    Integer maxTokens;

    /**
     * Number between -2.0 and 2.0.
     * Positive values penalize new tokens based on whether they appear in the text so far,
     * increasing the model's likelihood to talk about new topics.
     */
    Double presencePenalty;

    /**
     * Number between -2.0 and 2.0.
     * Positive values penalize new tokens based on their existing frequency in the text so far,
     * decreasing the model's likelihood to repeat the same line verbatim.
     */
    Double frequencyPenalty;

    /**
     * Modify the likelihood of specified tokens appearing in the completion.
     *
     * Maps tokens (specified by their token ID in the GPT tokenizer) to an associated bias value from -100 to 100.
     *
     * https://platform.openai.com/docs/api-reference/chat/create#chat/create-logit_bias
     */
    Map<String, Integer> logitBias;

    /**
     * A unique identifier representing your end-user, which will help OpenAI to monitor and detect abuse.
     */
    String user;
}
