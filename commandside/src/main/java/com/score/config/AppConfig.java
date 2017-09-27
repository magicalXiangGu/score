package com.score.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by zxp.
 */
@Configuration
@Import({
        AxonConfiguration.class,
        TeachingClassConfig.class,

})
public class AppConfig {
}
