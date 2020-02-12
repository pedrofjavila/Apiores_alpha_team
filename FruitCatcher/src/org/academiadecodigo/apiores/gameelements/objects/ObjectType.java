package org.academiadecodigo.apiores.gameelements.objects;

public enum ObjectType {
    BEER("resources/cerveja.png"),
    CAR("resources/carro.png"),
    BRACKETS("resources/chaveta.png"),
    BAD_DESIGN("resources/bad_design.png"),
    SUMARIZER("resources/summarizer.png"),
    PINEAPPLE("resources/nanas.png");


    private String link;

    ObjectType(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;

    }
}

