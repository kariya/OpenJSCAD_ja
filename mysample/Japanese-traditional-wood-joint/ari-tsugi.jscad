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
    .translate([0,0,4.5]);	
	
	return CSG.cube({radius:1}).scale([6,3,1.5]).translate([6,0,6]).union([
		new CSG.cube({radius: 1}).scale([6.5,3,1.5]).translate([5.5,0,3]),
        ari
	]);
}

// megi means female wood
function ari_megi() {
	return new CSG.cube({radius: [6, 3, 3]}).translate([-6, 0, 4.5])
	.subtract(ari_ogi());
}

function main() {
	return [
		ari_ogi().setColor(1,0,0).translate([0,0,4-4]),
		ari_megi().setColor(0,1,0)
	];
}
