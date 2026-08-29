package com.example.demo.exploration;

import org.springframework.stereotype.Service;

@Service
public class ExplorationService {
    public boolean checkExploration(String param) {
        if (param == null || param.isEmpty()) {
            return false;
        }

        return true;
    }
}
