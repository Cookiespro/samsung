package ru.vlad.proect;

import java.util.ArrayList;

public class Game {

    public final int RIGHT_ANSWER_POINTS = +10;
    public final int WRONG_ANSWER_POINTS = 10;
    public final int WIN_POINTS = 50;

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    private int scores = 0;
    private int currentLevel = 0;
    private ArrayList<Level> levels = new ArrayList<>();


    public Game() {
        ArrayList<String> wrongMusic1 = new ArrayList<>();
        wrongMusic1.add("Kolibry");
        wrongMusic1.add("Muddy Water");
        wrongMusic1.add("Showdown");
        Level level1 = new Level(1, "cantholdus", wrongMusic1);
        ArrayList<String> wrongMusic2 = new ArrayList<>();
        wrongMusic2.add("RinRinRin");
        wrongMusic2.add("Moralf");
        wrongMusic2.add("Сердцелом");
        Level level2 = new Level(2, "music", wrongMusic2);
        ArrayList<String> wrongMusic3 = new ArrayList<>();
        Level level3 = new Level(3, "muddywater", wrongMusic3);
        wrongMusic3.add("Drunk Dazed");
        wrongMusic3.add("Конь");
        wrongMusic3.add("Minor");
        ArrayList<String> wrongMusic4 = new ArrayList<>();
        wrongMusic4.add("Я солдат");
        wrongMusic4.add("UNDERGROUND");
        wrongMusic4.add("MASSVVNA");
        Level level4 = new Level(4, "phonk", wrongMusic4);
        ArrayList<String> wrongMusic5 = new ArrayList<>();
        Level level5 = new Level(5, "showdown", wrongMusic5);
        wrongMusic5.add("EVVORTEX");
        wrongMusic5.add("La Espada");
        wrongMusic5.add("Devil Eyes");
        ArrayList<String> wrongMusic6 = new ArrayList<>();
        wrongMusic6.add("ТАРАНТИНО");
        wrongMusic6.add("Papaoutai");
        wrongMusic6.add("Bang");
        Level level6 = new Level(6, "horses", wrongMusic6);
        ArrayList<String> wrongMusic7 = new ArrayList<>();
        wrongMusic7.add("Godzilla");
        wrongMusic7.add("Road");
        wrongMusic7.add("NaNaNaNa");
        Level level7 = new Level(7, "green", wrongMusic7);
        ArrayList<String> wrongMusic8 = new ArrayList<>();
        Level level8 = new Level(8, "lazyt", wrongMusic8);
        wrongMusic8.add("Шнурки");
        wrongMusic8.add("Al The Time");
        wrongMusic8.add("Beggin");
        ArrayList<String> wrongMusic9 = new ArrayList<>();
        wrongMusic9.add("Молодая кровь");
        wrongMusic9.add("Wellerman");
        wrongMusic9.add("Танцуй");
        Level level9 = new Level(9, "devileyes", wrongMusic9);
        ArrayList<String> wrongMusic10 = new ArrayList<>();
        Level level10 = new Level(10, "tetatet", wrongMusic10);
        wrongMusic10.add("Чупа чупс");
        wrongMusic10.add("Герои");
        wrongMusic10.add("Rise");
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        levels.add(level7);
        levels.add(level8);
        levels.add(level9);
        levels.add(level10);

    }

    public Level getCurrentLevel() {
        Level level = levels.get(currentLevel);
        changeLevel();
        return level;
    }

    public int getLevelsSize() {
        return levels.size();
    }

    public void changeLevel() {
        currentLevel++;
    }

    public void addScores() {
        scores += RIGHT_ANSWER_POINTS;
    }

    public int getCurrentLevelNumber() {
        return currentLevel;
    }

    public void removeScores() {
        scores -= WRONG_ANSWER_POINTS;
    }

}
