package com.community.repository;

import com.community.domain.Board;
import com.community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
