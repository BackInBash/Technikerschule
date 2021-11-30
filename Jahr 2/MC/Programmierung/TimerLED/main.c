/*
* main.c
*
* Created: 30/11/2021 10:06:39 PM
* Author: BackInBash
*/

#include <xc.h>
#include <stdlib.h>
#include <avr/io.h>
#include <avr/interrupt.h>
#include <avr/sleep.h>
#include <util/delay.h>

// Custom Delay Methode
void long_delay(uint16_t ms) {
	for (; ms>0; ms--) _delay_ms(1);
}

// Random LED Offset
int offset(){
	return rand() % 255;
}

// Random Clock Offset
int speed(){
	int MAX = 20000;
	int MIN = 1000;
	return rand() % (MAX + 1 - MIN) + MIN;
}

ISR(TIMER1_OVF_vect)
{  // INT-Service Routine
	//Timer1 neu starten (Anfangswert laden)
	// 1 Sekunde bei 1 MHZ Takt, Vorteiler 1/64
	TCNT1 = 0xffff-speed();//15625;
	//Ausgabe invertieren
	PORTA = offset();
}

int main(void)
{
	DDRA = 0xff;
	
	//Freigabe von INT bei Ueberlauf von TCNT1
	TIMSK = TIMSK|(1<<TOIE1);
	
	//Anfangswert Timer setzen, 1. Durchlauf
	TCNT1 = 0xffff-15625;
	
	//Timer starten, Clock Select: Clock/64
	TCCR1B = TCCR1B | ((1<<CS11) | (1<<CS10));
	
	sei();
	
	while(1)
	{
	}
}
