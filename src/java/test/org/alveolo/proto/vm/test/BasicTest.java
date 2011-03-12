package org.alveolo.proto.vm.test;

import org.alveolo.proto.vm.Any;
import org.alveolo.proto.vm.ComposedFunction;
import org.alveolo.proto.vm.Function;
import org.alveolo.proto.vm.Int;
import org.alveolo.proto.vm.Type;
import org.alveolo.proto.vm.nativeimpl.MulIntFunction;
import org.alveolo.proto.vm.nativeimpl.SubIntFunction;

public class BasicTest {
	public static void main(String[] args) {
		Any[] arg = {new Int(1), new Int(2), new Int(3)};

		Type[] argTypes = {Type.get("avm.int"), Type.get("avm.int"), Type.get("avm.int")};
		Type[] retTypes = {Type.get("avm.int")};

		// (a, b, c) -> a - (b*c)
		Function[] instructions = {MulIntFunction.INSTANCE, SubIntFunction.INSTANCE};

		Function f = new ComposedFunction(argTypes, retTypes, instructions);

		// 1 - (2*3) -> -5
		Any[] ret = f.eval(arg);

		System.out.println("results: " + ret.length + ", value: " + ((Int) ret[0]).value);
	}
}
