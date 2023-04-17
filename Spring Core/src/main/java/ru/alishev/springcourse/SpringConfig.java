package ru.alishev.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.alishev.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
  @Bean
  public ClassicalMusic classicalMusic(){
      return new ClassicalMusic();
  }
  @Bean
    public RockMusic rockMusic(){
      return new RockMusic();
  }

  @Bean
    public MusicPlayer musicPlayer(){
      return new MusicPlayer(rockMusic(), classicalMusic());
  }
}
