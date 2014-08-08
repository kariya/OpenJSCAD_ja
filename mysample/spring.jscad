function main() {
    return spring(5, 2, 10, 0.5);
}
function my_circle(r) {
    var buf = [];
    
    for (var i = 0; i < 360; i += 10) {
        buf.push([r * cos(i), r * sin(i), 0]);
    }
    
    return CSG.Polygon.createFromPoints(buf);
}

// radius, pitch, number of roles, width of line
function spring(r, p, num, w) {
    return spring1 = my_circle(w)
    .rotateX(90)
    .solidFromSlices({
        numslices: num * 30,
        callback: function (t, slice) {
            return this
            .rotateZ(num * 360 * t)
            .translate([r * cos(num * 360 * t), r * sin(num * 360 * t), num * t * p]);
        }
    });
}
