// sihou-ari joint
// sihou meas four directions.
// this joint appears very mysterious when you see it for the first time.

function tCutter() {
    return linear_extrude({height: 4},
				polygon([
					[-1/2, 0],
					[1/2, 0],
					[0, 3]]));
}

function ogi() {
	return union(
		intersection(
			rotate([-90,0,0],
				union(
					translate([-1, 0, -2],
						tCutter()),
					translate([1,0,-2],
						tCutter() ))),
			rotate([0,0,45],
				cube({size:[3,3,5], center:true}) )),
		translate([0,0,-2.5],
			rotate([0,0,45],
				cube({size:3, center:true}) )));
}

function megi() {
	return difference(
		rotate([0,0,45],
			cube({size:[3,3,4], center:true})),
		ogi());
}

function animation(t) {
	return union(
		ogi().setColor(1,0,0),
		megi().setColor(0,1,0).translate([0, 4*(0.9-t), 0])
	).translate([0,0,4]);
}

function loop(n) {
	if (n >= 0) {
		self.postMessage({cmd: 'rendered', result: animation(n).toCompactBinary()});
		setTimeout(function () {loop(n - 0.1);}, 1000);
	}
}

function main() {
	loop(0.9);
	return animation(0.9);
}

