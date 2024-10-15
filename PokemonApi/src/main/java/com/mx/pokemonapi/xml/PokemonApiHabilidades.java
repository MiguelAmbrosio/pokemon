package com.mx.pokemonapi.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para Ability complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Ability"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="is_hidden" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="slot" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ability" type="{http://www.ProyectoSoapApi.com/pokemonapi}AbilityObject"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ability", propOrder = {
    "isHidden",
    "slot",
    "ability"
})
public class PokemonApiHabilidades {

    @XmlElement(name = "is_hidden")
    protected boolean isHidden;
    protected int slot;
    @XmlElement(required = true)
    protected PokemonApiHabilidad ability;

    /**
     * Obtiene el valor de la propiedad isHidden.
     * 
     */
    public boolean isIsHidden() {
        return isHidden;
    }

    /**
     * Define el valor de la propiedad isHidden.
     * 
     */
    public void setIsHidden(boolean value) {
        this.isHidden = value;
    }

    /**
     * Obtiene el valor de la propiedad slot.
     * 
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Define el valor de la propiedad slot.
     * 
     */
    public void setSlot(int value) {
        this.slot = value;
    }

    /**
     * Obtiene el valor de la propiedad ability.
     * 
     * @return
     *     possible object is
     *     {@link PokemonApiHabilidad }
     *     
     */
    public PokemonApiHabilidad getAbility() {
        return ability;
    }

    /**
     * Define el valor de la propiedad ability.
     * 
     * @param value
     *     allowed object is
     *     {@link PokemonApiHabilidad }
     *     
     */
    public void setAbility(PokemonApiHabilidad value) {
        this.ability = value;
    }

}
