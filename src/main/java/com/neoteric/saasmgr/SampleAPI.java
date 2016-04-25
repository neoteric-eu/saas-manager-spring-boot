package com.neoteric.saasmgr;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Api(tags = SampleAPI.PATH)
@Path(SampleAPI.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class SampleAPI {

    public static final String PATH = "/v1/sample";

    @GET
    @PreAuthorize("permitAll")
    public SampleData getData(){
        LOG.info("userId: {}", SaasMgrAuthUtils.getPrincipal().getUserId());
        LOG.info("customerId: {}", SaasMgrAuthUtils.getPrincipal().getCustomerId());
        LOG.info("features: {}", SaasMgrAuthUtils.getPrincipal().getAuthorities());

        return SampleData.builder()
                .foo("foo1")
                .bar("bar1")
                .build();
    }

    @GET
    @Path("another")
    public SampleData anotherOne(){
        return SampleData.builder()
                .foo("foo1")
                .bar("bar1")
                .build();
    }

}
