// bolt and knot generator

function bolt(params, num) {
    var thread = CSG.Polygon.createFromPoints([
		[(params.D2-params.H)/2 + (params.H-params.D2+params.D1)/2,	 (params.H+params.D2-params.D1)/4, 0],
		[(params.D2-params.H)/2 + (params.H+params.D -params.D2)/2,	 (params.H-params.D +params.D2)/4, 0],
		[(params.D2-params.H)/2 + (params.H+params.D -params.D2)/2, -(params.H-params.D +params.D2)/4, 0],
		[(params.D2-params.H)/2 + (params.H-params.D2+params.D1)/2, -(params.H+params.D2-params.D1)/4, 0]
	]).rotateX(90);

    var angle = 10;
	var helical = thread.solidFromSlices({
		numslices: num*360 / angle + 1,
		callback: function (t, slice) {
			return this
				.translate([0, 0, params.P * t * num])
				.rotateZ(slice*angle);
		}
	});
	
	var tube = [];
	for (var i = 0; i < num+1; ++i) {
		tube.push(
			cylinder({r:params.D1/2,h:params.P})
			.translate([0,0,i*params.P])
			.setColor(i/num*0.2,0,i/num)
		);
	}
	
	var boltHead = 
	cylinder({r:params.D1/2+params.H*5, h:params.P*3, fn:6})
	.translate([0,0,-params.P*2])
	.setColor(0,1,0);
	
	return helical.union(tube).union(boltHead).translate([0,0,params.P*2]);
}

function knot(params, num) {
	var thread = CSG.Polygon.createFromPoints([
		[(params.D2-params.H)/2 + (params.H-params.D2+params.D1)/2,	 (params.H-params.D +params.D2)/4, 0],
		[(params.D2-params.H)/2 + (params.H+params.D -params.D2)/2,	 (params.H+params.D2-params.D1)/4, 0],
		[(params.D2-params.H)/2 + (params.H+params.D -params.D2)/2, -(params.H+params.D2-params.D1)/4, 0],
		[(params.D2-params.H)/2 + (params.H-params.D2+params.D1)/2, -(params.H-params.D +params.D2)/4, 0]
	]).rotateX(90);

	var angle = 10;
	var helical = thread.solidFromSlices({
		numslices: num * 360 / angle + 1,
		callback: function (t, slice) {
			return this
				.translate([0, 0, params.P * t * num])
				.rotateZ(slice*angle);
		}
	});
	
	var body =
		cylinder({fn:6, r: params.D1/2+params.H*3, h:params.P*num})
		.setColor(0,1,0)
		.subtract(
			cylinder({r: params.D/2, h:params.P*num})
		).union(helical);
	
	return body
    .cutByPlane(CSG.Plane.fromNormalAndPoint([0, 0, 1], [0, 0, params.P*num]))
    .cutByPlane(CSG.Plane.fromNormalAndPoint([0, 0, -1], [0, 0, 0]))
    /*.scale(1.175)*/;
}

function main()
{
	 var params = {
		P: 1*2,    //pitch
		D: 9.5*2,  // major diameter
		D1: 8.5*2, // minor daimeter
		D2: 9*2    // picth diameter
	};
	params.H = params.P / 2 * Math.sqrt(3);

    var knot1 = knot(params, 4);

	return [
        bolt(params,10)   .translate([65,  0, 0]),
        knot1.scale(1.0  ).translate([ 0,  0, 0]), // x
        knot1.scale(1.025).translate([30,  0, 0]), // x
        knot1.scale(1.05 ).translate([ 0, 30, 0]), // ok
        knot1.scale(1.075).translate([30, 30, 0]), // ok
        knot1.scale(1.1  ).translate([60, 30, 0]), // ok
        knot1.scale(1.125).translate([ 0, 60, 0]), // ok
        knot1.scale(1.15 ).translate([30, 60, 0]), // x
        knot1.scale(1.175).translate([60, 60, 0])  // x
    ];
}
