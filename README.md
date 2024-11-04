# Testes Automatizados com Java

## Conceitos Avançados de JUnit 5

Neste módulo, estamos explorando testes parametrizados em JUnit 5, que são uma ótima maneira de testar uma mesma função com diferentes conjuntos de dados sem precisar repetir o código de teste para cada caso.

### Testes Parametrizados

Testes parametrizados permitem que o mesmo teste seja executado com vários conjuntos de valores, facilitando a validação de vários cenários ao mesmo tempo. Para isso, usamos o `@ParameterizedTest` e o `@MethodSource` para indicar os valores que serão passados ao teste.

### Explicação do Código

1. **Configuração do Teste Parametrizado**:  
   No exemplo abaixo, o método `testDivision` recebe três parâmetros: `firstNumber`, `secondNumber`, e `expected`. Esses valores são fornecidos pelo método `testDivisionInputParameters`, que define diferentes combinações de números para serem testadas.

2. **Uso do `@MethodSource`**:  
   A anotação `@MethodSource` refere-se ao método que fornecerá os argumentos para o teste. Esse método deve retornar uma `Stream` (fluxo) de argumentos que representam os diferentes cenários de teste.

3. **Estrutura do Teste**:  
   O método `testDivision` realiza a divisão de `firstNumber` por `secondNumber` e compara o resultado (`actual`) com o valor esperado (`expected`). A função `assertEquals` verifica se o resultado real é igual ao esperado, dentro de uma margem de erro de `2D`, que representa a precisão da comparação.

### Código de Exemplo

```java
@ParameterizedTest
@MethodSource("testDivision")
void testDivision(double firstNumber, double secondNumber, double expected) {

    System.out.println("Testando " + firstNumber + " / " + secondNumber + " = " + expected);
    Double actual = math.division(firstNumber, secondNumber);

    assertEquals(expected, actual, 2D,
            () -> firstNumber + " / " + secondNumber +
            " não produziu o resultado esperado de " + expected + "!");
}

// Método que fornece os parâmetros para o teste
public static Stream<Arguments> testDivision() {
    return Stream.of(
            Arguments.of(6.2D, 2D, 3.1D),
            Arguments.of(71D, 14D, 5.07D),
            Arguments.of(18.3, 3.1D, 5.90D)
    );
}
```
### Explicação dos Componentes

- **@ParameterizedTest**: Define que o teste será executado várias vezes, com diferentes valores fornecidos.
- **@MethodSource("testDivision")**: Indica que o método `testDivision` fornecerá os valores a serem testados.
- **Stream.of(Arguments)**: Lista os valores a serem passados ao teste. Cada conjunto de argumentos (`Arguments.of(...)`) representa um caso de teste único, com os números e o valor esperado.
- **assertEquals**: Compara o valor obtido no teste (`actual`) com o valor esperado (`expected`), dentro de uma margem de erro para assegurar precisão.

Com esse teste parametrizado, conseguimos verificar se nossa função `division` está funcionando corretamente em diferentes casos, o que facilita o processo de validação e aumenta a confiabilidade do código.
________________________________________________________________________________________________________________________
### Testes Parametrizados com @CsvSource
O @CsvSource é uma anotação usada para fornecer parâmetros em testes JUnit, facilitando a execução de um mesmo teste com diferentes conjuntos de dados. Isso torna o código de teste mais limpo e evita a repetição de código.

Exemplo de Uso:

# Testes Parametrizados com `@CsvSource`

A anotação `@CsvSource` permite executar um mesmo teste com diferentes conjuntos de dados, tornando o código de teste mais conciso e evitando a repetição. Essa anotação é especialmente útil quando há múltiplos cenários a serem testados com o mesmo método.

## Exemplo de Uso

```java
@CsvSource({
    "6.2, 2, 3.1",
    "71, 14, 5.07",
    "18.3, 3.1, 5.90"
})
void testDivisao(double valor1, double valor2, double resultadoEsperado) {
    assertEquals(resultadoEsperado, valor1 / valor2, 0.01);
}
```

## Explicação

* **`@ParameterizedTest`**: Permite a execução de testes parametrizados no JUnit, usando diferentes conjuntos de valores.
* **`@CsvSource`**: Passa valores diretamente no código, onde cada linha representa um novo conjunto de parâmetros. Esses valores são inseridos na ordem em que são listados.

No exemplo acima, o teste `testDivisao` é executado várias vezes, uma para cada conjunto de valores passados na anotação `@CsvSource`. A cada execução, os valores são mapeados para os parâmetros `valor1`, `valor2` e `resultadoEsperado`, e o teste verifica se `valor1 / valor2` é igual a `resultadoEsperado`.

## Exemplo Adicional

O `@CsvSource` também pode ser utilizado para valores de texto. Veja o exemplo abaixo:

```java
@ParameterizedTest
@CsvSource({
    "Pelé, Football",
    "Senna, F1",
    "Keith Moon, ''"
})
void testEsportes(String nome, String esporte) {
    // Implementação do teste usando valores de texto
}

