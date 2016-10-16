package com.sharpandrew.learndropwizard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.ws.rs.NotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public final class GraphResourceTest {
    private GraphResource graphResource;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        graphResource = new GraphResource();
    }

    @Test
    public void postGraph_firstGraphHasId1() throws Exception {
        Set<Edge> graph = ImmutableSet.of();
        graphResource.add(graph);
        assertThat(graphResource.get(1L), is(graph));
    }

    @Test
    public void getGraph_startsWithoutGraphs() throws Exception {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("There is no graph with id '1'");
        graphResource.get(1L);
    }

    @Test
    public void postGraph_multiplePosts() throws Exception {
        Set<Edge> graph1 = ImmutableSet.of(ImmutableEdge.of(1, 2, 3));
        graphResource.add(graph1);
        Set<Edge> graph2 = ImmutableSet.of(ImmutableEdge.of(4, 5, 6));
        graphResource.add(graph2);
        assertThat(graphResource.get(1L), is(graph1));
        assertThat(graphResource.get(2L), is(graph2));
    }

    @Test
    public void minimumSpanningTree_nonExistentId() throws Exception {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("There is no graph with id '1'");
        graphResource.minimumSpanningTree(1L);
    }

}