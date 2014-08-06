// test for fast vector_text using cache
// sorry, API has to change(csgBuilder aprameter)

function main() {
	var msg = "Long long long string\n";
	msg += msg;
	msg += msg;
	msg += msg;
	
	return text(1,1,msg);
}

function unionsForNonIntersecting(objs) {
	var buf = new CSG(); // empty
	for (var i = 0; i < objs.length; ++i) {
			buf = buf.unionForNonIntersecting(objs[i]);
	}
	return buf;
}

function text(w, h, msg) {
	var chars = vector_text(0, 0, msg);
	var buf = [];
	chars.forEach(function(s) {
		buf.push(rectangular_extrude(s, {w:w, h:h}));
	});
	return unionsForNonIntersecting(buf);
}

function my_text(w, h, msg) {
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
