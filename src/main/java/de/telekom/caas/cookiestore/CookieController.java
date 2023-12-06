package de.telekom.caas.cookiestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CookieController {

    private final CookieRepository cookieRepository;

    public CookieController(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @GetMapping("/cookies")
    public List<Cookie> getAllCookies() {
        return cookieRepository.findAll();
    }

    @GetMapping("/cookie/{id}")
    public Cookie getCookieById(@PathVariable Long id) {
        return cookieRepository.findById(id).orElseThrow();
    }
}
