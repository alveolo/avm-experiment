package org.alveolo.proto.vm;

/**
 * Represents a variable of root type (super-type of any type) in type hierarchy.
 */
public class Any {
	public final Type type;

	public Any(Type type) {
		this.type = type;
	}

	public Any(String typeName) {
		this.type = Type.get(typeName, this);
	}
}
