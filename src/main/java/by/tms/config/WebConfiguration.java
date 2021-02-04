package by.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "by.tms")
public class WebConfiguration {

    @Bean
    public InternalResourceViewResolver resourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/pages/");  // для быстрого поиска страниц
        internalResourceViewResolver.setSuffix(".jsp");  // для быстрой установки типа страницы
        return internalResourceViewResolver;
    }
}
