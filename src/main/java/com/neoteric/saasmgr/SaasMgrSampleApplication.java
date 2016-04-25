package com.neoteric.saasmgr;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableFeignClients
@SuppressWarnings("squid:S1118")
public class SaasMgrSampleApplication {

    public static void main(String... args) {
        SpringApplication.run(SaasMgrSampleApplication.class, args);
    }

    @Component
    static class JerseyConfig extends ResourceConfig {

        @SuppressWarnings("squid:S1699")
        public JerseyConfig() {
            register(SampleAPI.class);
        }
    }
}