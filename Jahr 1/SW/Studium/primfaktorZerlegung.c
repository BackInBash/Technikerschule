#include <stdio.h>
#include <math.h>

int main()
{
    // User Input
    long input;
    // Vektor Array für Primfaktoren
    long vektor[1024];

    // User Eingabe
    scanf("%ld", &input);

    // IF Userinput = 1
    if(input == 1)
    {
        printf("%ld is Ungueltig", input);
        return 0;
    }

    // Prim Faktor pro durchlauf
    long t = 2;
    // Array Index Counter
    int vektor_count = 0;

    // Berechnung Primfaktoren

    while (input % 2 == 0) 
    {
        // Speichern des Primfaktors im Array
        vektor[vektor_count] = 2;
        // Array Index erhöhen
        vektor_count++;

        input = input /= 2;
    }

    for (int i = 3; i <= sqrt(input); i += 2) 
    {
            while (input % i == 0) {
                // Speichern des Primfaktors im Array
                vektor[vektor_count] = i;
                // Array Index erhöhen
                vektor_count++;
                input = input /= i;
            }
    }

    if (input > 2) 
    {
        // Speichern des Primfaktors im Array
        vektor[vektor_count] = input;
        // Array Index erhöhen
        vektor_count++;
    }

    // Ausgabe der Werte des Arrays
    for(int i = 0; i<vektor_count; i++)
    {
        if(vektor[i] > 0)
        {
            printf("%ld \n", vektor[i]);
        }
    }
}