package ec.app.batch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import ec.gp.GPNode;
import jasima.core.random.continuous.DblConst;
import jasima.core.simulation.Simulation;
import jasima.core.simulation.Simulation.SimEvent;
import jasima.core.statistics.SummaryStat;
import jasima.core.util.observer.NotifierListener;
import jasima.shopSim.core.PR;
import jasima.shopSim.models.dynamicShop.DynamicShopExperiment;
import jasima.shopSim.models.dynamicShop.DynamicShopExperiment.Scenario;
import jasima.shopSim.prioRules.basic.FASFS;
import jasima.shopSim.prioRules.basic.FCFS;
import jasima.shopSim.prioRules.gp.NormalizedBrankeRule;
import jasima.shopSim.prioRules.gp.NormalizedBrankeRule_StringExecution;
import jasima.shopSim.prioRules.gp.testGPRule;
import jasima.shopSim.prioRules.meta.IgnoreFutureJobs;
import jasima.shopSim.util.BasicJobStatCollector;

public class DummyOperationWrapper {
	
	public ArrayList<DummyOperation> DummyOPs;
	public int NumOfDummyOPs = 100;
	public long InitialSeed;
	private Random rd;
	public HashMap NodeMapFitness = null;
	public Set setFitness = null;
	public DynamicShopExperiment dsExp;
	
	private double fifoFitness;
	
	public DummyOperationWrapper()
	{
		InitialSeed = 8888;
		rd = new Random(InitialSeed);
		DummyOPs = new ArrayList<DummyOperation>();
		NodeMapFitness = new HashMap();
		setFitness = new HashSet();
	}
	
	public void Init()
	{	
	}

	public double GetFitnessOfGPNode(GPNode node)
	{
		JavaCallCPlus shp1 = new JavaCallCPlus();  
		//System.out.println(node.makeCTree(true, true, true)); 
		double obj=shp1.getsimpleobj(node.makeCTree(true, true, true));
		//System.out.println(obj); 
		SummaryStat test1=new SummaryStat();
		test1.value(obj);
		
		double fitness = test1.mean();
		return fitness;
		
//		//testGPRule pr = new testGPRule(node);
//		NormalizedBrankeRule pr = new NormalizedBrankeRule(node);		
//		/*在这里添加node的simple test，并返回simple fitness*/
//		PR sr2 = new IgnoreFutureJobs(pr);
//		PR sr3 = new FASFS();
//		sr2.setTieBreaker(sr3);
//		dsExp.setSequencingRule(sr2);
//		
//		dsExp.runExperiment();
//		
//		Map<String, Object> res = dsExp.getResults();
//		SummaryStat flowtime = (SummaryStat)res.get("flowtime");
//		
//		BigDecimal fitness = BigDecimal.valueOf(flowtime.mean());
//		return fitness;
	}
	
	public SummaryStat getSimulationSummaryOfGPNode(GPNode node)
	{
		JavaCallCPlus shp1 = new JavaCallCPlus();  
		double obj=shp1.getsimpleobj(node.makeCTree(true, true, true));
		SummaryStat test1=new SummaryStat();
		test1.value(obj);
		return test1;
		
		
//		NormalizedBrankeRule pr = new NormalizedBrankeRule(node);		
//		
//		PR sr2 = new IgnoreFutureJobs(pr);
//		PR sr3 = new FASFS();
//		sr2.setTieBreaker(sr3);
//		dsExp.setSequencingRule(sr2);
//		
//		dsExp.runExperiment();
//		
//		Map<String, Object> res = dsExp.getResults();
//		SummaryStat flowtime = (SummaryStat)res.get("flowtime");
//		return flowtime;
	}
	
	public double getFitnessInDouble(GPNode node)
	{
		return GetFitnessOfGPNode(node);
	}
	
	public SummaryStat getFitnessInSummary(GPNode node)
	{
		SummaryStat test1=new SummaryStat();
		long seed=this.InitialSeed;
		for(int i=0;i<50;i++)
		{
			test1.combine(test1.value(GetFitnessOfGPNodewithSeed(node,seed)));
			seed++;
		}
		return test1;
	}
	
	public double GetFitnessOfGPNodewithSeed(GPNode node,long seed)
	{
		JavaCallCPlus shp1 = new JavaCallCPlus();  
		
		double obj=shp1.getsimpleobjwithseed(node.makeCTree(true, true, true), seed);
		SummaryStat test1=new SummaryStat();
		test1.value(obj);
		double fitness = test1.mean();
		return fitness;
	}
	public void AddFitness(BigDecimal fitness)
	{
		if(!setFitness.contains(fitness))	
		{
			setFitness.add(fitness);
		}
		
	}
	
	public void AddFitness(double fitness)
	{
		double fitnessBig = fitness;
		
		if(!setFitness.contains(fitnessBig))	
		{
			setFitness.add(fitnessBig);
		}
		
	}
	
	public Boolean isFitnessExisted(double fitness)
	{
		Boolean isSame = true;
		
		if(!setFitness.contains(fitness))	
		{		
			isSame = false;		}
		
		return isSame;
	}
	
	public Boolean isIndividualSame(GPNode node)
	{
		Boolean isSame = true;		
		double newfitness = GetFitnessOfGPNode(node);
		
//		if(newfitness.compareTo(fifoFitness) != -1)
//		{
//			return isSame;
//		}
		
		if(!setFitness.contains(newfitness))	
		{
			setFitness.add(newfitness);
			isSame = false;
		}
		
		return isSame;
	}
}
