package com.skillstorm.springoauth2google.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private OAuth2AuthorizedClientService clientService;    

    @GetMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }

    // get method for retrieving user's info that we have permission to use (scope)
    @GetMapping("/userinfo")
    @ResponseBody
    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }

    @GetMapping("/accessToken")
    @ResponseBody
    public String accessToken(Authentication auth) {

        //checking to see if the auth object that we pulled from security context is a OAuth2AuthenticationToken
        if(auth instanceof OAuth2AuthenticationToken) {

            //casting the Authentication object to be a OAuth2AuthenticationToken object
            OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken)auth;

            // retrieving the authorized client with *this specific* Authenticatation Principal (each user is unique)
            OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());

            /* Something like this for adding access token to http only cookie - make sure you take in HttpServletResponse as parameter
            Cookie cookie = new Cookie("Access Token", client.getAccessToken().getTokenValue());
            cookie.isHttpOnly();
            response.addCookie(cookie);
            */

            //returning the value of the token
            return client.getAccessToken().getTokenValue();
        }
        return "";
    }


    /**
     * use this endpoint as a dedicated way to authenticate the user with the OAuth2 client
     *      - this also provides a convient way to get JSESSIONID and X-XSRF-TOKEN
     * 
     * 
     *      Flow:
     *          - frontend reedirects to this endpoint
     *          - this enpoint requires authentication so OAuth2 interject
     *          - the user signs in with the auth server
     *          - then continue on to this endpoint
     *          - this endpoint just sends you back to the frontend
     * 
     */
    @GetMapping("/signin")
    public RedirectView redirectView() {
        
        return new RedirectView("http://localhost:5173");
    }

    
}
