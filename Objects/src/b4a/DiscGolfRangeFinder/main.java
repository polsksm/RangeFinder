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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.DiscGolfRangeFinder", "b4a.DiscGolfRangeFinder.main");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.phone.Phone.PhoneSensors _phonesensors = null;
public static boolean _frontcamera = false;
public static float _m_angle = 0f;
public static float _set_angle = 0f;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _m_ctldistance = null;
public anywheresoftware.b4a.objects.CameraW _cam = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public b4a.DiscGolfRangeFinder.cameraexclass _camex = null;
public anywheresoftware.b4a.objects.LabelWrapper _dot = null;
public static int _dotcenterx = 0;
public static int _dotcentery = 0;
public static int _tapthreshold = 0;
public anywheresoftware.b4a.objects.SeekBarWrapper _seekbar1 = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _seekbar2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label6 = null;
public b4a.DiscGolfRangeFinder.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 79;BA.debugLine="Activity.LoadLayout(\"Layout\") ' Load the layout t";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 80;BA.debugLine="phoneSensors.Initialize(phoneSensors.TYPE_ACCELER";
_phonesensors.Initialize(_phonesensors.TYPE_ACCELEROMETER);
 //BA.debugLineNum = 82;BA.debugLine="dot.Initialize(\"\")";
mostCurrent._dot.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 83;BA.debugLine="dot.Color = Colors.Transparent";
mostCurrent._dot.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 //BA.debugLineNum = 85;BA.debugLine="dot.TextColor = Colors.White";
mostCurrent._dot.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 86;BA.debugLine="dot.Text = \"●\" ' Set the dot character (Unicode f";
mostCurrent._dot.setText(BA.ObjectToCharSequence("●"));
 //BA.debugLineNum = 87;BA.debugLine="dot.TextSize = 30 ' Set the dot size";
mostCurrent._dot.setTextSize((float) (30));
 //BA.debugLineNum = 88;BA.debugLine="dot.Gravity = Gravity.CENTER ' Center the text in";
mostCurrent._dot.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 90;BA.debugLine="Activity.AddView(dot, 0, 0, 30dip, 30dip) ' 30dip";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._dot.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 //BA.debugLineNum = 91;BA.debugLine="CenterDotOnPanel";
_centerdotonpanel();
 //BA.debugLineNum = 94;BA.debugLine="Label5.Text = \"K_UP \" & NumberFormat(Seekbar1.Val";
mostCurrent._label5.setText(BA.ObjectToCharSequence("K_UP "+anywheresoftware.b4a.keywords.Common.NumberFormat(mostCurrent._seekbar1.getValue()/(double)10,(int) (1),(int) (1))));
 //BA.debugLineNum = 95;BA.debugLine="Label6.Text = \"K_DOWN \" & NumberFormat(Seekbar2.V";
mostCurrent._label6.setText(BA.ObjectToCharSequence("K_DOWN "+anywheresoftware.b4a.keywords.Common.NumberFormat(mostCurrent._seekbar2.getValue()/(double)10,(int) (1),(int) (1))));
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Sub Activity_Pause(UserClosed As Boolean)";
 //BA.debugLineNum = 116;BA.debugLine="phoneSensors.StopListening()";
_phonesensors.StopListening(processBA);
 //BA.debugLineNum = 117;BA.debugLine="Log(\"Stopped listening to phone sensors.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6393218","Stopped listening to phone sensors.",0);
 //BA.debugLineNum = 118;BA.debugLine="Try";
try { //BA.debugLineNum = 119;BA.debugLine="Log(\"Stopping camera preview...\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6393220","Stopping camera preview...",0);
 //BA.debugLineNum = 120;BA.debugLine="cam.StopPreview ' Stop the camera preview when t";
mostCurrent._cam.StopPreview();
 //BA.debugLineNum = 121;BA.debugLine="cam.Release ' Release the camera when the activi";
mostCurrent._cam.Release();
 //BA.debugLineNum = 122;BA.debugLine="Log(\"Camera released.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6393223","Camera released.",0);
 } 
       catch (Exception e9) {
			processBA.setLastException(e9); //BA.debugLineNum = 124;BA.debugLine="Log(\"Error during camera release: \" & LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("6393225","Error during camera release: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 110;BA.debugLine="InitializeCamera";
_initializecamera();
 //BA.debugLineNum = 111;BA.debugLine="phoneSensors.StartListening(\"phoneSensors\")";
_phonesensors.StartListening(processBA,"phoneSensors");
 //BA.debugLineNum = 112;BA.debugLine="Log(\"Started listening to phone sensors.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6327683","Started listening to phone sensors.",0);
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_ready(boolean _success) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub Camera1_Ready(Success As Boolean)";
 //BA.debugLineNum = 67;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 68;BA.debugLine="camEx.SetJpegQuality(90)";
mostCurrent._camex._setjpegquality /*String*/ ((int) (90));
 //BA.debugLineNum = 69;BA.debugLine="camEx.SetContinuousAutoFocus";
mostCurrent._camex._setcontinuousautofocus /*String*/ ();
 //BA.debugLineNum = 70;BA.debugLine="camEx.CommitParameters";
mostCurrent._camex._commitparameters /*String*/ ();
 //BA.debugLineNum = 71;BA.debugLine="camEx.StartPreview";
mostCurrent._camex._startpreview /*String*/ ();
 //BA.debugLineNum = 72;BA.debugLine="Log(camEx.GetPreviewSize)";
anywheresoftware.b4a.keywords.Common.LogImpl("6196614",BA.ObjectToString(mostCurrent._camex._getpreviewsize /*b4a.DiscGolfRangeFinder.cameraexclass._camerasize*/ ()),0);
 }else {
 //BA.debugLineNum = 74;BA.debugLine="ToastMessageShow(\"Cannot open camera.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cannot open camera."),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _centerdotonpanel() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub CenterDotOnPanel";
 //BA.debugLineNum = 101;BA.debugLine="dotCenterX = Panel1.Left + (Panel1.Width / 2)";
_dotcenterx = (int) (mostCurrent._panel1.getLeft()+(mostCurrent._panel1.getWidth()/(double)2));
 //BA.debugLineNum = 102;BA.debugLine="dotCenterY = Panel1.Top + (Panel1.Height / 2)";
_dotcentery = (int) (mostCurrent._panel1.getTop()+(mostCurrent._panel1.getHeight()/(double)2));
 //BA.debugLineNum = 105;BA.debugLine="dot.Left = dotCenterX - (dot.Width / 2)";
mostCurrent._dot.setLeft((int) (_dotcenterx-(mostCurrent._dot.getWidth()/(double)2)));
 //BA.debugLineNum = 106;BA.debugLine="dot.Top = dotCenterY - (dot.Height / 2)";
mostCurrent._dot.setTop((int) (_dotcentery-(mostCurrent._dot.getHeight()/(double)2)));
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public static String  _displayeffectivedistance() throws Exception{
float _k_up = 0f;
float _k_down = 0f;
float _eff_distance = 0f;
float _distance = 0f;
float _angle_rad = 0f;
 //BA.debugLineNum = 159;BA.debugLine="Sub displayEffectiveDistance()";
 //BA.debugLineNum = 160;BA.debugLine="Dim k_up As Float";
_k_up = 0f;
 //BA.debugLineNum = 161;BA.debugLine="Dim k_down As Float";
_k_down = 0f;
 //BA.debugLineNum = 162;BA.debugLine="Dim eff_distance As Float";
_eff_distance = 0f;
 //BA.debugLineNum = 163;BA.debugLine="Dim distance As Float";
_distance = 0f;
 //BA.debugLineNum = 164;BA.debugLine="Dim angle_rad As Float = set_angle * (cPI / 180.0";
_angle_rad = (float) (_set_angle*(anywheresoftware.b4a.keywords.Common.cPI/(double)180.0));
 //BA.debugLineNum = 166;BA.debugLine="If (m_ctlDistance.Text.Length < 1) Then Return";
if ((mostCurrent._m_ctldistance.getText().length()<1)) { 
if (true) return "";};
 //BA.debugLineNum = 167;BA.debugLine="distance = m_ctlDistance.Text";
_distance = (float)(Double.parseDouble(mostCurrent._m_ctldistance.getText()));
 //BA.debugLineNum = 170;BA.debugLine="distance = m_ctlDistance.Text.Trim ' Ensure there";
_distance = (float)(Double.parseDouble(mostCurrent._m_ctldistance.getText().trim()));
 //BA.debugLineNum = 172;BA.debugLine="If IsNumber(distance) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(BA.NumberToString(_distance))) { 
 //BA.debugLineNum = 173;BA.debugLine="distance = distance ' Text is already a number i";
_distance = _distance;
 }else {
 //BA.debugLineNum = 175;BA.debugLine="Log(\"Invalid distance value\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6589840","Invalid distance value",0);
 //BA.debugLineNum = 176;BA.debugLine="Return ' Exit the sub if the distance is not a v";
if (true) return "";
 };
 //BA.debugLineNum = 179;BA.debugLine="k_up = NumberFormat(Seekbar1.Value/10,1,1)";
_k_up = (float)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(mostCurrent._seekbar1.getValue()/(double)10,(int) (1),(int) (1))));
 //BA.debugLineNum = 180;BA.debugLine="k_down = NumberFormat(Seekbar2.Value/10,1,1)";
_k_down = (float)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(mostCurrent._seekbar2.getValue()/(double)10,(int) (1),(int) (1))));
 //BA.debugLineNum = 182;BA.debugLine="If (set_angle >= 0.0) Then";
if ((_set_angle>=0.0)) { 
 //BA.debugLineNum = 183;BA.debugLine="eff_distance = distance * (Cos(angle_rad) + k_up";
_eff_distance = (float) (_distance*(anywheresoftware.b4a.keywords.Common.Cos(_angle_rad)+_k_up*anywheresoftware.b4a.keywords.Common.Sin(_angle_rad)));
 }else {
 //BA.debugLineNum = 185;BA.debugLine="eff_distance = distance * (Cos(angle_rad) + k_do";
_eff_distance = (float) (_distance*(anywheresoftware.b4a.keywords.Common.Cos(_angle_rad)+_k_down*anywheresoftware.b4a.keywords.Common.Sin(_angle_rad)));
 };
 //BA.debugLineNum = 188;BA.debugLine="Log(\"m_angle: \" & m_angle)";
anywheresoftware.b4a.keywords.Common.LogImpl("6589853","m_angle: "+BA.NumberToString(_m_angle),0);
 //BA.debugLineNum = 189;BA.debugLine="Label2.Text = \"Effective Distance: \" & NumberForm";
mostCurrent._label2.setText(BA.ObjectToCharSequence("Effective Distance: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_eff_distance,(int) (1),(int) (1))+" ft"));
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Dim m_angle As Float";
_m_angle = 0f;
 //BA.debugLineNum = 27;BA.debugLine="Dim set_angle As Float";
_set_angle = 0f;
 //BA.debugLineNum = 28;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private m_ctlDistance As EditText";
mostCurrent._m_ctldistance = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private cam As Camera";
mostCurrent._cam = new anywheresoftware.b4a.objects.CameraW();
 //BA.debugLineNum = 32;BA.debugLine="Private Panel1 As Panel ' Use Panel instead of Su";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private camEx As CameraExClass";
mostCurrent._camex = new b4a.DiscGolfRangeFinder.cameraexclass();
 //BA.debugLineNum = 34;BA.debugLine="Private dot As Label    ' Label to represent the";
mostCurrent._dot = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private dotCenterX As Int ' Center X coordinate o";
_dotcenterx = 0;
 //BA.debugLineNum = 36;BA.debugLine="Private dotCenterY As Int ' Center Y coordinate o";
_dotcentery = 0;
 //BA.debugLineNum = 37;BA.debugLine="Private tapThreshold As Int = 30dip ' Threshold d";
_tapthreshold = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30));
 //BA.debugLineNum = 38;BA.debugLine="Private Seekbar1 As SeekBar";
mostCurrent._seekbar1 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private Seekbar2 As SeekBar";
mostCurrent._seekbar2 = new anywheresoftware.b4a.objects.SeekBarWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private Label5 As Label";
mostCurrent._label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private Label6 As Label";
mostCurrent._label6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static void  _initializecamera() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 45;BA.debugLine="Log(\"Initialize Camera\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6131073","Initialize Camera",0);
 //BA.debugLineNum = 46;BA.debugLine="Starter.rp.CheckAndRequest(Starter.rp.PERMISSION_";
parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,parent.mostCurrent._starter._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_CAMERA);
 //BA.debugLineNum = 47;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 48;BA.debugLine="If Result Then";
if (true) break;

case 1:
//if
this.state = 12;
if (_result) { 
this.state = 3;
}else {
this.state = 11;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 49;BA.debugLine="Log(\"Permission granted, initializing camera...\"";
anywheresoftware.b4a.keywords.Common.LogImpl("6131077","Permission granted, initializing camera...",0);
 //BA.debugLineNum = 50;BA.debugLine="Sleep(100) ' Delay to ensure SurfaceView is read";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (100));
this.state = 14;
return;
case 14:
//C
this.state = 4;
;
 //BA.debugLineNum = 51;BA.debugLine="camEx.Initialize(Panel1, frontCamera, Me, \"Camer";
parent.mostCurrent._camex._initialize /*String*/ (mostCurrent.activityBA,parent.mostCurrent._panel1,parent._frontcamera,main.getObject(),"Camera1");
 //BA.debugLineNum = 52;BA.debugLine="If camEx.IsInitialized Then";
if (true) break;

case 4:
//if
this.state = 9;
if (parent.mostCurrent._camex.IsInitialized /*boolean*/ ()) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 //BA.debugLineNum = 53;BA.debugLine="Log(\"Camera initialized successfully.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6131081","Camera initialized successfully.",0);
 //BA.debugLineNum = 54;BA.debugLine="camEx.StartPreview";
parent.mostCurrent._camex._startpreview /*String*/ ();
 //BA.debugLineNum = 55;BA.debugLine="Log(\"Camera preview started.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6131083","Camera preview started.",0);
 if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 57;BA.debugLine="Log(\"Camera initialization failed.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6131085","Camera initialization failed.",0);
 if (true) break;

case 9:
//C
this.state = 12;
;
 //BA.debugLineNum = 59;BA.debugLine="frontCamera = camEx.Front";
parent._frontcamera = parent.mostCurrent._camex._front /*boolean*/ ;
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 61;BA.debugLine="ToastMessageShow(\"No permission!!!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission!!!"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 62;BA.debugLine="Log(\"Camera permission denied.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6131090","Camera permission denied.",0);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _m_ctldistance_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Private Sub m_ctlDistance_TextChanged (Old As Stri";
 //BA.debugLineNum = 204;BA.debugLine="Log(\"distance changed\")";
anywheresoftware.b4a.keywords.Common.LogImpl("65308417","distance changed",0);
 //BA.debugLineNum = 205;BA.debugLine="displayEffectiveDistance";
_displayeffectivedistance();
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public static String  _panel1_touch(int _action,float _x,float _y) throws Exception{
double _distance = 0;
 //BA.debugLineNum = 144;BA.debugLine="Sub Panel1_Touch (Action As Int, X As Float, Y As";
 //BA.debugLineNum = 146;BA.debugLine="Dim distance As Double";
_distance = 0;
 //BA.debugLineNum = 147;BA.debugLine="distance = Sqrt(Power(X - dotCenterX, 2) + Power(";
_distance = anywheresoftware.b4a.keywords.Common.Sqrt(anywheresoftware.b4a.keywords.Common.Power(_x-_dotcenterx,2)+anywheresoftware.b4a.keywords.Common.Power(_y-_dotcentery,2));
 //BA.debugLineNum = 148;BA.debugLine="If distance <= tapThreshold Then";
if (_distance<=_tapthreshold) { 
 //BA.debugLineNum = 150;BA.debugLine="Log(\"Tap within threshold, setting angle.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6524294","Tap within threshold, setting angle.",0);
 //BA.debugLineNum = 151;BA.debugLine="Label4.Text = \"Angle: \" & m_angle";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Angle: "+BA.NumberToString(_m_angle)));
 //BA.debugLineNum = 152;BA.debugLine="set_angle = m_angle";
_set_angle = _m_angle;
 //BA.debugLineNum = 153;BA.debugLine="displayEffectiveDistance";
_displayeffectivedistance();
 }else {
 //BA.debugLineNum = 155;BA.debugLine="Log(\"Tap outside threshold, ignoring.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("6524299","Tap outside threshold, ignoring.",0);
 };
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public static String  _phonesensors_sensorchanged(float[] _values) throws Exception{
float _x = 0f;
float _y = 0f;
float _z = 0f;
 //BA.debugLineNum = 128;BA.debugLine="Sub phoneSensors_SensorChanged (Values() As Float)";
 //BA.debugLineNum = 130;BA.debugLine="Dim x As Float = Values(0)";
_x = _values[(int) (0)];
 //BA.debugLineNum = 131;BA.debugLine="Dim y As Float = Values(1)";
_y = _values[(int) (1)];
 //BA.debugLineNum = 132;BA.debugLine="Dim z As Float = Values(2)";
_z = _values[(int) (2)];
 //BA.debugLineNum = 135;BA.debugLine="m_angle = 90.0 - ATan2(y, Sqrt(x * x + z * z)) *";
_m_angle = (float) (90.0-anywheresoftware.b4a.keywords.Common.ATan2(_y,anywheresoftware.b4a.keywords.Common.Sqrt(_x*_x+_z*_z))*(180/(double)anywheresoftware.b4a.keywords.Common.cPI));
 //BA.debugLineNum = 136;BA.debugLine="If z > 1.0 Then";
if (_z>1.0) { 
 //BA.debugLineNum = 137;BA.debugLine="m_angle = m_angle * -1";
_m_angle = (float) (_m_angle*-1);
 };
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="Private phoneSensors As PhoneSensors";
_phonesensors = new anywheresoftware.b4a.phone.Phone.PhoneSensors();
 //BA.debugLineNum = 20;BA.debugLine="Private frontCamera As Boolean = False";
_frontcamera = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _seekbar1_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Private Sub SeekBar1_ValueChanged (Value As Int, U";
 //BA.debugLineNum = 193;BA.debugLine="Label5.Text = \"K_UP \" & NumberFormat(Value/10,1,1";
mostCurrent._label5.setText(BA.ObjectToCharSequence("K_UP "+anywheresoftware.b4a.keywords.Common.NumberFormat(_value/(double)10,(int) (1),(int) (1))));
 //BA.debugLineNum = 194;BA.debugLine="displayEffectiveDistance";
_displayeffectivedistance();
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public static String  _seekbar2_valuechanged(int _value,boolean _userchanged) throws Exception{
 //BA.debugLineNum = 197;BA.debugLine="Private Sub SeekBar2_ValueChanged (Value As Int, U";
 //BA.debugLineNum = 198;BA.debugLine="Label6.Text = \"K_DOWN \" & NumberFormat(Value/10,1";
mostCurrent._label6.setText(BA.ObjectToCharSequence("K_DOWN "+anywheresoftware.b4a.keywords.Common.NumberFormat(_value/(double)10,(int) (1),(int) (1))));
 //BA.debugLineNum = 199;BA.debugLine="displayEffectiveDistance";
_displayeffectivedistance();
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
}
