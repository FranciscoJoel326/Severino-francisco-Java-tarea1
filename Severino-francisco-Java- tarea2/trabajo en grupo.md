Grupo #6
John Santos 1000-4863
Maikey Diaz 2023-0371
Francisco Severino 1000-4508
Robertson tejada 2023-0707
Andy Cruz 2023-0181

# Caso #6 — “El paciente tiene fuga de encapsulamiento”

## Tema: Encapsulamiento y polimorfismo

### Síntomas
El sistema bancario permite modificar el balance directamente desde cualquier parte del programa.

### Código del paciente

```java
class Cuenta {

    public double balance;

}

public class Main {

    public static void main(String[] args) {

        Cuenta c = new Cuenta();

        c.balance = -50000;

        System.out.println(c.balance);

    }
}
```
class Cuenta {
    
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Error: El balance no puede ser negativo.");
        } else {
            this.balance = balance;
        }
    }
}



### Preguntas para el equipo

1. ¿Qué principio de POO se está violando?
2. ¿Por qué es peligroso?
3. ¿Cómo debería implementarse correctamente?
4. ¿Qué validación agregarían al sistema?

1 ¿Qué principio de POO se está violando?
Se esta violando el principio de encapsulamiento, se esta violando porque el
atrubuto balance fue declarado como publico double balance y el balance esta
negativo.

2. ¿Por qué es peligroso?
Por ser un atributo publico cualquier parte del programa puede asignar valores inválidos, ilógicos y malisiosos.

3. ¿Cómo debería implementarse correctamente?
El balance debería estar en posiMvo, la variable double llamada balance esta
publica donde debería estar privada para que no se pueda modificar.

4. ¿Qué validación agregarían al sistema?
Se debería de agregar la estructura condicional en el método de asignación
setBalance o depositar, reMrar que no deje registrar un monto negaMvo o una
transacción que deje la cuenta vacia.

