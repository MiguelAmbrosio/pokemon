package com.mx.pokemonapi.vo;

import java.util.ArrayList;

public class PokemonApiHeldsVO {
    private PokemonApiHeldObjectVO item;
    private ArrayList<PokemonApiVersionDetallesVO> version_details;

    public PokemonApiHeldsVO() {
    }

    public PokemonApiHeldsVO(PokemonApiHeldObjectVO item, ArrayList<PokemonApiVersionDetallesVO> version_details) {
        this.item = item;
        this.version_details = version_details;
    }

    public PokemonApiHeldObjectVO getItem() {
        return item;
    }

    public void setItem(PokemonApiHeldObjectVO item) {
        this.item = item;
    }

    public ArrayList<PokemonApiVersionDetallesVO> getVersionDetails() {
        return version_details;
    }

    public void setVersionDetails(ArrayList<PokemonApiVersionDetallesVO> version_details) {
        this.version_details = version_details;
    }

    @Override
    public String toString() {
        return "Held{" +
                "item=" + item +
                ", version_details=" + version_details +
                '}';
    }
}
