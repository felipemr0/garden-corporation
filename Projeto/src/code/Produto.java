package code;

public class Produto implements java.io.Serializable {
private String nomep ;
private double preco ;
private String idProd ;
private int quantidadeProd ;
private boolean reservado ;

/**
 * 
 * @param nomep String
 * @param preco double
 * @param idprod String
 */
public Produto(String nomep , double preco , String idprod ) {
        this.reservado = false ;
	this.nomep = nomep ;
	this.preco = preco ;
	this.idProd = idprod ;
	this.quantidadeProd = 0 ;
}

/**
 * 
 * @return boolean
 */
    public boolean getReservado() {
        return this.reservado;
    }
/**
 * 
 * @param r boolean
 */
    public void setReservado(boolean r) {
        this.reservado = r;
    }
/**
 * 
 * @return int
 */
public int getQuant () {
	return this.quantidadeProd ;
}
/**
 * 
 * @return String
 */
public String getNomeproduto () {
	return nomep ;
}
/**
 * 
 * @return double
 */
public double getPreco () {
	return preco ;
}
/**
 * 
 * @return String
 */
public String getIdProd () {
	return idProd ;
}
/**
 * 
 * @param nomep String
 */
public void setNomep (String nomep) {
	this.nomep = nomep ;
}
/**
 * 
 * @param preco double
 */
public void setPreco (double preco) {
	this.preco = preco ;
}
/**
 * 
 * @param quantidadeProd int
 */
public void setQuant (int quantidadeProd) {
	this.quantidadeProd = quantidadeProd ;
}
/**
 * 
 * @param idProd String
 */
public void setIdProd (String idProd) {
	this.idProd = idProd ;
}
/**
 * 
 * @return String
 */
    @Override
    public String toString() {
        return "Produto{" + "nomep=" + nomep + ", preco=" + preco + ", idProd=" + idProd + ", quantidadeProd=" + quantidadeProd + ", reservado=" + reservado + '}';
    }

}
