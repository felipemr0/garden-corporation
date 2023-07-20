package code;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList ;


public class Listas implements java.io.Serializable {
   public ArrayList<Produto> lprod ;
   public ArrayList<Venda> lvend ; 
   public ArrayList<Encomenda> lenc ;
   public ArrayList<CartaoCliente> lcard ;
   public ArrayList<Cliente> lfcc ;
   public ArrayList<Chequeoferta> lcqo ;
   public Listas() {
       lcqo = new ArrayList<Chequeoferta>() ;
       lfcc = new ArrayList<Cliente>() ;
       lprod = new ArrayList<Produto>() ;
       lvend = new ArrayList<Venda>() ;
       lenc = new ArrayList<Encomenda>() ;
       lcard = new ArrayList<CartaoCliente>();
   }
   /**Método que permite registar um cheque oferta
    * 
    * @param cq Chequeoferta
    */
   public void RegCheq(Chequeoferta cq){
       for(Chequeoferta c: lcqo){
           if(c.getId().equals(cq.getId())){
               lcqo.add(cq);
           }else{
               
           }
       }
       lcqo.add(cq);
   }
   
   
   /**Método que permite registar uma ficha cliente
    * Se já existir não regista outra vez
    * @param c Cliente
    */
   public void Regficha(Cliente c) {
       if(checkidccli(c.getNumero())){
           for(Cliente cliente: lfcc){
               if(cliente.getNumero().equals(c.getNumero())){
                   
               }
           }
       }else{
           lfcc.add(c);
       }
   }
   /**Método que permite registar uma venda usando um cheque oferta
    *Se o cheque id não tiver vazio e howver quantidade de produto e se este não estiver reservado regista-se a venda e remove-se a quantidade no stock
    * @param x Venda
    */
   public void RegVendacheq(Venda x){
       if(!(x.getIdcheque().isEmpty())){
           if(checkquantprod(x.getIdProd(),x.getQuantidade())){
               if(!(x.isReservado())){
                   for(Chequeoferta cheque: lcqo){
                       if(x.getIdcheque().equals(cheque.getId())){
                           if(x.getValordocheque() >= x.getPreco()){
                           lvend.add(x);
                           removeQuant(x.getQuantidade(),x.getIdProd());
                       }
                       }
                   }
                }
           }
       }
   }
   /**Método que permite verificar se um dado nº cliente(id) existe
    * Se existir retorna true , caso contrário false
    * @param id String
    * @return boolean
    */
   public boolean checkidccli(String id){
       boolean b = false ;
       for(Cliente cliente: lfcc){
           if(cliente.getNumero().equals(id)){
               b = true ;
           }
       }
       return b ;
   }
   /**Método que permite verificar se um dado nº cartão existe(id)
    * Se existir retorna true , caso contrário false
    * @param id
    * @return 
    */
   public boolean checkidcard(String id){
       boolean b = false ;
       for(CartaoCliente cc: lcard){
           if(cc.getNumcartao().equals(id)){
               b = true ;
           }
       }
       return b ;
   }
   
   /**Método que permite registar um cartão cliente(cc)
    * Se o cartão já existir não regista , caso contrário regista-se o cartão
    * @param cc CartaoCliente
    */
   public void Regcard(CartaoCliente cc) {
       if(checkidcard(cc.getNumcartao())){  
           for(CartaoCliente dd: lcard){
               if(dd.getNumcartao().equals(cc.getNumcartao())){
                   
               }
           }
       }else{
           lcard.add(cc);
       }
    }
   /**Método que permite registar uma venda (x)
    * Só regista se o produto existir , se tiver quantidade no stock para efetuar a venda
    * Se não tiver reservado
    * Se vender por cartão de cliente incrementa os pontos e regista-se a venda e remove-se quantidade do stock
    * Se o objeto venda não receber número de cartão , regista-se 
    * @param x Venda
    */
   public void Regvenda (Venda x) {            
         if(checkid(x.getIdProd()) && checkquantprod(x.getIdProd() , x.getQuantidade()) ) {
             if(!(isreservado(x.getIdProd()))){ 
                 try{
                 if(!(x.getNumcard().isEmpty())){
                     double preco = x.getPreco();
                     double montante = preco * x.getQuantidade();
                     int pontosganhos = x.calculodepontos(montante);
                     for(CartaoCliente c: lcard) {
                         String ncard = c.getNumcartao();
                         if(ncard.equals(x.getNumcard())){
                             c.setPontos(pontosganhos + c.getPontos());
                             lvend.add(x);
                             removeQuant(x.getQuantidade() , x.getIdProd()) ;
                         }
                     }
                 }else{
             lvend.add(x) ;
             removeQuant(x.getQuantidade() , x.getIdProd()) ;
                 }
         }catch(Exception e) {
             lvend.add(x);
             removeQuant(x.getQuantidade() , x.getIdProd()) ;
         }
             }
         }
     }
   /**Método que permite registar uma venda e descontar os pontos
    * Só desconta pontos se tiver pontos no cartão
    * @param x Venda
    */
   public void Regvendacomdesc (Venda x) {
       if(checkid(x.getIdProd()) && checkquantprod(x.getIdProd() , x.getQuantidade()) ) {
           if(x.getPontos() > 0){
           if(!(isreservado(x.getIdProd()))){
               if(!(x.getNumcard().isEmpty())){
                   String number = x.getNumcard();
                   for(CartaoCliente c: lcard) {
                       if(number.equals(c.getNumcartao())){
                   double novovalor = (calcnovoprecopordesc(x.getValoradescontar(),x.getPreco(),x.getPontos(),x.getValorMax()));
                   c.setPontos(c.getPontos() - pontosadescontar);
                   x.setMontante(novovalor * x.getQuantidade());
                   int pontosganhos = x.calculodepontos(novovalor * x.getQuantidade());
                   c.setPontos(pontosganhos + c.getPontos());
                   lvend.add(x);
                   removeQuant(x.getQuantidade(), x.getIdProd());
                       }
                   }
               }
           }
           }
       }
   }
   /**Método que regista a venda usando um cheque oferta
    * 
    * @param x Venda
    */
   public void Registarvendaporcheque(Venda x){
       if(checkid(x.getIdProd()) && checkquantprod(x.getIdProd() , x.getQuantidade()) ) {
              if(!(isreservado(x.getIdProd()))){
                  
              }
       }
   }
   
   int pontosadescontar ;
   /**Método que permite calcular um novo valor que representará o novo preço descontado dos pontos
    * valoradescontar é o valor a descontar por cada ponto , normalmente será 1
    * preco é o valor que vai ser altera pelo método e retornado pelo mesmo
    * pontos são os pontos que vão ser utilizados para serem descontados 
    * valormáximo será um valor que não pode ser ultrapassado (preço limite)
    * @param valoradescontar double
    * @param preco double
    * @param pontos int
    * @param valormaximo double
    * @return double
    */
   public double calcnovoprecopordesc (double valoradescontar , double preco , int pontos , double valormaximo) {
       pontosadescontar = 0 ;
       boolean flag = false ;
       if(preco  <= valormaximo){
           flag = true ;
       }
       while(!flag){
           preco = preco - valoradescontar ;
           ++pontosadescontar ;
           --pontos ;
           if(preco == valormaximo ) {
               flag = true ;
           }
           if(pontos == 0) {
            flag = true ;  
           }
       }
       return preco ;
   }
   /**Método que verifiqua se um determinado produto(idprod) exsite em stock
    * 
    * @param idprod String
    * @return boolean
    */
   public boolean checkid(String idprod) {
          boolean b = false ;
          for(Produto c : lprod) {		  
    		  if(c.getIdProd().equals(idprod)) {
         		b = true;	  
      }
          }
          return b ;
      }   
   /**Método que verifica se uma determinada quantidade (q) é "suficiente" comparado com o stock
    * 
    * @param id String
    * @param q int
    * @return boolean
    */
   public boolean checkquantprod(String id , int q) {
       boolean b = false ;
       for(Produto c: lprod) {
           String i = c.getIdProd() ;
           if(id.equals(i)) {
               int qq = c.getQuant() ;
               if(qq > q || qq == q) {
                   b = true ;
               }
           }
       }
       return b ;
       }   
   /**Método que permite registar um produto (x) no stock
    * Ao registar fáz um "refresh" na lista de encomendas
    * Se o produto já existir não faz nada
    * @param x Produto
    */
   public void registaProd (Produto x) {
              updatequantinlenc(x.getIdProd());
              if(checkid(x.getIdProd()) == true ) {
                  for(Produto c: lprod){
                      if(x.getIdProd().equals(c.getIdProd())){
                          
                          }
                      }
                  }                  
              else{
                  lprod.add(x) ;
              }
       }
   /**Método que permite registar uma quantidade de um determinado produto
    * Ao adicionar quantidade fáz atualiza a lista de encomendas
    * A variável enc representa a quantidade encomendada
    * @param id String
    * @param quant int
    */
   public void registaQuant(String id , int quant) {
       updatequantinlenc(id);
       for(Produto c: lprod) {
           if(id.equals(c.getIdProd())) {
               if(!(c.getReservado())){
                   c.setQuant((quant + c.getQuant()) - enc);
                   updatequantinlenc(id);
               }else{
                   
                   enc = enc - quant;
                   updatequantinlenc(id);
               }
           }
       }
   }
   /**Método que atualiza a lista de encomendas(atualiza as informações de estado de encomenda) , atualiza tambén o stock(atualiza o estado do produto de reservado/não reservado)
    * 
    * @param id String
    */
    public void updatequantinlenc (String id) {
        for(Produto c: lprod) {
            if(id.equals(c.getIdProd())){
            boolean f = checkquantprod(c.getIdProd() , c.getQuant());
                if(f == true) {
                 for(Encomenda d: lenc) {
                    String idProd = d.getIdProd();
                    if(idProd.equals(c.getIdProd())) {
                        d.setInfor("Pronto");
                        c.setReservado(false);
                    }else{
                        d.setQuant(enc);
                        d.setInfor("Não Disponível");
                        c.setReservado(true);
                    }
                }
                }
            }
        }
    }    
      int quant ;
      /**Método que permite retornar a quantidade de um determinado produto(id)
       * 
       * @param id String
       * @return int
       */
      public int getQuant (String id) {
          for(Produto c: lprod ) {
    		  if(id.equals(c.getIdProd())) {
    			  quant = c.getQuant() ;
    		  }
    	  }
          return quant ;
      }
      /**Método que permite remover a quantidade(q) de um determiado produto(String) no stock
       * 
       * @param q int
       * @param idprod String 
       */
      public void removeQuant(int q , String idprod) {
    	  for(Produto c: lprod) {
    		  String id = c.getIdProd() ;
    		  if(id.equals(idprod)) {
    			  int i = c.getQuant() ;
    			  int ii = i - q ;
                          if(ii > 0 || i == 0) {
    			  c.setQuant(ii);
    		  }else{
                              ii = 0 ;
                              c.setQuant(ii);
                          }
                  }
    	  }
      } 
      int enc ;
      /**Método que permite registar uma encomenda(x)
       * 
       * @param x Encomenda
       */
   public void regEnc(Encomenda x) {
        if(checkid(x.getIdProd())) {
            if(checkquantprod(x.getIdProd() , x.getQuant())) {
                lenc.add(x) ;
                x.setInfor("PRONTO");
                removeQuant(x.getQuant() , x.getIdProd()) ;
            }else{
                enc = x.getQuant() - getQuant(x.getIdProd());
                porreservado(x.getIdProd()) ;
                x.setInfor("Não disponível");
                lenc.add(x) ; 
                removeQuant(x.getQuant() , x.getIdProd()) ;            
            }
        }
    }
   /**Método que permite saber se um determinado produto(id) está reservado(retorna true) ou não(retorna false)
    * 
    * @param id String
    * @return boolean
    */
   public boolean isreservado (String id) {
       boolean b = false ;
       for(Produto p: lprod) {
           String idprod = p.getIdProd() ;
           if(idprod.equals(id)) {
               b = p.getReservado() ;
           }
       }
       return b ;
   }
   /**Método que permite por um determinado produto em estado(Reservado)
    * 
    * @param id String
    */
   public void porreservado (String id) {
       for(Produto p: lprod) {
           String idprod = p.getIdProd() ;
           if(idprod.equals(id)) {
               p.setReservado(true);
           }
       }
   }
   /**Método que permite retornar a arraylist de encomendas
    * 
    * @return ArrayList<Encomenda>
    */
   public ArrayList<Encomenda> getLenc () {
        return this.lenc ;
    }
   /**Método que permite retornar a arraylist de vendas
    * 
    * @return ArrayList<Venda>
    */
    public ArrayList<Venda> getLvend() {
    	 return this.lvend ;
     }
    /**Método que permite retornar a arraylist de produtos(stock)
     * 
     * @return ArrayList<Produto>
     */
    public ArrayList<Produto> getLprod() {
    	  return this.lprod ;
      }
    /**Método que permite retornar a arraylist de clientes(fichas de clientes)
     * 
     * @return ArrayList<Cliente>
     */
    public ArrayList<Cliente> getLfcc(){
        return this.lfcc;
    }
    /**Método que permite retornar a arraylist de cartão cliente
     * 
     * @return ArrayList<CartaoCliente>
     */
    public ArrayList<CartaoCliente> getLcard(){
        return this.lcard;
    }
    /**Método que permite retornar a arraylist de cheques oferta
     * 
     * @return ArrayList<Chequeoferta>
     */
    public ArrayList<Chequeoferta> getLcqo(){
        return this.lcqo;
    }
    /**Método para gravar para o ficheiro
     * 
     * @param fich String
     * @throws IOException 
     */
    public void gravaObj(String fich) throws IOException {
      ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(fich));
      oos.writeObject(this);
      oos.flush(); oos.close();
  }
    /**Método que permite carregar os dados
     * 
     * @param sistema Sistema
     * @return Sistema
     * @throws IOException 
     */
     public Sistema carregaDados (Sistema sistema) throws IOException {
         try {
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dados.obj"));
             sistema = (Sistema) ois.readObject();
             ois.close();
         }
         catch(IOException e) {}
         catch(ClassNotFoundException ec) {};
         
         return sistema ;
     }
}