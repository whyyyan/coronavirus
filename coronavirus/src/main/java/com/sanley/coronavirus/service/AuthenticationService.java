package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.Authentication;

import java.util.List;

public interface AuthenticationService {
    public List<Authentication> findByUserId(int userId);
}
