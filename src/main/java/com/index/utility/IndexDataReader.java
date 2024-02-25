package com.index.utility;

import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IndexDataReader implements ItemReader<String>{
	
	private String apiUrl = "http://www.index.hr/";
    private final RestTemplate restTemplate;

    public IndexDataReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public String read() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        return response.getBody();
    }

}
