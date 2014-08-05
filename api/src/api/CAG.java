package api;

import api.CSG.Matrix4x4;
import api.CSG.Path2D;
import api.CSG.Polygon;
import api.CSG.Vector2D;

/**
 *EN CAG: solid area geometry: like CSG but 2D
 *EN Each area consists of a number of sides
 *EN Each side is a line between 2 points
 *JP CAG: ソリッド領域幾何：CSGと同様だが２Dである。
 *JP 各領域は縁(side)を持つ。
 *JP 各縁は２点間の直線である。
 */
public class CAG extends AddTransformationMethodsToPrototype {

	/**
	 *EN Construct a CAG from a list of `CAG.Side` instances.
	 *JP `CAG.Side`インスタンスのリストからCAGを構成する。
	 */
	public static CAG fromSides(Side[] sides) {return null;}
	/**
	 *EN Construct a CAG from a list of points (a polygon)
	 *EN Rotation direction of the points is not relevant. Points can be a convex or concave polygon.
	 *EN Polygon must not self intersect
	 *JP 点のリスト（ポリゴン）からCAGを構成する。
	 *JP 点の間の回転方向は無関係である。点は凸又は凹なポリゴンである。
	 *JP ポリゴンは自分自身と交わってはいけない。
	 */
	public static CAG fromPoints(Vector2D [] points) {return null;}
	/**
	 *EN Like CAG.fromPoints but does not check if it's a valid polygon.
	 *EN Points should rotate counter clockwise
	 *JP CAG.fromPoints と同様であるが、妥当なポリゴンであるかのチェックをしない。
	 *JP 点は反時計回りでなければならない。
	 */
	public static CAG fromPointsNoCheck(Vector2D[] points) {return null;}
	/**
	 *EN Converts a CSG to a CAG. The CSG must consist of polygons with only z coordinates +1 and -1
	 *EN as constructed by CAG.toCSG(-1, 1). This is so we can use the 3D union(), intersect() etc
	 *JP CSGをCAGに変換する。CSGはCAG.toCSG(-1,1)で作成されたようにz座標のみが+1と-1のポリゴンに含まれなければならない。
	 *JP このことは３Dのunion()やintersect()などを使う場合も成り立つ。
	 */
	public static CAG fromFakeCSG(CSG csg) {return null;}
	/**
	 *EN see if the line between p0start and p0end intersects with the line between p1start and p1end
	 *EN returns true if the lines strictly intersect, the end points are not counted!
	 *JP p0startとp0endの間の直線がp1startとp1endの間の直線と交わるかを調べる。
	 *JP 直線が厳密に交わるなら真を返す、端点は含まれない！
	 */
	public static boolean linesIntersect(Vector2D p0start, Vector2D p0end, Vector2D p1start, Vector2D p1end) {return false;}
	/**
	 *EN Construct a circle
	 *EN <pre>
	 *EN   options:
	 *EN	 center: a 2D center point
	 *EN	 radius: a scalar
	 *EN	 resolution: number of sides per 360 degree rotation
	 *EN </pre>
	 *EN   returns a CAG object
	 *JP 円を構成する：
	 *JP <pre>
	 *JP   オプション:
	 *JP	 center: ２Dの中心点
	 *JP	 radius: スカラー値
	 *JP	 resolution: ３６０度回転あたりの縁の数
	 *JP </pre>
	 *JP  CAGオブジェクトを返す
	 */
	public static CAG circle(Object options) {return null; }
	/**
	 *EN Construct a rectangle
	 *EN <pre>
	 *EN   options:
	 *EN	 center: a 2D center point
	 *EN	 radius: a 2D vector with width and height
	 *EN </pre>
	 *EN   returns a CAG object
	 *JP 長方形を構成する：
	 *JP <pre>
	 *JP   オプション:
	 *JP	 center: ２Dの中心点
	 *JP	 radius: 幅と高さからなる２Dベクトル
	 *JP </pre>
	 *JP  CAGオブジェクトを返す
	 */
	public static CAG rectangle(Object options) {return null; }
	/**
	 * <pre>
	 * var r = CSG.roundedRectangle({
	 *       center: [0, 0],
	 *       radius: [2, 1],
	 *       roundradius: 0.2,
	 *       resolution: 8,
	 *     });
	 * </pre>
	 */
	public static CAG roundedRectangle (Object options) {return null; }
	/**
	 *EN Reconstruct a CAG from the output of toCompactBinary()
	 *JP toCompactBinary()の出力からCAGを再構築する
	 */
	public static CAG fromCompactBinary (Object bin) {return null; }

	public String toString() {return null;}
	//public CSG toCSG(z0, z1) {return null;}
	public String toDebugString1() {return null;}
	public String toDebugString() {return null;}
	public CAG union(CAG cag) {return null;}
	public CAG subtract(CAG cag) {return null;}
	public CAG intersect(CAG cag) {return null;}
	public CAG transform(Matrix4x4 matrix4x4) {return null;}
	/**
	 *EN see http://local.wasp.uwa.edu.au/~pbourke/geometry/polyarea/ :
	 *EN Area of the polygon. For a counter clockwise rotating polygon the area is positive, otherwise negative
	 *JP http://local.wasp.uwa.edu.au/~pbourke/geometry/polyarea/ を参照：
	 *JP ポリゴンの面積。反時計回りのポリゴン領域なら面積は正、そうでなければ負になる。
	 */
	public double area() {return 0;}
	public CAG flipped() {return null;}
	public Vector2D[] getBounds() {return null;}
	public CAG center(Vector2D c) {return null;}
	public boolean isSelfIntersecting() {return false;}
	public CAG expandedShell(double radius, int resolution) {return null;}
	public CAG expanded(double radius, int resolution) {return null;}
	public CAG contract(double radius, int resolution) {return null;}
	/**
	 *EN extruded=cag.extrude({offset: [0,0,10], twistangle: 360, twiststeps: 100});
	 *EN linear extrusion of 2D shape, with optional twist
	 *EN The 2d shape is placed in in z=0 plane and extruded into direction <offset> (a CSG.Vector3D)
	 *EN The final face is rotated <twistangle> degrees. Rotation is done around the origin of the 2d shape (i.e. x=0, y=0)
	 *EN twiststeps determines the resolution of the twist (should be >= 1)
	 *EN returns a CSG object
	 *JP extruded=cag.extrude({offset: [0,0,10], twistangle: 360, twiststeps: 100});
	 *JP ひねり(省略可能)のある2Dの形の線形押出し。
	 *JP 2D形状はz=0平面上に位置し、offset (CSG.Vector3D) 方向に押し出される。
	 *JP 最終の面はtwistange度だけ回転する。回転は2D形状の原点（x=0, y=0)回りになされる。
	 *JP twiststep はひねりの分解度を決定する（１以上であるべき）。
	 *JP CSGオブジェクトを返す。
	 */
	public CSG extrude(Object options) {return null;}
	/**
	 *EN check if we are a valid CAG (for debugging)
	 *JP 妥当なCAGであるかを調べる（デバッグ用）
	 */
	public boolean check() {return false;}
	public boolean canonicalized() {return false;}
	public Object toCompactBinary() {return null;}
	public Path2D[] getOutlinePaths() {return null;}
	public Object toDxf() {return null;}

	public static Object PathsToDxf(Path2D paths) {return null;}


	public static class Vertex {
		public Vertex(Vector2D pos) {}

		public String toString() {return null;}
		public int getTag() {return 0;}
	}

	public static class Side extends AddTransformationMethodsToPrototype {
		public Side(Vertex vertex0, Vertex vertex1) {}

		public static Side fromFakePolygon(Polygon polygon) {return null;}
		public String toString() {return null;}
		public Polygon toPolygon3D(double z0, double z1) {return null;}

	}

	public static class fuzzyCAGFactory  {
		public fuzzyCAGFactory() {}

		public Vertex getVertex(Vertex sourcevertex) {return null;}
		public Side getSide(Side sourceside) {return null;}
		public CAG getCAG(CAG sourcecag) {return null;}
	}
	/**
	 *EN 2D polygons are now supported through the CAG class.
	 *EN With many improvements (see documentation):
	 *EN <pre>
	 *EN - shapes do no longer have to be convex
	 *EN - union/intersect/subtract is supported
	 *EN - expand / contract are supported
	 *EN </pre>
	 *EN But we'll keep CSG.Polygon2D as a stub for backwards compatibility
	 *JP 今は2DポリゴンはCAGクラスを通じてサポートされる。
	 *JP 多くの改善点（ドキュメント参照）がある：
	 *JP <pre>
	 *JP - 形状はもはや凸である必要はない
	 *JP - union/intersect/subtract がサポートされる
	 *JP - 膨張/収縮がサポートされる
	 *JP </pre>
	 *JP しかしCSG.Polyugon2Dは後方互換性のためスタブとして維持される。
	 */
	public static class Polygon2D  extends CAG {
		public Polygon2D(Vector2D[] points) {}
	}
}

