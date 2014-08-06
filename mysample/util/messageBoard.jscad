function main() {
	return messageBoard("hello\nbye!");
}

function messageBoard(msg) {
	return with_frame(1,1,1, text(1, 1, msg));
}

function unionsForNonIntersecting(objs) {
	var buf = objs[0];
	for (var i = 1; i < objs.length; ++i) {
		buf = buf.unionForNonIntersecting(objs[i]);
	}
	return buf;
}

function text(w, h, msg) {
	var chars = vector_text(0,0,msg);
	var buf = [];
	chars.forEach(function(s) {
    	buf.push(rectangular_extrude(s, {w:w, h:h}));
	});
	var text = unionsForNonIntersecting(buf);
	
	return text;
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

