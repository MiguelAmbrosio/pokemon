package com.mx.pokemonapi.repository;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.pokemonapi.entity.BitacoraPokemonApiEntity;
import com.mx.pokemonapi.vo.BitacoraPokemonApiVO;

@Service
public class BitacoraPokemonApiServicejpa {
	
	@Autowired
    private BitacoraPokemonApiRepository bitacoraPokemonApiRepository;
	
	
	public void guardarBitacora(BitacoraPokemonApiVO bitacoraPokemonApiVO) {
		
		 Date date = new Date();
	        BitacoraPokemonApiEntity bitacoraPokemonEntity = new BitacoraPokemonApiEntity();
	        bitacoraPokemonEntity.setMetodo(bitacoraPokemonApiVO.getMetodo());
	        bitacoraPokemonEntity.setIpOrigen(bitacoraPokemonApiVO.getIpOrigen());
	        bitacoraPokemonEntity.setFecha(new Timestamp(date.getTime()));
	        bitacoraPokemonEntity.setTiempo(bitacoraPokemonApiVO.getTiempo());
	        bitacoraPokemonEntity.setRequest(bitacoraPokemonApiVO.getRequest());
	       
	        
	        bitacoraPokemonApiRepository.save(bitacoraPokemonEntity);
	        
        
    }
	

}
