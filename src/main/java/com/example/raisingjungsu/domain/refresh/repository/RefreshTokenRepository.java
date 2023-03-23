package com.example.raisingjungsu.domain.refresh.repository;

import com.example.raisingjungsu.domain.refresh.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
