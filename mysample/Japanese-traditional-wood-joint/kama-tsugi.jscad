// Kama-tsugi
// kama means a sickle.
// Tsugi means joint.

// Ogi means male wood.
function kama_ogi() {
    var kama = union(
        new CAG.fromPoints([
    		[0, -0.5],
			[-2, -0.5],
			[-2, -0.8],
			[-4, -0.5],
			[-4, 0.5],
			[-2, 0.8],
			[-2, 0.5],
			[0, 0.5]
		])
		.extrude({offset:[0, 0, 3]})
        .translate([0.5,0,-1.5]),
		new CAG.fromPoints([
			[1, -0.5],
			[0, -0.5],
			[0, 0.5],
			[1, 0.5]
		])
		.extrude({offset:[0, 0, 6]})
		.translate([0.5, 0, -4.5])
	)
    .translate([0, 0, 4.5]);
	
	return new CSG.cube({radius: [6, 3, 1.5]})
        .translate([6.5, 0, 4.5])
        .union(
			new CSG.cube({radius: [5.5, 3, 1.5]})
			.translate([7, 0, 1.5])
		)
		.union(kama);
}

// megi means female wood
function kama_megi() {
	return new CSG.cube({radius: [10, 3, 3]})
    .translate([0,0,3])
	.subtract(kama_ogi());
}

function main() {
	var jointed = true;

	if (jointed) {
		return [kama_ogi().setColor(1,0,0), kama_megi().setColor(0,1,0)];
	} else {
		return [kama_ogi().setColor(1,0,0), kama_megi().setColor(0,1,0).translate([10, 6.5, 0])];
	}
}

