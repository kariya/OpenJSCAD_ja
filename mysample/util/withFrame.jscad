function main() {
    var obj = sphere({r:5});
	
	return with_frame(1,1,2,obj);
}

function with_frame(w, h, d, obj) {
	var bounds = obj.getBounds();
	var minX = bounds[0].x;
	var minY = bounds[0].y;
	var maxX = bounds[1].x;
	var maxY = bounds[1].y;
	
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


