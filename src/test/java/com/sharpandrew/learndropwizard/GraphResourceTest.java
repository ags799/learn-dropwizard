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

public class GraphResourceTest {
    private GraphService graphResource;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        graphResource = new GraphResource();
    }

    @Test
    public final void get_startsWithoutGraphs() throws Exception {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("There is no graph with id '1'");
        graphResource.get(1L);
    }

    @Test
    public final void add_firstGraphHasId1() throws Exception {
        Set<Edge> graph = ImmutableSet.of();
        assertThat(graphResource.add(graph), is(1L));
        assertThat(graphResource.get(1L), is(graph));
    }

    @Test
    public final void add_multiplePosts() throws Exception {
        Set<Edge> graph1 = ImmutableSet.of(ImmutableEdge.of(1, 2, 3));
        assertThat(graphResource.add(graph1), is(1L));
        Set<Edge> graph2 = ImmutableSet.of(ImmutableEdge.of(4, 5, 6));
        assertThat(graphResource.add(graph2), is(2L));
        assertThat(graphResource.get(1L), is(graph1));
        assertThat(graphResource.get(2L), is(graph2));
    }

    @Test
    public final void minimumSpanningTree_nonExistentId() throws Exception {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("There is no graph with id '1'");
        graphResource.minimumSpanningTree(1L);
    }

    @Test
    public final void getVertices_emptyGraph() throws Exception {
        long id = graphResource.add(ImmutableSet.of());
        assertThat(graphResource.getVertices(id), is(ImmutableSet.of()));
    }

    @Test
    public final void getVertices_oneVertex() throws Exception {
        long id = graphResource.add(ImmutableSet.of(ImmutableEdge.of(1, 1, 2)));
        assertThat(graphResource.getVertices(id), is(ImmutableSet.of(1)));
    }

    @Test
    public final void getVertices_twoVertices() throws Exception {
        long id = graphResource.add(ImmutableSet.of(ImmutableEdge.of(1, 2, 3)));
        assertThat(graphResource.getVertices(id), is(ImmutableSet.of(1, 2)));
    }

    @Test
    public final void getVertices_disconnected() throws Exception {
        long id = graphResource.add(ImmutableSet.of(ImmutableEdge.of(1, 2, 3), ImmutableEdge.of(3, 3, 4)));
        assertThat(graphResource.getVertices(id), is(ImmutableSet.of(1, 2, 3)));
    }

}
