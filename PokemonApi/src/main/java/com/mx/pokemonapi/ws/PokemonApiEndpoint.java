package com.mx.pokemonapi.ws;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mx.pokemonapi.api.PokemonApiCliente;
import com.mx.pokemonapi.repository.BitacoraPokemonApiServicejpa;
import com.mx.pokemonapi.vo.BitacoraPokemonApiVO;

import com.mx.pokemonapi.vo.PokemonApiHabilidadesVO;
import com.mx.pokemonapi.vo.PokemonApiHeldsVO;

import com.mx.pokemonapi.vo.PokemonApiResponseVO;

import com.mx.pokemonapi.vo.PokemonApiVersionDetallesVO;
import com.mx.pokemonapi.xml.PokemonApiHabilidades;
import com.mx.pokemonapi.xml.PokemonApiHabilidadesRequest;
import com.mx.pokemonapi.xml.PokemonApiHabilidad;
import com.mx.pokemonapi.xml.PokemonApiRequest;
import com.mx.pokemonapi.xml.PokemonApiResponse;
import com.mx.pokemonapi.xml.PokemonApiHelds;
import com.mx.pokemonapi.xml.PokemonApiHeldsRequest;
import com.mx.pokemonapi.xml.PokemonApiIdRequest;
import com.mx.pokemonapi.xml.PokemonApiLocAreaEncosRequest;
import com.mx.pokemonapi.xml.PokemonApiNombreRequest;
import com.mx.pokemonapi.xml.PokemonApiHeld;
import com.mx.pokemonapi.xml.PokemonApi;
import com.mx.pokemonapi.xml.PokemonApiBaseExperienciaRequest;
import com.mx.pokemonapi.xml.PokemonApiVersion;
import com.mx.pokemonapi.xml.PokemonApiVersionDetalles;

import jakarta.servlet.http.HttpServletRequest;


import java.math.BigInteger;

@Endpoint
public class PokemonApiEndpoint {
	
	
	@Autowired
    private BitacoraPokemonApiServicejpa bitacoraPokemonApiServicejpa;
	
	BitacoraPokemonApiVO bitacoraPokemonApiVO = new BitacoraPokemonApiVO();
    protected static Logger logger = LoggerFactory.getLogger(PokemonApiEndpoint.class);
    private static final String NAMESPACE_URI = "http://www.ProyectoSoapApi.com/pokemonapi";

    private PokemonApiResponseVO obtenerPokemon(String nombrePokemon) {
        PokemonApiCliente pokemonApiCliente = new PokemonApiCliente();
        PokemonApiResponseVO response = new PokemonApiResponseVO();

        try {
            response = pokemonApiCliente.consultarPokemonApi(nombrePokemon);
        } catch (Exception e) {
        	logger.error(e.getMessage());
        } finally {
        	pokemonApiCliente.close();
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public PokemonApiResponse getPokemon(@RequestPayload PokemonApiRequest request,MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
   
        PokemonApiResponse getPokemonResponse = new PokemonApiResponse();
        PokemonApiResponseVO pokemonResponse = obtenerPokemon(request.getName());
        
        
        
        if(pokemonResponse == null)
            return getPokemonResponse;
        else {
            PokemonApi pokemonApi = new PokemonApi();
            pokemonApi.setName(pokemonResponse.getName());
            pokemonApi.setBaseExperience(BigInteger.valueOf(pokemonResponse.getBaseExperience()));
            pokemonApi.setId(BigInteger.valueOf(pokemonResponse.getId()));
            pokemonApi.setLocationAreaEncounters(pokemonResponse.getLocationAreaEncounters());

            for (PokemonApiHeldsVO held : pokemonResponse.getHeldItems()) {
                PokemonApiHelds pokemonApiHelds = new PokemonApiHelds();
                PokemonApiHeld heldItem = new PokemonApiHeld();
                heldItem.setName(held.getItem().getName());
                heldItem.setUrl(held.getItem().getUrl());
                pokemonApiHelds.setItem(heldItem);
                
                for (PokemonApiVersionDetallesVO version : held.getVersionDetails()) {
                    PokemonApiVersionDetalles pokemonApiVersionDetalles = new PokemonApiVersionDetalles();
                    PokemonApiVersion pokemonApiVersion = new PokemonApiVersion();
                    pokemonApiVersion.setName(version.getVersion().getName());
                    pokemonApiVersion.setUrl(version.getVersion().getUrl());
                    pokemonApiVersionDetalles.setVersion(pokemonApiVersion);
                    pokemonApiVersionDetalles.setRarity(version.getRarity());
                    pokemonApiHelds.getVersionDetails().add(pokemonApiVersionDetalles);
                }
                pokemonApi.getHeldItems().add(pokemonApiHelds);
            }

            for (PokemonApiHabilidadesVO ability : pokemonResponse.getAbilities()) {
            	PokemonApiHabilidades pokemonApiHabilidades = new PokemonApiHabilidades();
            	pokemonApiHabilidades.setSlot(ability.getSlot());
            	pokemonApiHabilidades.setIsHidden(ability.getHidden());
                PokemonApiHabilidad abilityObject = new PokemonApiHabilidad();
                abilityObject.setName(ability.getAbility().getName());
                abilityObject.setUrl(ability.getAbility().getUrl());
                pokemonApiHabilidades.setAbility(abilityObject);
                pokemonApi.getAbilities().add(pokemonApiHabilidades);
            }
            getPokemonResponse.setPokemon(pokemonApi);
         
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());

            return getPokemonResponse;
        }
    }
    

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAbilitiesRequest")
    @ResponsePayload
    public PokemonApiResponse getAbilities(@RequestPayload PokemonApiHabilidadesRequest request, MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
        PokemonApiResponse pokemonApiResponse = new PokemonApiResponse();
        PokemonApiResponseVO pokemonApiResponseVO = obtenerPokemon(request.getName());

        if(pokemonApiResponseVO == null)
            return pokemonApiResponse;
        else {
        	PokemonApi pokemonApi = new PokemonApi();
            for (PokemonApiHabilidadesVO habilidades : pokemonApiResponseVO.getAbilities()) {
            	PokemonApiHabilidades pokemonApiHabilidades = new PokemonApiHabilidades();
            	pokemonApiHabilidades.setSlot(habilidades.getSlot());
            	pokemonApiHabilidades.setIsHidden(habilidades.getHidden());
            	PokemonApiHabilidad pokemonApiHabilidad = new PokemonApiHabilidad();
            	pokemonApiHabilidad.setName(habilidades.getAbility().getName());
            	pokemonApiHabilidad.setUrl(habilidades.getAbility().getUrl());
            	pokemonApiHabilidades.setAbility(pokemonApiHabilidad);
            	pokemonApi.getAbilities().add(pokemonApiHabilidades);
            }
           
            pokemonApiResponse.setPokemon(pokemonApi);
            
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());
         
            return pokemonApiResponse;
        }
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBaseExperienceRequest")
    @ResponsePayload
    public PokemonApiResponse getBaseExperience(@RequestPayload PokemonApiBaseExperienciaRequest request, MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
        PokemonApiResponse pokemonApiResponse = new PokemonApiResponse();
        PokemonApiResponseVO pokemonApiResponseVO = obtenerPokemon(request.getName());

        if(pokemonApiResponseVO == null)
            return pokemonApiResponse;
        else {
        	PokemonApi pokemon = new PokemonApi();
            pokemon.setBaseExperience(BigInteger.valueOf(pokemonApiResponseVO.getBaseExperience()));
            pokemonApiResponse.setPokemon(pokemon);
            
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());
         
            return pokemonApiResponse;
        }
    }
    

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHeldItemsRequest")
    @ResponsePayload
    public PokemonApiResponse getHeldItems(@RequestPayload PokemonApiHeldsRequest request, MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
      PokemonApiResponse pokemonApiResponse = new PokemonApiResponse();
      PokemonApiResponseVO pokemonApiResponseVO = obtenerPokemon(request.getName());


        if(pokemonApiResponseVO == null)
            return pokemonApiResponse;
        else {
            PokemonApi pokemon = new PokemonApi();

            for (PokemonApiHeldsVO pokemonApiHeldsVO : pokemonApiResponseVO.getHeldItems()) {
            	
            	PokemonApiHelds pokemonApiHelds = new PokemonApiHelds();
            	PokemonApiHeld pokemonApiHeld = new PokemonApiHeld();
            	pokemonApiHeld.setName(pokemonApiHeldsVO.getItem().getName());
            	pokemonApiHeld.setUrl(pokemonApiHeldsVO.getItem().getUrl());
            	
                pokemonApiHelds.setItem(pokemonApiHeld);
                
                for (PokemonApiVersionDetallesVO pokemonApiVersionDetallesVO : pokemonApiHeldsVO.getVersionDetails()) {
                	
                	PokemonApiVersionDetalles pokemonApiVersionDetalles = new PokemonApiVersionDetalles();
                	PokemonApiVersion pokemonApiVersion = new PokemonApiVersion();
                	
                	pokemonApiVersion.setName(pokemonApiVersionDetallesVO.getVersion().getName());
                	pokemonApiVersion.setUrl(pokemonApiVersionDetallesVO.getVersion().getUrl());
                	
                	pokemonApiVersionDetalles.setVersion(pokemonApiVersion);
                	pokemonApiVersionDetalles.setRarity(pokemonApiVersionDetallesVO.getRarity());
                	
                	pokemonApiHelds.getVersionDetails().add(pokemonApiVersionDetalles);
                }
                pokemon.getHeldItems().add(pokemonApiHelds);
            }

           
            pokemonApiResponse.setPokemon(pokemon);
            
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());

            return pokemonApiResponse;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetIdRequest")
    @ResponsePayload
    public PokemonApiResponse getId(@RequestPayload PokemonApiIdRequest request, MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
        PokemonApiResponse pokemonApiResponse = new PokemonApiResponse();
        PokemonApiResponseVO pokemonApiResponseVO = obtenerPokemon(request.getName());

        if(pokemonApiResponseVO == null)
            return pokemonApiResponse;
        else {
            PokemonApi pokemon = new PokemonApi();
            pokemon.setId(BigInteger.valueOf(pokemonApiResponseVO.getId()));
          
            pokemonApiResponse.setPokemon(pokemon);
        
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());

            return pokemonApiResponse;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetNameRequest")
    @ResponsePayload
    public PokemonApiResponse getName(@RequestPayload PokemonApiNombreRequest request, MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
        PokemonApiResponse pokemonApiResponse = new PokemonApiResponse();
        PokemonApiResponseVO pokemonApiResponseVO = obtenerPokemon(request.getName());

        if(pokemonApiResponseVO == null)
            return pokemonApiResponse;
        else {
            PokemonApi pokemon = new PokemonApi();
            pokemon.setName(pokemonApiResponseVO.getName());
      
            pokemonApiResponse.setPokemon(pokemon);
         
            
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());

            return pokemonApiResponse;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetLocationAreaEncountersRequest")
    @ResponsePayload
    public PokemonApiResponse getLocationAreaEncounters(@RequestPayload PokemonApiLocAreaEncosRequest request, MessageContext messageContext) {
    	long startTime = System.currentTimeMillis(); 
        PokemonApiResponse pokemonApiResponse = new PokemonApiResponse();
        PokemonApiResponseVO pokemonApiResponseVO = obtenerPokemon(request.getName());

        if(pokemonApiResponseVO == null)
            return pokemonApiResponse;
        else {
            PokemonApi pokemon = new PokemonApi();
            pokemon.setLocationAreaEncounters(pokemonApiResponseVO.getLocationAreaEncounters());
            
            pokemonApiResponse.setPokemon(pokemon);
            
            long endTime = System.currentTimeMillis(); 
            guardarBitacoraPokemonApi(messageContext, startTime, endTime, request.getName());

            return pokemonApiResponse;
        }
    }
    
    public String obtenerIpCliente() {
    	
        String ipCliente = "";
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (sra != null) {
            HttpServletRequest request = sra.getRequest();
            ipCliente = request.getRemoteAddr();  
        }
        return ipCliente;
    }
    
    public void guardarBitacoraPokemonApi(MessageContext messageContext,long comienzaPeticion,long terminaPeticion, String request){
    	
    	Long tiempoEjecucion = terminaPeticion-comienzaPeticion;
    	 bitacoraPokemonApiVO.setMetodo(messageContext.getRequest().toString().split("}")[1]);
         bitacoraPokemonApiVO.setIpOrigen(obtenerIpCliente());
         bitacoraPokemonApiVO.setTiempo(tiempoEjecucion.toString());
         bitacoraPokemonApiVO.setRequest(request);
         bitacoraPokemonApiServicejpa.guardarBitacora(bitacoraPokemonApiVO);
    	
    }


 
}
