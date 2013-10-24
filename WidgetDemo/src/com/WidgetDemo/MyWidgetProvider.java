package com.WidgetDemo;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class MyWidgetProvider extends AppWidgetProvider {
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Timer timer=new Timer();
		timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager),1,1000);
	}
	
	private class MyTime extends TimerTask
	{
		RemoteViews remoteViews;
		AppWidgetManager appWidgetManager;
		ComponentName thisWidget;
		DateFormat format=SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
		public MyTime(Context context, AppWidgetManager appWidgetManager) {
			this.appWidgetManager = appWidgetManager;
			remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
			thisWidget = new ComponentName(context,MyWidgetProvider.class);
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			remoteViews.setTextViewText(R.id.update,format.format(new Date()));
			appWidgetManager.updateAppWidget(thisWidget, remoteViews);
		}

		
	}
	
}
