package org.academiadecodigo.apiores.gameelements.objects;

public enum ObjectType {
    BEER("resources/cerveja.png", " resources/sounds/beer_opening_ok.wav"),
    CAR("resources/carro.png"," resources/sounds/car_crash_ok.wav"),
    BRACKETS("resources/chaveta_branca.png"," resources/sounds/not_again_brackets_ok.wav"),
    BAD_DESIGN("resources/bad_design.png"," resources/sounds/bad_desing_oh_shit_ok.wav"),
    SUMARIZER("resources/summarizer.png"," resources/sounds/cheer_summarizer_ok.wav"),
    PINEAPPLE("resources/nanas.png"," resources/sounds/eat_sound_pineapple_ok.wav");

    private String link;
    private String soundLink;

    ObjectType(String link, String soundLink) {
        this.link = link;
        this.soundLink= soundLink;
    }

    public String getLink() {
        return link;
    }

    public String getSoundLink() {
        return soundLink;
    }
}

