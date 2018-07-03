package ec.app.batch;

import ec.*;
import ec.gp.*;

public class SPT extends GPNode
{
	public String toString() { return "SPT"; }
	
	public int expectedChildren() { return 0; }

	public void eval(final EvolutionState state,
			final int thread,
			final GPData input,
			final ADFStack stack,
			final GPIndividual individual,
			final Problem problem)
	{
		DoubleData rd = ((DoubleData)(input));		
		rd.x = rd.SPT;
	}
}
