package com.macheight.utils;

import com.macheight.domain.Player;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Util {
    public static List<String> findPairs(List<Player> players, int input) {
        List<String> result = new ArrayList<>();
        Collections.sort(players);
        int low = 0;
        int high = players.size() - 1;
        log.info("Input: "+input);
        while (low < high)
        {
            if (players.get(low).getH_in() + players.get(high).getH_in() == input)
            {
                log.info("Pair found (" + players.get(low).getFullName() + ", " +
                        players.get(high).getFullName() + ")");
                result.add(players.get(low).getFullName() + "," +
                        players.get(high).getFullName());
            }
            if (players.get(low).getH_in() + players.get(high).getH_in() < input) {
                low++;
            }
            else {
                high--;
            }
        }
        return result;
    }
}
