package com.example.queueApi.service;

import com.example.queueApi.model.User;
import com.example.queueApi.repository.UserRepository;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.apache.hc.core5.http.ParseException;
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
        System.out.println("OAuth2User attributes: " + oAuth2User.getAttributes());

        String accessToken = userRequest.getAccessToken().getTokenValue();
        SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();
        GetCurrentUsersProfileRequest profileRequest = spotifyApi.getCurrentUsersProfile().build();
        System.out.println("profileRequest: " + profileRequest);
        try {
            se.michaelthelin.spotify.model_objects.specification.User spotifyUser = profileRequest.execute();

            User user = userRepository.findById(spotifyUser.getId()).orElseGet(() -> new User());
            System.out.println("user: " + user);
            user.setId(spotifyUser.getId());
            user.setDisplayName(spotifyUser.getDisplayName());
            userRepository.save(user);

        } catch (Exception e) {
            logger.error("Error saving user: {}", e.getMessage());

        }

        return oAuth2User;
    }
}
