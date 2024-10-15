package com.mx.pokemonapi.vo;

public class PokemonApiHabilidadesVO {

    private PokemonApiHabilidadObjectVO ability;
    private Boolean is_hidden;
    private Integer slot;

    public PokemonApiHabilidadesVO() {
    }

    public PokemonApiHabilidadesVO(PokemonApiHabilidadObjectVO ability, Boolean is_hidden, Integer slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public PokemonApiHabilidadObjectVO getAbility() {
        return ability;
    }

    public void setAbility(PokemonApiHabilidadObjectVO ability) {
        this.ability = ability;
    }

    public Boolean getHidden() {
        return is_hidden;
    }

    public void setHidden(Boolean hidden) {
        is_hidden = hidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "ability=" + ability +
                ", isHidden=" + is_hidden +
                ", slot=" + slot +
                '}';
    }
}
