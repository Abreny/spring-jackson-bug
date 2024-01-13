package pro.abned.bug;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.defaultViewInclusion(true);
        ObjectMapper objectMapper = builder.build();
        objectMapper.setConfig(objectMapper.getSerializationConfig().withView(JsonViews.Default.class));

        return objectMapper;
    }
}
