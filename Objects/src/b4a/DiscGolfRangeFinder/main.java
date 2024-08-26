package b4a.DiscGolfRangeFinder;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.DiscGolfRangeFinder", "b4a.DiscGolfRangeFinder.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.DiscGolfRangeFinder", "b4a.DiscGolfRangeFinder.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.DiscGolfRangeFinder.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.phone.Phone.PhoneSensors _phonesensors = null;
public static boolean _frontcamera = false;
public static anywheresoftware.b4a.objects.Timer _startpreviewtimer = null;
public static float _m_angle = 0f;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _m_ctldistance = null;
public anywheresoftware.b4a.objects.EditTextWrapper _m_ctlkup = null;
public anywheresoftware.b4a.objects.EditTextWrapper _m_ctlkdown = null;
public anywheresoftware.b4a.objects.CameraW _cam = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public b4a.DiscGolfRangeFinder.cameraexclass _camex = null;
public b4a.DiscGolfRangeFinder.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\") ' Load the layout t";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="phoneSensors.Initialize(phoneSensors.TYPE_ACCELER";
_phonesensors.Initialize(_phonesensors.TYPE_ACCELEROMETER);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="m_ctlKUp.Text = 2.5";
mostCurrent._m_ctlkup.setText(BA.ObjectToCharSequence(2.5));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="m_ctlKDown.Text = 0.5";
mostCurrent._m_ctlkdown.setText(BA.ObjectToCharSequence(0.5));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="phoneSensors.StopListening()";
_phonesensors.StopListening(processBA);
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Log(\"Stopped listening to phone sensors.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1262146","Stopped listening to phone sensors.",0);
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Try";
try {RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Log(\"Stopping camera preview...\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1262148","Stopping camera preview...",0);
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="cam.StopPreview ' Stop the camera preview when t";
mostCurrent._cam.StopPreview();
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="cam.Release ' Release the camera when the activi";
mostCurrent._cam.Release();
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="Log(\"Camera released.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1262151","Camera released.",0);
 } 
       catch (Exception e9) {
			processBA.setLastException(e9);RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="Log(\"Error during camera release: \" & LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("1262153","Error during camera release: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="InitializeCamera";
_initializecamera();
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="phoneSensors.StartListening(\"phoneSensors\")";
_phonesensors.StartListening(processBA,"phoneSensors");
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Log(\"Started listening to phone sensors.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1196611","Started listening to phone sensors.",0);
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="End Sub";
return "";
}
public static void  _initializecamera() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "initializecamera", false))
	 {Debug.delegate(mostCurrent.activityBA, "initializecamera", null); return;}
ResumableSub_InitializeCamera rsub = new ResumableSub_InitializeCamera(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_InitializeCamera extends BA.ResumableSub {
public ResumableSub_InitializeCamera(b4a.DiscGolfRangeFinder.main parent) {
this.parent = parent;
}
b4a.DiscGolfRangeFinder.main parent;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Starter.rp.CheckAndRequest(Starter.rp.PERMISSION_";
parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_CAMERA);
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "initializecamera"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="If Result Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="camEx.Initialize(Panel1, frontCamera, Me, \"Camer";
parent.mostCurrent._camex._initialize /*String*/ (null,mostCurrent.activityBA,parent.mostCurrent._panel1,parent._frontcamera,main.getObject(),"Camera1");
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="frontCamera = camEx.Front";
parent._frontcamera = parent.mostCurrent._camex._front /*boolean*/ ;
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="ToastMessageShow(\"No permission!!!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission!!!"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _camera1_ready(boolean _success) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "camera1_ready", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "camera1_ready", new Object[] {_success}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub Camera1_Ready(Success As Boolean)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="camEx.SetJpegQuality(90)";
mostCurrent._camex._setjpegquality /*String*/ (null,(int) (90));
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="camEx.SetContinuousAutoFocus";
mostCurrent._camex._setcontinuousautofocus /*String*/ (null);
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="camEx.CommitParameters";
mostCurrent._camex._commitparameters /*String*/ (null);
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="camEx.StartPreview";
mostCurrent._camex._startpreview /*String*/ (null);
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Log(camEx.GetPreviewSize)";
anywheresoftware.b4a.keywords.Common.LogImpl("14390918",BA.ObjectToString(mostCurrent._camex._getpreviewsize /*b4a.DiscGolfRangeFinder.cameraexclass._camerasize*/ (null)),0);
 }else {
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="ToastMessageShow(\"Cannot open camera.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cannot open camera."),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="End Sub";
return "";
}
public static String  _displayeffectivedistance() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "displayeffectivedistance", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "displayeffectivedistance", null));}
float _k_up = 0f;
float _k_down = 0f;
float _eff_distance = 0f;
float _distance = 0f;
float _angle_rad = 0f;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub displayEffectiveDistance()";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim k_up As Float";
_k_up = 0f;
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Dim k_down As Float";
_k_down = 0f;
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Dim eff_distance As Float";
_eff_distance = 0f;
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Dim distance As Float";
_distance = 0f;
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Dim angle_rad As Float = m_angle * (cPI / 180.0)";
_angle_rad = (float) (_m_angle*(anywheresoftware.b4a.keywords.Common.cPI/(double)180.0));
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="If (m_ctlDistance.Text.Length < 1) Then Return";
if ((mostCurrent._m_ctldistance.getText().length()<1)) { 
if (true) return "";};
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="distance = m_ctlDistance.Text";
_distance = (float)(Double.parseDouble(mostCurrent._m_ctldistance.getText()));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="distance = m_ctlDistance.Text.Trim ' Ensure there";
_distance = (float)(Double.parseDouble(mostCurrent._m_ctldistance.getText().trim()));
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="If IsNumber(distance) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_distance))) { 
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="distance = distance ' Text is already a number i";
_distance = _distance;
 }else {
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="Log(\"Invalid distance value\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1458768","Invalid distance value",0);
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="Return ' Exit the sub if the distance is not a v";
if (true) return "";
 };
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="k_up = m_ctlKUp.Text";
_k_up = (float)(Double.parseDouble(mostCurrent._m_ctlkup.getText()));
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="k_down = m_ctlKDown.Text";
_k_down = (float)(Double.parseDouble(mostCurrent._m_ctlkdown.getText()));
RDebugUtils.currentLine=458775;
 //BA.debugLineNum = 458775;BA.debugLine="If (m_angle >= 0.0) Then";
if ((_m_angle>=0.0)) { 
RDebugUtils.currentLine=458776;
 //BA.debugLineNum = 458776;BA.debugLine="eff_distance = distance * (Cos(angle_rad) + k_up";
_eff_distance = (float) (_distance*(anywheresoftware.b4a.keywords.Common.Cos(_angle_rad)+_k_up*anywheresoftware.b4a.keywords.Common.Sin(_angle_rad)));
 }else {
RDebugUtils.currentLine=458778;
 //BA.debugLineNum = 458778;BA.debugLine="eff_distance = distance * (Cos(angle_rad) + k_do";
_eff_distance = (float) (_distance*(anywheresoftware.b4a.keywords.Common.Cos(_angle_rad)+_k_down*anywheresoftware.b4a.keywords.Common.Sin(_angle_rad)));
 };
RDebugUtils.currentLine=458781;
 //BA.debugLineNum = 458781;BA.debugLine="Label2.Text = \"Effective Distance: \" & NumberForm";
mostCurrent._label2.setText(BA.ObjectToCharSequence("Effective Distance: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_eff_distance,(int) (1),(int) (1))+" ft"));
RDebugUtils.currentLine=458782;
 //BA.debugLineNum = 458782;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel1_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Panel1_Touch (Action As Int, X As Float, Y As";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Label4.Text = \"Angle: \" & m_angle";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Angle: "+BA.NumberToString(_m_angle)));
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="displayEffectiveDistance";
_displayeffectivedistance();
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="End Sub";
return "";
}
public static String  _phonesensors_sensorchanged(float[] _values) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "phonesensors_sensorchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "phonesensors_sensorchanged", new Object[] {_values}));}
float _x = 0f;
float _y = 0f;
float _z = 0f;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub phoneSensors_SensorChanged (Values() As Float)";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim x As Float = Values(0)";
_x = _values[(int) (0)];
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Dim y As Float = Values(1)";
_y = _values[(int) (1)];
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Dim z As Float = Values(2)";
_z = _values[(int) (2)];
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="m_angle = ATan2(y, Sqrt(x * x + z * z)) * (180 /";
_m_angle = (float) (anywheresoftware.b4a.keywords.Common.ATan2(_y,anywheresoftware.b4a.keywords.Common.Sqrt(_x*_x+_z*_z))*(180/(double)anywheresoftware.b4a.keywords.Common.cPI));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Log(\"Tilt Angle: \" & m_angle & \" degrees\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1524296","Tilt Angle: "+BA.NumberToString(_m_angle)+" degrees",0);
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="End Sub";
return "";
}
}