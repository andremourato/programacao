package aula12.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import aula10.ex1.Circulo;

public class ObjectGenerator {
	
	static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Object> createdObjects = new ArrayList<>();
		Object obj = null;
		String inputClass = null;
		do{
			System.out.print("Class of object: ");
			inputClass = read.nextLine();
			if(inputClass.equals("0")) break;
			try {
				obj = createObject("aula12.ex1."+inputClass);
			} catch (InstantiationException e) {
				System.out.println("Given name is an Interface or Abstract Class. Please insert a class.");
				continue;
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found. Insert a valid one!");
				continue;
			}catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			createdObjects.add(obj);
			dumpObject(obj);
		}while(true);
		for(int i = 0; i < createdObjects.size(); i++) {
			System.out.println(i+" - "+createdObjects.get(i));
		}
		System.out.print("Selected object: ");
		try {
			invokeClassMethod(createdObjects.get(Integer.parseInt(read.nextLine())));
		} catch (Exception e) {
			System.out.println("Invalid arguments");
			System.exit(1);
		}
	}

	private static void invokeClassMethod(Object c1) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] classMethods = c1.getClass().getDeclaredMethods();
		for(int i = 0; i < classMethods.length; i++) {
			System.out.println(i+" - "+methodToString(classMethods[i].toString()));
		}
		System.out.println("Selected method: ");
		Method method = classMethods[Integer.parseInt(read.nextLine())];
		Class<?>[] argTypes = method.getParameterTypes();
		List<Object> args = new ArrayList<>();
		for(int i = 0; i < argTypes.length; i++) {
			args.add(instanciateObjectOfType(argTypes[i]));
		}
		System.out.println("Output: "+method.invoke(c1, args.toArray(new Object[0])));
	}

	private static Object createObject(String className) throws ClassNotFoundException,
	InstantiationException,Exception {
		Class<?> reflection = Class.forName(className);
		if(Modifier.isAbstract( reflection.getModifiers() ) || reflection.isInterface())
			throw new InstantiationException();
		Constructor<?>[] constructors = reflection.getConstructors();
		for(int i = 0; i < constructors.length; i++) {
			System.out.println(i+" - "+constructorToString(constructors[i]));
		}
		int chosenIndex = -1;
		do {
			System.out.print("Selected constructor: ");
			try {
				chosenIndex = Integer.parseInt(read.nextLine());
			}catch(Exception e) {
				System.out.println("Invalid index!");
			}
		}while(chosenIndex == -1);
		Constructor<?> chosenOne = constructors[chosenIndex];
		Class<?>[] params = chosenOne.getParameterTypes();
		List<Object> args = new ArrayList<>();
		for(Class<?> param : params) {
			args.add(instanciateObjectOfType(param));
		}
		return chosenOne.newInstance(args.toArray(new Object[0]));
	}
	
	private static Object instanciateObjectOfType(Class<?> arg) {
		String argType = arg.getCanonicalName();
		Object obj = null;
		String userInputValue = null;
		if(arg.isPrimitive()) {
			System.out.print(argType+": ");
			userInputValue = read.nextLine();
		}
		if(argType.equals("float")) {
			obj = Float.parseFloat(userInputValue);
		}else if(argType.equals("double")) {
			obj = Double.parseDouble(userInputValue);
		}else if(argType.equals("byte")) {
			obj = Byte.parseByte(userInputValue);
		}else if(argType.equals("int")) {
			obj = Integer.parseInt(userInputValue);
		}else if(argType.equals("short")) {
			obj = Short.parseShort(userInputValue);
		}else if(argType.equals("long")) {
			obj = Long.parseLong(userInputValue);
		}else if(argType.equals("boolean")) {
			obj = Boolean.parseBoolean(userInputValue);
		}else if(argType.equals("char")) {
			obj = userInputValue.charAt(0);
		}else if(argType.equals("String")){
			obj = userInputValue;
		}else{ //In case it's not a primitive type
			try {
				obj = createObject(arg.getCanonicalName());
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("UNKNOWN ERROR");
				System.exit(1);
			}
		}
		return obj;
	}

	private static void dumpObject(Object c1) {
		Class<?> reflection = c1.getClass();
		System.out.print(Modifier.toString(reflection.getModifiers()));
		/* Prints type */
		if(reflection.isInterface())
			System.out.print(" interface ");
		else
			System.out.print(" class ");
		
		/* Prints the name */
		System.out.print(reflection.getSimpleName());
		
		/* Prints the superclasses */
		System.out.print(reflection.getSuperclass() != null ? " extends " +
				getSimpleName(reflection.getSuperclass().toString()): "");
		/* Prints implemented interfaces */
		Class<?>[] interfaces = reflection.getInterfaces();
		if(interfaces.length != 0) {
			System.out.print(" implements ");
			for(int i = 0; i < interfaces.length; i++) {
				Class<?> interfa = interfaces[i];
				System.out.print(i == 0 ? "" : ",");
				System.out.print(getSimpleName(interfa.toString()));
			}
		}
		System.out.println(" {\n");
		
		/* Prints the constructors */
		Constructor[] constructors = reflection.getConstructors();
		for(Constructor constructor : constructors) {
			System.out.println("\t"+constructorToString(constructor) + " { ... }");
		}
		
		System.out.println();
		
		/* Prints fields */
		Field[] fields = reflection.getFields();
		for(Field field : fields) {
			String[] strArray = field.toString().split(" ");
			System.out.println("\t"+strArray[0]+" "
									+getSimpleName(strArray[1])+" "
									+getSimpleName(strArray[2]));
		}
		
		/* Prints methods */
		Object[] methods = reflection.getDeclaredMethods();
		List<Object> list = Arrays.stream(methods).map(x -> x.toString()).sorted(new Comparator<Object>() {
			//Sorts the methods alphabetically
			@Override
			public int compare(Object o1, Object o2) {
				String[] split1 = o1.toString().split(" ");
				String o1String = split1[split1.length-1];
				String[] split2 = o2.toString().split(" ");
				String o2String = split2[split2.length-1];
				return o1String.compareTo(o2String);
			}
		}).collect(Collectors.toList());
		
		for(Object method : list){
			String[] strArray = method.toString().split(" ");
			System.out.println("\t" + methodToString(method.toString()));
		}
		
		System.out.println("\n}");
	}
	
	private static String constructorToString(Constructor constructor) {
		String[] spaceSplit = constructor.toString().split(" ");
		String rawDeclaration = spaceSplit[spaceSplit.length-1];
		String[] args = rawDeclaration.substring(constructor.getName().length()+1, rawDeclaration.length()-1).split(",");
		String str = "";
		str = getSimpleName(constructor.getName()) + "(";
		for(int i = 0; i < args.length; i++) {
			if(i != 0)
				str += ",";
			str += getSimpleName(args[i]);
		}
		return str + ")";
	}
	
	/* Converts "public void package1.method(aula11.ex2.Ponto,int,int)" to "Circulo(Ponto,int,int)" */
	private static String methodToString(String rawDeclaration) {
		String[] spaceSplit = rawDeclaration.split(" ");
		String[] argsRawArray = spaceSplit[spaceSplit.length-1].split("\\(");
		String argsRawString = argsRawArray[argsRawArray.length-1];
		argsRawString = argsRawString.substring(0,argsRawString.length()-1);
		String[] args = argsRawString.split(",");
		String methodName = getSimpleName(argsRawArray[0]);
		String[] array = rawDeclaration.split("\\(");
		return spaceSplit[0]+" "+
				getSimpleName(spaceSplit[1])+" "+
				methodName+"("+
				Arrays.stream(args).map(x -> getSimpleName(x)).collect(Collectors.joining(","))
				+ ")";
	}
	
	/* Converts "java.util.Scanner" to "Scanner" */
	private static String getSimpleName(String fullName) {
		String[] array = fullName.split("\\.");
		if(array.length == 0) return fullName;
		return array[array.length-1];
	}
}
