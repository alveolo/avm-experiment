package org.alveolo.proto.vm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComposedFunction extends Function {
	public final Function[] instructions;

	public ComposedFunction(Type[] argumentTypes, Type[] returnTypes, Function[] instructions) {
		super(argumentTypes, returnTypes);
		this.instructions = instructions;
	}

	@Override
	public Any[] eval(Any[] args) {
		List<Any> vars = new ArrayList<Any>(Arrays.asList(args));

		for (Function instr : instructions) {
			int size = vars.size();
			List<Any> argList = vars.subList(size - instr.argumentTypes.length, size);
			Any[] instrArgs = argList.toArray(new Any[argList.size()]);
			argList.clear();
			Any[] instrRets = instr.eval(instrArgs);
			vars.addAll(Arrays.asList(instrRets));
		}

		return vars.toArray(new Any[vars.size()]);
	}
}
