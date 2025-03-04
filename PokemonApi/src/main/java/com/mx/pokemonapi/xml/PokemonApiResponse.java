package com.mx.pokemonapi.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Pokemon" type="{http://www.ProyectoSoapApi.com/pokemonapi}Pokemon"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pokemon"
})
@XmlRootElement(name = "GetPokemonResponse")
public class PokemonApiResponse {

    @XmlElement(name = "Pokemon", required = true)
    protected PokemonApi pokemon;

    /**
     * Obtiene el valor de la propiedad pokemon.
     * 
     * @return
     *     possible object is
     *     {@link PokemonApi }
     *     
     */
    public PokemonApi getPokemon() {
        return pokemon;
    }

    /**
     * Define el valor de la propiedad pokemon.
     * 
     * @param value
     *     allowed object is
     *     {@link PokemonApi }
     *     
     */
    public void setPokemon(PokemonApi value) {
        this.pokemon = value;
    }

}
