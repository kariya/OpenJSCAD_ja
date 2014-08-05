// puzzle version

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
	return union([
		ogi().setColor(1,0,0),
		megi().setColor(0,1,0).translate([0, 4*(0.9-t), 0])
	]).translate([0,0,4]);
}

function render(o) {
    self.postMessage({cmd: 'rendered', result: o.toCompactBinary()});
}

var mes1 = null;
var mes2 = null;

// rotatation animation
function loop1(n, cb) {
    if (n < 360) {
        render(animation(0.9).rotateZ(n).union(mes1));
        setTimeout(function () { loop1(n + 10, cb); }, 200);
    } else {
        setTimeout(cb, 5000);
    }
}

// ansert animation
function loop2(n, cb) {
	if (n >= 0) {
		render(animation(n).union(mes2));
		setTimeout(function () {loop2(n - 0.1);}, 1000);
	} else {
        setTimeout(cb, 0);   
	}
}

function main() {
	mes1 = show("How to unjoint this?\nseems impossible?");
    mes2 = show("Now the answer!");

    setTimeout(function () {
        loop1(0, function () {
            loop2(0.9, function () {
            });});
    }, 3000);
    
	return mes1;
}

function show(msg) {
    var t = vector_text(0,0,msg);
	var o = [];

	t.forEach(function(s) {
		o.push(rectangular_extrude(s, {w:2, h:3}));
	});
	
	var text = union(o).scale([0.1,0.1,0.1]).setColor(0.9,0.9,0.9);
	var minP = text.getBounds()[0];
	var maxP = text.getBounds()[1];
	var frame = CAG.roundedRectangle({
		center: [(minP.x + maxP.x) / 2, (minP.y + maxP.y) / 2],
		radius: [(maxP.x - minP.x) / 2 * 1.25, (maxP.y - minP.y) / 2 * 1.25],
		roundradius: 0.25
	}).extrude({offset: [0,0,2]})
	.subtract(
		CAG.rectangle({
			center: [(minP.x + maxP.x) / 2, (minP.y + maxP.y) / 2],
			radius: [(maxP.x - minP.x) / 2 * 1.1, (maxP.y - minP.y) / 2]
		})
		.extrude({offset: [0,0,2]})
        .translate([0,0,0.1])
	)
	.scale([1,1,0.05])
	.setColor(0,0,0);
	
	return union(text, frame)
    .rotateZ(45)
    .translate([0,10,2])
    .scale([0.7,0.7,1]);
}
