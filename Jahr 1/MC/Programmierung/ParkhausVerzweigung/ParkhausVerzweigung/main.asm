;
; ParkhausVerzweigung.asm
;
; Created: 21/05/2021 12:08:25
; Author : Markus
;


; Replace with your application code

init:
	; Setup Bit-Mask
	ldi R16, 0b00001111 ; low-nibbl Mask
	ldi R17, 0b11110000 ; high-nibbl Mask

	ldi R18, 0 ; Register for low nibbl mask
	ldi R19, 0 ; Register for high nibbl mask

	ldi R20, 0xff ; Initialize PORTA
	out DDRA, R20

	out SFIOR, R20

	ldi R21, 0x00 ; Initialize PORTB
	out DDRB, R21
	

main:
    in R18, PORTA ; Save PORTA Results
	in R19, PORTA

	and R18, R16 ; Mask Results
	and R19, R17
	
	; Shift High Nibbl
	lsr R19
	lsr R19
	lsr R19
	lsr R19

	sub R18, R19 ; Add both results

	; Check Zero Flag
	brbs 1, alarm
	keinalarm:
		; No alarm
		jmp end
	alarm:
		; ALARM!!!
		out PORTB, R20 ; Write results to PORTB
end: