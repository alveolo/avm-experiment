package org.alveolo.proto.vm;

public class Int extends Any {
	public final int value;

	public Int(int value) {
		super("avm.int");
		this.value = value;
	}
}
