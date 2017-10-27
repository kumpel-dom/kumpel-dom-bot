# Smart home bot

[![Build Status](https://travis-ci.org/kumpel-dom/kumpel-dom-bot.svg?branch=master)](https://travis-ci.org/kumpel-dom/kumpel-dom-bot)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a1f480a2fc904bad8a4b711b4333d899)](https://www.codacy.com/app/alexNeto/kumpel-dom-bot?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=kumpel-dom/kumpel-dom-bot&amp;utm_campaign=Badge_Grade)
[![Maintainability](https://api.codeclimate.com/v1/badges/5c97a7c6b9c0eb6fcae9/maintainability)](https://codeclimate.com/github/kumpel-dom/kumpel-dom-bot/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/5c97a7c6b9c0eb6fcae9/test_coverage)](https://codeclimate.com/github/kumpel-dom/kumpel-dom-bot/test_coverage)

## section Materiais e Métodos

Para facilitar o desenvolvimento o projeto foi separado em duas partes, um que aborda o  _chatbot_ e outro o dispositivo que vai controlar a casa.
Esses dois contextos deven funcionar de forma independente.

### contexto do bot
Para o desenvolvimento do teste, foi escolhido a plataforma de \textit{chatbot} do Telegram, tanto pela documentação disponível quanto pela facilidade de desenvolvimento. A linguagem utilizada para a implementação do \textit{chatbot} foi o Java, junto com o gerenciamento de dependências, Maven.

### contexto do IoT
#### _Hardware_
O dispositivo utilizado foi o_esp8266_, pela capacidade de conexão via _WiFi_. Tambem foram utilizados LEDs e resistores para a representação da comunicação entre _chatbot_ e dispositivo de IoT.

#### _Software_
Para a programação do esp8266, foi utlilizado a linguagem de programação do arduino.

# Funcionamento
Como objeto de estudo foi iniciado o desenvolvimento para interação entre homem e dispositivo de IoT(_Internet of Things_), como meio de facilitar a utilização e verificar a viabilidade desse metodo.


O usuario pergunta ou faz algum comando, atualmente, apenas por texto, para o _chatbot_. O comando é interpretado e dado o devido comando para o dispositivo IoT.


O dispositivo IoT possue um servidor configurtado, que recebe requisições e executa uma função ou conjunto de funções apartir do serviço requisitado.


A resposta do usuario é a ação realizada com sucesso ou uma mensagem alertando da impossibilidade dessa ação.