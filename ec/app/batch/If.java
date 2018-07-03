package ec.app.batch;

import ec.*;
import ec.gp.*;

public class If extends GPNode
{
	public String toString() { return "If"; }
	
	public int expectedChildren() { return 3; }

	public void eval(final EvolutionState state,
			final int thread,
			final GPData input,
			final ADFStack stack,
			final GPIndividual individual,
			final Problem problem)
	{
		double firstParam;
		
		DoubleData rd = ((DoubleData)(input));

		children[0].eval(state,thread,input,stack,individual,problem);
		firstParam = rd.x;
		
		if(firstParam >= 0)
		{
			children[1].eval(state,thread,input,stack,individual,problem);			
		}
		else
		{
			children[2].eval(state,thread,input,stack,individual,problem);
		}


	}

}
