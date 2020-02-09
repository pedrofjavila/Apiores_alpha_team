package org.academiadecodigo.apiores.gameelements.objects;

public enum ObjectType {
    BEER(""),
    CAR(""),
    BRACKETS(""),
    BAD_DESIGN(""),
    SUMARIZER(""),
    PINEAPPLE("");


    private String link;

    ObjectType(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;

    }
}

