package pro.abned.bug;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyPojo {
    private String property;

    @JsonView(JsonViews.Public.class)
    private String propertyPublic;

    @JsonView(JsonViews.Admin.class)
    private String propertyAdmin;
}
