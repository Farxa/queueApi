package com.example.queueApi.service;

import com.example.queueApi.model.User;
import com.example.queueApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        logger.info("OAuth2User attributes: {}", oAuth2User.getAttributes());

        // Extracting and processing user information
        // Log the extracted information
        String spotifyId = oAuth2User.getAttribute("id");
        String displayName = oAuth2User.getAttribute("display_name");
        logger.info("Spotify ID: {}, Display Name: {}", spotifyId, displayName);

        // Save or update the user in the database
        User user = userRepository.findById(spotifyId)
                .orElseGet(() -> new User(spotifyId, displayName));
        userRepository.save(user);

        return oAuth2User;
    }
}
