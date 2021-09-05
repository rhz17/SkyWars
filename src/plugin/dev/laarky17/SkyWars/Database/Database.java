package plugin.dev.laarky17.SkyWars.Database;

import plugin.dev.laarky17.SkyWars.EntryPoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String Host = EntryPoint.getPInstance().getDatabaseConfig().getString("Database.Host");
    private static String Port =  EntryPoint.getPInstance().getDatabaseConfig().getString("Database.Port");;
    private static String Database =  EntryPoint.getPInstance().getDatabaseConfig().getString("Database.Database");;
    private static String Username =  EntryPoint.getPInstance().getDatabaseConfig().getString("Database.Username");;
    private static String Password =  EntryPoint.getPInstance().getDatabaseConfig().getString("Database.Password");;
    private static String GeneralHost = "jdbc:mysql://" + Host + ":" + Port + "/" + Database;

    public static Connection SQLConnection = null;

    public static void openSQLConnection() {
        if (SQLConnection == null) {
            try {
                SQLConnection = DriverManager.getConnection(GeneralHost, Username, Password);
            } catch (SQLException Ex) {
                EntryPoint.getPInstance().getPluginLoader().disablePlugin(EntryPoint.getPInstance());
                Ex.printStackTrace();
            }
        }
    }

    public static void closeSQLConnection() {
        if (SQLConnection != null) {
            try {
                SQLConnection.close();
            } catch (SQLException Ex) {
                EntryPoint.getPInstance().getPluginLoader().disablePlugin(EntryPoint.getPInstance());
                Ex.printStackTrace();
            }
        }
    }
}
