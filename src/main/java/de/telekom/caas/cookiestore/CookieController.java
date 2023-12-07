package de.telekom.caas.cookiestore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/cookies/{id}")
    public Cookie getCookieById(@PathVariable Long id) throws CookieNotFoundException {
        Optional<Cookie> c = cookieRepository.findById(id);
        // return cookie, if found, else return 404
        if (c.isPresent()) {
            return c.get();
        }

        throw new CookieNotFoundException();

    }
}
