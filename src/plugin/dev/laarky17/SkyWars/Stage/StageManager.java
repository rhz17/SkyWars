package plugin.dev.laarky17.SkyWars.Stage;

import plugin.dev.laarky17.SkyWars.Stage.Stages.InGame;
import plugin.dev.laarky17.SkyWars.Stage.Stages.Waiting;

public class StageManager {
    public static Stage getGameStage = null;

    public static String getGameStageName() {
        if (getGameStage == Stage.AGUARDANDO)
            return "Aguardando";
        else if (getGameStage == Stage.JOGO)
            return "Jogo";
        else if (getGameStage == Stage.FINALIZANDO)
            return "Finalizando";

        return null;
    }

    public static void runGameStage() {
        Waiting.runWaiting();
    }
}
