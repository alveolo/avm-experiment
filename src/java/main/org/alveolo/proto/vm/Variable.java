package org.alveolo.proto.vm;

public class Variable {
	public final Any type;
	public Object value;

	public Variable(Any type) {
		this.type = type;
	}

	public Variable(Any type, Object value) {
		this.type = type;
		this.value = value;
	}
}
