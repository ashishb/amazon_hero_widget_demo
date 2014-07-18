package net.ashishb.amazon_hero_widget_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.amazon.device.home.GroupedListHeroWidget;
import com.amazon.device.home.GroupedListHeroWidget.Group;
import com.amazon.device.home.GroupedListHeroWidget.ListEntry;
import com.amazon.device.home.GroupedListHeroWidget.VisualStyle;
import com.amazon.device.home.HeroWidgetActivityStarterIntent;
import com.amazon.device.home.HomeManager;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class AmazonHeroWidget {

    public static final String TAG = "AmazonHeroWidget";

    public AmazonHeroWidget(Context context) {
        HomeManager homeManager = HomeManager.getInstance(context);
        homeManager.updateNumericBadge(2);
        GroupedListHeroWidget widget = new GroupedListHeroWidget();
        List listEntries = new ArrayList();
        ListEntry entry1 = new ListEntry(context);
        entry1.setVisualStyle(VisualStyle.PEEKABLE);
        entry1.setPrimaryText("item 1");
        entry1.setSecondaryText("details of 1");
        ListEntry entry2 = new ListEntry(context);
        entry2.setVisualStyle(VisualStyle.PEEKABLE);
        entry2.setPrimaryText("item 2");
        entry2.setSecondaryText("details of 2");

        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.f2);
        File file = new File(context.getFilesDir().toString(), "f2.jpg");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (Exception e) {
            Log.d(TAG, "error", e);
        }
        bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
        Log.d(TAG, "wrote f2.jpg to " + file.toString());
        // FileOutputStream fos = new FileOutputStream("f2.jpg", Context.MODE_PRIVATE);

        entry1.setPrimaryIcon(R.drawable.f2);
        entry2.setPrimaryIcon(Uri.fromFile(file));
        try {
           listEntries.add(entry1); 
           listEntries.add(entry2);
        } catch(Exception e) {
            Log.d(TAG, "error", e);
        }
        Group group = new Group();
        group.setGroupName("group 1");
        group.setListEntries(listEntries);
        try {
           widget.addGroup(0, group);
        } catch(Exception e) {
            Log.d(TAG, "error", e);
        }
        homeManager.updateWidget(widget);
    }
}
