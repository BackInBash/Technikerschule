/*
* main.c
*
* Created: 10/6/2021 12:42:56 PM
*  Author: yannic.rubenzer
*/
#include <avr/io.h>
#include <util/delay.h>

int main(void)

{
	
	DDRA = 0xFF; //set PortA for output
	PORTA = 0x00; //turn on all LED
	
	unsigned char schritte[4] = { 0b00001010, 0b00001001, 0b00000101, 0b00000110 };
	
	while(1)
	{
		for (int i=0 ; i < sizeof(schritte); i++)
		{
			PORTA = schritte[i];
			_delay_ms(100);
		}
	}
}
