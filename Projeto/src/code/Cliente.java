package code;

public class Cliente implements java.io.Serializable {
private String nome ;
private String numero ;
private String numerotel ;
private double despesas ;
/**
 * 
 * @param nome String
 * @param numero String
 * @param numerotel String
 */
public Cliente(String nome , String numero , String numerotel) {
	this.nome = nome ;
	this.numero = numero ;
        this.numerotel = numerotel ;
        this.despesas = 0 ;
}
    /**
     * 
     * @param despesas double
     */
    public void setDespesas(double despesas) {
        this.despesas = this.despesas + despesas;
    }

    /**
     * 
     * @return double
     */
    public double getDespesas() {
        return despesas;
    }


/**
 * 
 * @return String
 */
public String getNumerotel(){
    return this.numerotel;
}
/**
 * 
 * @return String
 */
public String getNomecliente(){
	return nome ;
}
/**
 * 
 * @return String
 */
public String getNumero() {
	return numero ;
}
/**
 * 
 * @param nome String
 */
public void setNome (String nome) {
	this.nome = nome ;
}
/**
 * 
 * @param numero String
 */
public void setNumero (String numero) {
	this.numero = numero ;
}
/**
 * 
 * @param numerotel String
 */
public void setNumerotel(String numerotel){
    this.numerotel = numerotel;
}
}
