// src/main/java/com/matthewcasperson/auth0demo/controllers/ApiProxyController.java

package com.matthewcasperson.auth0demo.controllers;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ApiProxyController {

    private OAuth2AuthorizedClientService clientService;

    @Autowired
    public ApiProxyController(OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

    private String getAccessToken() {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        OAuth2AuthenticationToken oauthToken =
                (OAuth2AuthenticationToken) authentication;

        OAuth2AuthorizedClient client =
                clientService.loadAuthorizedClient(
                        oauthToken.getAuthorizedClientRegistrationId(),
                        oauthToken.getName());

        return client.getAccessToken().getTokenValue();
    }

    private String accessAPI(String message) {
        try {
            CloseableHttpClient httpClient = HttpClients.custom().build();
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("http://" + System.getenv().get("EXTERNALAPI") + "/api/messages/" + message)
                    .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                    .build();
            CloseableHttpResponse response = httpClient.execute(request);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            return "{\"message\": \"" + e + "\"}";
        }
    }

    @RequestMapping(value = "/api/messages/{message}", method = RequestMethod.GET)
    @ResponseBody
    public String proxyMessageRequest(HttpServletResponse response, @PathVariable("message") String message) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        return accessAPI(message);
    }
}