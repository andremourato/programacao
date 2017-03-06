package number;

/**
 * Tipo de dados representando uma fracção.
 * Esta versão impõe um invariante (interno) mais forte:
 * as frações armazenadas têm sempre denominador positivo.
 * Isto permite simplificar alguns métodos.
 *
 * @author João Manuel Rodrigues
 * 2007-2017
 */
 
public class Fraction implements Comparable<Fraction>{
    
    private int den = 1;
    private int num = 0;
    
    public Fraction(int num, int den){
		
		assert invariant();
		if(den < 0){
			this.den = -den;
			this.num = -num;
		}else{
			this.den = den;
			this.num = num;
		}
		assert invariant();
		
	}
    
    public Fraction(){}

  /* Testa o invariante do objeto.
   * Ou seja, a propriedade que define a validade de uma fração.
   * É para testar em asserções nos métodos.
   */
  public boolean invariant() {
    if(den > 0) return true;   // O denominador não pode ser nulo (nem negativo)!
	return false;
  }

  /** Converte uma string numa fracção.
   *  Chamava-se fromString na v5.  Implementado de outra forma.
   *  @param str String no formato {@code "inteiro/inteiro"}
   *             representando uma fracção válida.
   *  @return fracção correspondente a {@code str}.
   */
  public static Fraction parseFraction(String str) {
    String[] p = str.split("/", 2);  // divide a string em até 2 partes
    int n = Integer.parseInt(p[0]);  // extrai numerador
    int d = (p.length==2)? Integer.parseInt(p[1]) : 1;
        // se tem 2 partes, extrai denominador, senão fica 1
    return new Fraction(n, d);
  }

  /** Converte a fracção numa string.
   *  @return string com a representação desta fracção.
   */
  public String toString() {
    assert invariant();
    // Com um invariante mais forte, pode-se simplificar este método!
    String s;
    s = "(" + num + "/" + den + ")";
    return s;
  }

  /** Devolve o numerador da fracção.
   *  @return numerador desta fração.
   */
  public int num() { return num; }

  /** Devolve o denominador da fracção.
   *  @return denominador desta fração.
   */
  public int den() { return den; }

  /** Multiplica esta fracção por outra (this * b).
   *  @param b multiplicando.
   *  @return fracção produto de this * b.
   */
  public Fraction multiply(Fraction b) {
    Fraction r = new Fraction();  // fracção para o resultado
    r.num = num*b.num;  // possibilidade de overflow!
    r.den = den*b.den;
    assert r.invariant() : "Result should be valid.";
    return r;
  }

  /** Adiciona esta fracção com outra (this + b).
   *  @param b fracção a adicionar a esta.
   *  @return fracção soma de this + b.
   */
  public Fraction add(Fraction b) {
    Fraction r = new Fraction();  // fracção para o resultado
    r.num = num*b.den + den*b.num;  // possibilidade de overflow!
    r.den = den*b.den;
    assert r.invariant() : "Result should be valid.";
    return r;
  }

  public Fraction divide(Fraction b) {
    assert b.invariant() : "Division by zero!";
    Fraction r = new Fraction();
    r.num = num*b.den;
    r.den = den *b.num;
    return r;
  }

  public Fraction subtract(Fraction b) {
	assert b.invariant() : "Division by zero!";
	Fraction r = new Fraction();
	r.num = num*b.den - den*b.num;  // possibilidade de overflow!
    r.den = den*b.den;
	assert r.invariant() : "Result should be valid.";
    return b;
  }

  public boolean equals(Fraction b) {
	assert b.invariant() : "Division by zero!";
	return (num / b.num) == (den / b.den);
}
	
  public int compareTo(Fraction b) {
	
	if((float)(num/den) < (float)(b.num/b.den)) return -1;
	else if((float)(num/den) > (float)(b.num/b.den)) return 1;
	else return 0;
  }
}
