package scratch;

import io.javalin.Javalin;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HelloEndpoint {


    private Javalin javalin;


    public HelloEndpoint(Javalin javalin) {
        this.javalin = javalin;
        setup();
    }

    void setup() {
        javalin.get("/hello", ctx -> {

            Map<String, Object> map = new HashMap<>();
            map.put("gold", 2000);
            map.put("human", 232);
            ctx.json(map);
        });
    }
}
