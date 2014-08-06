function main() {
	return messageBoard("hello\nbye!");
}

function messageBoard(msg) {
	return with_frame(1,1,1, text(1, 1, msg));
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
	var minY = bounds[0].y + h;
	var maxX = bounds[1].x + w * 2;
	var maxY = bounds[1].y + w;
	
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

