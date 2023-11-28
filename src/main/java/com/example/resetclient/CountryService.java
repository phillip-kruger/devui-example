package com.example.resetclient;

import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Set;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v3.1")
@RegisterRestClient(configKey="countries-api")
@ClientQueryParam(name = "fields", value = "name,flags")
public interface CountryService {
    
    @GET
    @Path("/all")
    Set<Country> getCountries();
}
