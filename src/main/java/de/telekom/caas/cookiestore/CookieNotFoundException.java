package de.telekom.caas.cookiestore;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cookie not found")
public class CookieNotFoundException extends RuntimeException {

}
