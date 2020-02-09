package org.academiadecodigo.apiores.gameelements.players;

public enum PlayerType {
    JOJO ("resources/sprite_jojo.png"),
    SORAIA (" "),
    RICARDO(""),
    RITA("");

    private String link;

    PlayerType (String link){
    this.link=link;
}

    public String getLink() {
        return link;
    }
}

