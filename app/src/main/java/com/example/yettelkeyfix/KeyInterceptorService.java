package com.example.yettelkeyfix;

import android.accessibilityservice.AccessibilityService;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.app.Instrumentation;

public class KeyInterceptorService extends AccessibilityService {

    private static final String TARGET_PACKAGE = "bg.yettel.tv.selfcare";
    private String currentPackage = "";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getPackageName() != null) {
            currentPackage = event.getPackageName().toString();
        }
    }

    @Override
    protected boolean onKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN &&
                event.getKeyCode() == KeyEvent.KEYCODE_ENTER &&
                TARGET_PACKAGE.equals(currentPackage)) {

            sendDpadCenter();
            return true; // consume ENTER
        }

        return super.onKeyEvent(event);
    }

    private void sendDpadCenter() {
        new Thread(() -> {
            try {
                Instrumentation inst = new Instrumentation();
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
            } catch (Exception ignored) {
            }
        }).start();
    }

    @Override
    public void onInterrupt() {}
}
