package api;


/**
 *EN Holds a binary space partition tree representing a 3D solid.
 *EN Two solids can be combined using the `union()`, `subtract()`, and `intersect()` methods.
 *JP 3D�\���b�h��\������Q����ԕ����؂�ێ�����B
 *JP �Q�̃\���b�h��`union()`��`subtract()`�A`intersect()`���\�b�h�Ō����ł���B
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
	 *JP  `CSG.Polygon`�C���X�^���X�̃��X�g����CSG�\���b�h���\������B
	 */
	public static CSG fromPolygons(Polygon[] polygons) {return null;}
	/**
	 *EN Construct a CSG solid from generated slices.
	 *EN Look at CSG.Polygon.prototype.solidFromSlices for details
	 *JP �������ꂽ�X���C�X����CSG�\���b�h���\������B
	 *JP �ڍׂ�CSG.Polygon.prototype.solidFromSlices���Q�ƁB
	 */
	public static CSG fromSlices(Object options) {return null;}
	/**
	 *EN create from an untyped object with identical property names:
	 *JP ����̃v���p�e�B�������^�t������Ă��Ȃ��I�u�W�F�N�g����쐬����
	 */
	public static CSG fromObject(Object obj) {return null;}
	/**
	 *EN Reconstruct a CSG from the output of toCompactBinary()
	 *JP toCompactBinary()�̏o�͂���CSG���č\������B
	 */
	public static CSG fromCompactBinary(Object bin) {return null;}

	public Polygon[] toPolygons() {return null;}
	/**
	 *EN Return a new CSG solid representing space in either this solid or in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP �{�\���b�h�܂��̓\���b�h`csg`�̂ǂ��炩�Ɋ܂܂���Ԃ�\���V����CSG�\���b�h��Ԃ��B
	 */
	public CSG union(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in either this solid or in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP �{�\���b�h�܂��̓\���b�h`csg`�̂ǂ��炩�Ɋ܂܂���Ԃ�\���V����CSG�\���b�h��Ԃ��B
	 */
	public CSG union(CSG[] csgs) {return null;}
	public CSG unionSub(CSG csg, boolean retesselate, boolean canonicalize) {return null;}
	/**
	 *EN Like union, but when we know that the two solids are not intersecting
	 *EN Do not use if you are not completely sure that the solids do not intersect!
	 *JP union���l�����A�Q�̃\���b�h�������Ȃ����Ƃ��킩���Ă���ꍇ�B
	 *JP �\���b�h�������Ȃ������S�ɂ͂킩��Ȃ��Ȃ�g��Ȃ����ƁB
	 */
	public CSG unionForNonIntersecting(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in this solid but not in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP �{�\���b�h�Ɋ܂܂�邪�\���b�h`csg`�ɂ͊܂܂�Ȃ���Ԃ�\���V����CSG�\���b�h��Ԃ��B
	 *JP �{�\���b�h���\���b�h`csg`���ύX����Ȃ��B
	 */
	public CSG subtract(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space in this solid but not in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP �{�\���b�h�Ɋ܂܂�邪�\���b�h`csg`�ɂ͊܂܂�Ȃ���Ԃ�\���V����CSG�\���b�h��Ԃ��B
	 *JP �{�\���b�h���\���b�h`csg`���ύX����Ȃ��B
	 */
	public CSG subtract(CSG[] csgs) {return null;}
	public CSG subtractSub(CSG csg, boolean retesselate, boolean canonicalize) {return null;}
	/**
	 *EN Return a new CSG solid representing space both this solid and in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP �{�\���b�h�ɂ��\���b�h`csg`�ɂ��܂܂���Ԃ�\���V����CSG�\���b�h��Ԃ��B
	 *JP �{�\���b�h���\���b�h`csg`���ύX����Ȃ��B
	 */
	public CSG intersect(CSG csg) {return null;}
	/**
	 *EN Return a new CSG solid representing space both this solid and in the
	 *EN solid `csg`. Neither this solid nor the solid `csg` are modified.
	 *JP �{�\���b�h�ɂ��\���b�h`csg`�ɂ��܂܂���Ԃ�\���V����CSG�\���b�h��Ԃ��B
	 *JP �{�\���b�h���\���b�h`csg`���ύX����Ȃ��B
	 */
	public CSG intersect(CSG[] csg) {return null;}
	public CSG intersectSub(CSG csg, boolean retesselate, boolean canonicalize) {return null;}
	/**
	 *EN Return a new CSG solid with solid and empty space switched. This solid is
	 *EN not modified.
	 *JP �\���b�h�Ƌ�̋�Ԃ����ւ����V����CSG�\���b�h��Ԃ��B
	 *JP �{�\���b�h�͕ύX����Ȃ��B
	 * @return
	 */
	public CSG inverse() {return null;}
	/**
	 *EN Affine transformation of CSG object. Returns a new CSG object
	 *JP CSG�I�u�W�F�N�g���A�t�B���ϊ�����B�����炵��CSG�I�u�W�F�N�g��Ԃ��B
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
	 *JP �\���b�h��c��������B
	 *JP @param resolution: �ۂ߂�ꂽ���ɂ��ĂR�U�O�x������̓_�̐�
	 */
	public CSG expand(double radius, int resolution) {return null;}
	/**
	 *EN Contract the solid
	 *EN @param resolution: number of points per 360 degree for the rounded corners
	 *JP �\���b�h�����k������B
	 *JP @param resolution: �ۂ߂�ꂽ���ɂ��ĂR�U�O�x������̓_�̐�
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
	 *JP �\���b�h�̖c�����ꂽ�O�k���쐬����F
	 *JP ���ׂĂ̖ʂ�2*radius�̌����ŉ����o�����
	 *JP �~���͑S�Ă̑��ʂ܂��ɍ\�������
	 *JP �������ׂĂ̒��_�ɔz�u�����
	 *JP @prama unionWithThis: �^�Ȃ猋�ʂ̃\���b�h�͖{�\���b�h�ƌ��������F
	 *JP ���ʂ̓\���b�h�̖{���̖c���ɂȂ�
	 *JP �U�Ȃ�O�k�݂̂��Ԃ����
	 */
	public CSG expandedShell(double radius, int resolution, boolean unionWithThis) {return null;}
	public CSG canonicalized() {return null;}
	public CSG reTesselated() {return null;}
	/**
	 *EN returns an array of two CSG.Vector3Ds (minimum coordinates and maximum coordinates)
	 *JP �Q��CSG.Vector3D����Ȃ�z���Ԃ��i�ŏ����W�ƍő���W�j
	 */
	public Vector3D[] getBounds() {return null;}
	/**
	 *EN returns true if there is a possibility that the two solids overlap
	 *EN returns false if we can be sure that they do not overlap
	 *JP �Q�̃\���b�h���d�Ȃ�\��������ΐ^��Ԃ�
	 *JP �����ďd�Ȃ�Ȃ��Ȃ�U��Ԃ�
	 */
	public boolean mayOverlap(CSG csg) {return false;}
	/**
	 *EN Cut the solid by a plane. Returns the solid on the back side of the plane
	 *JP �\���b�h�𕽖ʂŐؒf����B�Жʂ̗����̃\���b�h��Ԃ��B
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
	 *JP �\���b�h��ʂ̃\���b�h�ƌ������A�Q��CSG.Connector�������ς݂ɂȂ�悤�ɂ���
	 *JP @param myConnector: �{�\���b�h��CSG.Connector
	 *JP @param otherConnector: myConnector�����������Ώۂ�CSG.Connector
	 *JP @param mirror: �U�Ȃ�R�l�N�^��`��`�x�N�g���͓����������w���A�^�Ȃ甽�Ό������w���B
	 *JP @param normalrotation: �Q�̃R�l�N�^��`�@��`�x�N�g���Ԃ̉�]�p�x
	 */
	public CSG connectTo(Connector myConnector, Connector otherConnector, boolean mirror, int normalrotation) {return null;}
	/**
	 *EN set the .shared property of all polygons
	 *EN Returns a new CSG solid, the original is unmodified!
	 *JP �S�Ẵ|���S����.shared�v���p�e�B�[���Z�b�g����
	 *JP �V����CSG�\���b�h��Ԃ��A���̃\���b�h�͕ύX����Ȃ��I
	 */
	public CSG setShared(Polygon.Shared shared) {return null;}
	/**
	 *EN @param {Array} color [red, green, blue] color values are float numbers 0..1
	 *EN @return {CSG} new CSG instance
	 *JP @param {Array} color [red, green, blue] �F�̒l�͂O����P�̏���
	 *JP @return {CSG} �V����CSG�C���X�^���X
	 */
	public CSG setColor(double red, double green, double blue, double alpha) {return null;}
	public Object toCompactBinary() {return null;}
	/**
	 *EN For debugging
	 *EN Creates a new solid with a tiny cube at every vertex of the source solid
	 *JP �f�o�b�O�p
	 *JP ���̃\���b�h�̊e���_�ɏ����ȗ����̂�z�u�����V�����\���b�h���쐬����
	 */
	public CSG toPointCloud(double cuberadius) {return null;}
	/**
	 *EN Get the transformation that transforms this CSG such that it is lying on the z=0 plane,
	 *EN as flat as possible (i.e. the least z-height).
	 *EN So that it is in an orientation suitable for CNC milling
	 *JP CGS��z=0���ʂɒu���Ăł��邾������ɂȂ�iz-�������ŏ��ɂȂ�j�悤�Ƀ\���b�h��ϊ�����ϊ��s��𓾂�B
	 *JP ���ʁACNC�؍�ɓK���������ɂȂ�
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

