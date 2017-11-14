package aula8.ex2;

public class Pixel {
	
	final byte R;
	final byte G;
	final byte B;
	
	public Pixel(byte b, byte g, byte r) {
		R = r;
		G = g;
		B = b;
	}
	
	@Override
	public String toString() {
		return "RGB("+(R & 0xff)+","+(G & 0xff)+","+(B & 0xff)+")";
	}
	
}
