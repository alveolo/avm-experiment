package org.alveolo.proto.vm.nativeimpl;

import org.alveolo.proto.vm.Any;
import org.alveolo.proto.vm.Function;
import org.alveolo.proto.vm.Int;
import org.alveolo.proto.vm.Type;

public class SubIntFunction extends Function {
	private static final Type[] ARG_TYPES = {Type.get("avm.int"), Type.get("avm.int")};
	private static final Type[] RET_TYPES = {Type.get("avm.int")};

	public static final SubIntFunction INSTANCE = new SubIntFunction();

	private SubIntFunction() {
		super(ARG_TYPES, RET_TYPES);
	}

	@Override
	public Any[] eval(Any[] params) {
		int i0 = ((Int) params[0]).value;
		int i1 = ((Int) params[1]).value;

		return new Any[] {new Int(i0 - i1)};
	}
}
