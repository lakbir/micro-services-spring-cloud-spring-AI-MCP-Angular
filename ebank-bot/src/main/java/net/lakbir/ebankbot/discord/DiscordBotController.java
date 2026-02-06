package net.lakbir.ebankbot.discord;


import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.lakbir.ebankbot.agents.EbankAgentAI;
import org.springframework.ai.chat.prompt.Prompt;

/**
 * Created by lakbir.abderrahim on 06/02/2026
 */

@DiscordController
public class DiscordBotController {

    private final EbankAgentAI agent;

    public DiscordBotController(EbankAgentAI agent) {
        this.agent = agent;
    }

    @DiscordMapping
    private  void perform(MessageReceivedEvent event){
        if(event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        String response = agent.chat(new Prompt(query));
        event.getChannel().sendMessage(response).queue();
    }
}
