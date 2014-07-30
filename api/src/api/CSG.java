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
	 */
	public CSG union(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in either this solid or in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP 本ソリッドまたはソリッド`csg`のどちらかに含まれる空間を表す新しいCSGソリッドを返す。
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
	 * @return
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
	//public Blob? toX3D() {return null;}
	//public Blob? toStlBinary() {return null;}
	/**
	 *EN @see http://en.wikipedia.org/wiki/STL_%28file_format%29#Binary_STL
	 *JP @see http://en.wikipedia.org/wiki/STL_%28file_format%29#Binary_STL
	 */
	public String toStlBinary() {return null;}
	public String toString() {return null;}
	public CSG center(double x, double y, double z) {return null;}
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
	 *JP ソリッドを平面で切断する。片面の裏側のソリッドを返す。
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
	//public CAG projectToOrthoNormalBasis(? orthobasis) {return null;}
	//public CAG sectionCut(? orthobasis) {return null;}
	public CSG fixTJunctions() {return null;}

	public static Object parseOption(Object options, String optionname, Object defaultvalue) {return null;}
	public static Vector3D parseOptionAs3DVector(Object options, String optionname, Object defaultvalue) {return null;}
	public static Vector2D parseOptionAs2DVector(Object options, String optionname, Object defaultvalue) {return null;}
	public static double parseOptionAsFloat(Object options, String optionname, Object defaultvalue) {return 0;}
	public static int parseOptionAsInt(Object options, String optionname, Object defaultvalue) {return 0;}
	public static boolean parseOptionAsBool(Object options, String optionname, Object defaultvalue) {return false;}
	public static CSG cube(Object option) {return null;}
	public static CSG sphere(Object option) {return null;}
	public static CSG cylinder(Object option) {return null;}
	public static CSG roundedCylinder(Object option) {return null;}
	public static CSG roundedCube(Object option) {return null;}
	public static CSG IsFloat(Object n) {return null;}
	public static double[] solve2Linear(double a, double b, double c, double d, double u, double v) {return null;}

	public static class Vector3D extends AddTransformationMethodsToPrototype {
		public Vector3D(double x, double y, double z) {}
		public Vector3D(double x, double y) {}
		public Vector3D(double[] pos) {}
		public Vector3D(Vector3D pos) {}
		public Vector3D(Vector2D pos) {}

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
		public Vector3D multiply4x4(Matrix4x4 matrix4x4) {return null;}
		public Vector3D transform(Matrix4x4 matrix4x4) {return null;}
		public String toAMFString() {return null;}
		public String toString() {return null;}
		public Vector3D randomNonParallelVector() {return null;}
		public Vector3D min() {return null;}
		public Vector3D max() {return null;}
	}

	public static class Vertex extends AddTransformationMethodsToPrototype {
		public Vertex(Object obj) {}

		public Vertex flipped() {return null;}
		public int getTag() {return 0;}
		public Vertex interpolate(Vertex other, double t) {return null;}
		public Vertex transform(Matrix4x4 matrix4x4) {return null;}
		public String toStlString() {return null;}
		public String toAMFString() {return null;}
		public String toString() {return null;}
	}

	public static class Plane extends AddTransformationMethodsToPrototype {
		public Plane(Vector3D normal, double w) {}

		public static Plane fromObject(Object obj) {return null;}
		public static double EPSILON;
		public static Plane fromVector3Ds(Vector3D a, Vector3D b, Vector3D c)  {return null;}
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
		public Object splitPolygon(Polygon polygon) {return null;}
		//public ? splitLineBetweenPoints(? p1, ? p2) {return null;}
		public Vector3D intersectWithLine(Line3D line3d) {return null;}
		//public ? intersectWithPlane(Plane plane) {return null;}
		public double signedDistanceToPoint(Vector3D point) {return 0;}
		public String toString() {return null;}
		public Vector3D mirrorPoint(Vector3D point3d) {return null;}
	}

	public static class Polygon extends AddTransformationMethodsToPrototype {
		public Polygon(Vertex[] vertices, boolean shared, Plane plane) {}
		public Polygon(Vertex[] vertices, boolean shared) {}
		public Polygon(Vertex[] vertices) {}

		public static Polygon fromObject(Object obj) {return null;}

		public boolean checkIfConvex() {return false;}
		public Polygon setColor(double red, double green, double blue, double alpha) {return null;}
		public CSG extrude(Vector3D offsetvector) {return null;}
		//public Polygon translate(? offset) {return null;}
		//public ? boundingSphere() {return null;}
		public Vector3D[] boundingBox() {return null;}
		public Polygon flipped() {return null;}
		public Polygon transform(Matrix4x4 matrix4x4) {return null;}
		public String toStlString() {return null;}
		public String toString() {return null;}
		//public projectToOrthoNormalBasis(? orthobasis) {return null;}
		public CSG solidFromSlices(Object options) {return null;}
		public CSG _addWalls(Polygon[] walls, Polygon bottom, Polygon top, boolean bFlipped) {return null;}

		//public static ? verticesConvex(Vertex[] vertices, ? planenormal) {return null;}
		//public static ? createFromPoints(double[][] points, boolean shared, Plane plane) {return null;}
		//public static ? createFromPoints(Vector3D[] points, boolean shared, Plane plane) {return null;}
		//public static ? createFromPoints(Vector2D[] points, boolean shared, Plane plane) {return null;}
		//public static ? createFromPoints(double[][] points, boolean shared) {return null;}
		//public static ? createFromPoints(Vector3D[] points, boolean shared) {return null;}
		//public static ? createFromPoints(Vector2D[] points, boolean shared) {return null;}
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

