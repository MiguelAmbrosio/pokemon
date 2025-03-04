package com.mx.pokemonapi.vo;

public class PokemonApiVersionVO {
    private String name;
    private String url;

    public PokemonApiVersionVO() {
    }

    public PokemonApiVersionVO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Version{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
