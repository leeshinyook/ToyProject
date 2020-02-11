package com.community;

import com.community.domain.Board;
import com.community.domain.User;
import com.community.domain.enums.BoardType;
import com.community.domain.enums.UserType;
import com.community.repository.BoardRepository;
import com.community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class BoardApplication  {
	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
