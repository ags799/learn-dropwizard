package com.sharpandrew.learndropwizard;

import com.codahale.metrics.annotation.Timed;
import java.util.Set;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/graphs")
@Produces(MediaType.APPLICATION_JSON)
public interface GraphService {
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    Long add(Set<Edge> graph);

    @GET
    @Path("/{id}")
    @Timed
    Set<Edge> get(@PathParam("id") Long id);

    @GET
    @Path("/{id}/vertices")
    @Timed
    Set<Integer> getVertices(@PathParam("id") Long id);

    @GET
    @Path("/{id}/mst")
    @Timed
    Set<Edge> minimumSpanningTree(@PathParam("id") Long id);

}
