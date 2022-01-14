package com.macheight.controller;

import com.macheight.domain.Player;
import com.macheight.exception.PlayerNotFoundException;
import com.macheight.service.PlayerService;
import com.macheight.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.UnknownHostException;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/player/get_pairs/{input}")
    public List<String> getPairs(@PathVariable int input) {
        try {
            List<Player> players = playerService.GetAllPlayers();
            List<String> pairs = Util.findPairs(players,input);
            if(pairs.size()==0) {
                throw new PlayerNotFoundException(input);
            }
            return pairs;
        } catch (UnknownHostException exc) {
            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE, "Host not reachable", exc);
        }

    }
}
