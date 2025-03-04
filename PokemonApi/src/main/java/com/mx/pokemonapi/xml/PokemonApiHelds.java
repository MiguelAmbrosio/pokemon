package com.mx.pokemonapi.xml;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Held complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Held"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="item" type="{http://www.ProyectoSoapApi.com/pokemonapi}HeldItem"/&gt;
 *         &lt;element name="version_details" type="{http://www.ProyectoSoapApi.com/pokemonapi}VersionDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Held", propOrder = {
    "item",
    "versionDetails"
})
public class PokemonApiHelds {

    @XmlElement(required = true)
    protected PokemonApiHeld item;
    @XmlElement(name = "version_details")
    protected List<PokemonApiVersionDetalles> versionDetails;

    /**
     * Obtiene el valor de la propiedad item.
     * 
     * @return
     *     possible object is
     *     {@link PokemonApiHeld }
     *     
     */
    public PokemonApiHeld getItem() {
        return item;
    }

    /**
     * Define el valor de la propiedad item.
     * 
     * @param value
     *     allowed object is
     *     {@link PokemonApiHeld }
     *     
     */
    public void setItem(PokemonApiHeld value) {
        this.item = value;
    }

    /**
     * Gets the value of the versionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PokemonApiVersionDetalles }
     * 
     * 
     */
    public List<PokemonApiVersionDetalles> getVersionDetails() {
        if (versionDetails == null) {
            versionDetails = new ArrayList<PokemonApiVersionDetalles>();
        }
        return this.versionDetails;
    }

}
