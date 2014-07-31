// Japanese traditional wood joint
// ari-tsugi
// ari means an ant
// tsugi means joint

// ogi means male wood
function ari_ogi() {
    var ari = CAG.fromPoints([
    	[0, -0.5],
		[-1, -0.75],
		[-1, 0.75],
		[0,0.5]
	])
    .extrude({offset: [0, 0, 3]})
    .translate([0,0,3]);	
	
	return CSG.cube({radius:1}).scale([6,3,1.5]).translate([6,0,4.5]).union([
		new CSG.cube({radius: 1}).scale([6.5,3,1.5]).translate([5.5,0,1.5]),
        ari
	]);
}

// megi means female wood
function ari_megi() {
	return new CSG.cube({radius: [6, 3, 3]}).translate([-6, 0, 3])
	.subtract(ari_ogi());
}

function main() {
	var jointed = true;
	
	if (jointed) {
		// jointed form
		return [
			ari_ogi().setColor(1,0,0),
			ari_megi().setColor(0,1,0)
		];
	} else {
		// separate form (printable)
		return [
			ari_ogi().setColor(1,0,0),
			ari_megi().setColor(0,1,0).translate([12,7,0])
		];
	}
}
