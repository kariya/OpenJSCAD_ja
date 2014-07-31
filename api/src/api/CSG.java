package api;


/**
 *EN Holds a binary space partition tree representing a 3D solid.
 *EN Two solids can be combined using the `union()`, `subtract()`, and `intersect()` methods.
 *JP 3Dソリッドを表現する２分空間分割木を保持する。
 *JP ２つのソリッドは`union()`や`subtract()`、`intersect()`メソッドで結合できる。
 */
public abstract class CSG extends AddTransformationMethodsToPrototype {
	public CSG() {}

	public Polygon[] polygons;
	public Properties properties ;
	public boolean isCanonicalized ;
	public boolean isRetesselated;

	public static int defaultResolution2D;
	public static int defaultResolution3D;

	/**
	 *EN Construct a CSG solid from a list of `CSG.Polygon` instances.
	 *JP  `CSG.Polygon`インスタンスのリストからCSGソリッドを構成する。
	 */
	public static CSG fromPolygons(Polygon[] polygons) {return null;}
	/**
	 *EN Construct a CSG solid from generated slices.
	 *EN Look at CSG.Polygon.prototype.solidFromSlices for details
	 *JP 生成されたスライスからCSGソリッドを構成する。
	 *JP 詳細はCSG.Polygon.prototype.solidFromSlicesを参照。
	 */
	public static CSG fromSlices(Object options) {return null;}
	/**
	 *EN create from an untyped object with identical property names:
	 *JP 同一のプロパティ名を持つ型付けされていないオブジェクトから作成する
	 */
	public static CSG fromObject(Object obj) {return null;}
	/**
	 *EN Reconstruct a CSG from the output of toCompactBinary()
	 *JP toCompactBinary()の出力からCSGを再構成する。
	 */
	public static CSG fromCompactBinary(Object bin) {return null;}

	public Polygon[] toPolygons() {return null;}
	/**
	 *EN Return a new CSG solid representing space in either this solid or in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドまたはソリッド`csg`のどちらかに含まれる空間を表す新しいCSGソリッドを返す。
	 *JP 本ソリッドもソリッド`csg`も変更されない。
	 */
	public CSG union(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in either this solid or in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドまたはソリッド`csg`のどちらかに含まれる空間を表す新しいCSGソリッドを返す。
	 *JP 本ソリッドもソリッド`csg`も変更されない。
	 */
	public CSG union(CSG[] csgs) {return null;}
	public CSG unionSub(CSG csg, boolean retesselate, boolean canonicalize) {return null;}
	/**
	 *EN Like union, but when we know that the two solids are not intersecting
	 *EN Do not use if you are not completely sure that the solids do not intersect!
	 *JP union同様だが、２つのソリッドが交わらないことがわかっている場合。
	 *JP ソリッドが交わらないか完全にはわからないなら使わないこと。
	 */
	public CSG unionForNonIntersecting(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in this solid but not in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドに含まれるがソリッド`csg`には含まれない空間を表す新しいCSGソリッドを返す。
	 *JP 本ソリッドもソリッド`csg`も変更されない。
	 */
	public CSG subtract(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in this solid but not in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドに含まれるがソリッド`csg`には含まれない空間を表す新しいCSGソリッドを返す。
	 *JP 本ソリッドもソリッド`csg`も変更されない。
	 */
	public CSG subtract(CSG[] csgs) {return null;}
	public CSG subtractSub(CSG csg, boolean retesselate, boolean canonicalize) {return null;}
	/**
	 *EN Return a new CSG solid representing space both this solid and in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドにもソリッド`csg`にも含まれる空間を表す新しいCSGソリッドを返す。
	 *JP 本ソリッドもソリッド`csg`も変更されない。
	 */
	public CSG intersect(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space both this solid and in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドにもソリッド`csg`にも含まれる空間を表す新しいCSGソリッドを返す。
	 *JP 本ソリッドもソリッド`csg`も変更されない。
	 */
	public CSG intersect(CSG[] csg) {return null;}
	public CSG intersectSub(CSG csg, boolean retesselate, boolean canonicalize) {return null;}
	/**
	 *EN Return a new CSG solid with solid and empty space switched. This solid is
	 *EN not modified.
	 *JP ソリッドと空の空間を入れ替えた新しいCSGソリッドを返す。
	 *JP 本ソリッドは変更されない。
	 */
	public CSG inverse() {return null;}
	/**
	 *EN Affine transformation of CSG object. Returns a new CSG object
	 *JP CSGオブジェクトをアフィン変換する。あたらしいCSGオブジェクトを返す。
	 */
	public CSG transform1(Matrix4x4 matrix4x4) {return null;}
	public CSG transform(Matrix4x4 matrix4x4) {return null;}
	public String toStlString() {return null;}
	public String toAMFString() {return null;}

	public Object /*Blob*/ toX3D() {return null;}
	//public Object /*Blob*/ toStlBinary() {return null;}
	/**
	 *EN @see http://en.wikipedia.org/wiki/STL_%28file_format%29#Binary_STL
	 *JP @see http://en.wikipedia.org/wiki/STL_%28file_format%29#Binary_STL
	 */
	public String toStlBinary() {return null;}
	public String toString() {return null;}
	public CSG center(double c) {return null;}
	public CSG center(double[] pos) {return null;}
	/**
	 *EN Expand the solid
	 *EN @param resolution: number of points per 360 degree for the rounded corners
	 *JP ソリッドを膨張させる。
	 *JP @param resolution: 丸められた隅について３６０度あたりの点の数
	 */
	public CSG expand(double radius, int resolution) {return null;}
	/**
	 *EN Contract the solid
	 *EN @param resolution: number of points per 360 degree for the rounded corners
	 *JP ソリッドを収縮させる。
	 *JP @param resolution: 丸められた隅について３６０度あたりの点の数
	 */
	public CSG contract(double radius, int resolution) {return null;}
	/**
	 *EN Create the expanded shell of the solid:
	 *EN All faces are extruded to get a thickness of 2*radius
	 *EN Cylinders are constructed around every side
	 *EN Spheres are placed on every vertex
	 *EN @rama unionWithThis: if true, the resulting solid will be united with 'this' solid;
	 *EN the result is a true expansion of the solid
	 *EN If false, returns only the shell
	 *JP ソリッドの膨張された外殻を作成する：
	 *JP すべての面は2*radiusの厚さで押し出される
	 *JP 円柱は全ての側面まわりに構成される
	 *JP 球がすべての頂点に配置される
	 *JP @prama unionWithThis: 真なら結果のソリッドは本ソリッドと結合される：
	 *JP 結果はソリッドの本当の膨張になる
	 *JP 偽なら外殻のみが返される
	 */
	public CSG expandedShell(double radius, int resolution, boolean unionWithThis) {return null;}
	public CSG canonicalized() {return null;}
	public CSG reTesselated() {return null;}
	/**
	 *EN returns an array of two CSG.Vector3Ds (minimum coordinates and maximum coordinates)
	 *JP ２つのCSG.Vector3Dからなる配列を返す（最小座標と最大座標）
	 */
	public Vector3D[] getBounds() {return null;}
	/**
	 *EN returns true if there is a possibility that the two solids overlap
	 *EN returns false if we can be sure that they do not overlap
	 *JP ２つのソリッドが重なる可能性があれば真を返す
	 *JP 決して重ならないなら偽を返す
	 */
	public boolean mayOverlap(CSG csg) {return false;}
	/**
	 *EN Cut the solid by a plane. Returns the solid on the back side of the plane
	 *JP ソリッドを平面で切断する。平面の裏面のソリッドを返す。
	 */
	public CSG cutByPlane(Plane plane) {return null;}
	/**
	 *EN Connect a solid to another solid, such that two CSG.Connectors become connected
	 *EN @param myConnector: a CSG.Connector of this solid
	 *EN @param otherConnector: a CSG.Connector to which myConnector should be connected
	 *EN @param mirror: false: the 'axis' vectors of the connectors should point in the same direction
	 *EN         true: the 'axis' vectors of the connectors should point in opposite direction
	 *EN @param normalrotation: degrees of rotation between the 'normal' vectors of the two
	 *EN                 connectors
	 *JP ソリッドを別のソリッドと結合し、２つのCSG.Connectorが結合済みになるようにする
	 *JP @param myConnector: 本ソリッドのCSG.Connector
	 *JP @param otherConnector: myConnectorが結合される対象のCSG.Connector
	 *JP @param mirror: 偽ならコネクタの`軸`ベクトルは同じ向きを指す、真なら反対向きを指す。
	 *JP @param normalrotation: ２つのコネクタの`法線`ベクトル間の回転角度
	 */
	public CSG connectTo(Connector myConnector, Connector otherConnector, boolean mirror, int normalrotation) {return null;}
	/**
	 *EN set the .shared property of all polygons
	 *EN Returns a new CSG solid, the original is unmodified!
	 *JP 全てのポリゴンの.sharedプロパティーをセットする
	 *JP 新しいCSGソリッドを返し、元のソリッドは変更されない！
	 */
	public CSG setShared(Polygon.Shared shared) {return null;}
	/**
	 *EN @param {Array} color [red, green, blue] color values are float numbers 0..1
	 *EN @return {CSG} new CSG instance
	 *JP @param {Array} color [red, green, blue] 色の値は０から１の小数
	 *JP @return {CSG} 新しいCSGインスタンス
	 */
	public CSG setColor(double red, double green, double blue, double alpha) {return null;}
	public Object toCompactBinary() {return null;}
	/**
	 *EN For debugging
	 *EN Creates a new solid with a tiny cube at every vertex of the source solid
	 *JP デバッグ用
	 *JP 元のソリッドの各頂点に小さな立方体を配置した新しいソリッドを作成する
	 */
	public CSG toPointCloud(double cuberadius) {return null;}
	/**
	 *EN Get the transformation that transforms this CSG such that it is lying on the z=0 plane,
	 *EN as flat as possible (i.e. the least z-height).
	 *EN So that it is in an orientation suitable for CNC milling
	 *JP CGSをz=0平面に置いてできるだけ平らになる（z-高さが最小になる）ようにソリッドを変換する変換行列を得る。
	 *JP 結果、CNC切削に適した向きになる
	 */
	public Matrix4x4 getTransformationToFlatLying() {return null;}
	public CSG lieFlat() {return null;}
	public CAG projectToOrthoNormalBasis(OrthoNormalBasis orthobasis) {return null;}
	public CAG sectionCut(OrthoNormalBasis orthobasis) {return null;}
	public CSG fixTJunctions() {return null;}

	/**
	 *EN Parse an option from the options object
	 *EN If the option is not present, return the default value
	 *JP オプションオブジェクトからのオプションを解析する
	 *JP オプションが存在しない場合、デフォルト値を返す
	 */
	public static Object parseOption(Object options, String optionname, Object defaultvalue) {return null;}
	/**
	 *EN Parse an option and force into a CSG.Vector3D. If a scalar is passed it is converted
	 *EN into a vector with equal x,y,z
	 *JP オプションを解析してCSG.Vector3Dに強制的に変換する。スカラー値が渡された場合、同じ値のx,y,zからなるベクトルに変換される。
	 */
	public static Vector3D parseOptionAs3DVector(Object options, String optionname, Object defaultvalue) {return null;}
	/**
	 *EN Parse an option and force into a CSG.Vector2D. If a scalar is passed it is converted
	 *EN into a vector with equal x,y
	 *JP オプションを解析してCSG.Vector2Dに強制的に変換する。スカラー値が渡された場合、同じ値のx,yからなるベクトルに変換される。
	 */
	public static Vector2D parseOptionAs2DVector(Object options, String optionname, Object defaultvalue) {return null;}
	public static double parseOptionAsFloat(Object options, String optionname, Object defaultvalue) {return 0;}
	public static int parseOptionAsInt(Object options, String optionname, Object defaultvalue) {return 0;}
	public static boolean parseOptionAsBool(Object options, String optionname, Object defaultvalue) {return false;}
	/**
	 *EN Construct an axis-aligned solid cuboid.
	 *EN @param center: center of cube (default [0,0,0])
	 *EN @param radius: radius of cube (default [1,1,1]), can be specified as scalar or as 3D vector
	 *EN Example code:
	 *EN <pre>
	 *EN     var cube = CSG.cube({
	 *EN       center: [0, 0, 0],
	 *EN       radius: 1
	 *EN     });
	 *EN </pre>
	 *JP 軸に沿ったソリッドの立方体を構成する。
	 *JP @param center: 立方体の中心(デフォルト [0,0,0])
	 *JP @param radius: 立方体の範囲(デフォルト [1,1,1])、 スカラー値でも３Dエクトルでも指定可能
	 *JP コード例:
	 *JP <pre>
	 *JP     var cube = CSG.cube({
	 *JP       center: [0, 0, 0],
	 *JP       radius: 1
	 *JP     });
	 *JP </pre>
	 */
	public static CSG cube(Object option) {return null;}
	/**
	 *EN Construct a solid sphere
	 *EN @param center: center of sphere (default [0,0,0])
	 *EN @param radius: radius of sphere (default 1), must be a scalar
	 *EN @param resolution: determines the number of polygons per 360 degree revolution (default 12)
	 *EN @param axes: (optional) an array with 3 vectors for the x, y and z base vectors
	 *EN Example usage:
	 *EN <pre>
	 *EN     var sphere = CSG.sphere({
	 *EN       center: [0, 0, 0],
	 *EN       radius: 2,
	 *EN       resolution: 32,
	 *EN     });
	 *EN </pre>
	 *JP ソリッドの球を構成します。
	 *JP @param center: 級の中心(デフォルト [0,0,0])
	 *JP @param radius: 級の半径(デフォルト 1), スカラー値でなければいけない
	 *JP @param resolution: 360度周期あたりのポリゴンの数を決定する(デフォルト 12)
	 *JP @param axes: (省略可能) x,y,zの３つの基底ベクトルからなる配列
	 *JP 使用例:
	 *JP <pre>
	 *JP     var sphere = CSG.sphere({
	 *JP       center: [0, 0, 0],
	 *JP       radius: 2,
	 *JP       resolution: 32,
	 *JP     });
	 *JP </pre>
	 */
	public static CSG sphere(Object option) {return null;}
	/**
	 *EN Construct a solid cylinder.
	 *EN @param start: start point of cylinder (default [0, -1, 0])
	 *EN @param end: end point of cylinder (default [0, 1, 0])
	 *EN @param radius: radius of cylinder (default 1), must be a scalar
	 *EN @param resolution: determines the number of polygons per 360 degree revolution (default 12)
	 *EN Example usage:
	 *EN <pre>
	 *EN     var cylinder = CSG.cylinder({
	 *EN       start: [0, -1, 0],
	 *EN       end: [0, 1, 0],
	 *EN       radius: 1,
	 *EN       resolution: 16
	 *EN     });	 *
	 *EN </pre>
	 *JP ソリッドの円柱を構成する。
	 *JP @param start: 円柱の開始点(デフォルト [0, -1, 0])
	 *JP @param end: 円柱の終了点(デフォルト [0, 1, 0])
	 *JP @param radius: 円柱の半径(デフォルト 1)、スカラー値でなければならない
	 *JP @param resolution: 360度周期あたりのポリゴンの数を決定する(デフォルト 12)
	 *JP 使用例:
	 *JP <pre>
	 *JP     var cylinder = CSG.cylinder({
	 *JP       start: [0, -1, 0],
	 *JP       end: [0, 1, 0],
	 *JP       radius: 1,
	 *JP       resolution: 16
	 *JP     });
	 *JP </pre>
	 */
	public static CSG cylinder(Object option) {return null;}
	/**
	 *EN Like a cylinder, but with rounded ends instead of flat
	 *EN @param start: start point of cylinder (default [0, -1, 0])
	 *EN @param end: end point of cylinder (default [0, 1, 0])
	 *EN @param radius: radius of cylinder (default 1), must be a scalar
	 *EN @param resolution: determines the number of polygons per 360 degree revolution (default 12)
	 *EN @param normal: a vector determining the starting angle for tesselation. Should be non-parallel to start.minus(end)
	 *EN Example usage:
	 *EN <pre>
	 *EN     var cylinder = CSG.roundedCylinder({
	 *EN       start: [0, -1, 0],
	 *EN       end: [0, 1, 0],
	 *EN       radius: 1,
	 *EN       resolution: 16
	 *EN     });
	 *EN </pre>
	 *JP 円柱同様だが、端が平坦ではなく丸められる
	 *JP @param start: 円柱の開始点(デフォルト [0, -1, 0])
	 *JP @param end: 円柱の終了点(デフォルト [0, 1, 0])
	 *JP @param radius: 円柱の半径(デフォルト 1)、スカラー値でなければならない
	 *JP @param resolution: 360度周期あたりのポリゴンの数を決定する(デフォルト 12)
	 *JP @param normal: 平面充填のための開始角を決定するベクトル。start.minus(end)と平行でないこと。
	 *JP 使用例:
	 *JP <pre>
	 *JP     var cylinder = CSG.roundedCylinder({
	 *JP       start: [0, -1, 0],
	 *JP       end: [0, 1, 0],
	 *JP       radius: 1,
	 *JP       resolution: 16
	 *JP     });
	 *JP </pre>
	 */
	public static CSG roundedCylinder(Object option) {return null;}
	/**
	 *EN Construct an axis-aligned solid rounded cuboid.
	 *EN @param center: center of cube (default [0,0,0])
	 *EN @param radius: radius of cube (default [1,1,1]), can be specified as scalar or as 3D vector
	 *EN @param roundradius: radius of rounded corners (default 0.2), must be a scalar
	 *EN @param resolution: determines the number of polygons per 360 degree revolution (default 8)
	 *EN Example code:
	 *EN <pre>
	 *EN     var cube = CSG.roundedCube({
	 *EN       center: [0, 0, 0],
	 *EN       radius: 1,
	 *EN       roundradius: 0.2,
	 *EN       resolution: 8,
	 *EN     });
	 *EN </pre>
	 *JP 軸に沿ったソリッドの丸められた立方体を構成する。
	 *JP @param center: 立方体の中心(デフォルト [0,0,0])
	 *JP @param radius: 立方体の範囲(デフォルト [1,1,1])、スカラー値と3Dベクトルが指定可能
	 *JP @param roundradius: 丸められた隅の半径(デフォルト 0.2)、スカラー値でなければならない
	 *JP @param resolution: 360度周期あたりのポリゴンの数を決定する(デフォルト 8)
	 *JP コード例:
	 *JP <pre>
	 *JP     var cube = CSG.roundedCube({
	 *JP       center: [0, 0, 0],
	 *JP       radius: 1,
	 *JP       roundradius: 0.2,
	 *JP       resolution: 8,
	 *JP     });
	 *JP </pre>
	 */
	public static CSG roundedCube(Object option) {return null;}
	public static CSG IsFloat(Object n) {return null;}
	/**
	 *EN solve 2x2 linear equation:
	 **EN <pre>
	 *EN [ab][x] = [u]
	 *EN [cd][y]   [v]
	 *EN </pre>
	 *JP ２ｘ２の一次方程式を解く：
	 *JP <pre>
	 *JP [ab][x] = [u]
	 *JP [cd][y]   [v]
	 *JP </pre>
	 */
	public static double[] solve2Linear(double a, double b, double c, double d, double u, double v) {return null;}

	/**
	 *EN Represents a 3D vector.
	 *EN Example usage:
	 *EN <pre>
	 *EN     new CSG.Vector3D(1, 2, 3);
	 *EN     new CSG.Vector3D([1, 2, 3]);
	 *EN     new CSG.Vector3D({ x: 1, y: 2, z: 3 });
	 *EN     new CSG.Vector3D(1, 2); // assumes z=0
	 *EN     new CSG.Vector3D([1, 2]); // assumes z=0
	 *EN </pre>
	 *JP ３Dベクトルを表す。
	 *JP 使用例:
	 *JP <pre>
	 *JP     new CSG.Vector3D(1, 2, 3);
	 *JP     new CSG.Vector3D([1, 2, 3]);
	 *JP     new CSG.Vector3D({ x: 1, y: 2, z: 3 });
	 *JP     new CSG.Vector3D(1, 2); // z=0を仮定
	 *JP     new CSG.Vector3D([1, 2]); // z=0を仮定
	 *JP </pre>
	 */
	public static class Vector3D extends AddTransformationMethodsToPrototype {
		public Vector3D(double x, double y, double z) {}
		public Vector3D(double x, double y) {}
		public Vector3D(double[] pos) {}
		public Vector3D(Vector3D pos) {}
		public Vector3D(Vector2D pos) {}
		public Vector3D(Object pos) {}

		public double get_x() {return 0;}
		public double get_y() {return 0;}
		public double get_z() {return 0;}
		public void set_x(double x) {return;}
		public void set_y(double y) {return;}
		public void set_z(double z) {return;}
		public Vector3D clone() {return null;}
		public Vector3D negated() {return null;}
		public Vector3D abs() {return null;}
		public Vector3D plus(Vector3D a) {return null;}
		public Vector3D minus(Vector3D a) {return null;}
		public Vector3D times(double a) {return null;}
		public Vector3D dividedBy(Vector3D a) {return null;}
		public double dot(Vector3D a) {return 0;}
		public Vector3D lerp(Vector3D a, double t) {return null;}
		public double lengthSquared() {return 0;}
		public double length() {return 0;}
		public Vector3D unit() {return null;}
		public Vector3D cross(Vector3D a) {return null;}
		public double distanceTo(Vector3D a) {return 0;}
		public double distanceToSquared(Vector3D a) {return 0;}
		public boolean equals(Vector3D a) {return false;}
		/**
		 *EN Right multiply by a 4x4 matrix (the vector is interpreted as a row vector)
		 *EN Returns a new CSG.Vector3D
		 *JP 4x4行列による右からの乗算(ベクトルは行ベクトルと解釈される)
		 *JP 新しいCSG.Vector3Dを返す
		 */
		public Vector3D multiply4x4(Matrix4x4 matrix4x4) {return null;}
		public Vector3D transform(Matrix4x4 matrix4x4) {return null;}
		public String toAMFString() {return null;}
		public String toString() {return null;}
		/**
		 *EN find a vector that is somewhat perpendicular to this one
		 *JP 本ベクトルに何かしら垂直なベクトルを見つける
		 */
		public Vector3D randomNonParallelVector() {return null;}
		public Vector3D min() {return null;}
		public Vector3D max() {return null;}
	}

	/**
	 *EN Represents a vertex of a polygon. Use your own vertex class instead of this
	 *EN one to provide additional features like texture coordinates and vertex
	 *EN colors. Custom vertex classes need to provide a `pos` property
	 *EN `flipped()`, and `interpolate()` methods that behave analogous to the ones
	 *EN defined by `CSG.Vertex`.
	 *JP ポリゴンの頂点を表す。テクスチャ座標や頂点の色のような追加の機能を提供するには本クラスのかわりにユーザー独自の頂点クラスを使うこと。
	 *JP カスタム頂点クラスは`CSG.Vertex`で定義されるのと同様に振る舞う`pos`プロパティーと`flipped()`と`interpolate()`メソッドを提供する必要がある。
	 */
	public static class Vertex extends AddTransformationMethodsToPrototype {
		public Vertex(Object obj) {}

		/**
		 *EN create from an untyped object with identical property names:
		 *JP 同一のプロパティー名を持つ型付けられていないオブジェクトから作成する：
		 */
		public static Vertex fromObject(Object obj) {return null;}

		/**
		 *EN Return a vertex with all orientation-specific data (e.g. vertex normal) flipped. Called when the
		 *EN orientation of a polygon is flipped.
		 *JP 向きを指定する（頂点の法線）をすべて反転した頂点を返す。ポリゴンの向きを反転するときに呼ばれる。
		 */
		public Vertex flipped() {return null;}
		public int getTag() {return 0;}
		/**
		 *EN Create a new vertex between this vertex and `other` by linearly
		 *EN interpolating all properties using a parameter of `t`. Subclasses should
		 *EN override this to interpolate additional properties.
		 *JP 本頂点と`other`の間をパラメーター`t`を使って全てのプロパティーを線形補間して新しい頂点を作成する。
		 *JP サブクラスは追加のプロパティーを補間するためこのメソッドをオーバーライドすること。
		 */
		public Vertex interpolate(Vertex other, double t) {return null;}
		/**
		 *EN Affine transformation of vertex. Returns a new CSG.Vertex
		 *JP 頂点のアフィン変換。新しいCSG.Vertexを返す。
		 */
		public Vertex transform(Matrix4x4 matrix4x4) {return null;}
		public String toStlString() {return null;}
		public String toAMFString() {return null;}
		public String toString() {return null;}
	}

	/**
	 *EN Represents a plane in 3D space.
	 *JP 3D空間上の平面を表す。
	 */
	public static class Plane extends AddTransformationMethodsToPrototype {
		public Plane(Vector3D normal, double w) {}

		/**
		 *EN create from an untyped object with identical property names:
		 *JP 同一のプロパティー名を持つ型付けられていないオブジェクトから作成する：
		 */
		public static Plane fromObject(Object obj) {return null;}
		/**
		 *EN `CSG.Plane.EPSILON` is the tolerance used by `splitPolygon()` to decide if a
		 *EN point is on the plane.
		 *JP `CSG.Plane.EPSILON`は点が平面上にあるかを決定する`splitPolygon()`が使う許容度である。
		 */
		public static double EPSILON;
		public static Plane fromVector3Ds(Vector3D a, Vector3D b, Vector3D c)  {return null;}
		/**
		 *EN like fromVector3Ds, but allow the vectors to be on one point or one line
		 *EN in such a case a random plane through the given points is constructed
		 *JP fromVector3Dsと同様だが、ベクトルが同一点か同一直線上にあることを許す。
		 *JP その場合、与えられた点を通るランダムな平面が作成される。
		 */
		public static Plane anyPlaneFromVector3Ds(Vector3D a, Vector3D b, Vector3D c)  {return null;}
		public static Plane fromPoints(double[] a, double[] b, double[] c) {return null;}
		public static Plane fromPoints(Vector3D a, Vector3D b, Vector3D c) {return null;}
		public static Plane fromPoints(Vector2D a, Vector2D b, Vector2D c) {return null;}
		public static Plane fromNormalAndPoint(double[] normal, double[] point) {return null;}
		public static Plane fromNormalAndPoint(Vector3D normal, Vector3D point) {return null;}
		public static Plane fromNormalAndPoint(Vector2D normal, Vector2D point) {return null;}

		public Plane flipped() {return null;}
		public int getTag() {return 0;}
		public boolean equals() {return false;}
		public Plane transform(Matrix4x4 matrix4x4) {return null;}
		/**
		 *EN Returns object:
		 *EN <pre>
		 *EN .type:
		 *EN   0: coplanar-front
		 *EN   1: coplanar-back
		 *EN   2: front
		 *EN   3: back
		 *EN   4: spanning
		 *EN </pre>
		 *EN In case the polygon is spanning, returns:
		 *EN <pre>
		 *EN .front: a CSG.Polygon of the front part
		 *EN .back: a CSG.Polygon of the back part
		 *EN </pre>
		 *JP 以下のオブジェクトを返す:
		 *JP <pre>
		 *JP .type:
		 *JP   0: 平滑-前面
		 *JP   1: 平滑-背面
		 *JP   2: 前面
		 *JP   3: 背面
		 *JP   4: spanning
		 *JP </pre>
		 *JP ポリゴンがspanningな場合、以下を返す:
		 *JP <pre>
		 *JP .front: 前面のCSG.Polygon
		 *JP .back: 背面のCSG.Polygon
		 *JP </pre>
		 */
		public Object splitPolygon(Polygon polygon) {return null;}
		/**
		 *EN robust splitting of a line by a plane
		 *EN will work even if the line is parallel to the plane
		 *JP 平面による直線の堅牢な分割
		 *JP 直線が平面と平行な場合でも機能する
		 */
		public Vector3D splitLineBetweenPoints(Vector3D p1, Vector3D p2) {return null;}
		/**
		 *EN returns CSG.Vector3D
		 *JP CSG.Vector3Dを返す
		 */
		public Vector3D intersectWithLine(Line3D line3d) {return null;}
		/**
		 *EN intersection of two planes
		 *JP ２つの平面の交差
		 */
		public Line3D intersectWithPlane(Plane plane) {return null;}
		public double signedDistanceToPoint(Vector3D point) {return 0;}
		public String toString() {return null;}
		public Vector3D mirrorPoint(Vector3D point3d) {return null;}
	}

	/**
	 *EN Represents a convex polygon. The vertices used to initialize a polygon must
	 *EN be coplanar and form a convex loop. They do not have to be `CSG.Vertex`
	 *EN instances but they must behave similarly (duck typing can be used for
	 *EN customization).
	 *EN
	 *EN Each convex polygon has a `shared` property, which is shared between all
	 *EN polygons that are clones of each other or were split from the same polygon.
	 *EN This can be used to define per-polygon properties (such as surface color).
	 *EN
	 *EN The plane of the polygon is calculated from the vertex coordinates
	 *EN To avoid unnecessary recalculation, the plane can alternatively be
	 *EN passed as the third argument
	 *JP 凸ポリゴンを表す。ポリゴンを初期化するのに使われる頂点は平滑(coplanar)かつ凸なループでなければならない。
	 *JP それらは`CSG.Vertex`インスタンスである必要はないが、同様に振る舞えなければならない（ダックタイピングがカスタム化のために用いられる）。
	 *JP
	 *JP 各凸ポリゴンは`共有`プロパティーを持つ。それは互いにクローンであるか、同じポリゴンから分割されたかのいずれかのすべてのポリゴン間で共有される。
	 *JP これは（表面色のような）ポリゴン毎のプロパティーを定義するのに使うことができる。
	 *JP
	 *JP ポリゴンの平面は頂点の座標から計算される。不必要な再計算を避けるため、平面は第３引数として渡すこともできる。
	 */
	public static class Polygon extends AddTransformationMethodsToPrototype {
		public Polygon(Vertex[] vertices, boolean shared, Plane plane) {}
		public Polygon(Vertex[] vertices, boolean shared) {}
		public Polygon(Vertex[] vertices) {}

		/**
		 *EN create from an untyped object with identical property names:
		 *JP 同一のプロパティー名を持つ型付けられていないオブジェクトから作成する：
		 */
		public static Polygon fromObject(Object obj) {return null;}

		/**
		 *EN check whether the polygon is convex (it should be, otherwise we will get unexpected results)
		 *JP ポリゴンが凸かをチェックする（そうであるべき、そうでなければ予期しない結果になる）
		 */
		public boolean checkIfConvex() {return false;}
		/**
		 * @param {Array} 色 [red, green, blue, alpha] 色の値は０から１の小数である
	 	 * @return {CSG.Polygon} 現在のポリゴン
	 	 */
		public Polygon setColor(double red, double green, double blue, double alpha) {return null;}
		/**
		 *EN Extrude a polygon into the direction offsetvector
		 *EN Returns a CSG object
		 *JP offsetvectorの方向にポリゴンを押し出す
		 *JP CSGオブジェクトを返す
		 */
		public CSG extrude(Vector3D offsetvector) {return null;}
		public Polygon translate(Vector3D offset) {return null;}
		/**
		 *EN returns an array with a CSG.Vector3D (center point) and a radius
		 *JP CSG.Vector3D(中心点)と半径からなる配列を返す
		 */
		public Object[] boundingSphere() {return null;}
		/**
		 *EN returns an array of two CSG.Vector3Ds (minimum coordinates and maximum coordinates)
		 *JP ２つのCSG.Vector3D(最小座標と最大座標)からなる配列を返す
		 */
		public Vector3D[] boundingBox() {return null;}
		public Polygon flipped() {return null;}
		/**
		 *EN Affine transformation of polygon. Returns a new CSG.Polygon
		 *JP ポリゴンのアフィン変換。新しいCSG.Polygonを返す。
		 */
		public Polygon transform(Matrix4x4 matrix4x4) {return null;}
		public String toStlString() {return null;}
		public String toString() {return null;}
		/**
		 *EN project the 3D polygon onto a plane
		 *JP 3Dポリゴンを平面に射影する
		 */
		public CAG projectToOrthoNormalBasis(OrthoNormalBasis orthobasis) {return null;}
		public CSG solidFromSlices(Object options) {return null;}
		public CSG _addWalls(Polygon[] walls, Polygon bottom, Polygon top, boolean bFlipped) {return null;}

		//public static boolean verticesConvex(Vertex[] vertices, ? planenormal) {return null;}
		public static Polygon createFromPoints(double[][] points, boolean shared, Plane plane) {return null;}
		public static Polygon createFromPoints(Vector3D[] points, boolean shared, Plane plane) {return null;}
		public static Polygon createFromPoints(Vector2D[] points, boolean shared, Plane plane) {return null;}
		public static Polygon createFromPoints(double[][] points, boolean shared) {return null;}
		public static Polygon createFromPoints(Vector3D[] points, boolean shared) {return null;}
		public static Polygon createFromPoints(Vector2D[] points, boolean shared) {return null;}
		public static boolean isConvexPoint(Vector3D prevpoint, Vector3D point, Vector3D nextpoint, Vector3D normal) {return false;}
		public static boolean isStrictlyConvexPoint(Vector3D prevpoint, Vector3D point, Vector3D nextpoint, Vector3D normal) {return false;}

		public static class Shared {
			public Shared(double[] color) {}

			public int getTag() {return 0;}
			public String getHash()  {return null;}

			public static Shared defaultShared;
		}
	}


	public static class PolygonTreeNode {

	}

	public static class Tree {

	}

	public static class Node {

	}

	public static class Matrix4x4 {

	}

	public static class Vector2D extends AddTransformationMethodsToPrototype {

	}

	public static class Line2D extends AddTransformationMethodsToPrototype {

	}

	public static class Line3D extends AddTransformationMethodsToPrototype {

	}

	public static class OrthoNormalBasis  {

	}

	//public static ? interpolateBetween2DPointsForY(point1, point2, y);
	//public static ? reTesselateCoplanarPolygons(sourcepolygons, destpolygons);



	public static class fuzzyFactory  {

	}

	public static class fuzzyCSGFactory {

	}

	public static int staticTag;
	public static int getTag() {return 0;}

	public static class Properties {

	}

	public static class Connector extends AddTransformationMethodsToPrototype {

	}

	public static class Path2D extends AddTransformationMethodsToPrototype {

	}


	public static class Polygon2D {

	}
}

