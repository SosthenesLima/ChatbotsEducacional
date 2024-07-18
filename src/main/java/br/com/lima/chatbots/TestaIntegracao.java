/*
  By Sósthenes Oliveira Lima
 */
package br.com.lima.chatbots;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.Arrays;

public class TestaIntegracao {
    public static void main(String[] args) {

        var user = "Gere 05 Perguntas sobre Matemática";
        var system = "Matemática é uma área do conhecimento que inclui os tópicos dos números, fórmulas e estruturas relacionadas, formas e os espaços em que estão contidos, e quantidades e suas mudanças. ";

        var chave = System.getenv("OPENIA_API_KEY");
        var service = new OpenAiService(chave);

        var completionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-4")
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.USER.value(), user),
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),system)
                ))
                .build();
        service
                .createChatCompletion(completionRequest)
                .getChoices()
                .forEach(c -> System.out.print(c.getMessage().getContent()));

    }
}
