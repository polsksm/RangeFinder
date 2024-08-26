
package b4a.DiscGolfRangeFinder;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.DiscGolfRangeFinder.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _phonesensors = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneSensors");
public static RemoteObject _frontcamera = RemoteObject.createImmutable(false);
public static RemoteObject _startpreviewtimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _m_angle = RemoteObject.createImmutable(0f);
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _m_ctldistance = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _m_ctlkup = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _m_ctlkdown = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _cam = RemoteObject.declareNull("anywheresoftware.b4a.objects.CameraW");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _camex = RemoteObject.declareNull("b4a.DiscGolfRangeFinder.cameraexclass");
public static b4a.DiscGolfRangeFinder.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"cam",main.mostCurrent._cam,"camEx",main.mostCurrent._camex,"frontCamera",main._frontcamera,"Label2",main.mostCurrent._label2,"Label4",main.mostCurrent._label4,"m_angle",main._m_angle,"m_ctlDistance",main.mostCurrent._m_ctldistance,"m_ctlKDown",main.mostCurrent._m_ctlkdown,"m_ctlKUp",main.mostCurrent._m_ctlkup,"Panel1",main.mostCurrent._panel1,"phoneSensors",main._phonesensors,"Starter",Debug.moduleToString(b4a.DiscGolfRangeFinder.starter.class),"startPreviewTimer",main._startpreviewtimer,"xui",main._xui};
}
}