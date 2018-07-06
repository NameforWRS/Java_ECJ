/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package ec.app.batch;
import ec.util.*;
import jasima.core.statistics.SummaryStat;
import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;


public class BatchProblem extends GPProblem implements SimpleProblemForm
    {
    private static final long serialVersionUID = 1;
    
    public static final String P_Seed="Seed";
    
    public long InitialSeed=83261;
    
    public void setup(final EvolutionState state,
        final Parameter base)
        {
        super.setup(state, base);
        
        this.InitialSeed=state.parameters.getLongWithDefault(base.push(P_Seed), null, System.currentTimeMillis());
        // verify our input is the right class (or subclasses from it)
        if (!(input instanceof DoubleData))
            state.output.fatal("GPData class must subclass from " + DoubleData.class,
                base.push(P_DATA), null);
        }
        
    public void evaluate(final EvolutionState state, 
        final Individual ind, 
        final int subpopulation,
        final int threadnum)
        {
        if (!ind.evaluated)  // don't bother reevaluating
            {
        	//run evaluation        	
        	((GPIndividual)ind).trees[0].printTwoArgumentNonterminalsAsOperatorsInC = false;
            JavaCallCPlus shp1 = new JavaCallCPlus();  
            String heu=((GPIndividual)ind).trees[0].child.makeCTree(true, true, true);
			double obj=shp1.getobj(heu, this.InitialSeed);
            // the fitness better be KozaFitness!
			SummaryStat test1=new SummaryStat();			
            KozaFitness f = ((KozaFitness)ind.fitness);
            f.setStandardizedFitness(state, test1.value(obj).mean());
			f.setVariance(state, test1.value(obj).stdDev());
			f.NumOfEvaluations = test1.value(obj).numObs();
			f.summaryStat = test1.value(obj);
            ind.evaluated = true;
            }
        }
    }

