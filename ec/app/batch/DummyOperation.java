package ec.app.batch;

import ec.gp.GPIndividual;
import ec.gp.GPNode;
import jasima.core.random.continuous.DblConst;
import jasima.core.simulation.Simulation;
import jasima.core.simulation.Simulation.SimEvent;
import jasima.core.util.observer.NotifierListener;
import jasima.shopSim.models.dynamicShop.DynamicShopExperiment;
import jasima.shopSim.models.dynamicShop.DynamicShopExperiment.Scenario;
import jasima.shopSim.prioRules.gp.testGPRule;
import jasima.shopSim.util.BasicJobStatCollector;

import java.util.Random;

public class DummyOperation {
	double FPT;
	double SPT;
	double FSUMPT;
	double FMAXPT;
	double FMINPT;
	double SSUMPT;
	double SMAXPT;
	double SMINPT;
	double RFSUMPT;
	double RFMAXPT;
	double RFMINPT;
	double RSSUMPT;
	double RSMAXPT;
	double RSMINPT;
	public long InitialSeed = 10000;
	public int Index;
	public double Priority;
	
/*	public DummyOperation(long seed, int index)
	{
		InitialSeed = seed;
		Index = index;
		
		Random rd = new Random(InitialSeed);
		SPT = rd.nextDouble() * 46 + 1;
		ESUMPT = rd.nextDouble() * 47;
		EMAXPT = rd.nextDouble() * 410;
		EMINPT = rd.nextDouble() * 263 + 1;
		RSUMPT = rd.nextInt() * 9 + 1;
		RMAXPT = rd.nextDouble() * 1500;
		RMINPT = rd.nextDouble() * 2770;
	}*/
	
/*	public double calPriority(GPNode rootNode)
	{
		DoubleData input = new DoubleData();
		input.SPT = SPT;
		input.ESUMPT = ESUMPT;
		input.EMAXPT = EMAXPT;
		input.EMINPT = EMINPT;
		input.RSUMPT = RSUMPT;
		input.RMAXPT = RMAXPT;
		input.RMINPT = RMINPT;
		
		//rootNode.evalSimple(input);

		return input.x;	
	}*/
}
