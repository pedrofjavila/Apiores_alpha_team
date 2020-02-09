package org.academiadecodigo.apiores.gameelements.players;

public enum PlayerType {
    JOJO ("resources/jojo_60x30.png"),
    SORAIA ("resources/soraia60x30.png"),
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

