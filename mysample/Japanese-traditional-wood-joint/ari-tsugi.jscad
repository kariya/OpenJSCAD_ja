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

function joint(l) {
    return union(
            ari_ogi().setColor(1,0,0),
            ari_megi().setColor(0,1,0).translate([-l/4,0,l])
    );

}

function loop(n) {
    if (n >= 0) {
        self.postMessage({cmd:'rendered', result: joint(n % 10).toCompactBinary()});
        setTimeout(function() {loop(n - 1);}, 1000);
    }
}

function getParameterDefinitions() {
	return [
		{name: 'kind', type: 'choice', caption: '', values: [0, 1, 2], captions: ['animation', 'static(jointed)', 'static(separate)'], initial: 0},
	];
}

function main(params) {
	var animation = (params.kind == 0);
	var jointed = (params.kind != 0) && (params.kind == 1);

	if (animation) {
		loop(10);		
		return cube().scale([.1,.1,.1]);
	} else {
	
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
}

