package ec.app.batch;

import ec.*;
import ec.gp.*;

public class RSSUMPT extends GPNode
{
	public String toString() { return "RSSUMPT"; }
	
	public int expectedChildren() { return 0; }

	public void eval(final EvolutionState state,
			final int thread,
			final GPData input,
			final ADFStack stack,
			final GPIndividual individual,
			final Problem problem)
	{
		DoubleData rd = ((DoubleData)(input));		
		rd.x = rd.RSSUMPT;
	}
}
