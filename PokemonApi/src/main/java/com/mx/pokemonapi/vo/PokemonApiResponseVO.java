package com.mx.pokemonapi.vo;



import java.util.ArrayList;

public class PokemonApiResponseVO {
    private ArrayList<PokemonApiHabilidadesVO> abilities;
    private Integer base_experience;
    private ArrayList<PokemonApiHeldsVO> held_items;
    private Integer id;
    private String name;
    private String location_area_encounters;

    public ArrayList<PokemonApiHabilidadesVO> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<PokemonApiHabilidadesVO> abilities) {
        this.abilities = abilities;
    }

    public Integer getBaseExperience() {
        return base_experience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.base_experience = baseExperience;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PokemonApiHeldsVO> getHeldItems() {
        return held_items;
    }

    public void setHeldItems(ArrayList<PokemonApiHeldsVO> held_items) {
        this.held_items = held_items;
    }

    public String getLocationAreaEncounters() {
        return location_area_encounters;
    }

    public void setLocationAreaEncounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    @Override
    public String toString() {
        return "PokemonResponse{" +
                "abilities=" + abilities +
                ", base_experience=" + base_experience +
                ", held_items=" + held_items +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", location_area_encounters='" + location_area_encounters + '\'' +
                '}';
    }
}
