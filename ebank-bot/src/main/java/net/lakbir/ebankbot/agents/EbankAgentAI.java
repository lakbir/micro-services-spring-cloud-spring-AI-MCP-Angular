package net.lakbir.ebankbot.agents;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

/**
 * Created by lakbir.abderrahim on 04/02/2026
 */

@Service
public class EbankAgentAI {

    private ChatClient chatClient;

    public EbankAgentAI(ChatClient.Builder chatClient,
                        ChatMemory chatMemory,
                        ToolCallbackProvider tools) {

        this.chatClient =  chatClient
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(tools)
                .build();
    }


    public String chat(String query){
        return chatClient.prompt(query).call().content();
    }
}
