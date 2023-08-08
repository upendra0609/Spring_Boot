package com.sikku.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
public class HelloController {

//	@RequestMapping(value="/hello")
	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("Hello");
		return "Hello User!";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String login_id, @RequestParam String password, Model model) throws RestClientException {
	    String authenticationApiUrl = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";

	    // Prepare the request body
	    MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
	    requestBody.add("login_id", login_id);
	    requestBody.add("password", password);
	    // Set up the headers with the Content-Type
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // Create the HTTP entity with headers and request body
	    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
	    RestTemplate template = new RestTemplate();
	    // Make the POST request to the authentication API
	    ResponseEntity<String> response = template.exchange(authenticationApiUrl, HttpMethod.POST, requestEntity, String.class);

	    // Check the response status code
	    if (response.getStatusCode().is2xxSuccessful()) {
	        // Authentication successful, extract the bearer token from the response
	        String bearerToken = response.getBody();
	        // Save the bearer token in session or as a class variable for further API calls

	        // For the sake of simplicity, we will just set the bearer token as a model attribute
	        model.addAttribute("bearerToken", bearerToken);
	        // Assuming successful login, redirect to the customer list page
	        return "redirect:/customerList";
	    } else {
	        // Authentication failed, handle the error (e.g., show an error message on the login page)
	        return "login";
	    }
	}


}
