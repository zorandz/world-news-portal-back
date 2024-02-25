package com.index.utility;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiCaller {
	
	private RestTemplate restTemplate;

    public ApiCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Makes a call to HNB API, takes middle exchange rate for USD out of the response and returns it.
     * 
     * @return middle exchange rate for USD
     * @throws JsonMappingException if there is an error mapping JSON
     * @throws JsonProcessingException if there is an error processing JSON
     */
    public BigDecimal getUSDMiddleExchangeRate() throws JsonMappingException, JsonProcessingException {
    	 String url = "https://api.hnb.hr/tecajn-eur/v3?valuta=USD" ;
	        String response = restTemplate.getForObject(url, String.class);
	        
	        ObjectMapper objectMapper = new ObjectMapper();

	        TypeReference<List<LinkedHashMap<String, Object>>> typeReference = new TypeReference<List<LinkedHashMap<String, Object>>>() {};

	        List<LinkedHashMap<String, Object>> exchangeRates = objectMapper.readValue(response, typeReference);

	        String middleExchangeRateString = (String) exchangeRates.get(0).get("srednji_tecaj");
	        
	        String noCommaMiddleExchangeRateString = middleExchangeRateString.replace(",", ".");
	        
	        BigDecimal middleExchangeRate = new BigDecimal(noCommaMiddleExchangeRateString);
	        
	        return middleExchangeRate;
    }
}
