package org.alveolo.proto.vm;

import java.util.HashMap;

/**
 * Type of variable.
 */
public class Type extends Any {
	public final String name;

	private Type(String name) {
		super("avm.type");
		this.name = name;
	}

	private static final HashMap<String, Type> types = new HashMap<String, Type>();

	public static synchronized Type get(String name) {
		Type t = types.get(name);
		if (t == null) {
			types.put(name, t = new Type(name));
		}
		return t;
	}

	static synchronized Type get(String name, Any any) {
		if (name.equals("avm.type")) {
			return (Type) any;
		}

		return get(name);
	}
}
