package com.mx.pokemonapi.vo;

public class PokemonApiVersionDetallesVO {
    private Integer rarity;
    private PokemonApiVersionVO version;

    public PokemonApiVersionDetallesVO() {
    }

    public PokemonApiVersionDetallesVO(Integer rarity, PokemonApiVersionVO version) {
        this.rarity = rarity;
        this.version = version;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public PokemonApiVersionVO getVersion() {
        return version;
    }

    public void setVersion(PokemonApiVersionVO version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "VersionDetail{" +
                "rarity=" + rarity +
                ", version=" + version +
                '}';
    }
}
