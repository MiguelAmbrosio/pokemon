package com.mx.pokemonapi.xml;

import jakarta.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mx.pokemonapi.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class PokemonApiObjectFactory {



    /**
     * Create an instance of {@link PokemonApiRequest }
     * 
     */
    public PokemonApiRequest createGetPokemonRequest() {
        return new PokemonApiRequest();
    }

    /**
     * Create an instance of {@link PokemonApiResponse }
     * 
     */
    public PokemonApiResponse createGetPokemonResponse() {
        return new PokemonApiResponse();
    }

    /**
     * Create an instance of {@link PokemonApi }
     * 
     */
    public PokemonApi createPokemon() {
        return new PokemonApi();
    }


   
    /**
     * Create an instance of {@link PokemonApiHabilidad }
     * 
     */
    public PokemonApiHabilidad createAbilityObject() {
        return new PokemonApiHabilidad();
    }

    /**
     * Create an instance of {@link PokemonApiHabilidades }
     * 
     */
    public PokemonApiHabilidades createAbility() {
        return new PokemonApiHabilidades();
    }

    /**
     * Create an instance of {@link PokemonApiHelds }
     * 
     */
    public PokemonApiHelds createHeld() {
        return new PokemonApiHelds();
    }

    /**
     * Create an instance of {@link PokemonApiHeld }
     * 
     */
    public PokemonApiHeld createHeldItem() {
        return new PokemonApiHeld();
    }

    /**
     * Create an instance of {@link PokemonApiVersionDetalles }
     * 
     */
    public PokemonApiVersionDetalles createVersionDetail() {
        return new PokemonApiVersionDetalles();
    }

    /**
     * Create an instance of {@link PokemonApiVersion }
     * 
     */
    public PokemonApiVersion createVersion() {
        return new PokemonApiVersion();
    }

}
