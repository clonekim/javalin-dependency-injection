package scratch;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebServerConfig {



    @Bean(destroyMethod = "stop" )
    public Javalin javalin(@Value("${server.port}") int port) {

        log.debug("server is starting on port:{}", port);
        return Javalin.create( config -> {
            config.showJavalinBanner = false;
            config.enableCorsForAllOrigins();
            config.enableDevLogging();

        }).start(port);
    }
}
