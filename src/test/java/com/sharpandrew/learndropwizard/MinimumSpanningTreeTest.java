package com.sharpandrew.learndropwizard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.junit.Test;

public class MinimumSpanningTreeTest {
    @Test
    public final void minimumSpanningTree_emptyGraph() throws Exception {
        runMinimumSpanningTree(ImmutableSet.of(), ImmutableSet.of());
    }

    @Test
    public final void minimumSpanningTree_oneEdge() throws Exception {
        runMinimumSpanningTree(ImmutableSet.of(ImmutableEdge.of(1, 2, 3)), ImmutableSet.of(ImmutableEdge.of(1, 2, 3)));
    }

    @Test
    public final void minimumSpanningTree_twoEdges() throws Exception {
        runMinimumSpanningTree(
                ImmutableSet.of(ImmutableEdge.of(1, 2, 3), ImmutableEdge.of(1, 2, 4)),
                ImmutableSet.of(ImmutableEdge.of(1, 2, 3)));
    }

    @Test
    public final void minimumSpanningTree_threeEdges() throws Exception {
        runMinimumSpanningTree(
                ImmutableSet.of(ImmutableEdge.of(1, 2, 1), ImmutableEdge.of(2, 3, 1), ImmutableEdge.of(1, 3, 3)),
                ImmutableSet.of(ImmutableEdge.of(1, 2, 1), ImmutableEdge.of(2, 3, 1)));
    }

    @Test
    public final void minimumSpanningTree_disconnected() throws Exception {
        runMinimumSpanningTree(
                ImmutableSet.of(ImmutableEdge.of(1, 2, 1), ImmutableEdge.of(3, 4, 1)),
                ImmutableSet.of(ImmutableEdge.of(1, 2, 1), ImmutableEdge.of(3, 4, 1)));
    }

    private void runMinimumSpanningTree(Set<Edge> input, Set<Edge> output) {
        assertThat(MinimumSpanningTree.minimumSpanningTree(input), is(output));
    }

}
