package aula12.ex2;
import aula12.ex2.IPlugin;

public class Plugin1 implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("PLUGIN1 LOADED");
	}

}
