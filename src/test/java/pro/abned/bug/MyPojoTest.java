package pro.abned.bug;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(JacksonConfig.class)
public class MyPojoTest {
    @Autowired
    private ObjectMapper objectMapper;

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
