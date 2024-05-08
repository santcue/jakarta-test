package cue.edu.co.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {

    Optional<String> getusername(HttpServletRequest req);

}
