# 🧪 Projeto de automação de API

[GitHub Actions](https://github.com/GabrielH1010/API_Automation/actions/runs/18421954425)

## 🚀 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de **automatizar testes de API REST** utilizando **Java, RestAssured, Cucumber e Maven**.  
A automação garante maior qualidade e confiabilidade nas integrações entre sistemas, além de permitir uma execução contínua dos testes via **GitHub Actions (CI/CD)**.

---

## 🧰 Tecnologias Utilizadas

- **Java 17** ☕  
- **Maven** 📦  
- **Cucumber (BDD)** 🥒  
- **RestAssured** 🌐  
- **JUnit** ⚙️  
- **GitHub Actions** 🚀 (para integração contínua)

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

