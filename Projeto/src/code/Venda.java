package code;

public class Venda implements java.io.Serializable {
private String nome ;
private String numero ;
private String idProd ;
private int quantidade ;
private Produto prod ;
private Cliente cli ;
private double preco ;
private boolean reservado ;
private CartaoCliente cc ;
private int pontos ;
private String numcard ;
private double valoradescontar ;
private double montantetotalapagar ;
private double valormáximodescontado ;
private String nomedoproduto;
private double despesas ;
private String idcheque ;
private double valordocheque ;
/**
 * 
 * @param x Cliente
 * @param prod Produto
 * @param quantidade int
 */
public Venda(Cliente x, Produto prod ,int quantidade) {
        this.nome = x.getNomecliente() ;
        this.numero = x.getNumero() ;
	this.idProd = prod.getIdProd() ;
	this.quantidade = quantidade;
        this.preco = prod.getPreco() ;
        this.reservado = prod.getReservado() ;
        this.montantetotalapagar = prod.getPreco() * quantidade ;
        this.nomedoproduto = prod.getNomeproduto();
        this.despesas = x.getDespesas();
}
/**
 * 
 * @param prod Produto
 * @param quantidade int
 */
public Venda(Produto prod , int quantidade) {
	this.idProd = prod.getIdProd() ;
	this.quantidade = quantidade;
        this.preco = prod.getPreco() ;
        this.reservado = prod.getReservado() ;
        this.montantetotalapagar = prod.getPreco() * quantidade ;
        this.nomedoproduto = prod.getNomeproduto();
}
/**
 * 
 * @param cc CartaoCliente
 * @param prod Produto
 * @param quantidade int
 */
public Venda(CartaoCliente cc , Produto prod , int quantidade ){
    this.nome = cc.getNom();
    this.numero = cc.getNum();
    this.idProd = prod.getIdProd();
    this.preco = prod.getPreco();
    this.reservado = prod.getReservado();
    this.quantidade = quantidade ;
    this.pontos = cc.getPontos();
    this.numcard = cc.getNumcartao();
    this.valoradescontar = 1 ;
    this.montantetotalapagar = prod.getPreco() * this.quantidade ;
    this.valormáximodescontado = 10 ;
    this.nomedoproduto = prod.getNomeproduto();
    this.despesas = cc.getDespesas();
}
/**
 * 
 * @param cheque Chequeoferta
 * @param prod Produto
 * @param quantidade int
 */
public Venda(Chequeoferta cheque,Produto prod , int quantidade){
    this.idProd = prod.getIdProd();
    this.idcheque = cheque.getId();
    this.nomedoproduto = prod.getNomeproduto();
    this.numero = cheque.getNumeroowner();
    this.quantidade = quantidade;
    this.reservado = prod.getReservado();
    this.preco = prod.getPreco();
    this.valordocheque = cheque.getValor();
}
/**
 * 
 * @return String
 */
    public String getIdcheque() {
        return idcheque;
    }

    public double getValordocheque() {
        return this.valordocheque;
    }
    
/**
 * 
 * @return boolean
 */
    public boolean isReservado() {
        return this.reservado;
    }
    public void setDespesas(double despesas){
        this.despesas = despesas + this.despesas;
    }
    public double getDespesas(){
        return this.despesas;
    }
    
/**
 * 
 * @return String
 */
public String getNomedoProd(){
    return this.nomedoproduto;
}
/**
 * 
 * @return double
 */
public double getValorMax() {
    return this.valormáximodescontado;
}
/**
 * 
 * @param novovalor double
 */
public void setValorMax(double novovalor) {
    this.valormáximodescontado = novovalor ;
}
/**
 * 
 * @return double
 */
public double getPreco () {
    return this.preco ;
}
/**
 * 
 * @param p double
 */
public void setPreco (double p) {
    this.preco = p ;
} 
/**
 * 
 * @return double
 */
public double getMontante() {
    return this.montantetotalapagar;
}
/**
 * 
 * @param valor double
 */
public void setMontante(double valor) {
    this.montantetotalapagar = valor ;
}
/**
 * 
 * @return String
 */
public String getNome() {
	return nome;
}
/**
 * 
 * @param nome String
 */
public void setNomecliente(String nome) {
	this.nome = nome;
}
/**
 * 
 * @return String
 */
public String getNumero() {
	return this.numero;
}
/**
 * 
 * @param numero String
 */
public void setNumero(String numero) {
	this.numero = numero;
}
/**
 * 
 * @return String
 */
public String getIdProd() {
	return idProd;
}
/**
 * 
 * @param idProd String
 */
public void setIdProd(String idProd) {
	this.idProd = idProd;
}
/**
 * 
 * @return int
 */
public int getQuantidade() {
	return quantidade;
}
/**
 * 
 * @param quantidade int
 */
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
/**
 * 
 * @param val double
 */
public void setValoradescontar(double val) {
    this.valoradescontar = val ;
}
/**
 * 
 * @return double
 */
public double getValoradescontar() {
    return this.valoradescontar;
}
/**
 * 
 * @return String
 */
public String getNumcard() {
    return this.numcard;
}
/**
 * 
 * @return int
 */
public int getPontos() {
    return this.pontos;
}
/**Método que permite calcular pontos dado um determinado valor(valor)
 * 
 * @param valor double
 * @return int
 */
public int calculodepontos (double valor) {
    int pts = 0 ;
    boolean b = true ;
    if (valor > 10) {
    while (b) {
        valor = valor - 10 ;
        if(valor > 0 || valor == 0) {
            ++pts ;
        }else{
            b = false ;
        }
    }
    }
    return pts ;
}
/**
 * 
 * @param p int
 */
public void setPontos(int p) {
    this.pontos = p ;
}
}