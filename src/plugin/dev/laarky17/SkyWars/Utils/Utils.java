package plugin.dev.laarky17.SkyWars.Utils;

public class Utils {
    public static String FormatTime(int secs) {
        int remainder = secs % 86400;

        int days = secs / 86400;
        int hours = remainder / 3600;
        int minutes = (remainder / 60) - (hours * 60);
        int seconds = (remainder % 3600) - (minutes * 60);

        String fDays = (days > 0 ? "" + days + "d " : "");
        String fHours = (hours > 0 ? "" + hours + "h " : "");
        String fMinutes = (minutes > 0 ? "" + minutes + "m " : "");
        String fSeconds = (seconds > 0 ? "" + seconds + "s " : "");

        return new StringBuilder().append(fDays).append(fHours)
                .append(fMinutes).append(fSeconds).toString();
    }
}
