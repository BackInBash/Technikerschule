#include <stdio.h>

int main()
{
    // User Input
    long input;
    // Vektor Array für Ürimfaktoren
    long vektor[1024];

    // User Eingabe
    scanf("%ld", &input);

    // IF Userinput = 1
    if(input == 1)
    {
        printf("%ld is Ungueltig", input);
        return 0;
    }

    // Prim Paktor pro durchlauf
    long t = 2;
    // Array Index Counter
    int vektor_count = 0;

    // Berechnung Primfaktoren
    while(t*t <= input)
    {
        if(input % t == 0){
            // Speichern des Primfaktors im Array
            vektor[vektor_count] = t;
            // Array Index erhöhen
            vektor_count++;

            input = input / t;
        }
        else
        {
            t++;
        }
    }

    // Speichern des Primfaktors im Array
    vektor[vektor_count] = t;
    // Array Index erhöhen
    vektor_count++;

    // Ausgabe der Werte des Arrays
    for(int i = 0; i<vektor_count; i++)
    {
        if(vektor[i] > 0)
        {
            printf("%ld \n", vektor[i]);
        }
    }
}