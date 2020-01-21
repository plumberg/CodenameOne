package com.codename1.samples;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.CN;
import com.codename1.ui.plaf.RoundRectBorder;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class RoundRectBorderTest {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Form hi = new Form("Hi World", BoxLayout.y());
        hi.add(new Label("Hi World"));
        Label l = l("Rectangle");
        l.getStyle().setBorder(b().cornerRadius(0f));
        hi.add(l);
        l = l("All corners");
        l.getStyle().setBorder(b());
        hi.add(l);
        l = l("Top Only");
        l.getStyle().setBorder(b().topOnlyMode(true));
        hi.add(l);
        l = l("Bottom Only");
        l.getStyle().setBorder(b().bottomOnlyMode(true));
        l = l("Top Left Only");
        l.getStyle().setBorder(b().topLeftMode(true).topRightMode(false).bottomLeftMode(false).bottomRightMode(false));
        hi.add(l);
        l = l("Top Right Only");
        l.getStyle().setBorder(b().topLeftMode(false).topRightMode(true).bottomLeftMode(false).bottomRightMode(false));
        hi.add(l);
        l = l("Bottom Left Only");
        l.getStyle().setBorder(b().topLeftMode(false).topRightMode(false).bottomLeftMode(true).bottomRightMode(false));
        hi.add(l);
        l = l("Bottom Right Only");
        l.getStyle().setBorder(b().topLeftMode(false).topRightMode(false).bottomLeftMode(false).bottomRightMode(true));
        hi.add(l);
        l = l("Left Only");
        l.getStyle().setBorder(b().topLeftMode(true).topRightMode(false).bottomLeftMode(true).bottomRightMode(false));
        hi.add(l);
        l = l("Right Only");
        l.getStyle().setBorder(b().topLeftMode(false).topRightMode(true).bottomLeftMode(false).bottomRightMode(true));
        hi.add(l);
        
        l = l("Border Radius 10");
        l.getStyle().setBorder(b().cornerRadius(10f));
        hi.add(l);
        
        
        
        hi.show();
    }
    
    private RoundRectBorder b() {
        RoundRectBorder out = RoundRectBorder.create();
        out.cornerRadius(5f);
        
        return out;
    }
    
    private Label l(String text) {
        Label l = new Label(text);
        int p = CN.convertToPixels(5);
        l.getStyle().setPadding(p, p, p, p);
        l.getStyle().setBgColor(0x333333);
        l.getStyle().setFgColor(0xffffff);
        l.getStyle().setBgTransparency(0xff);
        return l;
    }
    

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
