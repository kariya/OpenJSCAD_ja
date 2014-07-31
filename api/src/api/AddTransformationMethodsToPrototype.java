package api;
import api.CSG;

/**
 *EN Add several convenience methods to the classes that support a transform() method:
 *JP いくつかの便利なメソッドをtransform()メソッドをサポートするクラスに追加する
 */
public class AddTransformationMethodsToPrototype {
	public CSG mirrored(CSG.Plane plane) {return null;}
	public CSG mirroredX() {return null;}
	public CSG mirroredY() {return null;}
	public CSG mirroredZ() {return null;}
	public CSG translate(CSG.Vector3D v) {return null;}
	public CSG translate(CSG.Vector2D v) {return null;}
	public CSG translate(double[] v) {return null;}
	public CSG scale(double f) {return null;}
	public CSG rotateX(double deg) {return null;}
	public CSG rotateY(double deg) {return null;}
	public CSG rotateZ(double deg) {return null;}
	public CSG rotate(double[] rotationCenter, double[] rotationAxis, double degrees) {return null;}
	public CSG rotate(CSG.Vector3D rotationCenter, CSG.Vector3D rotationAxis, double degrees) {return null;}
	public CSG rotate(CSG.Vector2D rotationCenter, CSG.Vector2D rotationAxis, double degrees) {return null;}
}
