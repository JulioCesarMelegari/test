# Projeto: Sistema de Conta Bancária em Java

Este projeto é uma simulação simples de um sistema de conta bancária utilizando a linguagem Java. O sistema permite operações básicas como depósito, saque e saque total, além de conter testes automatizados para validar o comportamento esperado das operações.

## 🧩 Estrutura do Projeto

O projeto é composto por três classes principais:

### `Account`

Representa uma conta bancária e contém os seguintes métodos:

- `deposit(double amount)`: Realiza um depósito, descontando uma taxa de 2% sobre o valor depositado.
- `withdraw(double amount)`: Realiza um saque, lançando exceção se o saldo for insuficiente.
- `fullWithdraw()`: Realiza o saque de todo o saldo disponível.
- Getters e setters para `id` e `balance`.

### `AccountFactory`

Classe auxiliar para criação de instâncias de `Account`, útil para testes:

- `createEmptyAccount()`: Retorna uma conta com saldo zero.
- `createAccount(double initialBalance)`: Retorna uma conta com saldo inicial definido.

### `AccountTests`

Contém testes unitários utilizando JUnit:

- `depositShouldIncreaseBalanceWhenPositiveAmount`: Testa se um depósito com valor positivo aumenta o saldo corretamente (com a taxa de 2%).
- `depositShouldDoNothingWhenNegativeAmount`: Testa se depósitos com valor negativo são ignorados.
- `fullWithdrawShouldClearBalanceAndReturnFullBalance`: Testa se o saque total zera o saldo e retorna o valor total anterior.
- `withdrawShouldDecreaseBalanceWhenSufficientBalance`: Testa se o saque funciona com saldo suficiente.
- `withdrawShouldDecreaseBalanceWhenInsufficientBalance`: Testa se é lançada uma exceção ao tentar sacar mais do que o saldo disponível.

## ✅ Requisitos

- Java 8 ou superior
- JUnit 5 (para execução dos testes)

## 🚀 Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

