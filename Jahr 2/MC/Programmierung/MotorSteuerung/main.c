/*
* main.c
*
* Created: 10/6/2021 11:53:53 AM
*  Author: Hardware Rubi & Software Maggus
*/

#include <xc.h>
#include <stdlib.h>
#include <util/delay.h>

// Bipolare Ansteuerung Vollschritt
const unsigned char stepTableFull[] = {
	0b00000101,
	0b00001001,
	0b00001010,
	0b00000110
};

// Bipolare Ansteuerung Halbschritt
const unsigned char stepTableHalf[] = {
	0b00000101,
	0b00000001,
	0b00001001,
	0b00001000,
	0b00001010,
	0b00000010,
	0b00000110,
	0b00000100
};

void sleep(int delay){
	switch(delay){
		case 1000:
		_delay_ms(1000);
		break;
		case 500:
		_delay_ms(500);
		break;
		case 100:
		_delay_ms(100);
		break;
		case 10:
		_delay_ms(10);
		break;
	}
}

void full(int delay){
	for(int i = 0; i<sizeof(stepTableFull); i++){
		sleep(delay);
		PORTA = stepTableFull[i];
	}
}

void half(int delay){
	for(int i = 0; i<sizeof(stepTableHalf); i++){
		sleep(delay);
		PORTA = stepTableHalf[i];
	}
}

int main(void)
{
	DDRB = 0x00;
	DDRA = 0xff;
	while(1)
	{
		if(PORTA > 0b00000001){
			half(1000);
		}
		
		if(PORTA > 0b00000010){
			half(500);
		}
		
		if(PORTA > 0b00000100){
			half(100);
		}
	}
}
