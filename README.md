# Ebank – Architecture Simplifiée (Gateway + Services Métiers + Chatbot IA)

Ce repository présente une architecture **simple, modulaire et maintenable** pour exposer des services métiers (Customer / Ebank) via un **API Gateway** (Spring Cloud Gateway), un **Front Angular** et un **Chatbot Service** connecté à un **LLM** et à **Telegram**.

![Architecture](./architect.png)

---

## ✨ Principes & objectifs

- **Simplicité d’abord** : réduire les briques “infra” (pas de Discovery/Config au départ).
- **Entrée unique** : un **Gateway** centralise auth, CORS, routage, observabilité.
- **Isolation de l’IA** : toute la logique conversationnelle/LLM vit dans **`chatbot-service`**.
- **Services métiers “propres”** : `customer-service` et `ebank-service` restent focalisés sur le domaine.
- **Évolutivité pragmatique** : ajouter Discovery/Config/Mesh **seulement** si un besoin réel apparaît.

---

## 🧭 Vue d’ensemble fonctionnelle

- **Front (Angular)**  
  Affiche les écrans et consomme **uniquement** le Gateway.
- **API Gateway (Spring Cloud Gateway)**  
  Point d’entrée : authentifie/autorise (JWT), route vers les services, applique CORS/rate-limit.
- **Services métiers**  
  - `customer-service` : gestion des clients.
  - `ebank-service` : opérations bancaires.
- **`chatbot-service`**  
  - Webhook **Telegram** (réception des messages), appels sortants **Telegram API** (réponses).
  - Intégration **LLM** (API/SDK), gestion de prompts, règles, redaction/masking PII.
  - Appels **OpenFeign/REST** vers services métiers si besoin d’enrichissement.

---

## 🔄 Flux types

### 1) Consultation d’informations côté Angular

Angular (JWT) → Gateway → Customer Service → (réponse) → Gateway → Angular

### 2) Flux Telegram → Chatbot IA + Services métiers

Ce flux décrit la conversation entre l’utilisateur via Telegram, le chatbot, le LLM et les services métiers.
Telegram
→ /webhook/telegram
→ Chatbot Service
→ (appel LLM)
↘ si nécessaire → Customer Service / Ebank Service
Telegram ← Chatbot Service ← LLM / Services

- Telegram envoie un message via son **webhook**.
- Le **Chatbot Service** reçoit l’update, extrait le message et décide du traitement.
- Le service envoie une requête au **LLM** pour générer une réponse intelligente.
- Si nécessaire, il interroge les services métiers pour enrichir la réponse (infos client, solde, etc.).
- La réponse est envoyée à Telegram via l’API officielle.

---

## 🧑‍💻 Démarrage en local

Cette section explique comment exécuter l’architecture localement, avec ou sans Docker.

### 🔧 Prérequis

Avant de démarrer, installer :

- **JDK 21** (ou version compatible Spring Boot)
- **Node.js 20+**
- **Angular CLI** :
  ```bash
  npm install -g @angular/cli

Maven ou Gradle (via mvnw ou gradlew) (Optionnel) Docker + Docker Compose

Lancer les services Spring Boot localement (sans Docker)

Dans chaque dossier : gateway, customer-service, ebank-service, chatbot-service
Lancer :

  ```bash
        ./mvnw spring-boot:run
        # ou
        ./gradlew bootRun