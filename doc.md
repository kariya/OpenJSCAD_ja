**OpenJSCAD.org Version 0.017 (2013/04/25) - Note: This Is Work In Progress**
**訳注：日本語訳 2014/07/23- **

## イントロダクション
ようこそ、**OpenJSCAD.org User & Programming Guide** へ。. 
<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/drawing-02.png" align=right>

文脈を理解してもらうための説明ですが、
**OpenJSCAD.org** は [OpenJsCad (Github)](http://joostn.github.com/OpenJsCad/) 上に構築され、これ自身は [OpenSCAD.org](http://openscad.org) に触発されたもので、本質的には3Dモデルを開発する**JavaScript**を使ったプログラマー的取り組み方を提供し、特にこの強化は3D印刷のためのモデル作成用に調整されています。


**OpenJSCAD** は非常にオブジェクト指向的で、 **OpenSCAD** から来たプログラマーは以下のことに歓迎の意を表すかもしれません。
* OpenSCAD のソースコードのサポート(約 95% の関数が利用可能)
* OpenJSCADへの移行を簡単にするいくつかのJavaScriptの関数

この文章を続けて読んで下さい。

## WEBブラウザとコマンドライン・インタフェース（「２つの特徴を持つ用法」）

### WEBブラウザー (オンライン、ローカルとオフライン)

**[OpenJSCAD.org](http://openjscad.org)** には利用者のためのエディターが含まれます：

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/sshot-01.png" width=600>

エディター内で
* 組み込みのエディターを使ってオンラインで編集できます
* 好みのエディターを使ってオフラインで編集できます(.jscadファイルをブラウザーで示された領域にドラッグアンドドロップするだけです(Chrome & Firefox)。フォルダーでも可能です(Chromeのみ)。 Auto Reload [x] がチェックされていることを確認して下さい。)

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/sshot-05-illu.png" width=600>

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/sshot-06-illu.png" width=600>

**注意:** 現段階では **Google Chrome** と **Firefox** をサポートしています (WebGLが必須)が、 Opera と IE10 が後に続くかもしれません。

### ローカルインストール (オフライン)

前提条件:
* **[NodeJS](http://nodejs.org/)** をインストールして下さい(例 ``apt-get install nodejs``), <b>NodeJS &gt;= 0.8.1であることを確かめて下さい</b> (Ubuntu 12.04 は NodeJS 0.6.1 をインストールします)。

**注意:** 実際のNodeJS実行ファイル名が`/usr/local/bin/node` (デフォルト) か `/usr/bin/nodejs`であることと、`openjscad`の１行目がその名前であることをチェックして下さい。

以下では、次のようにレポジトリをクローンしたことを仮定します。
<pre>
% git clone git@github.com:Spiritdude/OpenJSCAD.org.git
% cd OpenJSCAD.org
% make install
</pre>

#### WEBブラウザ (オフライン)

`index.html`のローカルコピーに利用中のブラウザ(今の所、<b>Google Chrome</b> か <b>Firefox</b> のみ。 Opera と IE10 が続く予定です。)でアクセスして下さい。

**注意:** 複数の .jscad ファイルのドラッグアンドドロップのみできます。(Chrome か Firefox かを問わず)フォルダーは利用できません。

#### コマンドラインインターフェース (オフライン)

以下のコマンドで ``logo.stl`` または ``test.stl`` が作成されます。
<pre>
% cd examples
% openjscad logo.jscad
% openjscad logo.jscad -o test.stl
% openjscad logo.jscad -of stl
</pre>


さらに OpenSCAD (.scad)、 STL ASCII または Binary (.stl)、そして AMF (.amf) ファイルが取込可能です。 .jscad、 .stl (ASCII または Binary)か .amfが作成可能です。:
<pre>
% openjscad example001.scad -o example001.jscad
% openjscad example001.scad -o example001.stl
% openjscad frog.stl -o frog.jscad
% openjscad frog.stl -o frog2.stl             # does actually stl -> jscad -> stl (ascii)
% openjscad example001.jscad -o example001.amf  
% openjscad example001.jscad -of amf          # creates example001.amf
% openjscad example001.jscad -of stlb         # creates example001.stl (binary)
% openjscad example001.jscad -of stlb -o test.stl
</pre>

* ``-o`` は出力を表します。
* ``-of`` は出力形式を表します。(jscad, stl (デフォルト), stla, stlb, amf)

コマンドラインからmain()へ変数を渡す方法 <a href="https://github.com/Spiritdude/OpenJSCAD.org/wiki/User-Guide#command-line-interface-cli--parameters">Command Line Interface Parameters</a> も参照して下さい。

##言語 / ファイル形式のサポート

現在、次の言語とファイル形式をサポートしています。
* <b>JSCAD</b> / .jscad (OpenJSCAD.org): 本文書は.jscadの詳細を記述しています。これは本質的に JavaScript + CSG 及び、ソリッドを構築する3D関数とメソッドです。
* <b>SCAD</b> / .scad (OpenSCAD.org): [OpenSCAD User Manual](http://en.wikibooks.org/wiki/OpenSCAD_User_Manual) はscad文法を記述しています。scad言語の約95%がサポートされています (<a href="https://github.com/Spiritdude/OpenJSCAD.org/wiki/User-Guide#direct-openscad-scad-import">OpenSCAD Import Section</a> 参照)
* <b>STL</b> / .stl: <a href="http://en.wikipedia.org/wiki/STL_(file_format)">Wikipedia: STL (file format)</a>
* <b>AMF</b> / .amf: <a href="http://en.wikipedia.org/wiki/Additive_Manufacturing_File_Format">Additive Manufacturing File Format</a> (非常に実験的)

ファイルをドラッグアンドドロップすると、言語かファイルフォーマットがファイル拡張子(.jscad, .scad, .stl, .amf)に従って設定されます。 WEB GUI(ブラウザ)で直接編集を始める場合、デフォルトの言語は <b>JSCAD .jscad</b> です。

###ローカルかリモートのJSCADやSCAD、 STL、 AMFへの直接リンク

特定の例へのリンクを他の人に渡すことが出来ます：
####ローカル
* <b><a href="http://openjscad.org/#examples/slices/tor.jscad">http://openjscad.org/#examples/slices/tor.jscad</a></b>
* <b>http://localhost/OpenJSCAD.org/#examples/slices/tor.jscad</b>

JSCADを参照する場合、 <b>include()</b> がサポートされます。

####リモート
* <b><a href="http://openjscad.org/#http://openjscad.org/examples/slices/tor.jscad">http://openjscad.org/#http://openjscad.org/examples/slices/tor.jscad</a></b>
* <b><a href="http://openjscad.org/#http://www.thingiverse.com/download:164128">http://openjscad.org/#http://www.thingiverse.com/download:164128</a></b> (STL)
* <b><a href="http://openjscad.org/#http://pastebin.com/raw.php?i=5RbzVguT">http://openjscad.org/#http://pastebin.com/raw.php?i=5RbzVguT</a></b> (SCAD)
* <b><a href="http://openjscad.org/#http://amf.wikispaces.com/file/view/Rook.amf/268219202/Rook.amf">http://openjscad.org/#http://amf.wikispaces.com/file/view/Rook.amf/268219202/Rook.amf</a></b> (AMF)

.JSCADを参照する場合、 <b>include()</b> は <u>サポートされません</u> (おそらくサポートは後ほどになります)。

## JSCADファイルの解剖学

OpenJSCADの.jscadファイルは、ライブラリやヘルパー（複数ファイル）でない限り、少なくとも１つの関数``main()``を定義する必要があります。その関数はCSGオブジェクトか交わらないCSGオブジェクトの配列を返す必要があります。
<pre>
function main() {
   return union(sphere(), ...);    // an union of objects or
   return [sphere(), ...];        // an array of non-intersecting objects
}
</pre>
また次のようにします：
<pre>
var w = new Array();
function a() {
   w.push( sphere() );
   w.push( cube().translate([2,0,0]) );
}
function main() {
   a();
   return w;
}
</pre>

しかし以下の例は**動作しません**：
<pre>
var w = new Array();
w.push( sphere() );                    // Note: it's not within a function (!!)
w.push( cube().translate([2,0,0]) );

function main() {
    return w;
}
</pre>
なぜなら、３Dプリミティブのような全てのCSG作成物は``main()``を結果的に通って呼ばれる関数内に現れなければならないからです。


## 3Dプリミティブ

パラメーターはオブジェクトとして渡されます：ほとんどのパラメータはオプションです。3Dベクトルは配列として渡されます。もしスカラー値が3Dベクトルを期待するパラメーターとして渡された場合、x,y,zの値として用いられます。言い換えると、radius: 1 はradius: [1, 1, 1] となります。

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/primitives.png">

すべての丸められたソリッドは'fn' すなわち '分解度'パラメーターを平面充填を制御するために持ちます。もし分解度が８に設定されると、周期の３６０度あたり８つのポリゴンが使われます。分解度を増やすとレンダリング時間が劇的に増加することに注意して下さい。球の場合、ポリゴン数は使用する分解度の二次関数的に増加します。もし分解度パラメーターが省略されると、CSG.defaultResolution2D と CSG.defaultResolution3Dという２つの大域デフォルト値が使われます：前者は2D曲線（円、円柱）で、後者は３D曲線（球、3D展開）です。

###立方体
<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/cube.png">

立方体やどちらかと言えば箱は以下の様に作成できます：
<pre>
cube();                            // openscad like
cube(1);
cube({size: 1});
cube({size: [1,2,3]});
cube({size: 1, center: true});     // default center:false
cube({size: 1, center: [true,true,false]}); // individual axis center true or false
cube({size: [1,2,3], round: true});

CSG.cube();                        // object-oriented
CSG.cube({
  center: [0, 0, 0],
  radius: [1, 1, 1]
});
CSG.roundedCube({                  // rounded cube
  center: [0, 0, 0],
  radius: 1,
  roundradius: 0.2,
  resolution: 8,
});
</pre>

###球
<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/sphere.png">

球は次のようにして作成できます：
<pre>
sphere();                          // openscad like
sphere(1);
sphere({r: 2});                    // Note: center:true is default (unlike other primitives, as OpenSCAD)
sphere({r: 2, center: false});     // Note: OpenSCAD doesn't support center for sphere but we do
sphere({r: 2, center: [true, true, false]}); // individual axis center 
sphere({r: 10, fn: 100 });
sphere({r: 10, fn: 100, type: 'geodesic'});  // geodesic approach (icosahedron further triangulated)

CSG.sphere();                      // object-oriented
CSG.sphere({
  center: [0, 0, 0],
  radius: 2,                      // must be scalar
  resolution: 32
});
</pre>
ここで fn は球を近似する断片の量です。（デフォルトは３２、球の総ポリゴン数は fn*fnです。）

``type: 'geodesic'``の場合、fnは非測地線のfnに適合させようとしますが、実際は６のステップ（例えば fn=6..11は同じ）で、fn = 1 ではベースとなる形の２０面体が明らかになります。

**注意:** 球を作成し（例えば union()やintersection()で）操作すると、使われる大量のポリゴンのため、レンダリングや構築処理が遅くなります。


###円柱

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/cylinder.png">

円柱と円錐は以下のようにして作成できます：
<pre>
cylinder({r: 1, h: 10});                 // openscad like
cylinder({r: 1, h: 10, center: true});   // default: center:false
cylinder({r: 1, h: 10, center: [true, true, false]});  // individual x,y,z center flags
cylinder({r: 1, h: 10, round: true});
cylinder({r1: 3, r2: 0, h: 10});
cylinder({start: [0,0,0], end: [0,0,10], r1: 1, r2: 2, fn: 50});

CSG.cylinder({                      // object-oriented
  start: [0, -1, 0],
  end: [0, 1, 0],
  radius: 1,                        // true cylinder
  resolution: 16
});
CSG.cylinder({
  start: [0, -1, 0],
  end: [0, 1, 0],
  radiusStart: 1,                   // start- and end radius defined, partial cones
  radiusEnd: 2,
  resolution: 16
});
CSG.roundedCylinder({               // and its rounded version
  start: [0, -1, 0],
  end: [0, 1, 0],
  radius: 1,
  resolution: 16
});
</pre>

ここで fn は円柱の丸い形を近似するための断片の量です（デフォルト３２）。

###トーラス

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/torus.png">

トーラスは以下の様に定義されます：
* ri = 内径 (デフォルト: 1), 
* ro = 外径 (デフォルト: 4), 
* fni = 内側の分解度 (デフォルト: 16), 
* fno = 外側の分解度 (デフォルト: 32), 
* roti = 内側の回転 (デフォルト: 0)

<pre>
torus();                    // ri = 1, ro = 4;  
torus({ ri: 1.5, ro: 3 });
torus{{ ri: 0.2 });

torus({ fni:4 });           // make inner circle fn = 4 => square
torus({ fni:4,roti:45 });   // rotate inner circle, so flat is top/bottom
torus({ fni:4,fno:4,roti:45 });
torus({ fni:4,fno:5,roti:45 });
</pre>

###多面体
多面体は点のリストと三角形やポリゴンのリストで作ります。点のリストは形の頂点全てで、三角形のリストは点が多面体の表面にどのように関連するかを定めます｡

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/polyhedron.png">

<pre>
polyhedron({      // openscad-like (e.g. pyramid)
  points: [ [10,10,0],[10,-10,0],[-10,-10,0],[-10,10,0], // the four points at base
            [0,0,10] ],                                  // the apex point 
  triangles: [ [0,1,4],[1,2,4],[2,3,4],[3,0,4],          // each triangle side
               [1,0,3],[2,1,3] ]                         // two triangles for square base
});
</pre>
さらに  `triangles:` だけではなく`polygons: [ [0,1,4,5], [..] ]` とも定義できます。

多面体はより低水準でオブジェクト指向的に作成できます：
<pre>
var polygons = [];
polygons.push(new CSG.Polygon([
      new CSG.Vertex(new CSG.Vector3D(x1,y1,z1)),
      new CSG.Vertex(new CSG.Vector3D(x2,y2,z2)),
      new CSG.Vertex(new CSG.Vector3D(x3,y3,z3))
   ])
);
// add more polygons and finally:
solid = CSG.fromPolygons(polygons);
</pre>

###テキスト

``vector_text(x,y,string)`` や ``vector_char(x,y,char)`` はベクトルでレンダリングされたテキストや文字の線分を与えます：

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/text.png">

<pre>
var l = vector_text(0,0,"Hello World!");   // l contains a list of polylines to be drawn
var o = [];
l.forEach(function(pl) {                   // pl = polyline (not closed)
   o.push(rectangular_extrude(pl, {w: 2, h: 2}));   // extrude it to 3D
});
return union(o);
</pre>

また"\n"を使った複数行もサポートされます。今の所左詰めのみサポートされています。もっと詳細を知りたいなら、単一の文字を要求することもできます：
<pre>
var c = vector_char(x,y,"A");
c.width;    // width of the vector font rendered character
c.segments; // array of segments / polylines
</pre>

## 3D変換

###スケール変換

<pre>
scale(2,obj);          // openscad like
scale([1,2,3],obj);    //      '' 

obj.scale([1,2,3]);    // object-oriented
</pre>

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/scale.png">

###回転
<pre>
rotate([90,15,30],obj);       // openscad like
rotate(90,[1,0.25,0.5],obj);  //    ''

obj.rotateX(90);              // object-oriented
obj.rotateY(45);
obj.rotateZ(30);
</pre>

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/rotate.png">

###移動
<pre>
translate([0,0,10],obj);  // openscad like

obj.translate([0,0,10]);  // object-oriented
</pre>

###センタリング
オブジェクトを全ての軸で、または軸単位でセンタリングするには：
<pre>
center(true,cube());                // openscad-like all axis
center([true,true,false],cube());   // openscad-like axis-wise [x,y,z]

cube().center(true);                // object oriented center all axis
cube().center([true,false,true]);   // object oriented center axis-wise [x,y,z]
</pre>

false = 何もしない、 true = 軸にセンタリング


center() や .center() は左右対称で構築時には完全にはサイズがわからない物体を構成するのに役に立ちます。例えばパラメータ化されたデザインでのように。


###行列操作
<pre>
var m = new CSG.Matrix4x4();
m = m.multiply(CSG.Matrix4x4.rotationX(40));
m = m.multiply(CSG.Matrix4x4.rotationZ(40));
m = m.multiply(CSG.Matrix4x4.translation([-.5, 0, 0]));
m = m.multiply(CSG.Matrix4x4.scaling([1.1, 1.2, 1.3]));

// and apply the transform:
var cube3 = cube.transform(m);
</pre>

###ミラーリング
<pre>
mirror([10,20,90], cube(1)); // openscad like

var cube = CSG.cube().translate([1,0,0]);   // object-oriented

var cube2 = cube.mirroredX(); // mirrored in the x=0 plane
var cube3 = cube.mirroredY(); // mirrored in the y=0 plane
var cube4 = cube.mirroredZ(); // mirrored in the z=0 plane

// create a plane by specifying 3 points:
var plane = CSG.Plane.fromPoints([5,0,0], [5, 1, 0], [3, 1, 7]);

// and mirror in that plane:
var cube5 = cube.mirrored(plane);
</pre>

###和集合

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/union.png">

<pre>
union(sphere({r: 1, center:true}),cube({size: 1.5, center:true}));  // openscad like
</pre>
複数のオブジェクトの和を取ることができます。配列も可能です。
<pre>
sphere({r: 1, center:true}).union(cube({size: 1.5, center:true}));  // object-oriented
</pre>

###積集合

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/intersection.png">

<pre>
intersection(sphere({r: 1, center:true}),cube({size: 1.5, center:true})); // openscad like
</pre>
複数のオブジェクトの積を取ることができます。配列も可能です。
<pre>
sphere({r: 1, center:true}).intersect(cube({size: 1.5, center:true}));   // object-oriented
</pre>
**注意:** intersection() (openscad と同様) と intersect() との対比(メソッド、オブジェクト指向)

###差分 (減算)

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/difference.png">

<pre>
difference(sphere({r: 1, center:true}),cube({size: 1.5, center:true}));    // openscad like
</pre>
複数のオブジェクトの差分（減算）を取ることができます。配列も可能です。
<pre>
sphere({r: 1, center:true}).subtract(cube({size: 1.5, center:true}));      // object-oriented
</pre>
**注意:** difference() (openscad と同様) と substract() との対比(メソッド、オブジェクト指向)

## 2Dプリミティブ

###円

<pre>
circle();                        // openscad like
circle(1); 
circle({r: 2, fn:5});
circle({r: 3, center: true});    // center: false (default)

CAG.circle({center: [0,0], radius: 3, resolution: 32});   // object-oriented
</pre>

###正方形 / 長方形
<pre>
square();                                   // openscad like
square(1);                                  // 1x1
square([2,3]);                              // 2x3
square({size: [2,4], center: true});        // 2x4, center: false (default)

CAG.rectangle({center: [0,0], radius: [w/2, h/2]});   // object-oriented, whereas w or h = side-length of square
CAG.roundedRectangle({center: [0,0], radius: [w/2, h/2], roundradius: 1, resolution: 4});
</pre>

### ポリゴン

<pre>
polygon([ [0,0],[3,0],[3,3] ]);                // openscad like
polygon({ points: [ [0,0],[3,0],[3,3] ] });                    
polygon({ points: [ [0,0],[3,0],[3,3],[0,6] ], paths: [ [0,1,2],[1,2,3] ] }); // multiple paths not yet implemented

var shape1 = CAG.fromPoints([ [0,0],[5,0],[3,5],[0,5] ]);    // object-oriented
</pre>

## 2D変換

<pre>
translate([2,2], circle(1));      // openscad like
rotate([0,0,90], square());       //     ''
shape = center(true, shape());    // center both axis
shape = center([true,false], shape()); // center axis-wise [x,y] 

shape = shape.translate([-2, -2]);   // object-oriented
shape = shape.rotateZ(20);
shape = shape.scale([0.7, 0.9]);
shape = shape.center(true);          // center both axis
scape = shape.center([true,false]);  // center axis-wise [x,y]
</pre>

## 2Dパス

パスとは単なる点の列で、直線で結合されているものです。パスは開放することも、閉じる（追加の直線が最初と最後の点の間に描かれます）こともできます。2DパスはCSG.Path2Dクラスを通してサポートされます。2Dパスと2D CAGとの違いは、パスが「細い」直線なのに対し、CAGは囲まれた領域であることです。

パスは2D座標の列を与えたり、CSG.Path2D.arc()関数を通じたりして構築できます。後者は環状のカーブしたパスを構築します。パスは結合でき、結果は新しいパスになります。

パスをCAGに変換するには２つの方法があります：
* expandToCAG(pathradius, resolution) は円でパスを追跡します。結果、パスの線分は太くなります。
* innerToCAG() はパスで囲まれたCAGを作成します。パスは閉じたパスでなけばいけません。

3Dソリッドの作成は現状、rectangularExtrude()関数でサポートされます。この関数は2D長方形で（直立しパスの方向に垂直に）パスをなぞって3Dのシェイプを作成します。
<pre>
var path = new CSG.Path2D([ [10,10], [-10,10] ], /* closed = */ false);
var anotherpath = new CSG.Path2D([ [-10,-10] ]);
path = path.concat(anotherpath);
path = path.appendPoint([10,-10]);
path = path.close(); // close the path

// of course we could simply have done:
// var path = new CSG.Path2D([ [10,10], [-10,10], [-10,-10], [10,-10] ], /* closed = */ true);

// We can make arcs and circles:
var curvedpath = CSG.Path2D.arc({
  center: [0,0,0],
  radius: 10,
  startangle: 0,
  endangle: 180,
  resolution: 16,
});
</pre>


## 凸包

複数の２Dポリゴン（例えば circle()やsquare()、polygon()）を合わせて凸包にすることができます：


<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/hull.png">

<pre>
var h = hull( square(10),circle(10).translate([10,10,0]) );

linear_extrude({ height: 10 }, h);
</pre>

## 連鎖凸包

連鎖した凸包とは、複数の２Dの形の上の凸包の変種です。本質的に順次凸包にして、それらの和集合を取ります。<a href="https://plus.google.com/u/0/105535247347788377245/posts/aZGXKFX1ACN">Whosa whatsis</a>のアイデアにもとづきます:

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/chain_hull.png">

<pre>
chain_hull( 
    circle(), circle().translate([2,0,0]), ... );   // list of CAG/2D forms

var a = [];
a.push(circle()); 
chain_hull( a );                       // array of CAG/2D forms

chain_hull({closed: true},             // default is false
   circle(),circle().translate([2,0,0]),circle().translate([2,2,0]));
</pre>

## 押し出し（Extruding / Extrusion）

### 線形押し出し
高さ、ねじり(twist)（角度）、スライス（ねじるなら）を与え、2Dの形状を3Dに押し出します：

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/linear_extrude.png">

<pre>
// openscad like
linear_extrude({ height: 10 }, square());
linear_extrude({ height: 10, twist: 90 }, square([1,2]));
linear_extrude({ height: 10, twist: 360, slices: 50}, circle().translate([1,0,0]) );

linear_extrude({ height: 10, center: true, twist: 360, slices: 50}, translate([2,0,0], square([1,2])) );
linear_extrude({ height: 10, center: true, twist: 360, slices: 50}, square([1,2]).translate([2,0,0]) );
</pre>

2D形状の線形押し出しにはオプションでねじりを指定できます。2D形状はz=0平面上に配置され、CSG.Vector3Dの&lt;offset&gt; 方向に押し出されます。最終の表面は&lt;twistangle&gt;度だけ回転します。回転は2D形状の原点(つまりx=0, y=0)周りになされ、twiststepはねじり（１以上でなければならない）の分解度を決定します。CSGオブジェクトを返します。
<pre>
// object-oriented
var c = CAG.circle({radius: 3});
extruded = c.extrude({offset: [0,0,10], twistangle: 360, twiststeps: 100});
</pre>

### 長方形押し出し
パスを（直立で、パスの方向に垂直に）長方形でたどり押し出し、CSGソリッドを返します。

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/rectangular_extrude.png">

rectangular_extrude()を使うと単純化されます（OpenSCADはこれを提供していないがopenscadと同様）。ここで
* w: 幅 (デフォルト: 1), 
* h: 高さ (デフォルト: 1), 
* fn: 分解度 (デフォルト: 8)
* closed: パスが閉じているか (デフォルト: false)

<pre>
rectangular_extrude([ [10,10], [-10,10], [-20,0], [-10,-10], [10,-10] ],  // path is an array of 2d coords
    {w: 1, h: 3, closed: true});
</pre>

あるいはより低水準でオブジェクト指向的なrectangularExtrude()も使えます。次の無名の変数を与えます。
1. z=0平面での押し出しの幅
2. z方向に押し出す高さ
3. 分解度、つまり隅のカーブに対しての３６０度あたりの断片の数
4. roundEnds: 真ならポリゴンの末端は丸められます。そうでなければ真っ直ぐなままです。


<pre>
// first creating a 2D path, and then extrude it
var path = new CSG.Path2D([ [10,10], [-10,10], [-20,0], [-10,-10], [10,-10] ], /*closed=*/true);
var csg = path.rectangularExtrude(3, 4, 16, true);   // w, h, resolution, roundEnds
return csg;
</pre>

### 回転押し出し
さらに rotate_extrude() も利用可能です:

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/rotate_extrude.png">

<pre>
// openscad-like
rotate_extrude( translate([4,0,0], circle({r: 1, fn: 30, center: true}) ) );

// more object-oriented
rotate_extrude({fn:4}, square({size: [1,1], center: true}).translate([4,0,0]) );

rotate_extrude( polygon({points:[ [0,0],[2,1],[1,2],[1,3],[3,4],[0,5] ]}) );
rotate_extrude({fn:4}, polygon({points:[ [0,0],[2,1],[1,2],[1,3],[3,4],[0,5] ]}) );
</pre>

本質的に2Dポリゴン(円、正方形、ポリゴン）を押し出します。

## スライスからのソリッド

solidFromSlices() は数個のポリゴンからソリッドを作成することを可能にします。（例えば、三角形から正方形や任意の形への変換。）これらのポリゴンは変換中に移動や回転を使うのと同様に変換できます。

solidFromSlices() は CSG.Polygon インスタンスと静的メソッド CSG.fromSlices で定義されます。どちらのメソッドも与えられたオプションからソリッドを生成します。

* @parameter {Object} options ソリッドを生成するスライスを提供します。各スライスは３D空間の凸ポリゴンです。凸であるという制限の必要性はこれから評価される予定です。適切な結果のためスライスは同じ向きでなければいけません。つまりその法線間のなす角度は１８０度未満でなければいけません。
* numslices {Number} - 生成されるスライスの個数。２以上でなければいけません。最初と最後のスライスは底面と最上面として使われます。
* callback {Function} - 関数(t, sliceN)はスライスを生成します。２つの引数を受け取ります： t - [0..1]、 ここで０は底面に、１は最上面に対応します。 sliceN - [0..numslices-1] 現在のスライス数。 コールバックはCSG.Polygonの文脈で呼び出されます。したがってスライスは初期ポリゴンからそれを変換することで生成可能です。 "<a href="https://github.com/Spiritdude/OpenJSCAD.org/blob/master/examples/slices/tor.jscad">Tor (multi-color)</a>" の例を参照して下さい.
* loop {Boolean} - 真なら底面と最上面は生成されずソリッドはループになります。"<a href="https://github.com/Spiritdude/OpenJSCAD.org/blob/master/examples/slices/tor.jscad">Tor (multi-color)</a>" の例を再び参照して下さい。
 
<pre>
var csg = new CSG.Polygon.createFromPoints([ [0,1,0], ... ]).  // initial polygon
   solidFromSlices({
      numslices: num,              // amount of slices
      loop: true|false,            // final CSG is close by looping (start = end) like a torus
      callback: function(t,slice) {
         // t: 0..1
         // slice: 0 .. (numslices-1)
         return this.translate|rotate(...).setColor(..);
      }
   });
</pre>

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/from_slices.png">

<pre>
function main(params) {
    var sqrt3 = Math.sqrt(3) / 2;
    var radius = 10;

    var hex = CSG.Polygon.createFromPoints([
        [radius, 0, 0],
        [radius / 2, radius * sqrt3, 0],
        [-radius / 2, radius * sqrt3, 0],
        [-radius, 0, 0],
        [-radius / 2, -radius * sqrt3, 0],
        [radius / 2, -radius * sqrt3, 0]
    ]);

    var angle = 5;
    return hex.solidFromSlices({
      numslices: 720 / angle,
      callback: function(t, slice) {
         var coef = 1 - t * 0.8;
         return this.rotateZ(5 * slice).scale(coef).translate([radius * 4 * t, t * 15, 0]).rotate(
            [0,20,0],
            [-1, 0, 0],
            angle * slice
         );
      }
   });
}
</pre>
## 膨張と収縮
膨張はオブジェクトと球との３D畳み込みとみなすことができます。収縮はその逆です：ソリッドの外部領域は拡大され、これはその後ソリッドから減算されます。

膨張と収縮は、オブジェクトに滑らかな隅を持たせる非常に強力な手法です。例えば丸められた立方体は通常の立方体を膨張させることで生成可能です。

これらはコストのかかる操作であることに注意して下さい：球状体は元となるオブジェクトの全ての角と端を丸めて作られるので、ポリゴン数はすぐに増大します。膨張と収縮はしたがって単純な、カーブのないオブジェクトに対してのみ現実的です。

expand()や contract() は２つの引数をとります：第１は膨張・収縮の半径です；第２は省略可能で分解度（３６０度周期あたりの球面上のポリゴン数）です。

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/expand.png">

<pre>
expand(0.2, 8, difference(cube(2),translate([0.3,0.3,0.3], cube(2))));   // openscad like

var cube1 = CSG.cube({radius: 1.0});        // object-oriented
var cube2 = CSG.cube({radius: 1.0}).translate([-0.3, -0.3, -0.3]);
var csg = cube1.subtract(cube2);
var rounded = csg.expand(0.2, 8); 
</pre>

## プロパティー

ソリッドの'property'プロパティーはそのオブジェクトのメタ情報を格納するのに使うことができます。例えばソリッドの特定の興味のある点の座標などです。オブジェクトが変換（回転、スケール変換、移動など）された場合必ずプロパティーも変換されます。 そのためソリッドを何度変換してもプロパティーは興味のある同じ点を指し続けます。

プロパティーは任意の型を持つことができますが、'transform'メソッドをサポートするクラスのプロパティーしか実際に変換されません。これにはCSG.Vector3DやCSG.Plane、CSG.Connectorが含まれます。特にCSG.Connectorのプロパティー（下記参照）は非常に有用です：これはソリッドを別のソリッドに事前に決められた位置で現在の向きに関係なく取り付けるのに使用可能です。

他のソリッドのプロパティーとしてCSGソリッドを含ませることも可能です。これは例えばあるオブジェクトに適合するネジ穴を作成するために切り抜き円柱を定義するのに使えるでしょう。これらの'solid properties'はソリッドのオーナーと同じ変換を受けますが、union()のようなCSG操作の結果としては目に見えません。

他の種類のプロパティー（例えば文字列）は変換されたソリッドのプロパティーに含まれはしますが、オーナーソリッドが変換されてもその値はなんら変換されません。

全てのプリミティブソリッドはいくつかの事前定義されたプロパティーを持ちます。例えば球の中心点などです。（TODO: 文書化）

union()やsubtract()、intersect()といったCSG操作の結果作られるソリッドは元となるソリッド両者の併合されたプロパティーを持ちます。同名のプロパティーがあればそのうち１つのみしか保持されません。

<pre>
var cube = CSG.cube({radius: 1.0});
cube.properties.aCorner = new CSG.Vector3D([1, 1, 1]);
cube = cube.translate([5, 0, 0]);
cube = cube.scale(2);
// cube.properties.aCorner will now point to [12, 2, 2],
// which is still the same corner point 

// Properties can be stored in arrays; all properties in the array
// will be transformed if the solid is transformed:
cube.properties.otherCorners = [
  new CSG.Vector3D([-1, 1, 1]),
  new CSG.Vector3D([-1, -1, 1])
];

// and we can create sub-property objects; these must be of the 
// CSG.Properties class. All sub properties will be transformed with
// the solid:
cube.properties.myProperties = new CSG.Properties();
cube.properties.myProperties.someProperty = new CSG.Vector3D([-1, -1, -1]);
</pre>

## コネクター
CSG.Connectorクラスの目的は、２つのソリッドと互いに前もって決められた位置と方向で結合するのを容易にすることです。例えばサーボモーターを描いたCSGソリッドとサーボアームのソリッドがあるとしましょう：それぞれのコネクタープロパティーを定義することで、容易にサーボアームをサーボモーターに正しい位置（つまりモーター軸）と向き（つまり軸に垂直）で取り付けることができます。たとえ３D空間上の現在の位置と向きを知らなくても。

言い換えればコネクターは自在にオブジェクトを回転・移動することを、その位置と境界を追跡することなしに可能にします。そしてサードパーティーのライブラリーがそのソリッドにコネクターを公開すれば、ライブラリーの利用者は実際の寸法や形状を知る必要がなく、ただコネクターのプロパティーの名前さえ知っていればいいのです。

CSG.Connector には３つのプロパティーがあります：
<ul>
<li><b>point</b>: ３D空間上の結合点を定義するCSG.Vector3D
<li><b>axis</b>: 結合の方向ベクトルを定義するCSG.Vector3D (サーボモーターの例では軸の方向を指す）
<li><b>normal</b>: いずれかの軸に垂直なCSG.Vector3D 方向ベクトル； これは結合の「１２時」方向を定義する
</ul>

２つのコネクターを結合するとき、<b>point</b>プロパティーが同じになり、<b>axis</b>プロパティーが同じ向き（または mirrot == true なら反対向き）になり、<b>normal</b>ができるだけ適合するように、ソリッドは変換されます。

コネクターを結合するには２つの方法があります：
CSGソリッドの<b>connectTo()</b>関数が、２つのコネクターが結合された状態になるようにソリッドを変換します。
別の方法として、コネクターの<b>getTransformationTo()</b>メソッドを使って、コネクターを結合する変換行列を取得します。この方法は、同じ変換を複数のソリッドに適用する必要がある場合に使うことができます。

<pre>
var cube1 = CSG.cube({radius: 10});
var cube2 = CSG.cube({radius: 4});

// define a connector on the center of one face of cube1
// The connector's axis points outwards and its normal points
// towards the positive z axis:
cube1.properties.myConnector = new CSG.Connector([10, 0, 0], [1, 0, 0], [0, 0, 1]);

// define a similar connector for cube 2:
cube2.properties.myConnector = new CSG.Connector([0, -4, 0], [0, -1, 0], [0, 0, 1]);

// do some random transformations on cube 1:
cube1 = cube1.rotateX(30);
cube1 = cube1.translate([3.1, 2, 0]);

// Now attach cube2 to cube 1:
cube2 = cube2.connectTo(
  cube2.properties.myConnector, 
  cube1.properties.myConnector, 
  true,   // mirror 
  0       // normalrotation
);

// Or alternatively:
var matrix = cube2.properties.myConnector.getTransformationTo(
  cube1.properties.myConnector, 
  true,   // mirror 
  0       // normalrotation
);
cube2 = cube2.transform(matrix);

var result = cube2.union(cube1);
</pre>

## 境界と平面配置
getBound()関数を使ってオブジェクトのバウンディングボックスを取得できます。getBounds()は２つのCSG.Vector3Dからなる配列を返します。それぞれが最小のx,y,z座標と最大のx,y,z座標を示します。

lieFlat()はオブジェクトをz=0平面上に配置します。その際、z-高さが最小になり、z軸周りにセンタリングされるように処理されます。これはCNCミルで有用です：オブジェクトの一部を切削中の原材料の空間に変換するからです。または３Dプリンタでも同様です：最小の層数で印刷できるからです。lieFLat()の代わりにgetTransformationToFlatLying()関数も使えます。これは変換としてCSG.Matrix4x4を返します。

<pre>
var cube1 = CSG.cube({radius: 10});
var cube2 = CSG.cube({radius: 5});

// get the right bound of cube1 and the left bound of cube2:
var deltax = cube1.getBounds()[1].x - cube2.getBounds()[0].x;

// align cube2 so it touches cube1:
cube2  = cube2.translate([deltax, 0, 0]);

var cube3 = CSG.cube({radius: [100,120,10]});
// do some random transformations:
cube3 = cube3.rotateZ(31).rotateX(50).translate([30,50,20]);
// now place onto the z=0 plane:
cube3  = cube3.lieFlat();

// or instead we could have used:
var transformation = cube3.getTransformationToFlatLying();
cube3 = cube3.transform(transformation);

return cube3;
</pre>

## 雑多なこと

### 色

OpenSCADと同様に:
* <b>color([r,g,b], object, object2 ...)</b> e.g. color([1,1,0],sphere());
* <b>color([r,g,b], array)</b>
* <b>color([r,g,b,a], object, object2 ...)</b>
* <b>color([r,g,b,a], array)</b> 
* <b>color(name, object, object2 ...)</b> e.g. color('red',sphere());
* <b>color(name, a, object, object2 ...)</b> e.g. color('red',0.5, sphere());
* <b>color(name, array)</b>
* <b>color(name, a, array)</b> 

ここで名前付きの色は大文字小文字を区別しません。 ('RED'=='red')

オブジェクト指向的には：
* <b>.setColor([r,g,b]);</b>
* <b>.setColor([r,g,b,a]);</b>
* <b>.setColor(r,g,b);</b>
* <b>.setColor(r,g,b,a);</b>

例:
<pre>
color([1,0.5,0.3],sphere(1));                      // openscad like
color([1,0.5,0.3],sphere(1),cube(2));
color("Red",sphere(),cube().translate([2,0,0]));   // named color (case-insensitive)

sphere().setColor(1,0.5,0.3);                      // object-oriented
sphere().setColor([1,0.5,0.3]);   
</pre>

色調で並べられた全ての利用可能な色名については<a href="http://en.wikipedia.org/wiki/Web_colors">Wikipedia: Web Colors</a> を参照して下さい。

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/colors.png">

コード抜粋:
<pre>
o.push( color([1,0,0],sphere()) );
o.push( color([0,1,0],cube()) );
o.push( color([0,0,1],cylinder()) );

o.push( color("red",sphere()) );
o.push( color("green", cube()) );
o.push( color("blue", cylinder()) );

for(var i=0; i&lt;1; i+=1/12) {
   o.push( cube().setColor(hsl2rgb(i,1,0.5)) );
}
</pre>

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/transparency.png">

コード:
<pre>
function main() {
   var o = [];
   for(var i=0; i&lt;8; i++) {
      o.push(cylinder({r:3,h:20}).
         setColor(
            hsl2rgb(i/8,1,0.5).  // hsl to rgb, creating rainbow [r,g,b]
            concat(1/8+i/8)      // and add to alpha to make it [r,g,b,a]
         ).translate([(i-3)*7.5,0,0])
      );
   }
   o.push(color("red",cube(5)).translate([-4,-10,0]));
   o.push(color("red",0.5,cube(5)).translate([4,-10,0]));
   return o;
}
</pre>

*注意:* <a href="http://www.opengl.org/wiki/Transparency_Sorting">OpenGLの透過色の制限</a>があります。例えば順番次第で、部分的に透明なオブジェクトが透過して見えないかもしれません。

####色空間の変換
次の関数で色空間を変換できます：
<pre>
var hsl = rgb2hsl(r,g,b); // or rgb2hsl([r,g,b]);
var rgb = hsl2rgb(h,s,l); // or hsl2rgb([h,s,l]);
var hsv = rgb2hsv(r,g,b); // or rgb2hsv([r,g,b]);
var rgb = hsv2rgb(h,s,v); // or hsv2rgb([h,s,v]);
</pre>

ここで
* r,g,b (赤, 緑, 青)
* h,s,l (色調, 彩度, 明度)
* h,s,v (色調, 彩度, 値)

例えば、虹を作成するには、t=0..1で.setColor(hsl2rgb(t,1,0.5)) とします。

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/illu/multicolor.png">

<a href="http://openjscad.org/#examples/slices/tor.jscad">Tor (multi-color)</a>の例を直接参照して下さい。.

### エコー
<pre>
a = 1, b = 2;
echo("a="+a,"b="+b);
</pre>
はJavaScriptコンソールに以下を出力します。
<pre>
a=1, b=2
</pre>


## 数学関数
次のOpenSCAD互換関数が利用可能です。JavaScriptのMath.xyz()は脇へ置いておきます。
<pre>
sin(a);                   // a = 0..360
cos(a);                   //     ''
asin(a);                  // a = 0..1, returns 0..360
acos(a);                  //       ''
tan(a);                   // a = 0..360
atan(a);                  // a = 0..1, returns 0..360
atan2(a,b);               // returns 0..360
ceil(a);
floor(a);
abs(a);
min(a,b);
max(a,b);
rands(min,max,vn,seed);   // returns random vectors of vn dimension, seed not yet implemented
log(a);
lookup(ix,v);             // ix = index, e.g. v = [ [0,100], [10,10], [20,200] ] whereas v[x][0] = index, v[x][1] = value
                          //    return will be linear interpolated (e.g. lookup(5,[ [0,100], [10,10], [20,200] ]) == 45

pow(a,b);
sign(a);                  // -1, 0 or 1
sqrt(a);
round(a);
</pre>

## OpenSCADソースの直接取込

OpenSCAD (.scad)翻訳器・取り込み器がOpenJSCADには含まれます。次の機能はまだ動きません：
* DXF の取込と操作 (例 import_dxf, dxf-cross, dxf_dim functions)
* rotate_extrude() (<b>注意:</b> OpenJSCAD は rotate_extrude() をサポートします)
* minkowski() と hull() 変換 (<b>注意:</b> OpenJSCAD は hull() をサポートします)
* $fa, $fs 大域変数
* 修飾文字: #, !, %

OpenSCADのソースを組み込みエディターで編集できますが、１行目を次のようにしてください：
<pre>
//!OpenSCAD
</pre>
そうするとソースコードはOpenSCAD文法と認識されます。

更なるCAD言語のサポートは後でやってくるかもしれません。

## OpenSCAD から OpenJSCAD への変換

OpenSCAD .scad をネイティブのOpenJSCADコードに変換するためにはこの対比表を考慮に入れて下さい：
<table><tr><td width=50% valign=top>
<b>OpenSCAD (.scad)</b>
<pre>
union() {
      //cube(size=[30,30,0.1],center=true);
      translate([3,0,0]) cube();
      difference() {
         rotate([0,-45,0]) cube(size=[8,7,3],center=true);
         sphere(r=3,$fn=20,center=true);
      }
      translate([10,5,5]) scale([0.5,1,2]) sphere(r=5,$fn=50);
      translate([-15,0,0]) cylinder(r1=2,r2=0,h=10,$fn=20);
     
   for(i=[0:19]) {
      rotate([0,i/20*360,0]) 
      translate([i,0,0]) 
      rotate([0,i/20*90,i/20*90,0]) 
      cube(size=[1,1.2,.5],center=true);
   }
}
</pre>
</td><td valign=top>
<b>OpenJSCAD (.jscad)</b>
<pre>
function main() {  
   var cubes = new Array();
   for(i=0; i&lt;20; i++) {
      cubes[i] = rotate([0,i/20*360,0], 
         translate([i,0,0], 
         rotate([0,i/20*90,i/20*90,0], 
         cube({size:[1,1.2,.5],center:true}))));
   }
   return union(
      //cube({size:[30,30,0.1],center:true}),
      translate([3,0,0],cube()),
      difference(
         rotate([0,-45,0], cube({size:[8,7,3],center:true})),
         sphere({r:3,fn:20,center:true})
      ),
      translate([10,5,5], scale([0.5,1,2], sphere({r:5,fn:50}))),
      translate([-15,0,0], cylinder({r1:2,r2:0,h:10,fn:20})),
      cubes
   );
}
</pre>
</td></tr></table>

本質的に.scadの名前付き引数がfunc(a=1)のような場合は必ず func({a:1}) に変換して下さい。例えば、

* .scad: ``translate([0,0,2]) sphere(size=2,$fn=50);``
* .jscad (1): ``translate([0,0,2], sphere({size:2,fn:50}));``
* .jscad (2): ``sphere({size:2,fn:50}).translate([0,0,2]);``

## 対話的パラメータ化モデル

あるパラメータをブラウザー上で編集可能にすることができます。これはJavaScriptに馴染みのない利用者に、カスタマイズされたSTLファイルを生成できるようにしてくれます。

そうするためには、getParameterDefinitions()関数を.jscadソースに追加して下さい。この関数はパラメーター定義をもった配列を返します。現在４つのパラメーター型がサポートされています：float, int, text, choiceです。利用者が編集したパラメーターの値は.jscaddファイルのmain()関数へのオブジェクト引数として渡されます。

floatやint、textのパラメーターを作成するには、getParameterDefinitions()が返す配列の次のオブジェクトを含めます：

<pre>
{
  name: 'width',
  type: 'float',                      // or 'text' or 'int'
  initial: 1.23,                      // optional, sets the initial value
                                      // NOTE: parameter "default" is deprecated
  caption: 'Width of the thingy:',    // optional, displayed left of the input field
                                      // if omitted, the 'name' is displayed (i.e. 'width')
}
</pre>
'choce'パラメーターを作成するには次のオブジェクトを使います：
<pre>
{
  name: 'shape',
  type: 'choice',
  values: ["TRI", "SQU", "CIR"],               // these are the values that will be supplied to your script
  captions: ["Triangle", "Square", "Circle"],  // optional, these values are shown in the listbox
                                               // if omitted, the items in the 'values' array are used
  caption: 'Shape:',                           // optional, displayed left of the input field
  initial: "SQU",                              // optional, default selected value
                                               // if omitted, the first item is selected by default
                                               // NOTE: parameter "default" is deprecated
}
</pre>
値を用いるためには、main()関数の引数を追加して下さい。この引数は利用者が編集したパラメーターの値をもつオブジェクトを提供します。
<pre>
function main(params) {
  // custom error checking:
  if(params.width &lt;= 0) throw new Error("Width should be positive!");
  
  if(params.shape == "TRI") {
    // do something
  }
}
</pre>
完全な例：
<pre>
function getParameterDefinitions() {
  return [
    { name: 'width', type: 'float', initial: 10, caption: "Width of the cube:" },
    { name: 'height', type: 'float', initial: 14, caption: "Height of the cube:" },
    { name: 'depth', type: 'float', initial: 7, caption: "Depth of the cube:" },
    { name: 'rounded', type: 'choice', caption: 'Round the corners?', values: [0, 1], captions: ["No thanks", "Yes please"], initial: 1 }
  ];
}

function main(params) {
  var result;
  if(params.rounded == 1) {
    result = CSG.roundedCube({radius: [params.width, params.height, params.depth], roundradius: 2, resolution: 32});
  } else {
    result = CSG.cube({radius: [params.width, params.height, params.depth]});
  }
  return result;
}
</pre>

または<a href="https://github.com/Spiritdude/OpenJSCAD.org/blob/master/examples/example032.jscad">example032.jscad</a> (ギヤーの例)を参照下さい。対話的パラメーターの別の例としては:

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/sshot-03-illu.png" width=600>

###コマンドラインインタフェース (CLI) & パラメーター

``openjscad`` は対話的パラメータのための引数を受け付けます：
* --<i>key</i> <i>value</i> (e.g. <b>--thickness 3</b>) 
* --<i>key</i>=<i>value</i> (e.g. <b>--thickness=3</b>)


例:
<pre>
% openjscad name_plate.jscad --name "Just Me" --title "Geek" -o JustMe.amf
% openjscad name_plate.jscad "--name=Just Me" "--title=Geek" -o JustMe.amf
</pre>

## 直交基底

直交基底を使って3Dの点を3D平面に射影することで2Dの点に変換できます。直交基底は与えられた平面から構成されます。省略可能ですが、「右手」ベクトルが指定できます。これは２次元平面のx軸になります。

CSG.OrthoNormalBasis.Z0Plane() はz=0平面上の直交基底を作成します。これは(xx,yy,zz)の３D座標を2Dの(xx,yy)座標に変換するか、または逆に(xx,yy)から(xx,yy,0)に変換します。

to２D()やline3Dto2D()は３D空間から２D平面に変換します。to3D()やline2Dto3D()を使えば逆向きに変換できます。


getProjectionMatrix() は直交基底に変換する射影行列を与えます。getInverseProjectionMatrix() は直交基底へ逆変換する行列を与えます。

<pre>
// construct a plane:
var plane = CSG.Plane.fromNormalAndPoint([1,1,0], [0,0,1]);
var orthobasis = new CSG.OrthoNormalBasis(plane);
// or if we would like a specific right hand vector: 
// var orthobasis = new CSG.OrthoNormalBasis(plane, [0,0,1]);

var point3d = new CSG.Vector3D(1,5,7);
var point2d = orthobasis.to2D(point3d);
var projected = orthobasis.to3D(point2d);
</pre>

## 2D & 3D数学

多くの2Dと3Dの操作のためにユーティリティクラスがあります。以下は手早いまとめです。詳細はcsg.jsのソースを見て下さい：

### Vector3D
<pre>
var vec1 = new CSG.Vector3D(1,2,3);       // 3 arguments
var vec2 = new CSG.Vector3D( [1,2,3] );   // 1 array argument
var vec3 = new CSG.Vector3D(vec2);        // cloning a vector
// get the values as: vec1.x, vec.y, vec1.z
// vector math. All operations return a new vector, the original is unmodified!
// vectors cannot be modified. Instead you should create a new vector.
vec.negated()
vec.abs()
vec.plus(othervector)
vec.minus(othervector)
vec.times(3.0)
vec.dividedBy(-5)
vec.dot(othervector)
vec.lerp(othervector, t)  // linear interpolation (0 &lt;= t &lt;= 1)
vec.length()
vec.lengthSquared()       // == vec.length()^2
vec.unit()
vec.cross(othervector)    // cross product: returns a vector perpendicular to both
vec.distanceTo(othervector)
vec.distanceToSquared(othervector)  // == vec.distanceTo(othervector)^2
vec.equals(othervector)
vec.multiply4x4(matrix4x4)   // right multiply by a 4x4 matrix
vec.min(othervector)        // returns a new vector with the minimum x,y and z values
vec.max(othervector)        // returns a new vector with the maximum x,y and z values
</pre>

### Vector2D
<pre>
var vec1 = new CSG.Vector2D(1,2);       // 2 arguments
var vec2 = new CSG.Vector2D( [1,2] );   // 1 array argument
var vec3 = new CSG.Vector2D(vec2);      // cloning a vector
// vector math. All operations return a new vector, the original is unmodified!
vec.negated()
vec.abs()
vec.plus(othervector)
vec.minus(othervector)
vec.times(3.0)
vec.dividedBy(-5)
vec.dot(othervector)
vec.lerp(othervector, t)  // linear interpolation (0 &lt;= t &lt;= 1)
vec.length()
vec.lengthSquared()       // == vec.length()^2
vec.unit()
vec.normal()              // returns a 90 degree clockwise rotated vector
vec.distanceTo(othervector)
vec.distanceToSquared(othervector)  // == vec.distanceTo(othervector)^2
vec.cross(othervector)    // 2D cross product: returns a scalar
vec.equals(othervector)
vec.min(othervector)        // returns a new vector with the minimum x and y values
vec.max(othervector)        // returns a new vector with the maximum x and y values
vec.multiply4x4(matrix4x4)   // right multiply by a 4x4 matrix
vec.toVector3D(z)         // convert to a vector3D by adding a z coordinate
vec.angleDegrees()        // returns the angle of the vector: [1,0] = 0 degrees, [0, 1] = 90 degrees, etc
vec.angleRadians()        // ditto in radians
var vec = CSG.Vector2D.fromAngleDegrees(degrees);  // returns a vector at the specified angle
var vec = CSG.Vector2D.fromAngleRadians(radians);  // returns a vector at the specified angle
</pre>

### Matrix4x4
<pre>
var m1 = new CSG.Matrix4x4();          // unity matrix
var m2 = new CSG.Matrix4x4( [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1] );
  // elements are passed in row order
var result = m1.plus(m2); 
var result = m1.minus(m2);
var result = m1.multiply(m2);
// matrix vector multiplication (vectors are padded with zeroes to get a 4x1 vector):
var vec3d = m1.rightMultiply1x3Vector(vec3d);  // matrix * vector 
var vec3d = m1.leftMultiply1x3Vector(vec3d);   // vector * matrix
var vec2d = m1.rightMultiply1x2Vector(vec2d);  // matrix * vector 
var vec2d = m1.leftMultiply1x2Vector(vec2d);   // vector * matrix
// common transformation matrices:
var m = CSG.Matrix4x4.rotationX(degrees);      // matrix for rotation about X axis
var m = CSG.Matrix4x4.rotationY(degrees);      // matrix for rotation about Y axis
var m = CSG.Matrix4x4.rotationZ(degrees);      // matrix for rotation about Z axis
var m = CSG.Matrix4x4.rotation(rotationCenter, rotationAxis, degrees); // rotation about arbitrary point and axis
var m = CSG.Matrix4x4.translation(vec3d);      // translation
var m = CSG.Matrix4x4.scaling(vec3d);          // scale
var m = CSG.Matrix4x4.mirroring(plane);        // mirroring in a plane; the argument must be a CSG.Plane
// matrix transformations can be concatenated:
var transform = CSG.Matrix4x4.rotationX(20).multiply(CSG.Matrix4x4.rotationY(30));
// Use a CSG solid's transform() method to apply the transformation to a CSG solid
</pre>

### Plane
3D平面は法線ベクトル（単位長であるべき）と原点からの距離wで表現されます。平面はnormal.times(w)を貫通します。
<pre>
var plane1 = new CSG.Plane(normal, w);         
// Or we can construct a plane from 3 points:
var plane2 = CSG.Plane.fromPoints(p1, p2, p3);
// Or from a normal vector and 1 point:
var plane3 = CSG.Plane.fromNormalAndPoint(normal, point);
// Flip a plane (front side becomes back side):
var plane4 = plane3.flipped();
// Apply transformations (rotation, scaling, translation):
var transformed = plane3.transformed(matrix4x4);  // argument is a CSG.Matrix4x4
// Intersection of plane and 3d line:
var point = plane3.intersectWithLine(line);        // argument is CSG.Line3D, returns a CSG.Vector3D
// Intersection of 2 planes:
var line = plane3.intersectWithPlane(plane);       // argument is another CSG.Plane, returns a CSG.Line3D
// Distance to point:
var w = signedDistanceToPoint(point);             // argument is CSG.Vector3D, returns a float (positive
                                                  //    if in front of plane, negative if in back)
</pre>
### Line3D
3D空間上の直線は点と方向ベクトルで表現されます。方向は単位ベクトルであるべきです。点は直線上の任意の点です。
<pre>
var line = new CSG.Line3D(point, direction);      // argumenst are CSG.Vector3D
// or by giving two points:
var line = CSG.Line3D.fromPoints(p1, p2);         // argumenst are CSG.Vector3D
var point = intersectWithPlane(plane);            // == plane.intersectWithLine(this)
var line2 = line.reverse();                       // same line but reverse direction
var line2 = line.transform(matrix4x4);            // for rotation, scaling, etc
var p = line.closestPointOnLine(point);           // project point onto the line
var d = line.distanceToPoint(point);
</pre>

### Line2D
2D空間上の直線は法線ベクトルと、法線ベクトルに沿って原点からの距離wで表されます。または点と方向ベクトルで表されます。方向は単位ベクトルであるべきです。点は直線上の任意の点です。
<pre>
var line = new CSG.Line2D(CSG.Line2D(normal,w));
// or by giving two points:
var line = CSG.Line2D.fromPoints(p1, p2);         // argumenst are CSG.Vector2D
var line2 = line.reverse();                       // same line but reverse direction
var line2 = line.transform(matrix4x4);            // for rotation, scaling, etc
var point = line.origin();                        // returns the point closest to the origin
var dir = line.direction();                       // direction vector (CSG.Vector2D)
var x = line.xAtY(y);                             // returns the x coordinate of the line at given y coordinate
var d = absDistanceToPoint(point);                // returns the absolute distance between a point and the line
var p = line.closestPoint(point);                 // projection of point onto the line
var point = line.intersectWithLine(line2);        // intersection of two lines, returns CSG.Vector2D
</pre>

##ファイルのインクルード

**include()** は他のJSCADファイルをインクルードを（再帰的にも）許します。例えば
<pre>
// main.jscad

include("lib.jscad");

function main() {
   return myLib.b(2);
}
</pre>
と
<pre>
// lib.jscad

myLib = function() {
   var a = function(n) {  // internal 
      return n*2;  
   }
   myLib.b = function(n) {      // public 
      return sphere(a(n));  
   }
}
</pre>
のようにです。

include()の再帰的用法については<a href="https://github.com/Spiritdude/OpenJSCAD.org/tree/master/examples/example050">Example 50: Platonics</a>も参照して下さい;しかし関数名をローカルにしないのはむしろ悪い例です。明瞭な記述スタイルガイドはOpenJSCADライブラリーのあるべき見た目に従うでしょう。

##include()のサポート

**include()** は以下の場合サポートされます
* **web-online remote** (e.g. http://openjscad.org/): ファイルがドラッグアンドドロップされた場合、またはWEBサーバー上で利用可能な場合(例 the examples)
* **web-online local** (e.g. http://localhost/OpenJSCAD/): ファイルがドラッグアンドドロップされた場合、またはローカルWEBサーバー上で利用可能な場合
* **web-offline local** (e.g. file://..../OpenJSCAD/index.html): ファイルがドラッグアンドドロップされた場合
* **command-line interface** (CLI): ファイルシステム上でローカルに利用可能な場合

ドラッグアンドドロップされたファイルのセットアップの例：

<img src="https://raw.github.com/Spiritdude/OpenJSCAD.org/master/doc/sshot-06-illu.png" width=600>

##JSCADファイルのレイアウト
大規模なOpenJSCADプロジェクトを作成したいとして、**include()**を使って機能別に分割することができます。
<pre>
ProjectName/
   main.jscad          # this one contains the "function main()", this file will be <b>executed</b>
   addon.jscad         # this file could be include("addon.jscad") in main.jscad
   optimizer.jscad     #             ''     include("optimizer.jscad") in main.jscad or also in addon.jscad 
   Makefile            # possible Makefile to do the same on CLI                  
</pre>

**注意:** **main.jscad** はデフォルトファイルなので実行されますが、"function main()" 宣言を含む必要があります。

##複数の JSCAD ファイルの開発

ブラウザーとローカルのセットアップ次第ですが、以下が適用されます：

* **Chrome (Version 26+)**:
 * Online (http://...): フォルダー全体、例えば ProjectName/ をドラッグアンドドロップ領域にドラッグアンドドロップする
 * Offline (file://...): 全jscadファイル（フォルダーではなく）をドラッグアンドドロップ領域にドラッグアンドドロップする
* **Firefox (Version 19+)**: プロジェクトの全jscadファイルをドラッグアンドドロップ領域にドラッグアンドドロップする
* **Opera**: まだ機能しない (WebGLのサポートがまだ利用可能でない)
* **IE10**: まだ機能しない (WebGLのサポートがまだ利用可能でない)

##補遺
* [OpenJsCad Documentation](http://joostn.github.com/OpenJsCad/), オブジェクト指向のみの取り組み、そこからの情報はほとんどここにも含まれています。


<br><br><br><br>
<div align=center>-- End of User Guide --</div>
