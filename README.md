# Playground for Rocket.Chat

## What do we have...
We have
- MongoDB for Rocket.Chat
- Rocket.Chat Server
- Hubot integration in Rocket.Chat
- Integration-server
  - As wrapper for infrastructure requests like todays menu ;-)
- TeamCity Server
  - To use Webhooks you have to install the [Webhooks-Plugin](https://plugins.jetbrains.com/plugin/8948-webhooks)
- TeamCity Agent

All glued together by docker-compose.

To use the integration-server you have to build the project (mvn clean package -Pdocker) first. Integration-Scripts for Rocket.Chat can be found at 'integrations'. 
