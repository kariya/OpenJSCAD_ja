package api;

import api.CSG.Matrix4x4;
import api.CSG.Path2D;
import api.CSG.Polygon;
import api.CSG.Vector2D;

/**
 *EN CAG: solid area geometry: like CSG but 2D
 *EN Each area consists of a number of sides
 *EN Each side is a line between 2 points
 *JP CAG: ソリッド領域幾何：CSG同様だが２D
 *JP 各領域は縁(side)を持つ
 *JP 各縁は２点間の直線である。
 */
public class CAG extends AddTransformationMethodsToPrototype {

	/**
	 *EN Construct a CAG from a list of `CAG.Side` instances.
	 *JP `CAG.Side`インスタンスのリストからCAGを構成する。
	 */
	public static CAG fromSides(Side[] sides) {return null;}
	//public static CAG fromPoints(points) {return null;}
	//public static CAG fromPointsNoCheck(points) {return null;}
	/**
	 *EN Converts a CSG to a CAG. The CSG must consist of polygons with only z coordinates +1 and -1
	 *EN as constructed by CAG.toCSG(-1, 1). This is so we can use the 3D union(), intersect() etc
	 *JP CSGをCAGに変換する。CSGはCAG.toCSG(-1,1)で作成されたようにz座標のみが+1と-1のポリゴンに含まれなければならない。
	 *JP このことは３Dのunion()やintersect()などを使う場合も成り立つ。
	 */
	public static CAG fromFakeCSG(CSG csg) {return null;}
	//public static boolean linesIntersect(p0start, p0end, p1start, p1end) {return null;}
	/**
	 *EN Construct a circle
	 *EN   options:
	 *EN	 center: a 2D center point
	 *EN	 radius: a scalar
	 *EN	 resolution: number of sides per 360 degree rotation
	 *EN   returns a CAG object
	 *JP 円を構成する：
	 *JP   オプション:
	 *JP	 center: ２Dの中心点
	 *JP	 radius: スカラー値
	 *JP	 resolution: ３６０度回転あたりの縁の数
	 *JP  CAGオブジェクトを返す
	 */
	public static CAG circle(Object options) {return null; }
	/**
	 *EN Construct a rectangle
	 *EN   options:
	 *EN	 center: a 2D center point
	 *EN	 radius: a 2D vector with width and height
	 *EN   returns a CAG object
	 *JP 長方形を構成する：
	 *JP   オプション:
	 *JP	 center: ２Dの中心点
	 *JP	 radius: 幅と高さからなる２Dベクトル
	 *JP  CAGオブジェクトを返す
	 */
	public static CAG rectangle(Object options) {return null; }
	public static CAG roundedRectangle (Object options) {return null; }
	public static CAG fromCompactBinary (Object bin) {return null; }

	public String toString() {return null;}
	//public CSG toCSG(z0, z1) {return null;}
	public String toDebugString1() {return null;}
	public String toDebugString() {return null;}
	public CAG union(CAG cag) {return null;}
	public CAG subtract(CAG cag) {return null;}
	public CAG intersect(CAG cag) {return null;}
	public CAG transform(Matrix4x4 matrix4x4) {return null;}
	public double area() {return 0;}
	public CAG flipped() {return null;}
	//public ?[] getBounds() {return null;}
	public CAG center(Vector2D c) {return null;}
	public boolean isSelfIntersecting() {return false;}
	public CAG expandedShell(double radius, int resolution) {return null;}
	public CAG expanded(double radius, int resolution) {return null;}
	public CAG contract(double radius, int resolution) {return null;}
	public CSG extrude(Object options) {return null;}
	public boolean check() {return false;}
	public boolean canonicalized() {return false;}
	public Object toCompactBinary() {return null;}
	public Path2D[] getOutlinePaths() {return null;}
	//public ? toDxf() {return null;}

	//public static ? PathsToDxf(Path2D paths) {return null;}


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

	public static class Polygon2D  extends CAG {
		//public Polygon2D(?[] points) {}
	}
}

