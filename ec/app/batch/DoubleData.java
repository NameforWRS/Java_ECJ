/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
 */


package ec.app.batch;
import ec.gp.*;

public class DoubleData extends GPData
{
	public double x;    // return value
	
	public double FPT;
	public double SPT;
	public double FSUMPT;
	public double FMAXPT;
	public double FMINPT;
	public double SSUMPT;
	public double SMAXPT;
	public double SMINPT;
	public double RFSUMPT;
	public double RFMAXPT;
	public double RFMINPT;
	public double RSSUMPT;
	public double RSMAXPT;
	public double RSMINPT;
	
	public double PTB;
	public double FSUMPTB;
	public double SSUMPTB;
	public double FMINPTB;
	public double SMINPTB;
	public double SMAXPTB;
	public double RT;
	public double PTS;
	public double RSUMPTS;
	public double RMINPTS;
	public double RMAXPTS;




	public void copyTo(final GPData gpd)   // copy my stuff to another DoubleData
	{ 
		((DoubleData)gpd).x = x; 
		((DoubleData)gpd).FPT = FPT;
		((DoubleData)gpd).SPT = SPT;
		((DoubleData)gpd).FSUMPT = FSUMPT;
		((DoubleData)gpd).FMAXPT = FMAXPT;
		((DoubleData)gpd).FMINPT = FMINPT;
		((DoubleData)gpd).SSUMPT = SSUMPT;
		((DoubleData)gpd).SMAXPT = SMAXPT;
		((DoubleData)gpd).SMINPT = SMINPT;
		((DoubleData)gpd).RFSUMPT = RFSUMPT;
		((DoubleData)gpd).RFMAXPT = RFMAXPT;
		((DoubleData)gpd).RFMINPT = RFMINPT;
		((DoubleData)gpd).RSSUMPT = RSSUMPT;
		((DoubleData)gpd).RSMAXPT = RSMAXPT;
		((DoubleData)gpd).RSMINPT = RSMINPT;	
		((DoubleData)gpd).PTB=PTB;
		((DoubleData)gpd).FSUMPTB=FSUMPTB;
		((DoubleData)gpd).SSUMPTB=SSUMPTB;
		((DoubleData)gpd).FMINPTB=FMINPTB;
		((DoubleData)gpd).SMINPTB=SMINPTB;
		((DoubleData)gpd).SMAXPTB=SMAXPTB;
		((DoubleData)gpd).RT=RT;
		((DoubleData)gpd).PTS=PTS;
		((DoubleData)gpd).RSUMPTS=RSUMPTS;
		((DoubleData)gpd).RMINPTS=RMINPTS;
		((DoubleData)gpd).RMAXPTS=RMAXPTS;

	}
}


