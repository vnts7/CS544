package edu.mum;

import javax.persistence.Entity;

@Entity
public class CD extends Product{
    private String artist;

    public CD() {
    }

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD{" +
                "name='" + getName() + '\'' +
                ", artist='" + artist + '\'' +
                "} ";
    }
}
