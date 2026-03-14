import java.util.*;
//esse é um jogo de texto criado por uma aluno do 1 ano

//meta: dividir novamente as classes entre: essenciais,enemy,player,esploração e combate
//como declarar um jogador de maneira universal?
// talvez seja preciso reescrever a logica e fazer ela funcionar com classes sendo usadas por uma função central Main

class Esencias {
    static Scanner teclado = new Scanner(System.in);
    static Random gerador = new Random();
}

class Enemy {
    public String nome;
    public int vida;
    public int agilidade;
    public int dano;
    public String descricao;

    public Enemy(String nome, int vida, int agilidade, int dano, String descricao) {
        this.nome = nome;
        this.vida = vida;
        this.agilidade = agilidade;
        this.dano = dano;
        this.descricao = descricao;
    }
}

class Player {

    public static int inventarioValores[] = new int[6];
    static String inventarioNomes[] = new String[6];
    public static int espacoPrenchido = 0;
    static int ouro;
    String nome;
    int vida_player;
    int agilidade_player;
    int dano_player;

    public Player() {
        vida_player = Esencias.gerador.nextInt(8) + 6;
        agilidade_player = Esencias.gerador.nextInt(5) + 6;
        dano_player = 6;
    }

    public void novoPersonagem() {
        System.out.println("""
        Este é um mundo de Magia e Grandeza, forjado sobre os escombros de um Antigo Império de poder imensurável.
        A humanidade se refugia em pequenas Cidades-Reino — baluartes da civilização erguidos para resistir aos perigos da imensa Grande Mata de Amantri.
        Esta floresta, uma criação mágica de última esperança do império caído, guarda em suas profundezas as Ruínas e os Artefatos Antigos que sustentam a vida moderna.
        Exploradores audazes, como você, arriscam-se por este labirinto verde em busca de tesouros e relíquias — pois é na herança do passado que reside o futuro.
        """);
        System.out.println("Então qual é o seu nome?");
        nome = Esencias.teclado.nextLine();

        System.out.println(nome + ", você é mais rápido ou resistente?");
        String escolha = Esencias.teclado.nextLine();

        if (escolha.equalsIgnoreCase("rapido")) {
            agilidade_player += 5;
        }
        else if (escolha.equalsIgnoreCase("resistente")) {
            vida_player += 5;
        }

        System.out.println("Então vamos começar? (pressione ENTER)");
        Esencias.teclado.nextLine();
    }
}

class text_game {

    static String item;
    static String act ="";
   // static int fuga = Esencias.gerador.nextInt(20)+1;

    //declaração de jogador
    static Player jogador = new Player();
    

   //salas
   static int maxSalas =10;
   static int salas_percoridas;
   //laço principal
   public static void main(String[] args) {
    System.out.println("""
        adventure game by:matheus Trajano

                                  |>>>
                                  |
                    |>>>      _  _|_  _         |>>>
                    |        |;| |;| |;|        |
                _  _|_  _    \\\\.    .  /    _  _|_  _

               |;|_|;|_|;|    \\\\:. ,  /    |;|_|;|_|;|
               \\\\..      /    ||;   . |    \\\\.    .  /
                \\\\.  ,  /     ||:  .  |     \\\\:  .  /
                 ||:   |_   _ ||_ . _ | _   _||:   |
                 ||:  .|||_|;|_|;|_|;|_|;|_|;||:.  |
                 ||:   ||.    .     .      . ||:  .|
                 ||: . || .     . .   .  ,   ||:   |       \\\\,/
                 ||:   ||:  ,  _______   .   ||: , |            /`\\\\
                 ||:   || .   /+++++++\\\\    . ||:   |
                 ||:   ||.    |+++++++| .    ||: . |
              __ ||: . ||: ,  |+++++++|.  . _||_   |
     ____--`~    '--~~__|.    |+++++__|----~    ~`---,              ___
-~--~                   ~---__|,--~'                  ~~----_____-~'   `~----~~
                        press [enter] to start
        """);
    Esencias.teclado.nextLine();
    jogador.novoPersonagem();
    //jogo_historia(args);  
    exploração(args);       
    }
       //na verdade isso é a "história" do jogo
       //n vou voltar e renomear o negocio interio
       private static void exploração(String[] args){
            int acontecimento = Esencias.gerador.nextInt(3);
            switch (acontecimento) {
                case 0 -> vila(args);
                case 1 -> jogo_historia(args);
                case 2 -> {
                    System.out.println("enquanto você viaja pela relva você escuta um barulho vindo da mata");
                    System.out.println("você ve algo se movnedo você deseja fugir[f] ou lutar[l] ");
                    act = Esencias.teclado.nextLine();
                    if(act.equalsIgnoreCase("f")){
                        if(Esencias.gerador.nextInt(20)+1d >= 10){
                            System.out.println("você foge");
                            exploração(args);
                        }
                        else{
                            System.out.println("você tenta fugir mas não consegue");
                            combate();
                        }
                    }
                    exploração(args);
            }
            }
       }
       private  static void vila(String[] args){
            System.out.println("após andar um pouco você encontra uma vila, onde você quer ir: \n taverna[t] \n quadro de missões[q] \n loja[l] \n ou sair[s]");
            String go = Esencias.teclado.nextLine();
            switch (go) {
                case "t" -> {
                    System.out.println("você chega a uma grande taverna comunitaria");
                    System.out.println("a comida é barata, você paga uma moeda e de dão um prato");
                    System.out.println("você sente revigorado, após isso você segue seu caminho");
                    jogador.vida_player = jogador.vida_player + 10;
                    exploração(args);

                }
                case "q" ->{ 
                    jogo_historia(args);
                }
                case "l" ->{ //vou programar isso depois quando tiver sistema de inventario e ouro
                    System.out.println("a loja está fechada");
                    exploração(args);
                    }
                case "s" -> {
                    exploração(args);
                    break;
                }
                default -> System.out.println("indisponivel");
            }

       }

       //no inicio isso era uma "historia para o jogo"
       //agora esta mais para algum tipo de "missão"
       private static void jogo_historia(String[] args) {
		
            int historia1 = Esencias.gerador.nextInt(4)+1;
            int historia2 = Esencias.gerador.nextInt(4)+1;
            String hist = ("");
            String hist2 = ("");
            switch(historia1) {//base da historia, objetivo principal
                case 1 -> hist = ("eliminar os monstros de");
                case 2 -> hist = ("explorar");
                case 3 -> hist = ("explorar");
                case 4 -> hist = ("roubar");
            }
        //base da historia, objetivo principal
            switch(historia2) {//local da història
                case 1 -> hist2 = ("uma ruina antiga");
                case 2 -> hist2 = ("um forte abandonado");
                case 3 -> hist2 = ("um forte abandonado");
                case 4 -> hist2 = ("uma caverna misteriosa");	
            }
        //local da història
            System.out.println("você ouve falar de uma missão para: "+hist+" "+hist2); 
            Esencias.teclado.nextLine();
            System.out.println(" você chega ao local  e entra pela porta escura e mal iluminada");//precisa de melhoria para printar o nome do local 
            Esencias.teclado.nextLine();
            //chama o jogo:
            salas(args);
        }
        //monstros
        private static Enemy gerarInimigo() {

            int tipo = Esencias.gerador.nextInt(4);

            if (salas_percoridas == maxSalas) {
                return new Enemy("Golem (Boss)",15,10,15,"Um colosso de pedra viva. O chão treme quando ele se move.");
            }

            return switch (tipo) {
                case 0 -> new Enemy("Goblim",5,3,3,"Uma criatura pequena e de olhos amarelados. Ágil, mas fraca. Ri enquanto empunha uma adaga enferrujada.");
 
                case 1 -> new Enemy("Esqueleto/Múmia",10,5,5,"Um corpo seco envolto em panos antigos. Seus ossos rangem a cada passo.");
                        
                case 2 -> new Enemy("Ogro",15,5, 8,"Um monstro enorme de músculos densos e olhar vazio. Lento, mas brutal.");
                        
                default -> new Enemy("Abominação",Esencias.gerador.nextInt(10) + 1,Esencias.gerador.nextInt(10) + 1,Esencias.gerador.nextInt(10) + 1,"Um amontoado grotesco de carne e ossos retorcidos que se move de forma disforme.");                
            };
        }

       //combate 
    private static void combate(){
        Enemy enemy = gerarInimigo();  // ← cria o inimigo certo

        // Apresentação
        System.out.println("\n Um " + enemy.nome + " aparece!");
        Esencias.teclado.nextLine();
        System.out.println(enemy.descricao);

        System.out.println("Vida: " + enemy.vida + " | Dano: " + enemy.dano + " | Agilidade: " + enemy.agilidade);
        System.out.println("\nSeu HP: " + jogador.vida_player +
                        " | Dano: " + jogador.dano_player +
                        " | Agilidade: " + jogador.agilidade_player);

        // Loop de combate
        while (jogador.vida_player > 0 && enemy.vida > 0) {

            boolean playerAtacaPrimeiro = jogador.agilidade_player >= enemy.agilidade;

            if (playerAtacaPrimeiro) {

                System.out.println("\nVocê ataca primeiro!");
                enemy.vida -= jogador.dano_player;

                System.out.println("Você causa " + jogador.dano_player + " de dano ao " + enemy.nome + ".");

                if (enemy.vida <= 0) {
                    System.out.println("\n O " + enemy.nome + " foi derrotado!");
                    break;
                }

                System.out.println("O " + enemy.nome + " ainda tem " + enemy.vida + " de vida.");

                // Contra-ataque
                jogador.vida_player -= enemy.dano;
                System.out.println("O " + enemy.nome + " revida e causa " + enemy.dano + " de dano!");
                System.out.println("Sua vida agora é: " + jogador.vida_player);

                } else {

                    System.out.println("\nO " + enemy.nome + " é mais rápido e ataca primeiro!");
                    jogador.vida_player -= enemy.dano;

                    System.out.println("Você sofre " + enemy.dano + " de dano! (Vida atual: " + jogador.vida_player + ")");

                    if (jogador.vida_player <= 0) {
                        System.out.println("\n Você foi derrotado pelo " + enemy.nome + "...");                
                        Esencias.teclado.nextLine();
                        morrer();
                        return;
                    }

                    // Contra-ataque
                    enemy.vida -= jogador.dano_player;
                    System.out.println("Você contra-ataca e causa " + jogador.dano_player + " de dano!");
                    System.out.println("O " + enemy.nome + " agora tem " + enemy.vida + " de vida.");
                }

                // Pausa para o próximo turno
                System.out.println("\nPressione ENTER para o próximo turno...");
                Esencias.teclado.nextLine();
            }

            // Resultado final
            if (jogador.vida_player > 0 && enemy.vida <= 0) {
                System.out.println("\n Você venceu o combate contra o " + enemy.nome + "!");
                Esencias.teclado.nextLine();
            } else if (jogador.vida_player <= 0) {
                morrer();
            }
    }
       // criação de masmora
   private  static void salas(String[] args){
    salas_percoridas = 0;
       //int maxSalas = 10; // número total de salas da masmorra

       for (int i = 1; i <= maxSalas; i++) {
            int tipo = Esencias.gerador.nextInt(20); // tipo da sala (0 a 19)
            System.out.println("\n--- Sala " + i + " ---");

           switch (tipo) {
               case 0, 1, 2, 3, 4 -> { // Sala Pequena
                   System.out.println("""
                                      As paredes estreitas comprimem o espa\u00e7o, feitas de pedras antigas cobertas por fissuras.
                                      O teto \u00e9 baixo, sustentado por vigas desgastadas.
                                      O ch\u00e3o \u00e9 irregular e frio ao toque.
                                      O ar parece im\u00f3vel, como se o tempo ali tivesse parado.""");


                      
                   if ((Esencias.gerador.nextInt(20) + 1) % 2 == 0) {
                       System.out.println("Ao entrar na sala você vê um grande baú antigo e empoeirado em seu centro, você abre?");
                       String bau = Esencias.teclado.nextLine();
                       if(bau.equalsIgnoreCase("sim")){
                           if((tipo % 2)== 0){
                               gerarLoot(Esencias.gerador);
                               System.out.println("Você encontrou: " + item);
                           }
                           if((tipo % 2)== 1){
                               System.out.println("você abre o bau e uma armadilha dispara \n você não cosegue regir a tempo você leva 2 de dano" );
                               jogador.vida_player -= 2;
                               if (jogador.vida_player <= 0) {
                                   morrer();
                                   return;
                               }
                           }
                           Esencias.teclado.nextLine();
                       }
                   }
                   else {
                       System.out.println("você ve algo se movendo você deseja fugir[f] ou lutar[l] ");
                       act = Esencias.teclado.nextLine();
                       if(act.equalsIgnoreCase("f")){
                           if(Esencias.gerador.nextInt(20)+1 >= 10){
                               System.out.println("você foge");
                           }
                           else{
                               System.out.println("você tenta fugir mas não consegue");
                               combate();
                           }
                       }
                      if(act.equalsIgnoreCase("l")){
                        combate();
                      }
                   }
                   break;
               }
               case 5, 6, 7, 8, 9 -> { // Sala Média
                   System.out.println("""
                                      O ambiente se abre um pouco mais, revelando colunas simples que sustentam o teto de pedra.
                                      As paredes mostram sinais de antigas reformas e rachaduras profundas.
                                      O ch\u00e3o, plano e gasto, denuncia muitas passagens.
                                      O espa\u00e7o transmite uma sensa\u00e7\u00e3o de equil\u00edbrio entre ordem e ru\u00edna.""");

                   if ((Esencias.gerador.nextInt(20) + 1) % 2 == 0) {
                       System.out.println("Ao entrar na sala você vê um grande baú antigo e empoeirado em seu centro, você abre?");
                       String bau = Esencias.teclado.nextLine();
                       if(bau.equalsIgnoreCase("sim")){
                           if((tipo % 2)== 0){
                               gerarLoot(Esencias.gerador);
                               System.out.println("Você encontrou: " + item);
                           }
                           if((tipo % 2)== 1){
                               System.out.println("você abre o bau e uma armadilha dispara \n você não cosegue regir a tempo você leva 2 de dano" );
                               jogador.vida_player -= 2;
                               if (jogador.vida_player <= 0) {
                                   morrer();
                                   return;
                               }
                           }
                         Esencias.teclado.nextLine(); 
                       } 
                   } else {
                       System.out.println("você ve algo se movendo você deseja fugir[f] ou lutar[l] ");
                       act = Esencias.teclado.nextLine();
                       if(act.equalsIgnoreCase("f")){
                           if(Esencias.gerador.nextInt(20)+1 >= 10){
                               System.out.println("você foge");
                           }
                           else{
                               System.out.println("você tenta fugir mas não consegue");
                               combate();
                           }
                       }
                      if(act.equalsIgnoreCase("l")){
                        combate();
                      }
                   }
                  
                   break;
               }


               case 10, 11, 12, 13, 14 -> { // Sala Grande
                   System.out.println("""
                                      A estrutura imponente impressiona pela altura e pela amplitude do teto arqueado.
                                      As paredes parecem se perder na penumbra, constru\u00eddas com blocos enormes e irregulares.
                                      O ch\u00e3o \u00e9 liso, como se polido pelo tempo.
                                      H\u00e1 ecos que percorrem o sal\u00e3o, multiplicando cada som.""");



                   if ((Esencias.gerador.nextInt(20) + 1) % 2 == 0) {
                       System.out.println("Ao entrar na sala você vê um grande baú antigo e empoeirado em seu centro, você abre?");
                       String bau = Esencias.teclado.nextLine();
                       if(bau.equalsIgnoreCase("sim")){
                           if((tipo % 2)== 0){
                               gerarLoot(Esencias.gerador);
                               System.out.println("Você encontrou: " + item);
                           }
                           if((tipo % 2)== 1){
                               System.out.println("você abre o bau e uma armadilha dispara \n você não cosegue regir a tempo você leva 2 de dano" );
                               jogador.vida_player -= 2;
                               if (jogador.vida_player <= 0) {
                                   morrer();
                                   return;
                               }
                           Esencias.teclado.nextLine();
                           }
                       }
                   } else {
                       System.out.println("você ve algo se movendo você deseja fugir[f] ou lutar[l] ");
                       act = Esencias.teclado.nextLine();
                       if(act.equalsIgnoreCase("f")){
                           if(Esencias.gerador.nextInt(20)+1 >= 10){
                               System.out.println("você foge");
                           }
                           else{
                               System.out.println("você tenta fugir mas não consegue");
                               combate();
                           }
                       }
                      if(act.equalsIgnoreCase("l")){
                        combate();
                      }
                   }
                   break;
               }


               default -> { // Corredor
                   System.out.println("""
                                      O corredor se estende em linha quase perfeita, formado por pedras alinhadas com precis\u00e3o.
                                      O teto baixo cria uma sensa\u00e7\u00e3o de confinamento constante.
                                      As paredes s\u00e3o \u00famidas e cobertas por marcas do tempo.
                                      A passagem parece se alongar infinitamente diante dos olhos.""");
                   Esencias.teclado.nextLine();
                   break;
               }
           }
           if (salas_percoridas > 0 && salas_percoridas % 3 == 0) {
               jogador.dano_player += 1; // ganha 1 de dano a cada 3 salas
               int cura = Esencias.gerador.nextInt(3) + 1; // cura aleatória de 1 a 3
               jogador.vida_player += cura;
               //if (jogador.vida_player > jogador.vida_player) vida_player = vida_total; // não passa do máximo
               System.out.println("\nVocê sente-se mais experiente! (+1 dano, +" + cura + " de vida)");
           }
           salas_percoridas = salas_percoridas + 1; 
           if(salas_percoridas == maxSalas){
               System.out.println("Depois de percorrer a longa masmorra, você finalmente chega à câmara final.\nÉ um grande cômodo de pedra, onde a tensão no ar é palpável.\nNo centro, imponente e silencioso, espera o Golem.\nEste é o duelo que você deve vencer.");
               combate();
           } 
       }
        exploração(args);
   }
   public static String gerarLoot(Random r) {
       int tipoLoot = r.nextInt(6); // 0 a 5
       int efeito = 0; 


       switch (tipoLoot) {
           case 0 -> {
               item = "runa da afiação (+2 dano)";
               efeito = jogador.dano_player += 2;
           }
           case 1 -> {
               item = "runa do fogo (+5 dano)";
               efeito = jogador.dano_player += 5;
           }
           case 2 -> {
               item = "runa de dando forte (+10 dano)";
               efeito = jogador.dano_player += 10;
           }
           case 3 -> {
               item = "runa pesada (+15 dano, -5 agilidade)";
               jogador.dano_player += 15;
               efeito = jogador.agilidade_player -= 5;
           }
           case 4 -> {
               item = "runa da vitalidade";
               efeito = jogador.vida_player =  jogador.vida_player+10;
           }
           case 5 -> {
               item = "runa da Agilidade (+10 agilidade)";
               efeito = jogador.agilidade_player += 10;
           }
       }


       //System.out.println(item);
       System.out.println("você quer pegar:"+item);
       System.out.println("inventario(maximo 6 itens): " + Arrays.toString(Player.inventarioNomes));
       System.out.println("[sim] ou [não]");
       String resposta = Esencias.teclado.nextLine();
       if(resposta.equalsIgnoreCase("sim")){
            if(Player.espacoPrenchido < Player.inventarioNomes.length){
                Player.inventarioNomes[Player.espacoPrenchido]=item;
                Player.inventarioValores[Player.espacoPrenchido]= efeito;
                Player.espacoPrenchido++;
                return item;
            }
            else{
                System.out.println("inventario cheio");
            }
       }
       else{
            System.out.println("você deixa o item para tras.");
            return null;
       }
        return null;
   }
   private static void morrer() {
        System.out.println("\n Você foi derrotado...");
            System.out.println("""
                   ,-=-.      
                  /  +  \\     
                  | ~~~  |     
                  |R.I.P |     
            \\vV,,|______|V,VV,,
            """);
       
        System.out.println("Sua jornada chega ao fim.");


        System.out.println("\nDeseja tentar novamente? (sim/não)");
        String escolha = Esencias.teclado.nextLine();


        if (escolha.equalsIgnoreCase("sim")) {
            // Reinicia o jogo
            jogador.vida_player = 10;
            jogador.agilidade_player = 5;
            jogador.dano_player = 5;
            System.out.println("\nReiniciando sua aventura...");
            main(new String[]{}); // recomeça o jogo
        } else {
            System.out.println("Fim de jogo. Obrigado por jogar!");
            System.exit(0); // encerra o programa
       }
   }
}