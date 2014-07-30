package api;

import api.CSG.Matrix4x4;
import api.CSG.Path2D;
import api.CSG.Polygon;
import api.CSG.Vector2D;

/**
 *EN CAG: solid area geometry: like CSG but 2D
 *EN Each area consists of a number of sides
 *EN Each side is a line between 2 points
 *JP CAG: �\���b�h�̈�􉽁FCSG���l�����QD
 *JP �e�̈�͉�(side)������
 *JP �e���͂Q�_�Ԃ̒����ł���B
 */
public class CAG extends AddTransformationMethodsToPrototype {

	/**
	 *EN Construct a CAG from a list of `CAG.Side` instances.
	 *JP `CAG.Side`�C���X�^���X�̃��X�g����CAG���\������B
	 */
	public static CAG fromSides(Side[] sides) {return null;}
	//public static CAG fromPoints(points) {return null;}
	//public static CAG fromPointsNoCheck(points) {return null;}
	/**
	 *EN Converts a CSG to a CAG. The CSG must consist of polygons with only z coordinates +1 and -1
	 *EN as constructed by CAG.toCSG(-1, 1). This is so we can use the 3D union(), intersect() etc
	 *JP CSG��CAG�ɕϊ�����BCSG��CAG.toCSG(-1,1)�ō쐬���ꂽ�悤��z���W�݂̂�+1��-1�̃|���S���Ɋ܂܂�Ȃ���΂Ȃ�Ȃ��B
	 *JP ���̂��Ƃ͂RD��union()��intersect()�Ȃǂ��g���ꍇ�����藧�B
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
	 *JP �~���\������F
	 *JP   �I�v�V����:
	 *JP	 center: �QD�̒��S�_
	 *JP	 radius: �X�J���[�l
	 *JP	 resolution: �R�U�O�x��]������̉��̐�
	 *JP  CAG�I�u�W�F�N�g��Ԃ�
	 */
	public static CAG circle(Object options) {return null; }
	/**
	 *EN Construct a rectangle
	 *EN   options:
	 *EN	 center: a 2D center point
	 *EN	 radius: a 2D vector with width and height
	 *EN   returns a CAG object
	 *JP �����`���\������F
	 *JP   �I�v�V����:
	 *JP	 center: �QD�̒��S�_
	 *JP	 radius: ���ƍ�������Ȃ�QD�x�N�g��
	 *JP  CAG�I�u�W�F�N�g��Ԃ�
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

	}

	public static class Polygon2D  {

	}



}

