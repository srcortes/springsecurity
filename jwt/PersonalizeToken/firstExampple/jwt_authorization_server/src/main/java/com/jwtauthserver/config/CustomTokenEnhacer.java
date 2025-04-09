package com.jwtauthserver.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.time.ZoneId;
import java.util.Map;
import java.util.UUID;

public class CustomTokenEnhacer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken  = new DefaultOAuth2AccessToken(oAuth2AccessToken);
        Map<String, Object> info = Map.of("generatedInZone", ZoneId.systemDefault().toString(),
        "SessionId", UUID.randomUUID());
        defaultOAuth2AccessToken.setAdditionalInformation(info);

        return defaultOAuth2AccessToken;
    }
}
