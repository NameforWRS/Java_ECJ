package ec.app.batch;

import ec.*;
import ec.gp.*;

public class Max extends GPNode
{
	public String toString() { return "max"; }

	public void eval(final EvolutionState state,
			final int thread,
			final GPData input,
			final ADFStack stack,
			final GPIndividual individual,
			final Problem problem)
	{
		double result;
		DoubleData rd = ((DoubleData)(input));

		children[0].eval(state,thread,input,stack,individual,problem);
		result = rd.x;

		children[1].eval(state,thread,input,stack,individual,problem);
		rd.x = Math.max(result, rd.x);

	}
}
