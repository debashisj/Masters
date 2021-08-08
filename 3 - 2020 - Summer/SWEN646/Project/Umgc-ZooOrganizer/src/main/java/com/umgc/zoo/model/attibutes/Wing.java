package com.umgc.zoo.model.attibutes;

import com.umgc.zoo.enums.Color;

public class Wing {
    private Color featherColor;

    public Wing() {
    }

    public Wing(Color featherColor) {
        this.featherColor = featherColor;
    }

    public Color getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(Color featherColor) {
        this.featherColor = featherColor;
    }
}
