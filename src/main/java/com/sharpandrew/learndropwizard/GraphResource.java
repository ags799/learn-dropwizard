package com.sharpandrew.learndropwizard;

import com.google.common.collect.Maps;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

class GraphResource implements GraphService {
    private final AtomicLong graphCounter;
    private final Map<Long, Set<Edge>> graphs;

    GraphResource() {
        this.graphCounter = new AtomicLong();
        this.graphs = Maps.newConcurrentMap();
    }

    @Override
    public Response add(Set<Edge> graph) {
        Long id = graphCounter.incrementAndGet();
        graphs.put(id, graph);
        return Response.created(URI.create(String.format("graphs/%s", id))).build();
    }

    @Override
    public Set<Edge> get(Long id) {
        if (graphs.containsKey(id)) {
            return graphs.get(id);
        } else {
            throw new NotFoundException(String.format("There is no graph with id '%s'", id));
        }
    }

    @Override
    public Set<Edge> minimumSpanningTree(Long id) {
        return MinimumSpanningTree.minimumSpanningTree(get(id));
    }

}
