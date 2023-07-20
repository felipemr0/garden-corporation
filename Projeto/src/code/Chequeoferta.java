package code;
public class Chequeoferta implements java.io.Serializable {
    private String id ;
    private double valor ;
    private String numerocliente ;
    private String nome ;
    private String numerocliente2 ;
    private String numeroowner;
    private String nomecomprador;
    private String nomedono ;
    private double despesas ;
    /**
     * 
     * @param cli Cliente
     * @param clii Cliente
     * @param clienteowner Cliente
     * @param id String
     * @param valor double
     */
    public Chequeoferta(Cliente cli , Cliente clii , Cliente clienteowner ,String id, double valor ){
        this.id = id ;
        this.valor = valor ;
        this.numerocliente = cli.getNumero();
        this.numerocliente2 = clii.getNumero();
        this.numeroowner = clienteowner.getNumero();
        this.nomecomprador = cli.getNomecliente();
        this.nomedono = clii.getNomecliente();
        this.despesas = cli.getDespesas();
    }

    public double getDespesas() {
        return this.despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas + this.despesas;
    }
    
    /**
     * 
     * @return String
     */
    public String getNomecomprador() {
        return nomecomprador;
    }
    /**
     * 
     * @return String
     */
    public String getNomedono() {
        return nomedono;
    }
    /**
     * 
     * @return String
     */
    public String getNumeroowner() {
        return numeroowner;
    }
    /**
     * 
     * @param numeroowner String
     */
    public void setNumeroowner(String numeroowner) {
        this.numeroowner = numeroowner;
    }
    /**
     * 
     * @param numerocliente2 String
     */
    public void setNumerocliente2(String numerocliente2) {
        this.numerocliente2 = numerocliente2;
    } 
    /**
     * 
     * @return String
     */
    public String getNumerocliente2() {
        return numerocliente2;
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
     * @return String
     */
    public String getNome() {
        return nome;
    }
    /**
     * 
     * @return String
     */
    public String getNumerocliente() {
        return numerocliente;
    }
    /**
     * 
     * @param numerocliente String
     */
    public void setNumerocliente(String numerocliente) {
        this.numerocliente = numerocliente;
    }
    /**
     * 
     * @return String
     */
    public String getId() {
        return id;
    }
    /**
     * 
     * @return double
     */
    public double getValor() {
        return valor;
    }
    /**
     * 
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 
     * @param valor double
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
}
