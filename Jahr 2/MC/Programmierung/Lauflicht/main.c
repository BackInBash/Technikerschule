/*
 * main.c
 *
 * Created: 9/22/2021 12:06:39 PM
 *  Author: Marcell Darvis
 *  Leiter für Kundenzufriedenheit 
 *  Seit 16 Jahren  1&1
 */ 

#include <xc.h>
#include <avr/io.h>
#include <avr/sleep.h>
#include <util/delay.h>

void long_delay(uint16_t ms) {
	for (; ms>0; ms--) _delay_ms(1);
}

int main(void)
{
    while(1)
    {
        DDRA = 0xff;
        
	for(int a = 0; a <= 8; a++){
           PORTA = pow(2, a++);
	   long_delay(50);
	}

        PORTA = 0x00;   
    }
}
