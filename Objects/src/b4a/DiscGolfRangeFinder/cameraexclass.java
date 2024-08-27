package b4a.DiscGolfRangeFinder;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class cameraexclass extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.DiscGolfRangeFinder.cameraexclass");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.DiscGolfRangeFinder.cameraexclass.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public Object _nativecam = null;
public anywheresoftware.b4a.objects.CameraW _cam = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
public Object _target = null;
public String _event = "";
public boolean _front = false;
public Object _parameters = null;
public b4a.DiscGolfRangeFinder.main _main = null;
public b4a.DiscGolfRangeFinder.starter _starter = null;
public static class _camerainfoandid{
public boolean IsInitialized;
public Object CameraInfo;
public int Id;
public void Initialize() {
IsInitialized = true;
CameraInfo = new Object();
Id = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _camerasize{
public boolean IsInitialized;
public int Width;
public int Height;
public void Initialize() {
IsInitialized = true;
Width = 0;
Height = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _camera_focusdone(boolean _success) throws Exception{
 //BA.debugLineNum = 362;BA.debugLine="Private Sub Camera_FocusDone (Success As Boolean)";
 //BA.debugLineNum = 363;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 364;BA.debugLine="TakePicture";
_takepicture();
 }else {
 //BA.debugLineNum = 366;BA.debugLine="Log(\"AutoFocus error.\")";
__c.LogImpl("63538948","AutoFocus error.",0);
 };
 //BA.debugLineNum = 368;BA.debugLine="End Sub";
return "";
}
public String  _camera_picturetaken(byte[] _data) throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Private Sub Camera_PictureTaken (Data() As Byte)";
 //BA.debugLineNum = 151;BA.debugLine="CallSub2(target, event & \"_PictureTaken\", Data)";
__c.CallSubNew2(ba,_target,_event+"_PictureTaken",(Object)(_data));
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public String  _camera_ready(boolean _success) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Private Sub Camera_Ready (Success As Boolean)";
 //BA.debugLineNum = 128;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 129;BA.debugLine="r.target = cam";
_r.Target = (Object)(_cam);
 //BA.debugLineNum = 130;BA.debugLine="nativeCam = r.GetField(\"camera\")";
_nativecam = _r.GetField("camera");
 //BA.debugLineNum = 131;BA.debugLine="r.target = nativeCam";
_r.Target = _nativecam;
 //BA.debugLineNum = 132;BA.debugLine="parameters = r.RunMethod(\"getParameters\")";
_parameters = _r.RunMethod("getParameters");
 //BA.debugLineNum = 133;BA.debugLine="SetDisplayOrientation";
_setdisplayorientation();
 }else {
 //BA.debugLineNum = 135;BA.debugLine="Log(\"success = false, \" & LastException)";
__c.LogImpl("61310728","success = false, "+BA.ObjectToString(__c.LastException(ba)),0);
 };
 //BA.debugLineNum = 137;BA.debugLine="CallSub2(target, event & \"_ready\", Success)";
__c.CallSubNew2(ba,_target,_event+"_ready",(Object)(_success));
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private nativeCam As Object";
_nativecam = new Object();
 //BA.debugLineNum = 8;BA.debugLine="Private cam As Camera";
_cam = new anywheresoftware.b4a.objects.CameraW();
 //BA.debugLineNum = 9;BA.debugLine="Private r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 10;BA.debugLine="Private target As Object";
_target = new Object();
 //BA.debugLineNum = 11;BA.debugLine="Private event As String";
_event = "";
 //BA.debugLineNum = 12;BA.debugLine="Public Front As Boolean";
_front = false;
 //BA.debugLineNum = 13;BA.debugLine="Type CameraInfoAndId (CameraInfo As Object, Id As";
;
 //BA.debugLineNum = 14;BA.debugLine="Type CameraSize (Width As Int, Height As Int)";
;
 //BA.debugLineNum = 15;BA.debugLine="Private parameters As Object";
_parameters = new Object();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public String  _closenow() throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Public Sub CloseNow";
 //BA.debugLineNum = 352;BA.debugLine="cam.Release";
_cam.Release();
 //BA.debugLineNum = 353;BA.debugLine="r.target = cam";
_r.Target = (Object)(_cam);
 //BA.debugLineNum = 354;BA.debugLine="r.RunMethod2(\"releaseCameras\", True, \"java.lang.b";
_r.RunMethod2("releaseCameras",BA.ObjectToString(__c.True),"java.lang.boolean");
 //BA.debugLineNum = 355;BA.debugLine="End Sub";
return "";
}
public String  _commitparameters() throws Exception{
 //BA.debugLineNum = 183;BA.debugLine="Public Sub CommitParameters";
 //BA.debugLineNum = 185;BA.debugLine="r.target = nativeCam";
_r.Target = _nativecam;
 //BA.debugLineNum = 186;BA.debugLine="r.RunMethod4(\"setParameters\", Array As Object(pa";
_r.RunMethod4("setParameters",new Object[]{_parameters},new String[]{"android.hardware.Camera$Parameters"});
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public Object  _facedetection_event(String _methodname,Object[] _args) throws Exception{
Object[] _faces = null;
Object _f = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _facerect = null;
 //BA.debugLineNum = 416;BA.debugLine="Private Sub FaceDetection_Event (MethodName As Str";
 //BA.debugLineNum = 417;BA.debugLine="Dim faces() As Object = Args(0)";
_faces = (Object[])(_args[(int) (0)]);
 //BA.debugLineNum = 418;BA.debugLine="For Each f As Object In faces";
{
final Object[] group2 = _faces;
final int groupLen2 = group2.length
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_f = group2[index2];
 //BA.debugLineNum = 419;BA.debugLine="Dim jo As JavaObject = f";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_f));
 //BA.debugLineNum = 420;BA.debugLine="Dim faceRect As Rect = jo.GetField(\"rect\")";
_facerect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
_facerect = (anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper(), (android.graphics.Rect)(_jo.GetField("rect")));
 //BA.debugLineNum = 421;BA.debugLine="Log(faceRect)";
__c.LogImpl("64194309",BA.ObjectToString(_facerect),0);
 }
};
 //BA.debugLineNum = 423;BA.debugLine="Return Null";
if (true) return __c.Null;
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return null;
}
public b4a.DiscGolfRangeFinder.cameraexclass._camerainfoandid  _findcamera(boolean _frontcamera) throws Exception{
b4a.DiscGolfRangeFinder.cameraexclass._camerainfoandid _ci = null;
Object _camerainfo = null;
int _cameravalue = 0;
int _numberofcameras = 0;
int _i = 0;
 //BA.debugLineNum = 60;BA.debugLine="Private Sub FindCamera(frontCamera As Boolean) As";
 //BA.debugLineNum = 61;BA.debugLine="Dim ci As CameraInfoAndId";
_ci = new b4a.DiscGolfRangeFinder.cameraexclass._camerainfoandid();
 //BA.debugLineNum = 62;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 63;BA.debugLine="Dim cameraInfo As Object";
_camerainfo = new Object();
 //BA.debugLineNum = 64;BA.debugLine="Dim cameraValue As Int";
_cameravalue = 0;
 //BA.debugLineNum = 65;BA.debugLine="Log(\"findCamera\")";
__c.LogImpl("61179653","findCamera",0);
 //BA.debugLineNum = 67;BA.debugLine="If frontCamera Then";
if (_frontcamera) { 
 //BA.debugLineNum = 68;BA.debugLine="cameraValue = 1";
_cameravalue = (int) (1);
 }else {
 //BA.debugLineNum = 70;BA.debugLine="cameraValue = 0";
_cameravalue = (int) (0);
 };
 //BA.debugLineNum = 73;BA.debugLine="cameraInfo = r.CreateObject(\"android.hardware.Cam";
_camerainfo = _r.CreateObject("android.hardware.Camera$CameraInfo");
 //BA.debugLineNum = 74;BA.debugLine="Dim numberOfCameras As Int = r.RunStaticMethod(\"a";
_numberofcameras = (int)(BA.ObjectToNumber(_r.RunStaticMethod("android.hardware.Camera","getNumberOfCameras",(Object[])(__c.Null),(String[])(__c.Null))));
 //BA.debugLineNum = 76;BA.debugLine="Log(\"Number of Cameras: \" & numberOfCameras)";
__c.LogImpl("61179664","Number of Cameras: "+BA.NumberToString(_numberofcameras),0);
 //BA.debugLineNum = 78;BA.debugLine="For i = 0 To numberOfCameras - 1";
{
final int step14 = 1;
final int limit14 = (int) (_numberofcameras-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
 //BA.debugLineNum = 79;BA.debugLine="r.RunStaticMethod(\"android.hardware.Camera\", \"ge";
_r.RunStaticMethod("android.hardware.Camera","getCameraInfo",new Object[]{(Object)(_i),_camerainfo},new String[]{"java.lang.int","android.hardware.Camera$CameraInfo"});
 //BA.debugLineNum = 82;BA.debugLine="r.target = cameraInfo";
_r.Target = _camerainfo;
 //BA.debugLineNum = 83;BA.debugLine="Log(\"r.target: \" & r.target)";
__c.LogImpl("61179671","r.target: "+BA.ObjectToString(_r.Target),0);
 //BA.debugLineNum = 85;BA.debugLine="If r.target <> Null Then";
if (_r.Target!= null) { 
 //BA.debugLineNum = 86;BA.debugLine="Log(\"facing: \" & r.GetField(\"facing\") & \" , cam";
__c.LogImpl("61179674","facing: "+BA.ObjectToString(_r.GetField("facing"))+" , cameraValue: "+BA.NumberToString(_cameravalue),0);
 //BA.debugLineNum = 87;BA.debugLine="If r.GetField(\"facing\") = cameraValue Then";
if ((_r.GetField("facing")).equals((Object)(_cameravalue))) { 
 //BA.debugLineNum = 88;BA.debugLine="ci.cameraInfo = r.target";
_ci.CameraInfo /*Object*/  = _r.Target;
 //BA.debugLineNum = 89;BA.debugLine="ci.id = i";
_ci.Id /*int*/  = _i;
 //BA.debugLineNum = 90;BA.debugLine="Return ci";
if (true) return _ci;
 };
 }else {
 //BA.debugLineNum = 93;BA.debugLine="Log(\"cameraInfo is null\")";
__c.LogImpl("61179681","cameraInfo is null",0);
 };
 }
};
 //BA.debugLineNum = 97;BA.debugLine="ci.id = -1";
_ci.Id /*int*/  = (int) (-1);
 //BA.debugLineNum = 98;BA.debugLine="Return ci";
if (true) return _ci;
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return null;
}
public String  _focusandtakepicture() throws Exception{
 //BA.debugLineNum = 357;BA.debugLine="Public Sub FocusAndTakePicture";
 //BA.debugLineNum = 358;BA.debugLine="cam.AutoFocus";
_cam.AutoFocus();
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public String  _getcoloreffect() throws Exception{
 //BA.debugLineNum = 193;BA.debugLine="Public Sub GetColorEffect As String";
 //BA.debugLineNum = 194;BA.debugLine="Return GetParameter(\"effect\")";
if (true) return _getparameter("effect");
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public int  _getexposurecompensation() throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Public Sub getExposureCompensation As Int";
 //BA.debugLineNum = 391;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 392;BA.debugLine="Return r.RunMethod(\"getExposureCompensation\")";
if (true) return (int)(BA.ObjectToNumber(_r.RunMethod("getExposureCompensation")));
 //BA.debugLineNum = 393;BA.debugLine="End Sub";
return 0;
}
public String  _getflashmode() throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Public Sub GetFlashMode As String";
 //BA.debugLineNum = 245;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 246;BA.debugLine="Return r.RunMethod(\"getFlashMode\")";
if (true) return BA.ObjectToString(_r.RunMethod("getFlashMode"));
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public float[]  _getfocusdistances() throws Exception{
float[] _f = null;
 //BA.debugLineNum = 338;BA.debugLine="Public Sub GetFocusDistances As Float()";
 //BA.debugLineNum = 339;BA.debugLine="Dim F(3) As Float";
_f = new float[(int) (3)];
;
 //BA.debugLineNum = 340;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 341;BA.debugLine="r.RunMethod4(\"getFocusDistances\", Array As Object";
_r.RunMethod4("getFocusDistances",new Object[]{(Object)(_f)},new String[]{"[F"});
 //BA.debugLineNum = 342;BA.debugLine="Return F";
if (true) return _f;
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return null;
}
public int  _getmaxexposurecompensation() throws Exception{
 //BA.debugLineNum = 405;BA.debugLine="Public Sub getMaxExposureCompensation As Int";
 //BA.debugLineNum = 406;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 407;BA.debugLine="Return r.RunMethod(\"getMaxExposureCompensation\")";
if (true) return (int)(BA.ObjectToNumber(_r.RunMethod("getMaxExposureCompensation")));
 //BA.debugLineNum = 408;BA.debugLine="End Sub";
return 0;
}
public int  _getmaxzoom() throws Exception{
 //BA.debugLineNum = 375;BA.debugLine="Public Sub GetMaxZoom As Int";
 //BA.debugLineNum = 376;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 377;BA.debugLine="Return r.RunMethod(\"getMaxZoom\")";
if (true) return (int)(BA.ObjectToNumber(_r.RunMethod("getMaxZoom")));
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return 0;
}
public int  _getminexposurecompensation() throws Exception{
 //BA.debugLineNum = 400;BA.debugLine="Public Sub getMinExposureCompensation As Int";
 //BA.debugLineNum = 401;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 402;BA.debugLine="Return r.RunMethod(\"getMinExposureCompensation\")";
if (true) return (int)(BA.ObjectToNumber(_r.RunMethod("getMinExposureCompensation")));
 //BA.debugLineNum = 403;BA.debugLine="End Sub";
return 0;
}
public String  _getparameter(String _key) throws Exception{
 //BA.debugLineNum = 178;BA.debugLine="Public Sub GetParameter(Key As String) As String";
 //BA.debugLineNum = 179;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 180;BA.debugLine="Return r.RunMethod2(\"get\", Key, \"java.lang.String";
if (true) return BA.ObjectToString(_r.RunMethod2("get",_key,"java.lang.String"));
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return "";
}
public b4a.DiscGolfRangeFinder.cameraexclass._camerasize  _getpicturesize() throws Exception{
b4a.DiscGolfRangeFinder.cameraexclass._camerasize _cs = null;
 //BA.debugLineNum = 286;BA.debugLine="Public Sub GetPictureSize As CameraSize";
 //BA.debugLineNum = 287;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 288;BA.debugLine="r.target = r.RunMethod(\"getPictureSize\")";
_r.Target = _r.RunMethod("getPictureSize");
 //BA.debugLineNum = 289;BA.debugLine="Dim cs As CameraSize";
_cs = new b4a.DiscGolfRangeFinder.cameraexclass._camerasize();
 //BA.debugLineNum = 290;BA.debugLine="cs.Width = r.GetField(\"width\")";
_cs.Width /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 291;BA.debugLine="cs.Height = r.GetField(\"height\")";
_cs.Height /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("height")));
 //BA.debugLineNum = 292;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return null;
}
public String  _getpreviewfpsrange(int[] _range) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Public Sub GetPreviewFpsRange(Range() As Int)";
 //BA.debugLineNum = 267;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 268;BA.debugLine="r.RunMethod4(\"getPreviewFpsRange\", Array As Objec";
_r.RunMethod4("getPreviewFpsRange",new Object[]{(Object)(_range)},new String[]{"[I"});
 //BA.debugLineNum = 269;BA.debugLine="End Sub";
return "";
}
public b4a.DiscGolfRangeFinder.cameraexclass._camerasize  _getpreviewsize() throws Exception{
b4a.DiscGolfRangeFinder.cameraexclass._camerasize _cs = null;
 //BA.debugLineNum = 277;BA.debugLine="Public Sub GetPreviewSize As CameraSize";
 //BA.debugLineNum = 278;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 279;BA.debugLine="r.target = r.RunMethod(\"getPreviewSize\")";
_r.Target = _r.RunMethod("getPreviewSize");
 //BA.debugLineNum = 280;BA.debugLine="Dim cs As CameraSize";
_cs = new b4a.DiscGolfRangeFinder.cameraexclass._camerasize();
 //BA.debugLineNum = 281;BA.debugLine="cs.Width = r.GetField(\"width\")";
_cs.Width /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 282;BA.debugLine="cs.Height = r.GetField(\"height\")";
_cs.Height /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("height")));
 //BA.debugLineNum = 283;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedcoloreffects() throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Public Sub GetSupportedColorEffects As List";
 //BA.debugLineNum = 255;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 256;BA.debugLine="Return r.RunMethod(\"getSupportedColorEffects\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedColorEffects")));
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedflashmodes() throws Exception{
 //BA.debugLineNum = 249;BA.debugLine="Public Sub GetSupportedFlashModes As List";
 //BA.debugLineNum = 250;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 251;BA.debugLine="Return r.RunMethod(\"getSupportedFlashModes\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedFlashModes")));
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedfocusmodes() throws Exception{
 //BA.debugLineNum = 317;BA.debugLine="Public Sub GetSupportedFocusModes As List";
 //BA.debugLineNum = 318;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 319;BA.debugLine="Return r.RunMethod(\"getSupportedFocusModes\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedFocusModes")));
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedpictureformats() throws Exception{
 //BA.debugLineNum = 345;BA.debugLine="Public Sub GetSupportedPictureFormats As List";
 //BA.debugLineNum = 346;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 347;BA.debugLine="Return r.RunMethod(\"getSupportedPictureFormats";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedPictureFormats")));
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return null;
}
public b4a.DiscGolfRangeFinder.cameraexclass._camerasize[]  _getsupportedpicturessizes() throws Exception{
anywheresoftware.b4a.objects.collections.List _list1 = null;
b4a.DiscGolfRangeFinder.cameraexclass._camerasize[] _cs = null;
int _i = 0;
 //BA.debugLineNum = 217;BA.debugLine="Public Sub GetSupportedPicturesSizes As CameraSize";
 //BA.debugLineNum = 218;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 219;BA.debugLine="Dim list1 As List = r.RunMethod(\"getSupportedPict";
_list1 = new anywheresoftware.b4a.objects.collections.List();
_list1 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedPictureSizes")));
 //BA.debugLineNum = 220;BA.debugLine="Dim cs(list1.Size) As CameraSize";
_cs = new b4a.DiscGolfRangeFinder.cameraexclass._camerasize[_list1.getSize()];
{
int d0 = _cs.length;
for (int i0 = 0;i0 < d0;i0++) {
_cs[i0] = new b4a.DiscGolfRangeFinder.cameraexclass._camerasize();
}
}
;
 //BA.debugLineNum = 221;BA.debugLine="For i = 0 To list1.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_list1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 222;BA.debugLine="r.target = list1.get(i)";
_r.Target = _list1.Get(_i);
 //BA.debugLineNum = 223;BA.debugLine="cs(i).Width = r.GetField(\"width\")";
_cs[_i].Width /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 224;BA.debugLine="cs(i).Height = r.GetField(\"height\")";
_cs[_i].Height /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("height")));
 }
};
 //BA.debugLineNum = 226;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 227;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedpreviewfpsrange() throws Exception{
 //BA.debugLineNum = 260;BA.debugLine="Public Sub GetSupportedPreviewFpsRange As List";
 //BA.debugLineNum = 261;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 262;BA.debugLine="Return r.RunMethod(\"getSupportedPreviewFpsRange\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedPreviewFpsRange")));
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return null;
}
public b4a.DiscGolfRangeFinder.cameraexclass._camerasize[]  _getsupportedpreviewsizes() throws Exception{
anywheresoftware.b4a.objects.collections.List _list1 = null;
b4a.DiscGolfRangeFinder.cameraexclass._camerasize[] _cs = null;
int _i = 0;
 //BA.debugLineNum = 201;BA.debugLine="Public Sub GetSupportedPreviewSizes As CameraSize(";
 //BA.debugLineNum = 202;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 203;BA.debugLine="Dim list1 As List = r.RunMethod(\"getSupportedPrev";
_list1 = new anywheresoftware.b4a.objects.collections.List();
_list1 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedPreviewSizes")));
 //BA.debugLineNum = 204;BA.debugLine="Dim cs(list1.Size) As CameraSize";
_cs = new b4a.DiscGolfRangeFinder.cameraexclass._camerasize[_list1.getSize()];
{
int d0 = _cs.length;
for (int i0 = 0;i0 < d0;i0++) {
_cs[i0] = new b4a.DiscGolfRangeFinder.cameraexclass._camerasize();
}
}
;
 //BA.debugLineNum = 205;BA.debugLine="For i = 0 To list1.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_list1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 206;BA.debugLine="r.target = list1.get(i)";
_r.Target = _list1.Get(_i);
 //BA.debugLineNum = 207;BA.debugLine="cs(i).Width = r.GetField(\"width\")";
_cs[_i].Width /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 208;BA.debugLine="cs(i).Height = r.GetField(\"height\")";
_cs[_i].Height /*int*/  = (int)(BA.ObjectToNumber(_r.GetField("height")));
 }
};
 //BA.debugLineNum = 210;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return null;
}
public int  _getzoom() throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Public Sub getZoom() As Int";
 //BA.debugLineNum = 381;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 382;BA.debugLine="Return r.RunMethod(\"getZoom\")";
if (true) return (int)(BA.ObjectToNumber(_r.RunMethod("getZoom")));
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _panel1,boolean _frontcamera,Object _targetmodule,String _eventname) throws Exception{
innerInitialize(_ba);
int _id = 0;
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize (Panel1 As Panel, FrontCamer";
 //BA.debugLineNum = 19;BA.debugLine="target = TargetModule";
_target = _targetmodule;
 //BA.debugLineNum = 20;BA.debugLine="event = EventName";
_event = _eventname;
 //BA.debugLineNum = 21;BA.debugLine="Front = FrontCamera";
_front = _frontcamera;
 //BA.debugLineNum = 22;BA.debugLine="Dim id As Int";
_id = 0;
 //BA.debugLineNum = 23;BA.debugLine="id = FindCamera(Front).id";
_id = _findcamera(_front).Id /*int*/ ;
 //BA.debugLineNum = 24;BA.debugLine="If id = -1 Then";
if (_id==-1) { 
 //BA.debugLineNum = 25;BA.debugLine="Front = Not(Front) 'try different camera";
_front = __c.Not(_front);
 //BA.debugLineNum = 26;BA.debugLine="id = FindCamera(Front).id";
_id = _findcamera(_front).Id /*int*/ ;
 //BA.debugLineNum = 27;BA.debugLine="If id = -1 Then";
if (_id==-1) { 
 //BA.debugLineNum = 28;BA.debugLine="ToastMessageShow(\"No camera found.\", True)";
__c.ToastMessageShow(BA.ObjectToCharSequence("No camera found."),__c.True);
 //BA.debugLineNum = 29;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 32;BA.debugLine="cam.Initialize2(Panel1, \"camera\", id)";
_cam.Initialize2(ba,(android.view.ViewGroup)(_panel1.getObject()),"camera",_id);
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public boolean  _iszoomsupported() throws Exception{
 //BA.debugLineNum = 370;BA.debugLine="Public Sub IsZoomSupported As Boolean";
 //BA.debugLineNum = 371;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 372;BA.debugLine="Return r.RunMethod(\"isZoomSupported\")";
if (true) return BA.ObjectToBoolean(_r.RunMethod("isZoomSupported"));
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return false;
}
public byte[]  _previewimagetojpeg(byte[] _data,int _quality) throws Exception{
Object _size = null;
Object _previewformat = null;
int _width = 0;
int _height = 0;
Object _yuvimage = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 297;BA.debugLine="Public Sub PreviewImageToJpeg(data() As Byte, qual";
 //BA.debugLineNum = 298;BA.debugLine="Dim size, previewFormat As Object";
_size = new Object();
_previewformat = new Object();
 //BA.debugLineNum = 299;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 300;BA.debugLine="size = r.RunMethod(\"getPreviewSize\")";
_size = _r.RunMethod("getPreviewSize");
 //BA.debugLineNum = 301;BA.debugLine="previewFormat = r.RunMethod(\"getPreviewFormat\")";
_previewformat = _r.RunMethod("getPreviewFormat");
 //BA.debugLineNum = 302;BA.debugLine="r.target = size";
_r.Target = _size;
 //BA.debugLineNum = 303;BA.debugLine="Dim width = r.GetField(\"width\"), height = r.GetFi";
_width = (int)(BA.ObjectToNumber(_r.GetField("width")));
_height = (int)(BA.ObjectToNumber(_r.GetField("height")));
 //BA.debugLineNum = 304;BA.debugLine="Dim yuvImage As Object = r.CreateObject2(\"android";
_yuvimage = _r.CreateObject2("android.graphics.YuvImage",new Object[]{(Object)(_data),_previewformat,(Object)(_width),(Object)(_height),__c.Null},new String[]{"[B","java.lang.int","java.lang.int","java.lang.int","[I"});
 //BA.debugLineNum = 307;BA.debugLine="r.target = yuvImage";
_r.Target = _yuvimage;
 //BA.debugLineNum = 308;BA.debugLine="Dim rect1 As Rect";
_rect1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 309;BA.debugLine="rect1.Initialize(0, 0, r.RunMethod(\"getWidth\"), r";
_rect1.Initialize((int) (0),(int) (0),(int)(BA.ObjectToNumber(_r.RunMethod("getWidth"))),(int)(BA.ObjectToNumber(_r.RunMethod("getHeight"))));
 //BA.debugLineNum = 310;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 311;BA.debugLine="out.InitializeToBytesArray(100)";
_out.InitializeToBytesArray((int) (100));
 //BA.debugLineNum = 312;BA.debugLine="r.RunMethod4(\"compressToJpeg\", Array As Object(re";
_r.RunMethod4("compressToJpeg",new Object[]{(Object)(_rect1.getObject()),(Object)(_quality),(Object)(_out.getObject())},new String[]{"android.graphics.Rect","java.lang.int","java.io.OutputStream"});
 //BA.debugLineNum = 314;BA.debugLine="Return out.ToBytesArray";
if (true) return _out.ToBytesArray();
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return null;
}
public String  _release() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Public Sub Release";
 //BA.debugLineNum = 163;BA.debugLine="cam.Release";
_cam.Release();
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _savepicturetofile(byte[] _data,String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 167;BA.debugLine="Public Sub SavePictureToFile(Data() As Byte, Dir A";
 //BA.debugLineNum = 168;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir, Fi";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
 //BA.debugLineNum = 169;BA.debugLine="out.WriteBytes(Data, 0, Data.Length)";
_out.WriteBytes(_data,(int) (0),_data.length);
 //BA.debugLineNum = 170;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public String  _setcoloreffect(String _effect) throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Public Sub SetColorEffect(Effect As String)";
 //BA.debugLineNum = 198;BA.debugLine="SetParameter(\"effect\", Effect)";
_setparameter("effect",_effect);
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public String  _setcontinuousautofocus() throws Exception{
anywheresoftware.b4a.objects.collections.List _modes = null;
 //BA.debugLineNum = 322;BA.debugLine="Public Sub SetContinuousAutoFocus";
 //BA.debugLineNum = 323;BA.debugLine="Dim modes As List = GetSupportedFocusModes";
_modes = new anywheresoftware.b4a.objects.collections.List();
_modes = _getsupportedfocusmodes();
 //BA.debugLineNum = 324;BA.debugLine="If modes.IndexOf(\"continuous-picture\") > -1 Th";
if (_modes.IndexOf((Object)("continuous-picture"))>-1) { 
 //BA.debugLineNum = 325;BA.debugLine="SetFocusMode(\"continuous-picture\")";
_setfocusmode("continuous-picture");
 }else if(_modes.IndexOf((Object)("continuous-video"))>-1) { 
 //BA.debugLineNum = 327;BA.debugLine="SetFocusMode(\"continuous-video\")";
_setfocusmode("continuous-video");
 }else {
 //BA.debugLineNum = 329;BA.debugLine="Log(\"Continuous focus mode is not availabl";
__c.LogImpl("63145735","Continuous focus mode is not available",0);
 };
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return "";
}
public String  _setdisplayorientation() throws Exception{
int _previewresult = 0;
int _result = 0;
int _degrees = 0;
b4a.DiscGolfRangeFinder.cameraexclass._camerainfoandid _ci = null;
int _orientation = 0;
 //BA.debugLineNum = 102;BA.debugLine="Private Sub SetDisplayOrientation";
 //BA.debugLineNum = 103;BA.debugLine="r.target = r.GetActivity";
_r.Target = (Object)(_r.GetActivity(ba));
 //BA.debugLineNum = 104;BA.debugLine="r.target = r.RunMethod(\"getWindowManager\")";
_r.Target = _r.RunMethod("getWindowManager");
 //BA.debugLineNum = 105;BA.debugLine="r.target = r.RunMethod(\"getDefaultDisplay\")";
_r.Target = _r.RunMethod("getDefaultDisplay");
 //BA.debugLineNum = 106;BA.debugLine="r.target = r.RunMethod(\"getRotation\")";
_r.Target = _r.RunMethod("getRotation");
 //BA.debugLineNum = 107;BA.debugLine="Dim previewResult, result, degrees As Int = r.tar";
_previewresult = 0;
_result = 0;
_degrees = (int) ((double)(BA.ObjectToNumber(_r.Target))*90);
 //BA.debugLineNum = 108;BA.debugLine="Dim ci As CameraInfoAndId = FindCamera(Front)";
_ci = _findcamera(_front);
 //BA.debugLineNum = 109;BA.debugLine="r.target = ci.CameraInfo";
_r.Target = _ci.CameraInfo /*Object*/ ;
 //BA.debugLineNum = 110;BA.debugLine="Dim orientation As Int = r.GetField(\"orientation\"";
_orientation = (int)(BA.ObjectToNumber(_r.GetField("orientation")));
 //BA.debugLineNum = 111;BA.debugLine="If Front Then";
if (_front) { 
 //BA.debugLineNum = 112;BA.debugLine="previewResult = (orientation + degrees) Mod 360";
_previewresult = (int) ((_orientation+_degrees)%360);
 //BA.debugLineNum = 113;BA.debugLine="result = previewResult";
_result = _previewresult;
 //BA.debugLineNum = 114;BA.debugLine="previewResult = (360 - previewResult) Mod 360";
_previewresult = (int) ((360-_previewresult)%360);
 }else {
 //BA.debugLineNum = 116;BA.debugLine="previewResult = (orientation - degrees + 360) Mo";
_previewresult = (int) ((_orientation-_degrees+360)%360);
 //BA.debugLineNum = 117;BA.debugLine="result = previewResult";
_result = _previewresult;
 //BA.debugLineNum = 118;BA.debugLine="Log(previewResult)";
__c.LogImpl("61245200",BA.NumberToString(_previewresult),0);
 };
 //BA.debugLineNum = 120;BA.debugLine="r.target = nativeCam";
_r.Target = _nativecam;
 //BA.debugLineNum = 121;BA.debugLine="r.RunMethod2(\"setDisplayOrientation\", previewResu";
_r.RunMethod2("setDisplayOrientation",BA.NumberToString(_previewresult),"java.lang.int");
 //BA.debugLineNum = 122;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 123;BA.debugLine="r.RunMethod2(\"setRotation\", result, \"java.lang.in";
_r.RunMethod2("setRotation",BA.NumberToString(_result),"java.lang.int");
 //BA.debugLineNum = 124;BA.debugLine="CommitParameters";
_commitparameters();
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _setexposurecompensation(int _v) throws Exception{
 //BA.debugLineNum = 395;BA.debugLine="Public Sub setExposureCompensation(v As Int)";
 //BA.debugLineNum = 396;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 397;BA.debugLine="r.RunMethod2(\"setExposureCompensation\", v, \"java.";
_r.RunMethod2("setExposureCompensation",BA.NumberToString(_v),"java.lang.int");
 //BA.debugLineNum = 398;BA.debugLine="End Sub";
return "";
}
public String  _setfacedetectionlistener() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
Object _e = null;
 //BA.debugLineNum = 410;BA.debugLine="Public Sub SetFaceDetectionListener";
 //BA.debugLineNum = 411;BA.debugLine="Dim jo As JavaObject = nativeCam";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_nativecam));
 //BA.debugLineNum = 412;BA.debugLine="Dim e As Object = jo.CreateEvent(\"android.hardwar";
_e = _jo.CreateEvent(ba,"android.hardware.Camera.FaceDetectionListener","FaceDetection",__c.Null);
 //BA.debugLineNum = 413;BA.debugLine="jo.RunMethod(\"setFaceDetectionListener\", Array(e)";
_jo.RunMethod("setFaceDetectionListener",new Object[]{_e});
 //BA.debugLineNum = 414;BA.debugLine="End Sub";
return "";
}
public String  _setflashmode(String _mode) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Public Sub SetFlashMode(Mode As String)";
 //BA.debugLineNum = 240;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 241;BA.debugLine="r.RunMethod2(\"setFlashMode\", Mode, \"java.lang.Str";
_r.RunMethod2("setFlashMode",_mode,"java.lang.String");
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public String  _setfocusmode(String _mode) throws Exception{
 //BA.debugLineNum = 333;BA.debugLine="Public Sub SetFocusMode(Mode As String)";
 //BA.debugLineNum = 334;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 335;BA.debugLine="r.RunMethod2(\"setFocusMode\", Mode, \"java.lang.";
_r.RunMethod2("setFocusMode",_mode,"java.lang.String");
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
return "";
}
public String  _setjpegquality(int _quality) throws Exception{
 //BA.debugLineNum = 234;BA.debugLine="Public Sub SetJpegQuality(Quality As Int)";
 //BA.debugLineNum = 235;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 236;BA.debugLine="r.RunMethod2(\"setJpegQuality\", Quality, \"java.lan";
_r.RunMethod2("setJpegQuality",BA.NumberToString(_quality),"java.lang.int");
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return "";
}
public String  _setparameter(String _key,String _value) throws Exception{
 //BA.debugLineNum = 173;BA.debugLine="Public Sub SetParameter(Key As String, Value As St";
 //BA.debugLineNum = 174;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 175;BA.debugLine="r.RunMethod3(\"set\", Key, \"java.lang.String\", Valu";
_r.RunMethod3("set",_key,"java.lang.String",_value,"java.lang.String");
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return "";
}
public String  _setpicturesize(int _width,int _height) throws Exception{
 //BA.debugLineNum = 229;BA.debugLine="Public Sub SetPictureSize(Width As Int, Height As";
 //BA.debugLineNum = 230;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 231;BA.debugLine="r.RunMethod3(\"setPictureSize\", Width, \"java.lang.";
_r.RunMethod3("setPictureSize",BA.NumberToString(_width),"java.lang.int",BA.NumberToString(_height),"java.lang.int");
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _setpreviewfpsrange(int _minvalue,int _maxvalue) throws Exception{
 //BA.debugLineNum = 271;BA.debugLine="Public Sub SetPreviewFpsRange(MinValue As Int, Max";
 //BA.debugLineNum = 272;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 273;BA.debugLine="r.RunMethod4(\"setPreviewFpsRange\", Array As Objec";
_r.RunMethod4("setPreviewFpsRange",new Object[]{(Object)(_minvalue),(Object)(_maxvalue)},new String[]{"java.lang.int","java.lang.int"});
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
return "";
}
public String  _setpreviewsize(int _width,int _height) throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Public Sub SetPreviewSize(Width As Int, Height As";
 //BA.debugLineNum = 214;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 215;BA.debugLine="r.RunMethod3(\"setPreviewSize\", Width, \"java.lang.";
_r.RunMethod3("setPreviewSize",BA.NumberToString(_width),"java.lang.int",BA.NumberToString(_height),"java.lang.int");
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public String  _setzoom(int _zoomvalue) throws Exception{
 //BA.debugLineNum = 385;BA.debugLine="Public Sub setZoom(ZoomValue As Int)";
 //BA.debugLineNum = 386;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 387;BA.debugLine="r.RunMethod2(\"setZoom\", ZoomValue, \"java.lang.in";
_r.RunMethod2("setZoom",BA.NumberToString(_zoomvalue),"java.lang.int");
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public String  _startfacedetection() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 428;BA.debugLine="Public Sub StartFaceDetection";
 //BA.debugLineNum = 429;BA.debugLine="Dim jo As JavaObject = nativeCam";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_nativecam));
 //BA.debugLineNum = 430;BA.debugLine="jo.RunMethod(\"startFaceDetection\", Null)";
_jo.RunMethod("startFaceDetection",(Object[])(__c.Null));
 //BA.debugLineNum = 431;BA.debugLine="End Sub";
return "";
}
public String  _startpreview() throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Public Sub StartPreview";
 //BA.debugLineNum = 155;BA.debugLine="cam.StartPreview";
_cam.StartPreview();
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return "";
}
public String  _stopfacedetection() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 433;BA.debugLine="Public Sub StopFaceDetection";
 //BA.debugLineNum = 434;BA.debugLine="Dim jo As JavaObject = nativeCam";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_nativecam));
 //BA.debugLineNum = 435;BA.debugLine="jo.RunMethod(\"stopFaceDetection\", Null)";
_jo.RunMethod("stopFaceDetection",(Object[])(__c.Null));
 //BA.debugLineNum = 436;BA.debugLine="End Sub";
return "";
}
public String  _stoppreview() throws Exception{
 //BA.debugLineNum = 158;BA.debugLine="Public Sub StopPreview";
 //BA.debugLineNum = 159;BA.debugLine="cam.StopPreview";
_cam.StopPreview();
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public String  _takepicture() throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub TakePicture";
 //BA.debugLineNum = 147;BA.debugLine="cam.TakePicture";
_cam.TakePicture();
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
