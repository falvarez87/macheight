package com.macheight.service;

import com.macheight.domain.Player;
import com.macheight.domain.PlayerWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.util.*;

@Service
@Slf4j
public class PlayerService {

    @Value("${api.players.url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    @Cacheable("players")
    public List<Player> GetAllPlayers() throws UnknownHostException {
        try{
            ResponseEntity<PlayerWrapper> response = restTemplate.getForEntity(url, PlayerWrapper.class);
            PlayerWrapper playerWrapper = response.getBody();
            List<Player> players = Arrays.asList(playerWrapper.getPlayers());
            log.info(players.size() + " players are obtained");
            return players;

        } catch (Exception ex) {
            log.error("Error get players list", ex);
            throw new UnknownHostException(ex.getMessage());
        }
    }
}
