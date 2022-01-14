package com.macheight.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player implements Comparable<Player> {
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    private Integer h_in;
    private double h_meters;

    public String getFirst_name() {
        return first_name;
    }

    @JsonProperty("first_name")
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @JsonProperty("last_name")
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getH_in() {
        return h_in;
    }

    @JsonProperty("h_in")
    public void setH_in(String h_in) {
        this.h_in = Integer.parseInt(h_in);
    }

    public double getH_meters() {
        return h_meters;
    }

    @JsonProperty("h_meters")
    public void setH_meters(String h_meters) {
        this.h_meters = Double.parseDouble(h_meters);
    }

    @Override
    public int compareTo(Player o) {
        return this.getH_in().compareTo(o.getH_in());
    }

    public String getFullName() {
        return this.getFirst_name() + ' ' + this.getLast_name();
    }
}
