package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME, blockHostConsole = true)
@CommandParameters(description = "Request an administrator with an issue or question.", usage = "/<command> <message>", aliases = "adminhelp,helpme,question")
public class Command_requestadmin extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        
        if (args.length > 2) 
        {
            return false;
        }
        
        Player player = getPlayer(args[0]);
        
                String request = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        plugin.cm.requestAdmin(playerSender, request);
        
        msg(ChatColor.GREEN + "Administrators have been notified, please be patient and wait at least 1 minute before asking again.");
        
        return true;
    }
    
}
