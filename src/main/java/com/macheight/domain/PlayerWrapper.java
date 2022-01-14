package com.macheight.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerWrapper {
    @JsonProperty("values")
    private Player[] players;

    public Player[] getPlayers() {
        return players;
    }

    @JsonProperty("values")
    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
