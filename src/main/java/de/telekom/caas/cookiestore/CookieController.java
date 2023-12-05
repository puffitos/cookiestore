package de.telekom.caas.cookiestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CookieController {

    @Autowired
    private CookieRepository cookieRepository;

    @GetMapping("/cookies")
    public List<Cookie> getAllCookies() {

        // Returning all cookies
        return cookieRepository.findAll();
    }
}
