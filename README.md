# Sistema Acadêmico - EP1

Este projeto é um sistema acadêmico desenvolvido em Java para a disciplina de Orientação a Objetos. O sistema roda no terminal e permite gerenciar alunos, disciplinas e turmas.

## Estrutura do Projeto
src/
controle/
SistemaAcademico.java
modelo/
Aluno.java
AlunoEspecial.java
Disciplina.java
Turma.java
service/
AlunoService.java
DisciplinaTurmaService.java
tela/
Main.java # Classe principal
MenuAluno.java
MenuDisciplinaTurma.java
MenuPrincipal.java
module-info.java


## Pré-requisitos
- Java JDK 21 ou superior

## Como Compilar e Executar

# Opção para Execução em IDE (Eclipse/IntelliJ)

## Configuração na IDE

1. **Importe o projeto**:
   - Abra sua IDE (Eclipse, IntelliJ)
   - Selecione "Import Existing Project" ou "Abrir Projeto Existente"
   - Navegue até a pasta raiz do projeto (contendo `module-info.java`)

2. **Configure o JDK**:
   - Certifique-se de que o projeto está usando o JDK 21
   - Em Eclipse: `Project → Properties → Java Build Path`
   - Em IntelliJ: `File → Project Structure → Project SDK`

## Execução Direta

### Método 1: Executar a classe Main
1. Navegue até `src/tela/Main.java`
2. Clique com o botão direito e selecione:
   - Eclipse: `Run As → Java Application`
   - IntelliJ: `Run 'Main.main()'`

### Método 2: Configurar Run Configuration (para IDEs avançadas)
1. Crie uma nova configuração de execução:
   - Eclipse: `Run → Run Configurations → Java Application`
   - IntelliJ: `Run → Edit Configurations`
2. Defina:
   - Main class: `tela.Main`
   - Module path: selecione o módulo `ep1`
   - Working directory: pasta raiz do projeto

### compilação (opção 2)
```bash
javac -d out --module-source-path src -m ep1
Execução
bash
java --module-path out -m ep1/tela.Main
Script Automático (Linux/Mac)
Crie um arquivo run.sh com:

bash
#!/bin/bash
javac -d out --module-source-path src -m ep1
java --module-path out -m ep1/tela.Main
Dê permissão e execute:

bash
chmod +x run.sh
./run.sh
Observação: A classe principal está em tela.Main. Certifique-se de estar no diretório correto ao executar os comandos.
```

Seguem abaixo 3 prints da execução do sistema no terminal:
![image](https://github.com/user-attachments/assets/f52112d9-e945-4243-9667-3292f507d5c1)
![image](https://github.com/user-attachments/assets/2ac5bbda-48b0-4a4e-869f-4e4aa6658132)
![image](https://github.com/user-attachments/assets/8e1aed37-cb93-43d2-8c38-ba64e333e890)


