// clock animation
// Press F5 to stop animation

function clock(hour, minute, second) {
    var t = second + 60 * (minute + 60 * hour); 
    var h = cylinder({r:0.3,h:4}).setColor(1,0,0).rotateX(-t/60/60/12*360);
    var m = cylinder({r:0.2,h:5}).setColor(0,1,0).rotateX(-t/60/60*360);
    var s = cylinder({r:0.1,h:6}).setColor(0,0,1).rotateX(-t/60*360);
    var c = cylinder({r:8}).rotateY(90).translate([-1,0,0]);
    return union(c, h, m, s).translate([1,0,0]).rotateY(-90);
}

function loop() {
    var d = new Date();
    self.postMessage({cmd:'rendered', result: clock(d.getHours(), d.getMinutes(), d.getSeconds()).toCompactBinary()});
    setTimeout(function () {loop();}, 1000);
}

function main() {
    loop();
    return clock(0,0,0);
}
