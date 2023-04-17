package ru.alishev.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TestSpring {
    public static void main(String[] args) {
        //Использование файла конфигурации XML
  /*      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application.Context.xml"
        );
        MusicPlayer musicPlayer = context.getBean("testConfiguration", MusicPlayer.class);
        MusicPlayer testScope = context.getBean("testConfiguration", MusicPlayer.class);
        if(musicPlayer.equals(testScope)){
            System.out.println("Объекты бинов одинаковые!");
        }else{
            System.out.println("Объекты бинов не одинаковые!");
        }
        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class );
        context.close();*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("Проверка работы только с Java кодом!");
        context.close();
    }
}
