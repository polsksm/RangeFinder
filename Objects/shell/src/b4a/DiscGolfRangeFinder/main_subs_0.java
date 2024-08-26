package b4a.DiscGolfRangeFinder;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
if (RapidSub.canDelegate("activity_create")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="Activity.LoadLayout(\"Layout\") ' Load the layout t";
Debug.ShouldStop(268435456);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 62;BA.debugLine="phoneSensors.Initialize(phoneSensors.TYPE_ACCELER";
Debug.ShouldStop(536870912);
main._phonesensors.runVoidMethod ("Initialize",(Object)(main._phonesensors.getField(true,"TYPE_ACCELEROMETER")));
 BA.debugLineNum = 63;BA.debugLine="m_ctlKUp.Text = 2.5";
Debug.ShouldStop(1073741824);
main.mostCurrent._m_ctlkup.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(2.5));
 BA.debugLineNum = 64;BA.debugLine="m_ctlKDown.Text = 0.5";
Debug.ShouldStop(-2147483648);
main.mostCurrent._m_ctlkdown.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(0.5));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("activity_pause")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 73;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="phoneSensors.StopListening()";
Debug.ShouldStop(512);
main._phonesensors.runVoidMethod ("StopListening",main.processBA);
 BA.debugLineNum = 75;BA.debugLine="Log(\"Stopped listening to phone sensors.\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1262146",RemoteObject.createImmutable("Stopped listening to phone sensors."),0);
 BA.debugLineNum = 76;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 77;BA.debugLine="Log(\"Stopping camera preview...\")";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1262148",RemoteObject.createImmutable("Stopping camera preview..."),0);
 BA.debugLineNum = 78;BA.debugLine="cam.StopPreview ' Stop the camera preview when t";
Debug.ShouldStop(8192);
main.mostCurrent._cam.runVoidMethod ("StopPreview");
 BA.debugLineNum = 79;BA.debugLine="cam.Release ' Release the camera when the activi";
Debug.ShouldStop(16384);
main.mostCurrent._cam.runVoidMethod ("Release");
 BA.debugLineNum = 80;BA.debugLine="Log(\"Camera released.\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1262151",RemoteObject.createImmutable("Camera released."),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e9) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e9.toString()); BA.debugLineNum = 82;BA.debugLine="Log(\"Error during camera release: \" & LastExcept";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1262153",RemoteObject.concat(RemoteObject.createImmutable("Error during camera release: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("activity_resume")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="InitializeCamera";
Debug.ShouldStop(8);
_initializecamera();
 BA.debugLineNum = 69;BA.debugLine="phoneSensors.StartListening(\"phoneSensors\")";
Debug.ShouldStop(16);
main._phonesensors.runVoidMethod ("StartListening",main.processBA,(Object)(RemoteObject.createImmutable("phoneSensors")));
 BA.debugLineNum = 70;BA.debugLine="Log(\"Started listening to phone sensors.\")";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1196611",RemoteObject.createImmutable("Started listening to phone sensors."),0);
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _camera1_ready(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Camera1_Ready (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("camera1_ready")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","camera1_ready", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 48;BA.debugLine="Sub Camera1_Ready(Success As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="If Success Then";
Debug.ShouldStop(65536);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 50;BA.debugLine="camEx.SetJpegQuality(90)";
Debug.ShouldStop(131072);
main.mostCurrent._camex.runClassMethod (b4a.DiscGolfRangeFinder.cameraexclass.class, "_setjpegquality" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, 90)));
 BA.debugLineNum = 51;BA.debugLine="camEx.SetContinuousAutoFocus";
Debug.ShouldStop(262144);
main.mostCurrent._camex.runClassMethod (b4a.DiscGolfRangeFinder.cameraexclass.class, "_setcontinuousautofocus" /*RemoteObject*/ );
 BA.debugLineNum = 52;BA.debugLine="camEx.CommitParameters";
Debug.ShouldStop(524288);
main.mostCurrent._camex.runClassMethod (b4a.DiscGolfRangeFinder.cameraexclass.class, "_commitparameters" /*RemoteObject*/ );
 BA.debugLineNum = 53;BA.debugLine="camEx.StartPreview";
Debug.ShouldStop(1048576);
main.mostCurrent._camex.runClassMethod (b4a.DiscGolfRangeFinder.cameraexclass.class, "_startpreview" /*RemoteObject*/ );
 BA.debugLineNum = 54;BA.debugLine="Log(camEx.GetPreviewSize)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","14390918",BA.ObjectToString(main.mostCurrent._camex.runClassMethod (b4a.DiscGolfRangeFinder.cameraexclass.class, "_getpreviewsize" /*RemoteObject*/ )),0);
 }else {
 BA.debugLineNum = 56;BA.debugLine="ToastMessageShow(\"Cannot open camera.\", True)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Cannot open camera.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _displayeffectivedistance() throws Exception{
try {
		Debug.PushSubsStack("displayEffectiveDistance (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("displayeffectivedistance")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","displayeffectivedistance");}
RemoteObject _k_up = RemoteObject.createImmutable(0f);
RemoteObject _k_down = RemoteObject.createImmutable(0f);
RemoteObject _eff_distance = RemoteObject.createImmutable(0f);
RemoteObject _distance = RemoteObject.createImmutable(0f);
RemoteObject _angle_rad = RemoteObject.createImmutable(0f);
 BA.debugLineNum = 102;BA.debugLine="Sub displayEffectiveDistance()";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Dim k_up As Float";
Debug.ShouldStop(64);
_k_up = RemoteObject.createImmutable(0f);Debug.locals.put("k_up", _k_up);
 BA.debugLineNum = 104;BA.debugLine="Dim k_down As Float";
Debug.ShouldStop(128);
_k_down = RemoteObject.createImmutable(0f);Debug.locals.put("k_down", _k_down);
 BA.debugLineNum = 105;BA.debugLine="Dim eff_distance As Float";
Debug.ShouldStop(256);
_eff_distance = RemoteObject.createImmutable(0f);Debug.locals.put("eff_distance", _eff_distance);
 BA.debugLineNum = 106;BA.debugLine="Dim distance As Float";
Debug.ShouldStop(512);
_distance = RemoteObject.createImmutable(0f);Debug.locals.put("distance", _distance);
 BA.debugLineNum = 107;BA.debugLine="Dim angle_rad As Float = m_angle * (cPI / 180.0)";
Debug.ShouldStop(1024);
_angle_rad = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {main._m_angle,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.getField(true,"cPI"),RemoteObject.createImmutable(180.0)}, "/",0, 0))}, "*",0, 0));Debug.locals.put("angle_rad", _angle_rad);Debug.locals.put("angle_rad", _angle_rad);
 BA.debugLineNum = 109;BA.debugLine="If (m_ctlDistance.Text.Length < 1) Then Return";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("<",main.mostCurrent._m_ctldistance.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 1)))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 110;BA.debugLine="distance = m_ctlDistance.Text";
Debug.ShouldStop(8192);
_distance = BA.numberCast(float.class, main.mostCurrent._m_ctldistance.runMethod(true,"getText"));Debug.locals.put("distance", _distance);
 BA.debugLineNum = 113;BA.debugLine="distance = m_ctlDistance.Text.Trim ' Ensure there";
Debug.ShouldStop(65536);
_distance = BA.numberCast(float.class, main.mostCurrent._m_ctldistance.runMethod(true,"getText").runMethod(true,"trim"));Debug.locals.put("distance", _distance);
 BA.debugLineNum = 115;BA.debugLine="If IsNumber(distance) Then";
Debug.ShouldStop(262144);
if (main.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(BA.NumberToString(_distance))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 116;BA.debugLine="distance = distance ' Text is already a number i";
Debug.ShouldStop(524288);
_distance = _distance;Debug.locals.put("distance", _distance);
 }else {
 BA.debugLineNum = 118;BA.debugLine="Log(\"Invalid distance value\")";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1458768",RemoteObject.createImmutable("Invalid distance value"),0);
 BA.debugLineNum = 119;BA.debugLine="Return ' Exit the sub if the distance is not a v";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 122;BA.debugLine="k_up = m_ctlKUp.Text";
Debug.ShouldStop(33554432);
_k_up = BA.numberCast(float.class, main.mostCurrent._m_ctlkup.runMethod(true,"getText"));Debug.locals.put("k_up", _k_up);
 BA.debugLineNum = 123;BA.debugLine="k_down = m_ctlKDown.Text";
Debug.ShouldStop(67108864);
_k_down = BA.numberCast(float.class, main.mostCurrent._m_ctlkdown.runMethod(true,"getText"));Debug.locals.put("k_down", _k_down);
 BA.debugLineNum = 125;BA.debugLine="If (m_angle >= 0.0) Then";
Debug.ShouldStop(268435456);
if ((RemoteObject.solveBoolean("g",main._m_angle,BA.numberCast(double.class, 0.0)))) { 
 BA.debugLineNum = 126;BA.debugLine="eff_distance = distance * (Cos(angle_rad) + k_up";
Debug.ShouldStop(536870912);
_eff_distance = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_distance,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"Cos",(Object)(BA.numberCast(double.class, _angle_rad))),_k_up,main.mostCurrent.__c.runMethod(true,"Sin",(Object)(BA.numberCast(double.class, _angle_rad)))}, "+*",1, 0))}, "*",0, 0));Debug.locals.put("eff_distance", _eff_distance);
 }else {
 BA.debugLineNum = 128;BA.debugLine="eff_distance = distance * (Cos(angle_rad) + k_do";
Debug.ShouldStop(-2147483648);
_eff_distance = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_distance,(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"Cos",(Object)(BA.numberCast(double.class, _angle_rad))),_k_down,main.mostCurrent.__c.runMethod(true,"Sin",(Object)(BA.numberCast(double.class, _angle_rad)))}, "+*",1, 0))}, "*",0, 0));Debug.locals.put("eff_distance", _eff_distance);
 };
 BA.debugLineNum = 131;BA.debugLine="Label2.Text = \"Effective Distance: \" & NumberForm";
Debug.ShouldStop(4);
main.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Effective Distance: "),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _eff_distance)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable(" ft"))));
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Dim m_angle As Float";
main._m_angle = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 27;BA.debugLine="Private Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Label4 As Label";
main.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private m_ctlDistance As EditText";
main.mostCurrent._m_ctldistance = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private m_ctlKUp As EditText";
main.mostCurrent._m_ctlkup = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private m_ctlKDown As EditText";
main.mostCurrent._m_ctlkdown = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private cam As Camera";
main.mostCurrent._cam = RemoteObject.createNew ("anywheresoftware.b4a.objects.CameraW");
 //BA.debugLineNum = 33;BA.debugLine="Private Panel1 As Panel ' Use Panel instead of Su";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private camEx As CameraExClass";
main.mostCurrent._camex = RemoteObject.createNew ("b4a.DiscGolfRangeFinder.cameraexclass");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _initializecamera() throws Exception{
try {
		Debug.PushSubsStack("InitializeCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("initializecamera")) { b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","initializecamera"); return;}
ResumableSub_InitializeCamera rsub = new ResumableSub_InitializeCamera(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_InitializeCamera extends BA.ResumableSub {
public ResumableSub_InitializeCamera(b4a.DiscGolfRangeFinder.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.DiscGolfRangeFinder.main parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("InitializeCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 38;BA.debugLine="Starter.rp.CheckAndRequest(Starter.rp.PERMISSION_";
Debug.ShouldStop(32);
parent.mostCurrent._starter._rp /*RemoteObject*/ .runVoidMethod ("CheckAndRequest",main.processBA,(Object)(parent.mostCurrent._starter._rp /*RemoteObject*/ .getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 39;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "initializecamera"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 40;BA.debugLine="If Result Then";
Debug.ShouldStop(128);
if (true) break;

case 1:
//if
this.state = 6;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 41;BA.debugLine="camEx.Initialize(Panel1, frontCamera, Me, \"Camer";
Debug.ShouldStop(256);
parent.mostCurrent._camex.runClassMethod (b4a.DiscGolfRangeFinder.cameraexclass.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(parent.mostCurrent._panel1),(Object)(parent._frontcamera),(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("Camera1")));
 BA.debugLineNum = 42;BA.debugLine="frontCamera = camEx.Front";
Debug.ShouldStop(512);
parent._frontcamera = parent.mostCurrent._camex.getField(true,"_front" /*RemoteObject*/ );
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 44;BA.debugLine="ToastMessageShow(\"No permission!!!\", True)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!!!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _panel1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("Panel1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,97);
if (RapidSub.canDelegate("panel1_touch")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","panel1_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 97;BA.debugLine="Sub Panel1_Touch (Action As Int, X As Float, Y As";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="Label4.Text = \"Angle: \" & m_angle";
Debug.ShouldStop(2);
main.mostCurrent._label4.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Angle: "),main._m_angle)));
 BA.debugLineNum = 99;BA.debugLine="displayEffectiveDistance";
Debug.ShouldStop(4);
_displayeffectivedistance();
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _phonesensors_sensorchanged(RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("phoneSensors_SensorChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("phonesensors_sensorchanged")) { return b4a.DiscGolfRangeFinder.main.remoteMe.runUserSub(false, "main","phonesensors_sensorchanged", _values);}
RemoteObject _x = RemoteObject.createImmutable(0f);
RemoteObject _y = RemoteObject.createImmutable(0f);
RemoteObject _z = RemoteObject.createImmutable(0f);
Debug.locals.put("Values", _values);
 BA.debugLineNum = 86;BA.debugLine="Sub phoneSensors_SensorChanged (Values() As Float)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 88;BA.debugLine="Dim x As Float = Values(0)";
Debug.ShouldStop(8388608);
_x = _values.getArrayElement(true,BA.numberCast(int.class, 0));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
 BA.debugLineNum = 89;BA.debugLine="Dim y As Float = Values(1)";
Debug.ShouldStop(16777216);
_y = _values.getArrayElement(true,BA.numberCast(int.class, 1));Debug.locals.put("y", _y);Debug.locals.put("y", _y);
 BA.debugLineNum = 90;BA.debugLine="Dim z As Float = Values(2)";
Debug.ShouldStop(33554432);
_z = _values.getArrayElement(true,BA.numberCast(int.class, 2));Debug.locals.put("z", _z);Debug.locals.put("z", _z);
 BA.debugLineNum = 93;BA.debugLine="m_angle = ATan2(y, Sqrt(x * x + z * z)) * (180 /";
Debug.ShouldStop(268435456);
main._m_angle = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"ATan2",(Object)(BA.numberCast(double.class, _y)),(Object)(main.mostCurrent.__c.runMethod(true,"Sqrt",(Object)(RemoteObject.solve(new RemoteObject[] {_x,_x,_z,_z}, "*+*",1, 0))))),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(180),main.mostCurrent.__c.getField(true,"cPI")}, "/",0, 0))}, "*",0, 0));
 BA.debugLineNum = 94;BA.debugLine="Log(\"Tilt Angle: \" & m_angle & \" degrees\")";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1524296",RemoteObject.concat(RemoteObject.createImmutable("Tilt Angle: "),main._m_angle,RemoteObject.createImmutable(" degrees")),0);
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.DiscGolfRangeFinder.main");
starter.myClass = BA.getDeviceClass ("b4a.DiscGolfRangeFinder.starter");
cameraexclass.myClass = BA.getDeviceClass ("b4a.DiscGolfRangeFinder.cameraexclass");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Private phoneSensors As PhoneSensors";
main._phonesensors = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneSensors");
 //BA.debugLineNum = 20;BA.debugLine="Private frontCamera As Boolean = False";
main._frontcamera = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 21;BA.debugLine="Private startPreviewTimer As Timer";
main._startpreviewtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}