package me.comu.exeter.commands.misc;

import me.comu.exeter.core.Core;
import me.comu.exeter.interfaces.ICommand;
import me.duncte123.botcommons.messaging.EmbedUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class IDLookupCommand implements ICommand {
    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event) {
        if (args.isEmpty())
        {
            event.getChannel().sendMessage("Please specify an ID to look up!").queue();
            return;
        }
        try {
            if (!args.isEmpty()) {
                event.getChannel().sendMessage(EmbedUtils.embedImage(event.getJDA().getUserById(args.get(0)).getEffectiveAvatarUrl().concat("?size=256&f=.gif")).setColor(event.getMember().getColor()).setTitle(args.get(0) + " belongs to `" + event.getJDA().getUserById(args.get(0)).getName() + "#" + event.getJDA().getUserById(args.get(0)).getDiscriminator() + "`").build()).queue();

            }
        } catch (NumberFormatException | NullPointerException ex)
        {
            event.getChannel().sendMessage("No user exists with that ID.").queue();
        }
    }

    @Override
    public String getHelp() {
        return "Gets the user associated with the specified ID\n`" + Core.PREFIX + getInvoke() + "[id]`\nAliases: `" + Arrays.deepToString(getAlias()) + "`";
    }

    @Override
    public String getInvoke() {
        return "idlookup";
    }

    @Override
    public String[] getAlias() {
        return new String[] {"lookup","id","whosid","whoid"};
    }
}
