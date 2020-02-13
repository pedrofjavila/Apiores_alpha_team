package org.academiadecodigo.apiores.gameelements.objects;

public enum ObjectType {
    BEER("resources/cerveja.png", " resources/sounds/beer_opening_2.wav"),
    CAR("resources/carro.png"," resources/sounds/car_crash.wav"),
    BRACKETS("resources/chaveta_branca.png"," resources/sounds/not_again_brackets.wav"),
    BAD_DESIGN("resources/bad_design.png"," resources/sounds/bad_desing_oh_shit.wav"),
    SUMARIZER("resources/summarizer.png"," resources/sounds/cheer_summarizer.wav"),
    PINEAPPLE("resources/nanas.png"," resources/sounds/bad_desing_oh_shit.wav");

    private String link;
    private String soundLink;

    ObjectType(String link, String soundLink) {
        this.link = link;
        this.soundLink= soundLink;
    }

    public String getLink() {
        return link;
    }
}

