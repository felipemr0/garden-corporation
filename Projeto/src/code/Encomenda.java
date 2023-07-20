package code;
public class Encomenda implements java.io.Serializable {
         private String nome ;
         private String numero ;
         private String idProd ;
         private String infor ;
         private int quantidade ;
         private Cliente cli ;
         private Produto prod ;
         private boolean reservado ;
         private String nomedoprod;
         private double montante;
         private double despesas ;
         
    /**
     * 
     * @param cli Cliente
     * @param prod Produto      
     * @param quantidade int
     */     
    public Encomenda(Cliente cli, Produto prod, int quantidade) {
        this.nome = cli.getNomecliente() ;
        this.numero = cli.getNumero() ;
        this.idProd = prod.getIdProd() ;
        this.infor = "" ;
        this.quantidade = quantidade ;
        this.reservado = prod.getReservado() ;
        this.nomedoprod = prod.getNomeproduto();
        this.montante = prod.getPreco() * this.quantidade;        
    }        
    /**
     * 
     * @param quantidade int
     */
    public void setQuant(int quantidade) {
        this.quantidade = quantidade ;
    }

    public double getMontante() {
        return montante;
    }
    
    /**
     * 
     * @return String
     */
    public String getNomeProd(){
        return this.nomedoprod;
    }
    /**
     * 
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @param idProd String
     */
    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }
    /**
     * 
     * @param infor String
     */
    public void setInfor(String infor) {
        this.infor = infor;
    }
    /**
     * 
     * @return int
     */
    public int getQuant() {
        return quantidade ;
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
     * @return String
     */
    public String getNumero() {
        return numero;
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
     * @return String 
     */
    public String getInfor() {
        return infor;
    }
}