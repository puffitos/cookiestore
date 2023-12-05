package de.telekom.caas.cookiestore;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<Cookie, Long> {
  List<Cookie> findAll();
}
