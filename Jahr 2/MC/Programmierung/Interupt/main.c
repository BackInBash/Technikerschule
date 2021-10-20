/*
* main.c
*
* Created: 10/20/2021 2:00:55 PM
*  Author: BackInbash
*/

#include <avr/interrupt.h>
#include <avr/io.h>
#include <avr/delay.h>


ISR(TIMER1_COMPA_vect)
{
	PORTB ^= 1<<PINB0;   //die LED blinkt in 1 Sekunde takt
	_delay_ms(100);
}

int main(void)
{
	sei();
	DDRB |= 1 << PINB0;  // PIN 0 von Port B als Ausgang definieren
	TIMSK |= 1<< OCIE1A;   // Timer Interrupt aktivieren
	//hier wird der interne Timer skaliert : 1000000/64 = 15625
	TCCR1B |= 1<<CS10  |  1<<CS11 | 1<<WGM12;
	
	OCR1A =  15624;  //nach 15624 Ticks ist eine Sekunde vegangen und Timer = //OCR1A-> springen
	
	while(1)
	{

	}
}
