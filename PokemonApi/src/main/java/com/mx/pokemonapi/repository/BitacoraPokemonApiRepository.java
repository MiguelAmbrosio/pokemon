package com.mx.pokemonapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.pokemonapi.entity.BitacoraPokemonApiEntity;

@Repository
public interface BitacoraPokemonApiRepository extends JpaRepository<BitacoraPokemonApiEntity, Long> {
	
	
	

	

}


