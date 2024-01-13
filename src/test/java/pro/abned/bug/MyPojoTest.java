package pro.abned.bug;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class MyPojoTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.defaultViewInclusion(true);
        objectMapper = builder.build();
        objectMapper.setConfig(objectMapper.getSerializationConfig().withView(JsonViews.Default.class));
    }

    @Test
    void testSerializeToObjectWithDefault() throws JsonProcessingException {
        assertThat(objectMapper.writeValueAsString(new MyPojo())).isEqualTo("{\"property\":null}");
    }

    @Test
    void testSerializeToObjectForPublic() throws JsonProcessingException {
        assertThat(objectMapper.writerWithView(JsonViews.Public.class).writeValueAsString(new MyPojo())).isEqualTo("{\"property\":null,\"propertyPublic\":null}");
    }

    @Test
    void testSerializeToObjectForAdmin() throws JsonProcessingException {
        assertThat(objectMapper.writerWithView(JsonViews.Admin.class).writeValueAsString(new MyPojo())).isEqualTo("{\"property\":null,\"propertyPublic\":null,\"propertyAdmin\":null}");
    }
}
