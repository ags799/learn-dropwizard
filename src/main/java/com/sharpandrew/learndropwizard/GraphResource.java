package com.sharpandrew.learndropwizard;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;

class GraphResource implements GraphService {
    private final AtomicLong graphCounter;
    private final Map<Long, Set<Edge>> graphs;

    GraphResource() {
        this.graphCounter = new AtomicLong();
        this.graphs = Maps.newConcurrentMap();
    }

    @Override
    public Long add(Set<Edge> graph) {
        Long id = graphCounter.incrementAndGet();
        graphs.put(id, graph);
        return id;
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
    public Set<Integer> getVertices(Long id) {
        return get(id).stream()
                .map(edge -> ImmutableSet.of(edge.getVertex1(), edge.getVertex2()))
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Edge> minimumSpanningTree(Long id) {
        return MinimumSpanningTree.minimumSpanningTree(get(id));
    }

}
