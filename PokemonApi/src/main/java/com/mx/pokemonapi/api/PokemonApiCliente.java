package com.mx.pokemonapi.api;

import com.google.gson.Gson;
import com.mx.pokemonapi.vo.PokemonApiResponseVO;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class PokemonApiCliente {
    protected static Logger logger = LoggerFactory.getLogger(PokemonApiCliente.class);
    static final  String URI = "https://pokeapi.co/api/v2/pokemon/";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void close() {
        try {
            httpClient.close();
        }  catch (IOException e) {
			logger.error(e.getMessage());
		} 
    }

    public PokemonApiResponseVO consultarPokemonApi(String nombrePokemon) throws ClientProtocolException  {
        var request = new HttpGet(URI + nombrePokemon);
        var pokemonApiResponseVO = new PokemonApiResponseVO();
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            var result = EntityUtils.toString(entity);
            var gson = new Gson();
          
            if (response.getStatusLine().getStatusCode() == 200) {
            	pokemonApiResponseVO = gson.fromJson(result, PokemonApiResponseVO.class);
                return pokemonApiResponseVO;
            }
        } catch (IOException e) {
			logger.error(e.getMessage());
		} 

        return null;
    }
}
