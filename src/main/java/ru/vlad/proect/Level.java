package ru.vlad.proect;

import java.util.ArrayList;

public class Level {
    private int number;
    private String rightMusicText;
    private ArrayList<String> wrongMusicTextList = new ArrayList<>();


    public Level(int number, String rightMusicText, ArrayList<String> wrongMusicTextList) {
        this.number = number;
        this.rightMusicText = rightMusicText;
        this.wrongMusicTextList = wrongMusicTextList;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRightMusicText() {
        return rightMusicText;
    }


    public void setRightMusicText(String rightMusicText) {
        this.rightMusicText = rightMusicText;
    }

    public ArrayList<String> getWrongMusicTextList() {
        return wrongMusicTextList;
    }

    public void setWrongMusicTextList(ArrayList<String> wrongMusicTextList) {
        this.wrongMusicTextList = wrongMusicTextList;
    }

    public void addWrongMusicText(String text) throws Exception {
        if (text == null || text.equals(""))
            throw new Exception("Отсутствует название неверной песни!");
        wrongMusicTextList.add(text);
    }
}
