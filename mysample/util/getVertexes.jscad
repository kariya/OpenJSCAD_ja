function getVertexes(polyhedron) {
    var vertexes = [];
	
	function found(vertex) {
		for (var i = 0; i < vertexes.length; ++i) {
			if (vertexes[i] == vertex) return true;
		}
		return false;
	}
	
	for (var i = 0; i < polyhedron.polygons.length; ++i) {
		var polygon = polyhedron.polygons[i];
		for (var j = 0; j < polygon.vertices.length; ++ j) {
			var vertex = polygon.vertices[j];
			if (!found(vertex)) {
				vertexes.push(vertex.pos);
			}
		}
	}
	return vertexes;
}

/*
function main() {
	var s = sphere({fn: 16}).scale(10);
	
    return getVertexes(s)
		.map(function (v) { return cube().translate([v.x, v.y, v.z]); });
}
*/
