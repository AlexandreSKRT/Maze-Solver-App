package dijkstra;

public class Dijkstra {
	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi,
			PreviousInterface previous) {

		VertexInterface pivot = r;
		a.addVertex(r);
		for (int j = 1; j < g.getSize(); j++) {

			for (VertexInterface y : g.NotIn(a)) {

				if (g.getSuccessors(pivot).contains(y)) {

					if (pi.getPi(pivot) + g.getWeight(pivot, y) < pi.getPi(y)) {
						pi.setPi(y, pi.getPi(pivot) + g.getWeight(pivot, y));
						previous.addPrevious(y, pivot);
					}
				}

			}
			pivot = pi.getVertexPiMin(a, g);
			a.addVertex(pivot);
		}
		return previous;
	}

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		ASetInterface a = new Aset();
		PiInterface pi = new Pi();
		PreviousInterface previous = new Previous();

		pi.initPi(g, r);

		return dijkstra(g, r, a, pi, previous);
	}

}
