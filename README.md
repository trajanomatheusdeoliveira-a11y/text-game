# RPG de Aventura em Texto (Java)

Um RPG de aventura em texto desenvolvido em Java para console. O jogador explora masmorras geradas proceduralmente, enfrenta monstros, coleta runas mágicas e derrota um boss ao final de cada dungeon.

Este projeto foi criado como exercício de aprendizado focado em lógica de programação, Java e organização básica de um jogo em console.

---

## Funcionalidades

- Exploração de masmorras com geração procedural
- Sistema de combate por turnos
- Diferentes tipos de inimigos (Goblin, Ogro, Esqueleto, Abominação)
- Boss ao final da masmorra
- Sistema de loot com runas mágicas
- Inventário com espaço limitado
- Atributos do jogador (vida, dano e agilidade)
- Eventos aleatórios durante exploração
- Interação com vila (taverna, quadro de missões)

---

## Mecânicas do Jogo

### Atributos do Jogador

- **Vida** – determina quanto dano o jogador pode receber.
- **Dano** – define quanto dano o jogador causa nos inimigos.
- **Agilidade** – define quem ataca primeiro no combate.

### Combate

O combate é baseado em turnos. O personagem com maior agilidade ataca primeiro.  
A batalha continua até que o jogador ou o inimigo fique com 0 de vida.

### Loot

Baús e eventos podem conceder **runas** que melhoram atributos do jogador como:

- dano
- agilidade
- vida

Os itens coletados são armazenados em um **inventário limitado**.

---

## Sistema de Masmorra

Cada masmorra possui várias salas geradas aleatoriamente. As salas podem conter:

- inimigos
- baús com loot
- armadilhas
- corredores vazios

Após percorrer todas as salas, o jogador enfrenta um **boss**.

---

## Estrutura do Projeto

Esencias → utilidades compartilhadas (Scanner, Random)  
Enemy → classe de inimigos e atributos  
Player → atributos do jogador e sistema de inventário  
text_game → lógica principal do jogo, exploração e combate

---

## Requisitos

- Java 17 ou superior
- Qualquer IDE Java ou terminal

---

## Como Executar

Compile o programa:

javac text_game.java

Execute o jogo:

java text_game

---

## Objetivos de Aprendizado

Este projeto explora:

- fundamentos da linguagem Java
- estruturas de controle
- geração aleatória
- programação orientada a objetos básica
- criação de jogos em console

---

## Melhorias Futuras

Possíveis expansões do projeto:

- sistema de equipamentos
- mais tipos de inimigos
- NPCs e diálogos
- sistema de mapa
- salvar e carregar jogo
- novos bosses
- melhoria do inventário

---

## Autor

Matheus Trajano  
Estudante de ensino médio técnico em Desenvolvimento de Sistemas
