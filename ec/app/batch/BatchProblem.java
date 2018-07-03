/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package ec.app.batch;
import ec.util.*;
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
        	((GPIndividual)ind).trees[0].printTwoArgumentNonterminalsAsOperatorsInC = false;
            
            double obj=0.0;
            JavaCallCPlus shp1 = new JavaCallCPlus();  
            String heu=((GPIndividual)ind).trees[0].child.makeCTree(true, true, true);
            System.out.println("outputed result1:");  
            System.out.println(heu);  
            double obj1=shp1.getobj(heu,this.InitialSeed);
        	obj=obj1+100;
            System.out.println("outputed result2:");  
        	System.out.println(obj); 
            // the fitness better be KozaFitness!
            KozaFitness f = ((KozaFitness)ind.fitness);
            f.setStandardizedFitness(state, obj);
            ind.evaluated = true;
            }
        }
    }

