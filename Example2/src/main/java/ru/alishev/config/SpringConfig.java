package ru.alishev.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import ru.alishev.model.ClassicalMusic;
import ru.alishev.model.JazzMusic;
import ru.alishev.model.Music;
import ru.alishev.model.RockMusic;

@Configuration
@ComponentScan("ru.alishev.model")
@PropertySource("classpath:musicPlayer.properties")
@Import(MySpringConfig.class)
public class SpringConfig {
    @Bean
    public int myInt() { return 10; }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Music classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public Music rockMusic() {
        return new RockMusic();
    }

    @Bean(name = "jazzMusic", initMethod = "init2", destroyMethod = "destroy2")
    public Music myFavoriteMusic() {
        return new JazzMusic();
    }
}
