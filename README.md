# 🧪 Automação de Testes de API — RestAssured + Cucumber

## 🚀 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de automatizar testes de APIs REST utilizando Java, RestAssured, Cucumber (BDD) e Maven.
O foco é garantir qualidade, estabilidade e confiança nas integrações entre sistemas, além de permitir a execução contínua dos testes via GitHub Actions (CI/CD).

A API utilizada é a Restful-Booker, um microserviço de reservas amplamente usado para testes de automação.

[Documentação Restful Booker](https://restful-booker.herokuapp.com/apidoc/index.html)

---

## 🧰 Tecnologias Utilizadas

- **Java 17** ☕  
- **Maven** 📦  
- **Cucumber (BDD)** 🥒  
- **RestAssured** 🌐  
- **JUnit** ⚙️  
- **GitHub Actions** 🚀 (para integração contínua)

---

## ⚙️ Configuração do Projeto

Clone o repositório:

```text
git clone https://github.com/GabrielH1010/API_Automation.git
```

Instale as dependências:

```text
mvn install
```

Execute os testes localmente:

```text
mvn test
```
---

## 🧩 Estrutura do Projeto

```text
API_Automation/
├── .github/
│   └── workflows/
│       └── ci.yml          
├── src/                
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── Hooks.java       
│       │   ├── steps/
│       │   │   └── RegressivoSteps.java
│       │   └── runners/
│       │       └── RunCucumberTest.java
│       │   └── utils/
│       │       └── DataStore.java
│       │       └── YamlUtils.java
│       └── resources/
│           ├── features/            
│           │   └── Regressivos.feature
│           └── fixtures/            
│               ├── criarReserva.json
│               ├── alterarReserva.json
│               └── gerarToken.json
├── pom.xml                         
└── README.md
```

## 📂 Descrição das Pastas
- `hooks/` → **Hooks.java**: configuração do RestAssured,, geração de token e métodos auxiliares que chamam APIs.
- `steps/` → Implementa as definições dos passos **(@Given, @When, @Then)** usados nos cenários BDD..
- `runners/` → executável do Cucumber (`RunCucumberTest.java`) com `@CucumberOptions`.
- `utils/` → **DataStore.java**: classe usada para guardar e compartilhar dados entre steps ou classes.
- `utils/` → **YamlUtils.java**: esponsável por ler e interpretar o arquivo env.yaml ou qualquer outro YAML do projeto.
- `resources/features/` → cenários de testes em Gherkin `.feature`.
- `resources/fixtures/` → payloads JSON e outros dados de entrada.
- `.github/workflows/` → workflow(s) do GitHub Actions (`ci.yml`).
- `pom.xml` → dependências (Cucumber, RestAssured, JUnit, SnakeYAML, org.json, etc.)

---

## 🔁 Integração Contínua (CI)
O projeto está configurado com GitHub Actions para rodar automaticamente a cada commit no branch principal.
Confira as execuções recentes no link abaixo:

[Acessar workflow](https://github.com/GabrielH1010/API_Automation/actions/runs/18421954425)

---

## 📊 Relatórios de Execução

Após a execução dos testes, um relatório HTML é gerado automaticamente na pasta target/, contendo o resumo dos cenários, steps e resultados.

📸 Exemplo de saída do report:

<img width="2064" height="518" alt="image" src="https://github.com/user-attachments/assets/38f4a841-3faf-45b9-a281-6e456c57a663" />

---

## 💬 Considerações Finais

Este projeto foi criado com o propósito de demonstrar domínio prático em automação de testes de API, aplicando boas práticas de BDD e CI/CD.
Ele reflete o uso real de ferramentas que fazem parte do meu dia a dia como Analista de Testes/QA.

---

## 👨‍💻 Autor

<p>Gabriel Henrique de Oliveira</p>
<p>Quality Assurance (QA) | QA Engineer | Cypress | RestAssured | Selenium | Testes Manuais & Automatizados</p>

- [📧 Gmail](gabrielhdeoliveira17@gmail.com)
- [💼 LinkedIn](https://www.linkedin.com/in/gabriel-henrique-de-oliveira)
- [🐙 GitHub](https://github.com/GabrielH1010)

---
