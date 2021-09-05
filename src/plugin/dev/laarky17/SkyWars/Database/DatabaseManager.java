package plugin.dev.laarky17.SkyWars.Database;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    public static String getPlayerLevelName(Player EntityPlayer) {
        String VerifyTable = "SELECT level FROM data WHERE uuid = ?";

        try {
            PreparedStatement PSVT = Database.SQLConnection.prepareStatement(VerifyTable);
            PSVT.setString(1, EntityPlayer.getUniqueId().toString().toLowerCase());
            ResultSet RSVT = PSVT.executeQuery();

            if (RSVT.next()) {
                int PlayerLevel = RSVT.getInt("level");

                if (PlayerLevel == 0)
                    return ChatColor.GREEN + "Polônio";
                else if (PlayerLevel == 1)
                    return ChatColor.YELLOW +"Radônio";
                else if (PlayerLevel == 2)
                    return ChatColor.GOLD + "Rádio";
                else if (PlayerLevel == 3)
                    return ChatColor.DARK_RED + "Actínio";
                else if (PlayerLevel == 4)
                    return ChatColor.RED + "Tório";
                else if (PlayerLevel == 5)
                    return ChatColor.AQUA + "Protactínio";
                else if (PlayerLevel == 6)
                    return ChatColor.LIGHT_PURPLE + "Urânio";
            }

        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }

        return "Polônio";
    }
}
