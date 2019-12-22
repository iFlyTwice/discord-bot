package me.comu.exeter.commands.economy;

import me.comu.exeter.core.Core;
import me.comu.exeter.interfaces.ICommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class EconomyUsersCommand implements ICommand {

    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event)  {

        if (EconomyManager.verifyUser(event.getMember().getUser().getId()))
        {
            EconomyManager.getUsers().put(event.getMember().getUser().getId(), 0);
        }
        event.getChannel().sendMessage(EconomyManager.getUsers().toString()).queue();
        EcoJSONHandler.saveEconomyConfig();
    }

    @Override
    public String getHelp() {
        return "Check all economy users\n" + "`" + Core.PREFIX + getInvoke() + "`\nAliases: `" + Arrays.deepToString(getAlias()) + "`";
    }

    @Override
    public String getInvoke() {
        return "ecousers";
    }

    @Override
    public String[] getAlias() {
        return new String[0];
    }
}
