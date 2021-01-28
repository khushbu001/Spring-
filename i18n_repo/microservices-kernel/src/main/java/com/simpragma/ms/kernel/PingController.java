package com.simpragma.ms.kernel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Ping health check API
 *
 * @author mmh
 */
@RestController
public class PingController {

    @RequestMapping("/ping")
    public Map<String, String> ping() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }
}
