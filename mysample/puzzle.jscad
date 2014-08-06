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

// answer animation
function loop2(n, cb) {
	if (n >= 0) {
		render(animation(n).union(mes2));
		setTimeout(function () {loop2(n - 0.1);}, 1000);
	} else {
        setTimeout(cb, 0);   
	}
}

function main() {
	mes1 = messageBoard("How to unjoint this?\nSeems impossible?");
    mes2 = messageBoard("Now the answer!");

    setTimeout(function () {
        loop1(0, function () {
            loop2(0.9, function () {
            });});
    }, 3000);
  
	return mes1;
}

function messageBoard(msg) {
	return with_frame(1,1,1, text(1, 1, msg))
    .scale([0.1,0.1,1])
    .rotateX(60)
    .rotateZ(45)
    .translate([5,2,0])
    .setColor(0,0,0);
}

function unionsForNonIntersecting(objs) {
	var buf = new CSG();
	for (var i = 0; i < objs.length; ++i) {
		buf = buf.unionForNonIntersecting(objs[i]);
	}
	return buf;
}

function text(w, h, msg) {
	return my_vector_text(0, 0, msg, function (seg) {
		return new CSG.Path2D(seg).rectangularExtrude(w, h, 16);
	});
}

function my_vector_text(x, y, s, csgBuilder) {
	var buf = [];
	var cache = new Array(128-32);
	
	var x0 = x;
	for (var i = 0; i < s.length; i++) {
		var c = s.charAt(i);
		var cc = s.charCodeAt(i) - 32;
		if(c == '\n') {
			x = x0; 
			y -= 30;
		} else {
			var ch = vector_char(0,0,c);
			var csgs = null;
			if (cache[cc] != null) csgs = cache[cc];
			else {
				csgs = ch.segments.map(function (seg) { return csgBuilder(seg); });
				cache[cc] = csgs;
			}
			csgs.forEach(function (csg) { buf.push(csg.translate([x,y,0])); });
			x += ch.width;
		}
   }
   return unionsForNonIntersecting(buf);
}

function with_frame(w, h, d, obj) {
	var bounds = obj.getBounds();
	var minX = bounds[0].x - w * 2;
	var minY = bounds[0].y + h * 2;
	var maxX = bounds[1].x + w * 2;
	var maxY = bounds[1].y + w * 2;
	
	var frame_top = linear_extrude({height: d}, CAG.fromPoints([
		[minX - w, minY - h],
		[maxX,     minY - h],
		[maxX,     minY    ],
		[minX - w, minY    ]
	]));
	var frame_bottom = linear_extrude({height: d}, CAG.fromPoints([
		[minX,     maxY    ],
		[maxX + w, maxY    ],
		[maxX + w, maxY + h],
		[minX,     maxY + h]
	]));
	var frame_left = linear_extrude({height: d}, CAG.fromPoints([
		[minX - w, minY],
		[minX,     minY],
		[minX,     maxY + h],
		[minX - w, maxY + h]
	]));
	var frame_right = linear_extrude({height: d}, CAG.fromPoints([
		[maxX,     minY - h],
		[maxX + w, minY - h],
		[maxX + w, maxY + 0],
		[maxX,     maxY + 0]
	]));
	
	return obj.union([frame_top, frame_bottom, frame_left, frame_right]);
}

