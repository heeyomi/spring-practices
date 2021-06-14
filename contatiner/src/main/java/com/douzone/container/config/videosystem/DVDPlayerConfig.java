package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;

@Configuration
public class DVDPlayerConfig {
	@Bean
	public Avengers avenger() {
		return new Avengers();
	}
}