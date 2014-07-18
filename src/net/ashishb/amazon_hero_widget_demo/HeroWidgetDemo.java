package net.ashishb.amazon_hero_widget_demo;

import android.app.Activity;
import android.os.Bundle;

public class HeroWidgetDemo extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AmazonHeroWidget widget = new AmazonHeroWidget(this);
    }
}
