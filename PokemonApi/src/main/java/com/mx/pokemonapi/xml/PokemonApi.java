package com.mx.pokemonapi.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Pokemon complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Pokemon"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="abilities" type="{http://www.ProyectoSoapApi.com/pokemonapi}Ability" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="base_experience" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="held_items" type="{http://www.ProyectoSoapApi.com/pokemonapi}Held" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="location_area_encounters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pokemon", propOrder = {
    "abilities",
    "baseExperience",
    "heldItems",
    "id",
    "name",
    "locationAreaEncounters"
})
public class PokemonApi {

    protected List<PokemonApiHabilidades> abilities;
    @XmlElement(name = "base_experience", required = true)
    protected BigInteger baseExperience;
    @XmlElement(name = "held_items")
    protected List<PokemonApiHelds> heldItems;
    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "location_area_encounters", required = true)
    protected String locationAreaEncounters;

    /**
     * Gets the value of the abilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PokemonApiHabilidades }
     * 
     * 
     */
    public List<PokemonApiHabilidades> getAbilities() {
        if (abilities == null) {
            abilities = new ArrayList<PokemonApiHabilidades>();
        }
        return this.abilities;
    }

    /**
     * Obtiene el valor de la propiedad baseExperience.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBaseExperience() {
        return baseExperience;
    }

    /**
     * Define el valor de la propiedad baseExperience.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBaseExperience(BigInteger value) {
        this.baseExperience = value;
    }

    /**
     * Gets the value of the heldItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the heldItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHeldItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PokemonApiHelds }
     * 
     * 
     */
    public List<PokemonApiHelds> getHeldItems() {
        if (heldItems == null) {
            heldItems = new ArrayList<PokemonApiHelds>();
        }
        return this.heldItems;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad locationAreaEncounters.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    /**
     * Define el valor de la propiedad locationAreaEncounters.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationAreaEncounters(String value) {
        this.locationAreaEncounters = value;
    }

}
