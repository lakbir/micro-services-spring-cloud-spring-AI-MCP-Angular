package net.lakbir.ebankbot.controller;


import net.lakbir.ebankbot.agents.EbankAgentAI;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lakbir.abderrahim on 04/02/2026
 */

@RestController
public class EbankChatBotController {

    private EbankAgentAI ebankAgentAI;

    public EbankChatBotController(EbankAgentAI ebankAgentAI) {
        this.ebankAgentAI = ebankAgentAI;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(name = "query", defaultValue = "Bonjour") String query){
        return this.ebankAgentAI.chat(query);
    }

}
