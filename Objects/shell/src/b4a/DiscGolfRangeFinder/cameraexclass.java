
package b4a.DiscGolfRangeFinder;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class cameraexclass {
    public static RemoteObject myClass;
	public cameraexclass() {
	}
    public static PCBA staticBA = new PCBA(null, cameraexclass.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _nativecam = RemoteObject.declareNull("Object");
public static RemoteObject _cam = RemoteObject.declareNull("anywheresoftware.b4a.objects.CameraW");
public static RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
public static RemoteObject _target = RemoteObject.declareNull("Object");
public static RemoteObject _event = RemoteObject.createImmutable("");
public static RemoteObject _front = RemoteObject.createImmutable(false);
public static RemoteObject _parameters = RemoteObject.declareNull("Object");
public static b4a.DiscGolfRangeFinder.main _main = null;
public static b4a.DiscGolfRangeFinder.starter _starter = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"cam",_ref.getField(false, "_cam"),"event",_ref.getField(false, "_event"),"Front",_ref.getField(false, "_front"),"nativeCam",_ref.getField(false, "_nativecam"),"parameters",_ref.getField(false, "_parameters"),"r",_ref.getField(false, "_r"),"target",_ref.getField(false, "_target")};
}
}