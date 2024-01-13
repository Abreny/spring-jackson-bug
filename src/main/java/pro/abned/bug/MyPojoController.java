package pro.abned.bug;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my-pojos")
public class MyPojoController {

    @GetMapping
    public MyPojo getPojo() {
        return new MyPojo();
    }

    @JsonView(JsonViews.Public.class)
    @GetMapping("public")
    public MyPojo getPojoForPublic() {
        return new MyPojo();
    }

    @JsonView(JsonViews.Admin.class)
    @GetMapping("admin")
    public MyPojo getPojoForAdmin() {
        return new MyPojo();
    }
}
