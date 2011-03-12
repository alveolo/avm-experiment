package org.alveolo.proto.vm;

public abstract class Function extends Any {
	public final Type[] argumentTypes;
	public final Type[] returnTypes;

	public Function(Type[] argumentTypes, Type[] returnTypes) {
		super(getTypeName(argumentTypes, returnTypes));
		this.argumentTypes = argumentTypes;
		this.returnTypes = returnTypes;
	}

	public abstract Any[] eval(Any[] args);

	public static String getTypeName(Type[] argTypes, Type[] retTypes) {
		StringBuilder b = new StringBuilder();

		b.append("avm.function${");
		for (Type t : argTypes) {
			b.append('{').append(t.name).append('}');
		}
		b.append('}');

		b.append("{");
		for (Type t : retTypes) {
			b.append('{').append(t.name).append('}');
		}
		b.append('}');

		return b.toString();
	}
}
