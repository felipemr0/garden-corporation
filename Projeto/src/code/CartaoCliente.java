package code;
public class CartaoCliente implements java.io.Serializable {
    private Cliente cli ;
    private int pontos ;
    private String numcartao ;
    private String nome ;
    private String numero ;
    private double despesas ;
    /**
     * 
     * @param cli Cliente
     * @param numcartao String
     */
    public CartaoCliente (Cliente cli  , String numcartao) {
        this.nome = cli.getNomecliente() ;
        this.numero = cli.getNumero() ;
        this.pontos = 0 ;
        this.numcartao = numcartao ;
        this.despesas = cli.getDespesas();
    }
    /**
     * 
     * @return double
     */
    public double getDespesas() {
        return this.despesas;
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
     * @param p int
     */
    public void setPontos (int p) {
        this.pontos =  p ;
    }
    /**
     * 
     * @return int
     */
    public int getPontos () {
        return this.pontos ;
    }
    /**
     * 
     * @return String
     */
    public String getNum () {
        return this.numero ;
    }
    /**
     * 
     * @return String
     */
    public String getNom () {
        return this.nome ;
    }
    /**
     * 
     * @return String
     */
    public String getNumcartao () {
        return this.numcartao ;
    }
    /**
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
     * @param numero String
     * @return boolean
     */
    public boolean checkcard (String numero) {
    boolean b = false ;
    if(this.numcartao.equals(numero)) {
        b = true ;
    }
    return b ;    
}
}