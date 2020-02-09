package org.academiadecodigo.apiores.gameelements.objects;

public enum ObjectType {
    BEER(""),
    CAR("resources/carro.png"),
    BRACKETS("resources/chaveta.png"),
    BAD_DESIGN(""),
    SUMARIZER("resources/chaveta.png"),
    PINEAPPLE("resources/nanas.png");


    private String link;

    ObjectType(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;

    }
}

